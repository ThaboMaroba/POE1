/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login2;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author heir
 */
public class Login2 {
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
     Login2 login= new Login2();
    String registrationStatus= login.registerUser();
    System.out.println(registrationStatus);
    
    Scanner scanner=new Scanner(System.in);
    System.out.print("Enter your username:  ");
    String Username= scanner.nextLine();
    System.out.print("Enter your password:  ");
    String Password= scanner.nextLine();
    boolean loginStatus= login.loginUser(Username, Password);
    System.out.println(login.returnLoginStatus(loginStatus));
    }
}      
      
