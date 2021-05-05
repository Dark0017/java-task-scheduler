import java.util.*;
import java.time.LocalDate;

enum Level{
    LOW,
    MEDIUM,
    HIGH,
    NONE
}

class List {
    public static Set<String> tags;
}


class Task {


        String title;
        String description;
        LocalDate deadline;
        Level priority;
        String tag;

        private Boolean isComplete;
        private LocalDate created;

        public String giveTitle(){ return this.title; }

        // TODO: create function that shows the task information        
        
        public void openTask(){
            Scanner sc = new Scanner(System.in);

            System.out.println("Task:           " + title);
            System.out.println("Description:    " + description);
            System.out.println("Deadline:       " + deadline);
            System.out.println("Priority level: " + priority);
            System.out.println("Tag:            " + tag);
            System.out.println("Date created:   " + created);
            if(isComplete == true){
                System.out.println("Status: Not Done");
            }
            else{
                System.out.println("Status: Completed");
            }
            String input = "";
            System.out.println("Mark task as completed?(Y/N): ");
            
            
            input = sc.nextLine();
            sc.close();
            if(input.equals("Y")){
                isComplete = true;
                System.out.println("Task marked as completed");
            } 
            else if (input.equals("N")){
                System.out.println("Returning");
                return;
            }
            else{
                System.out.println("Invalid Input returning");
            }
        }
        Task(){};

        Task(String inTitle, String inDescription, LocalDate inDeadline, Level inPriority, String inTag) {
            title = inTitle;
            description = inDescription;
            deadline = inDeadline;
            priority = inPriority;
            tag = inTag;
            isComplete = false;
            created = LocalDate.now();
        }

        public Task createTask(){
            title = getTitle();
            description = getDescription();
            deadline = getDeadline();
            priority = getPriority();
            tag = getTag();

            return new Task(title, description, deadline, priority, tag);
        }
    
        String getTitle(){
           // Scanner sc = new Scanner(System.in);
            String temp;

            System.out.println("Enter Task name");
            temp = System.console().readLine();
            //sc.close();
            return temp;
        }

        String getDescription(){
            String temp="";
            //Scanner sc = new Scanner(System.in);

            System.out.println("Enter Description of the task");
            temp = System.console().readLine();
            
            //sc.close();
            return temp;
        }
        
        LocalDate getDeadline(){

            Scanner sc = new Scanner(System.in);
            int year;
            int month;
            int day;
            System.out.println("Enter year of the deadline");
            year = sc.nextInt();
            System.out.println("Enter month of the deadline");
            month = sc.nextInt();
            System.out.println("Enter time of the deadline");
            day = sc.nextInt();
            sc.close();
            LocalDate deadline = LocalDate.of(year, month, day);
            return deadline;
        }
        
        
        Level getPriority(){
            String userInput;
            //Scanner sc = new Scanner(System.in);

            System.out.println("l= low, m=medium, h=high\n"
                +"Enter the priority of the task:");
            userInput = System.console().readLine();
            //sc.close();

            switch(userInput){
                case "l":
                return Level.LOW;
                case "m":
                return Level.MEDIUM;
                case "h":
                return Level.HIGH;
            }

            return Level.NONE;
        }

        String getTag(){
            String newTag;
            //Scanner sc = new Scanner(System.in);

            System.out.println("Please select one tag from the following list of tags");
            System.out.println(List.tags);
            newTag = System.console().readLine();
            //sc.close();

            if (List.tags.contains(newTag)){ 
                return tag;
            }
            else {
                List.tags.add(newTag);
                System.out.println("The entered tag does not exist. New tag created.");
                return newTag;
            }
        }

        void modifyTask(){

            String isExit = "Y";
            int ch;
            Scanner sc = new Scanner(System.in);

            while(isExit == "Y"){

                System.out.println("What do you want to modify?");
                System.out.println("1) Task name ");
                System.out.println("2) Task description ");
                System.out.println("3) Task deadline ");
                System.out.println("4) Task priority ");
                
                ch = sc.nextInt();
                switch(ch){
                    case 1:
                    getTitle();
                    break;
                    case 2:
                    getDescription();
                    break;
                    case 3:
                    getDeadline();
                    break;
                    case 4:
                    getPriority();
                    break;
                    default:
                    System.out.println("Wrong choice entered");

                }

                System.out.println("Do you want to modify anything else?(Y/N)");
                isExit = sc.nextLine();
            }
            sc.close();
        }
};

public class index {
    static ArrayList<Task> taskList;

    public static void main(String[] args ){
        boolean didExit = false;
        Scanner sc = new Scanner(System.in);

        
        while(!didExit)
        {   
            String input = "";
            int taskIndex = -1;
            String operation = "";

            // display list of tasks for today
            try{
            if(taskList != null) {
                for(int i =0; i < taskList.size(); i ++)
                {
                    Task tempTask = taskList.get(i);
                    System.out.println(i + ". "+ tempTask.giveTitle());
                }
            }
        } catch(Exception e) {
            System.out.println(e);
            System.out.println(taskList);
        }
            //Can't modify outer variables from inner lambda expression
            /*taskList.forEach((task) -> {
                System.out.println(i + ". "+ task.giveTitle());
                i = i + 1;
            });*/

            // display format to enter task number and option
            // #d - delete #th task, #m - modify #th task, exit
            System.out.println("Enter the operation you want to perform in '#x' format, where\n"
            +"# = so. no. of the task displayed\n"
            +"x = operation you wish to perform on the task\n"
            +"Operations: o: open, m: modify, d: delete"
            +"Enter EXIT to exit the program"
            +"Enter ADDTASK to add a task");

            // take input from user
            input = sc.nextLine();
            System.out.println("Input: " + input);

            // check if user wants to exit
            if(input.equals("EXIT")){didExit = true;}

            //check if user wants to add a task
            else if(input.equals("ADDTASK")){ //TODO: run task constructor and save task to tasklistJ
            Task temp =  new Task().createTask();
            taskList.add(temp);
            }

            else{
            //parse
            taskIndex = Integer.parseInt(input.substring(0,1));
            operation = input.substring(1);
            
            //get task object at index
            Task tempTask = taskList.get(taskIndex);

            //perform operation
            switch (operation){
                case "o":
                tempTask.openTask();
                break;
                case "m":
                tempTask.modifyTask();
                break;
                case "d":
                taskList.remove(taskIndex);
                break;
            }

            //save it back to the list
            taskList.set(taskIndex, tempTask);
        }

        }
        
        // 
        // 
        System.out.println("Hello ppl");
     
    }

}
