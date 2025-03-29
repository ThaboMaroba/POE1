/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.PART2;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach; 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author heir
 */
public class ENTERTest {
  private ENTER enter;
private ArrayList<TASKclass> tasks;  

    @BeforeEach
    public void setUp() {
        enter=new ENTER();
        tasks=new ArrayList<>();
        
        //Create test data
        TASKclass task1=new TASKclass("Create Login","Login functionality","Mike","Smith",5,1,"testUser");
        task1.setTaskStatus("To Do");
        TASKclass task2= new TASKclass("Create Add features","Add new features","Edward","Harrison",8,2,"testUser");
        task2.setTaskStatus("Doing");
        TASKclass task3=new TASKclass("Create reports","Generate reports","Samantha","Paulson",2,3,"testUser");
        task3.setTaskStatus("Done");
        TASKclass task4=new TASKclass("Add arrays","Implement arrays","Glenda","Oberholzer",11,4,"testUser");
        task4.setTaskStatus("To Do");
        
        //Add tasks to the list
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
    }
    
    @AfterEach
    public void tearDown() {
        tasks.clear();
    }

    /**
     * Test of checkUsername method, of class ENTER.
     */
    @Test 
   public void testDevelopersArrayPopulatedCorrectly(){
    String[] developers=new String[tasks.size()];
    //Populate developers array from tasks
    for(int i=0; i<tasks.size();i++){
        developers[i]=tasks.get(i).getDeveloperFullName();   //assuming getDeveloperFullName() returns First and Last
    }
    //Expected developer names
    String[] expectedDevelopers={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
    //Assert that the developers array is populated correctly
    assertArrayEquals(expectedDevelopers, developers);
   }
   @Test
   public void testLongestTaskDuration(){
       TASKclass longestTask=null;
       for(TASKclass task : tasks){
           if(longestTask==null || task.gettaskDuration()>longestTask.gettaskDuration()){
               longestTask=task;
           }
       }
       String expectedOutput="Glenda Oberholzer,11";// Expected output
       String actualOutput=longestTask.getDeveloperFullName()+", "+ longestTask.gettaskDuration();
       assertEquals(expectedOutput, actualOutput);
   }
   @Test
   public void testSearchTaskByName(){
       String taskNameToSearch="Create Login";
       TASKclass foundTask=null;
       for(TASKclass task : tasks){
           if(task.getTaskName().equalsIgnoreCase(taskNameToSearch)){
               foundTask=task;
               break;
           }
       }
      String expectedOutput="Mike Smith, Create Login";//Expected output
      String actualOutput= foundTask.getDeveloperFullName()+", "+ foundTask.getTaskName();
      assertEquals(expectedOutput, actualOutput);
   }
   @Test
   public void testDeleteTaskByName(){
       String taskNameToDelete="Create reports";
       boolean taskDeleted=false;
       for(int i=0; i< tasks.size();i++){
           if(tasks.get(i).getTaskName().equalsIgnoreCase(taskNameToDelete)){
               tasks.remove(i);
               taskDeleted=true;
               break;
           }
       }
       assertTrue(taskDeleted,"Task should be deleted");
       assertEquals(3, tasks.size(), "Size of tasks should be reduced by 1");
   }
   @Test
   public void testSearchTasksByDeveloper(){
       String developerNameToSearch="Samantha Paulson";
       StringBuilder developerTasks= new StringBuilder();
       boolean found =false;
       
       for(TASKclass task : tasks){
           if(task.getDeveloperFullName().equalsIgnoreCase(developerNameToSearch)){
               developerTasks.append(task.getTaskName()).append(", ");
               found=true;
           }
       }
       String expectedOutput= "Create reports, ";// Expected output
       String actualOutput= developerTasks.toString();
       assertTrue(found, "Developer should have tasks assigned");
       assertEquals(expectedOutput, actualOutput);
   }
   }   
    
 
