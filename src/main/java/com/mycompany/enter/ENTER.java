/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.enter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author heir
 */
public class ENTER {
private String Username;
private String Password;
private String FirstName;
private String LastName;

public boolean checkUsername(String Username){
    return Username.contains("_") && Username.length()<=5;
}
public boolean checkPasswordComplexity(String Password){
    String PasswordRegex="^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$";
    return Pattern.compile(PasswordRegex).matcher(Password).find();
}
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
 public boolean loginUser(String Username, String Password){
     return this.Username.equals(Username) && this.Password.equals(Password);
 }
 public String returnLoginStatus(boolean loginStatus){
     if(loginStatus){
         return "Login successful, welcome " + FirstName +" "+ LastName + " it is great to see you again";
     }else {
         return "Username or password incorrect, please try again";
     }
 }
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
    int numberOfTasks=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add: "));
    ArrayList<TASKclass> tasks= new ArrayList<>();
    int totalHours=0;
    
    JOptionPane.showMessageDialog(null, "Welcome to Easykanban");
    
    for (int i=0;i<numberOfTasks;i++){
    String taskUser=JOptionPane.showInputDialog("Enter Username: ");
    String taskName = JOptionPane.showInputDialog( "Enter Task Name:" );
    String taskDescription =JOptionPane.showInputDialog("Enter task description:");
    String developerFirstName =JOptionPane.showInputDialog("Enter Developer First Name: ");
    String developerLastName =JOptionPane.showInputDialog("Enter developer last name: ");
    int taskDuration= Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
    
    TASKclass task= new TASKclass(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, i, taskUser);
    if (task.checkDescription()){
        task.setTaskStatus(JOptionPane.showInputDialog("Select Task Status (To do, Done, Doing):"));
        tasks.add(task);
        totalHours+=task.returnTotalHours();
        JOptionPane.showMessageDialog(null, task.printTaskDetails());
    }else{
        JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.") ;
    }
    }
    JOptionPane.showMessageDialog(null, "Total Hours across all tasks: "+ totalHours);
    String[]options={"Add tasks", "Show Report(Coming Soon)","Quit"};
    int choice;
    
    do{
       choice=JOptionPane.showOptionDialog(null, "Choose an option:","Menu",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
       if (choice==0){
           //Logic to add tasks again can be implemented here
       }else if (choice==1){
           //logiv to show report can be implemented here
       }
    }while(choice!=2);
    dialog.dispose();
    }
}      
  
 
