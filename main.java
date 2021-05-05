import java.util.*;
import java.time.LocalDate;

enum Level{
    LOW,
    MEDIUM,
    HIGH
}

class List {
    public static Set<String> tags;
}


class Task {


        String title;
        String description;
        Date deadline;
        Level priority;
        String tag;

        private Boolean isComplete;
        private Date created;


        //create setTag method that selects tag from list object instance 

        public String giveTitle(){ return this.title; }
        public void showTask(){ System.out.println("Show Task"); } // TODO: create function that shows the task information        
        Task(String title, String description, Date deadline, Level priority, String tag, boolean isComplete, Date created) {
            
            
            
            this.title = getTitle();
            this.description = getDescription();
            //TODO:this.deadline = getDeadline();
            //TODO:this.priority = getPriority();
            this.tag = setTag(); 
            //TODO:this.created = setCurrentTime();
        }
    
        String getTitle(){
            String temp;
            System.out.println("Enter Task");
            temp = sc.nextLine(); 
            return temp;
        }
        String getDescription(){
            String temp;
            System.out.println("Enter Description of the task");
            temp = sc.nextLine(); 
            return temp;
        }
        //TODO:getDeadline
        /*
        Date getDeadline(){
            int y;
            int m;
            int d;
            System.out.println("Enter year of the deadline");
            y = sc.nextInt();
            System.out.println("Enter month of the deadline");
            m = sc.nextInt();
            System.out.println("Enter time of the deadline");
            d = sc.nextInt();
            
            Date deadline = new Date(y, m, d);
            return deadline;

        }
        */
        Level getLevel(){
            Level temp = LOW;
            System.out.println("Enter the priority of the task");
            //temp = 
            return temp;
        }
        String setTag(){
            String newTag;
            boolean isPresent;
            String choice;
            System.out.println("Please select one tag from the following list of tags");
            System.out.println(L.tags);
            newTag = sc.nextLine();
            
            isPresent = L.tags.contains(newTag);
            if (isPresent == true){ 
                return tag;
            }
            else {
                System.out.println("The entered tag does not exist. New tag created.");
                choice = sc.nextLine();
                
                L.tags.add(newTag);
                return newTag;
            }
        }
        //TODO:set current time
        /*Date setCurrenttime{

        }
        */

        //TODO:get priority
        /*Level getPriority{

        }
        */
        void modifyTask(){

            String isExit = true;
            int ch;
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

                System.out.println("Do you want to modify anything else?(Y/N)")
                isExit = sc.nextLine();
            }
        }
}


public class main {
    static ArrayList<Task> taskList;
    static List L = new List();
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
            else if(input.equals("ADDTASK")){ //TODO: run task constructor and save task to tasklist
            System.out.println("Task created ran");
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
                tempTask.showTask();
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
        sc.close();
    }

}
