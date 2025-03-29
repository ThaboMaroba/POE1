/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.PART2;

/**
 *
 * @author heir
 */
class TASKclass{
    private String taskName;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private int taskNumber;
    private String taskStatus;
    private String taskID;
    private String taskUser;
    
 public TASKclass( String taskName, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, int taskNumber, String taskUser) {
     this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskNumber = taskNumber;
        this.taskID = createID();
        this.taskUser= taskUser;
    }
public boolean checkDescription() {
        return true;
    }

    public String createID() {
        return (taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3).toUpperCase());
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer: " + developerFirstName + " " + developerLastName + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }

    public int returnTotalHours() {
        return taskDuration;
    }
    public String getdeveloperLastName(){
     return developerLastName;   
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    
    public String getTaskName(){
     return taskName;   
    }
    
    public String getTaskDescription(){
     return taskDescription;   
    }
    
    public String getDeveloperFirstName(){
     return developerFirstName;   
    }
     
    public int getTaskDuration(){
        return taskNumber;
    }
    public int getTaskNumber(){
        return taskNumber;
    }
    public String getTaskID(){
        return taskID;
    }
    public String getTaskUser(){
        return taskUser;
    }
    public String getTaskStatus(){
        return taskStatus;
    }
    public String getDeveloperFullName(){
        return developerFirstName+ " " + developerLastName;
    }
    public int gettaskDuration(){
        return taskDuration;
    }
}   
 
 
 