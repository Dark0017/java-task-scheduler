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
    public static void main(String[] args ){
        System.out.println("Hello ppl");
    }
}
