import java.util.*;

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
        public void modifyTask(){ System.out.println("Modify Task"); } // TODO: create function that allows user to modify a task
        
        public void newTask(String title, String description, Date deadline, Level priority, String tag, boolean isComplete, Date created) {
        
            //TODO:Create functions that ask the user for given property
            //this.title = getTitle();
            //this.description = getDescription();
            //this.deadline = getDeadline();
            //this.priority = getPriority();
            //this.tag = setTag(); TODO: Build setTag function
            //this.created = setCurrentTime(); TODO: Set current datetime 
        }
    
        /*Prototype for setTag function
        String setTag(){
            Display the available tags to the user
            Ask user to select a tag
            Allow user to create new tag
            Check if tag already exists
            
            Return the selected tag
        */

        //TODO:Create functions to delete individual attributes

}


public class main {
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
