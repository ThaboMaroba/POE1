/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.PART2;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;
/**
 *
 * @author heir
 */
public class ENTER {
private String Username;
private String Password;
private String FirstName;
private String LastName;

//Check if the username is valid
public boolean checkUsername(String Username){
    return Username.contains("_") && Username.length()<=5;
}
//Check if the password meets complexity requirements
public boolean checkPasswordComplexity(String Password){
    String PasswordRegex="^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$";
    return Pattern.compile(PasswordRegex).matcher(Password).find();
}
//Register a new user
public String registerUser(){
    Scanner scanner= new Scanner(System.in);
    System.out.print("Enter a username:  ");
    String Username= scanner.nextLine();
    if (checkUsername(Username)){
        System.out.println("Username Successfully captured");
        this.Username= Username;
    } else{
      System.out.println("Username not correctly formatted, please ensure that the username contains an underscore and is no more than 5 characters long");
      return "Registration failed";
    }
    System.out.print("Enter a password:  ");
    String Password= scanner.nextLine();
    if (checkPasswordComplexity(Password)){
     System.out.println("Password successfully captured");
     this.Password= Password;
    }else{
        System.out.println("Password format not correctly formatted, must contain 8 characters long, contain a capital letter, contain a special letter, contain a number");
        return "Registration Failed";
    }
    System.out.print("Enter your first name:  ");
    String FirstName=scanner.nextLine();
    this.FirstName= FirstName;
    System.out.print("Enter your last name:  ");
    String LastName= scanner.nextLine();
    this.LastName= LastName;
    return "Account created successfully!!";
}
//Login the user
 public boolean loginUser(String Username, String Password){
     return this.Username.equals(Username) && this.Password.equals(Password);
 }
 //Return login status message
 public String returnLoginStatus(boolean loginStatus){
     if(loginStatus){
         return "Login successful, welcome " + FirstName +" "+ LastName + " it is great to see you again";
     }else {
         return "Username or password incorrect, please try again";
     }
 }
 //Main method to test the functionality
    public static void main(String[] args) {
        ENTER login= new ENTER();
        
    String registrationStatus= login.registerUser();
    System.out.println(registrationStatus);
    
    Scanner scanner=new Scanner(System.in);
    System.out.print("Enter your username:  ");
    String Username= scanner.nextLine();
    System.out.print("Enter your password:  ");
    String Password= scanner.nextLine();
    boolean loginStatus= login.loginUser(Username, Password);
    System.out.println(login.returnLoginStatus(loginStatus));
    
    //task management
    final JDialog dialog=new JDialog();
    dialog.setAlwaysOnTop(true);
     JOptionPane.showMessageDialog(null, "Welcome to Easykanban");
    int numberOfTasks=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add: "));
    ArrayList<TASKclass> tasks= new ArrayList<>(); 
     //Populate arrays for task management
     String[] developers= new String[numberOfTasks]; //holds developer first names
     int totalHours= addTasks(tasks, developers );
 JOptionPane.showMessageDialog(null, "Total Hours across all tasks: "+ totalHours);
 
    for (int i=0;i<numberOfTasks;i++){
    String taskUser=JOptionPane.showInputDialog("Enter Username: ");
    String taskName = JOptionPane.showInputDialog( "Enter Task Name:" );
    String taskDescription =JOptionPane.showInputDialog("Enter task description:");
    String developerFirstName =JOptionPane.showInputDialog("Enter Developer First Name: ");
    String developerLastName =JOptionPane.showInputDialog("Enter developer last name: ");
    int taskDuration= Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
    
    TASKclass task= new TASKclass(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, i, taskUser);
    if (task.checkDescription()){
        String status = JOptionPane.showInputDialog("Select Task Status (To do, Done, Doing):") ;
        task.setTaskStatus(status);
        tasks.add(task); 
        totalHours+=task.returnTotalHours(); 
        developers[i]= developerFirstName;//Populate developers array
        JOptionPane.showMessageDialog(null, task.printTaskDetails());
    }else{
        JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.") ;
    }
    }
     
    //Display tasks with status "DONE" 
    String[] options={"Add tasks", "Show Report(Coming Soon)","Search Task by name" ,"Search tasks by developer","Delete Tasks",  "Quit"};
    int choice;
    
    do{
       choice=JOptionPane.showOptionDialog(null, "Choose an option:","Menu",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
       if (choice==0){
           //Logic to add tasks again can be implemented here
          totalHours+=addTasks(tasks, developers); 
       }else if (choice==1){
           //Call the displayTaskReport method when the user selects"Show report"
           displayTaskReport(tasks, developers);
       }else if(choice==2){
        searchTaskByName(tasks);    
       }else if(choice ==3){
        searchTasksByDeveloper(tasks);   
       }else if (choice==4){
           deleteTaskByName(tasks);
       }
    }while(choice!=5);
    dialog.dispose();
    }
    private static int addTasks(ArrayList<TASKclass> tasks, String[] developers){
int totalHours=0;
int numberOfTasks= Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add: "));
developers=new String[tasks.size()+ numberOfTasks];//Resize the developers array
    return 0;
    } 
 
    //Method to display tasks with a specific status
    static void displayDoneTasks(ArrayList<TASKclass> tasks){
    StringBuilder doneTasks= new StringBuilder("Done Tasks:\n");
for(TASKclass task: tasks){
    if("Done".equalsIgnoreCase(task.getTaskStatus())){
       doneTasks.append("Developer: ").append(task.getDeveloperFirstName())
                         .append(", Task Name: ").append(task.getTaskName())
                         .append(", Duration: ").append(task.gettaskDuration()).append(" hours\n"); 
    }
}  
JOptionPane.showMessageDialog(null, doneTasks.toString());
    }
    //Method to display the developer and duration of the task with the longest duration
    static void displayLongestTaskDuration(ArrayList<TASKclass> tasks){
        TASKclass  longestTask= null;
        for(TASKclass task: tasks){
            if(longestTask==null || task.gettaskDuration()> longestTask.gettaskDuration()){
                longestTask= task;
            }
        }
        if(longestTask != null){
     JOptionPane.showMessageDialog(null, "Longest Task:\nDeveloper : "+ longestTask.getDeveloperFirstName()+", Duration: "+ longestTask.gettaskDuration()+ " hours");
        }
    } 
    //Method to search for a task by name
    static void searchTaskByName(ArrayList<TASKclass> tasks){
        String taskName= JOptionPane.showInputDialog("Enter the task name to search:");
        for(TASKclass task: tasks){
            if(task.getTaskName().equalsIgnoreCase(taskName)){
                JOptionPane.showMessageDialog(null, "Task Name: "+task.getTaskName() + ", Developer: "+ task.getDeveloperFullName() + ", Status: "+ task.getTaskStatus());
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"Task not found.");
    }
    //Method to search for all tasks assigned to a developer
    static void searchTasksByDeveloper(ArrayList<TASKclass> tasks){
       String developerName= JOptionPane.showInputDialog("Enter the developer's first name to search:");
       StringBuilder developerTasks= new StringBuilder("Tasks assigned to "+ developerName+ ":\n");
       boolean found=false;
       for (TASKclass task: tasks){
           if(task.getDeveloperFirstName().equalsIgnoreCase(developerName)){
               developerTasks.append("Task Name: ").append(task.getTaskName()).append(", Status: ").append(task.getTaskStatus()).append("\n");
               found= true;
           }
       }
       if(found){
           JOptionPane.showMessageDialog(null, developerTasks.toString());
       }else {
           JOptionPane.showMessageDialog(null, "No tasks found for this developer.");
       }
    }
    //Method to delete a task by name
    static void deleteTaskByName(ArrayList<TASKclass> tasks){
        String taskName= JOptionPane.showInputDialog("Enter the task name to delete:");
        for(int i=0; i< tasks.size();i++){
          if(tasks.get(i).getTaskName().equalsIgnoreCase(taskName)){
           tasks.remove(i);
           JOptionPane.showMessageDialog(null, "Task '"+ taskName+ "' has been deleted.");
           return;
          }  
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }
    //Method to display a report of all tasks
    static void displayTaskReport(ArrayList<TASKclass> tasks, String[] developers){
     StringBuilder report=new StringBuilder("Task Report:\n");
     for(TASKclass task:tasks){
        report.append("Task ID: ").append(task.getTaskID()).append(", Task Name: ").append(task.getTaskName()).append(",Developer: ").append(task.getDeveloperFirstName()).append(", Duration: ").append(task.gettaskDuration()).append("hours, Status: ").append(task.getTaskStatus()).append("\n");
     }
     JOptionPane.showMessageDialog(null, report.toString());
     displayDoneTasks(tasks);
     displayLongestTaskDuration(tasks);
    } 
      
    }
   

  
 
