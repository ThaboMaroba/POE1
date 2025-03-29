/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.PART2;
 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author heir
 */
public class TASKclassTest {
     
    /**
     * Test of createID method, of class TASKclass.
     */
    @Test
    public void testTaskCreation() {
     String taskName= "Login Feature";
String taskDescription="Create loginto authenticate user";
String developerFirstName="Robyn";
String developerLastName="Harrison";
int taskDuration=8;//hours
int taskNumber=2;//Test task number
String taskUser="Robyn Harrison";
String expectedTaskStatus="To Do";

//Act
TASKclass task=new TASKclass(taskName, taskDescription, developerFirstName, developerLastName,taskDuration, taskNumber, taskUser);
task.setTaskStatus(expectedTaskStatus);// Set the task status

//Assert
assertEquals(taskName, task.getTaskName());
assertEquals(taskDescription, task.getTaskDescription());
assertEquals(developerFirstName, task.getDeveloperFirstName());
assertEquals(developerLastName, task.getdeveloperLastName());
        assertEquals(taskDuration, task.getTaskDuration());
        assertEquals(taskNumber, task.getTaskNumber());
        assertEquals(expectedTaskStatus, task.getTaskStatus());
        assertNotNull(task.getTaskID()); // Check if Task ID is generated
        assertEquals(taskUser , task.getTaskUser ());
    }

    @Test
    public void testTaskIDGeneration(){
      String taskName = "Login feature";
        String taskDescription = "Create login to authenticate user";
        String developerFirstName = "Robyn";
        String developerLastName = "Harrison";
        int taskDuration = 8; // hours
        int taskNumber = 1; // Example task number
        String taskUser  = "Robyn Harrison";

        // Act
        TASKclass task = new TASKclass(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, taskNumber, taskUser );
        String expectedTaskID = "LO:1:SON"; // Expected ID based on the createID logic

        // Assert
        assertEquals(expectedTaskID, task.getTaskID());  
    }
    /**
     * Test of printTaskDetails method, of class TASKclass.
     */
    @Test
    public void testPrintTaskDetails() {
       // Arrange
        String taskName = "Login feature";
        String taskDescription = "Create login to authenticate user";
        String developerFirstName = "Robyn";
        String developerLastName = "Harrison";
        int taskDuration = 8; // hours
        int taskNumber = 1; // Example task number
        String taskUser   = "Robyn Harrison";
        String taskStatus = "To do";

        TASKclass task = new TASKclass(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, taskNumber, taskUser );
        task.setTaskStatus(taskStatus);

        // Act
        String taskDetails = task.printTaskDetails();

        // Assert
        assertTrue(taskDetails.contains("Task Status: " + taskStatus));
        assertTrue(taskDetails.contains("Developer: " + developerFirstName + " " + developerLastName));
        assertTrue(taskDetails.contains("Task Number: " + taskNumber));
        assertTrue(taskDetails.contains("Task Name: " + taskName));
        assertTrue(taskDetails.contains("Task Description: " + taskDescription));
        assertTrue(taskDetails.contains("Task ID: " + task.getTaskID()));
        assertTrue(taskDetails.contains("Duration: " + taskDuration + " hours"));    }

    /**
     * Test of returnTotalHours method, of class TASKclass.
     */
    @Test
    public void testReturnTotalHours() {
        // Arrange
        String taskName = "Login feature";
        String taskDescription = "Create login to authenticate user";
        String developerFirstName = "Robyn";
        String developerLastName = "Harrison";
        int taskDuration = 8; // hours
        int taskNumber = 1; // Example task number
        String taskUser  = "Robyn Harrison";

        TASKclass task = new TASKclass(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, taskNumber, taskUser );

        // Act
        int totalHours = task.returnTotalHours();

        // Assert
        assertEquals(taskDuration, totalHours);
    }

    /**
     * Test of setTaskStatus method, of class TASKclass.
     */
    @Test
    public void testSetTaskStatus() {
         String taskName = "Login feature";
        String taskDescription = "Create login to authenticate user";
        String developerFirstName = "Robyn";
        String developerLastName = "Harrison";
        int taskDuration = 8; // hours
        int taskNumber = 1; // Example task number
        String taskUser   = "Robyn Harrison";
        String taskStatus = "Completed";

        TASKclass task = new TASKclass(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, taskNumber, taskUser  );

        // Act
        task.setTaskStatus(taskStatus);

        // Assert
        assertEquals(taskStatus, task.getTaskStatus());
     
    }

 
    }
    
 
