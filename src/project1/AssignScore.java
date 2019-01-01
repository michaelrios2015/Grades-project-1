/*
Michael Rios
COSC 600
Project 1, Class AssignSCore
Algorithm - in general this does the actual work, see notes for each method 
Purpose- See above
 */

package project1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mike
 */
public class AssignScore {
     
    //reads the data from a file returns the number of items in file
    //again may not be entirely necessary but makes the program more flexible
    //as it can read in a file of almost any size
    public int arraySize(){
    
        int i = 0;
        try{ 
        Scanner sc = new Scanner(new  File("mynumbers.txt"));
        while(sc.hasNextInt()){//simple loop 
            i++;
            sc.nextInt();
            
        }}
            catch(Exception e)
                {System.out.println("Error"+e.toString());}
          
        return i;
    }
    
    //takes the number of items in a file, and uses that to convert the data into an array 
    public int[] arrayToData(int size){
    
        int i = 0, sum = 0;
        int[] array = new int[size];
        try{ 
        Scanner sc = new Scanner(new  File("mynumbers.txt"));
        while(sc.hasNextInt()) {//essential the same as the arraySize but also puts the data into an array
            int number = sc.nextInt();
            array[i] = number;
            i++;
        }}
            catch(Exception e)
                {System.out.println("Error"+e.toString());}
          
        return array;
    }
    
    //calculates the average of the test scores
    public double average(int [] array, int size){
    
        int sum = 0;
               
        for (int i = 0; i<size; i++){//simple loop
            int number = array[i];
            sum = sum + number;
        }
        
        return (double)sum/size;//the math
    }

    //outputs data to screen
    public void outPutToScreen(int [] array, int size, double average){
         
        System.out.println("Score                Grade" );//header
        System.out.println("__________________________" );
        for(int index = 0; index < size; index++){        
            if ((average * 1.1) < array[index]){ //decides the letter grade
                System.out.printf("%d                  Outstanding\n", array[index]);
                System.out.println("__________________________" );}//makes it easrier to read
            else if ((average * .9) > array[index]){
                System.out.printf("%d                  Unsatisfactory\n", array[index]);
                System.out.println("__________________________" );}
            else{
                System.out.printf("%d                  Satisfactory\n", array[index]);
                System.out.println("__________________________" );}
        }
        
        
}
    
    //outputs data to file same as above just a different place
    public void outPutToFile(int [] array, int size, double average){
         
    try{
        FileWriter yourfile = new FileWriter("yourdata.txt"); //creates file just fine
                
	yourfile.write("The Average is " + average + System.getProperty( "line.separator" )+ System.getProperty( "line.separator" ));
        
        yourfile.write("Score             Grade" + System.getProperty( "line.separator" ));
        yourfile.write("__________________________" + System.getProperty( "line.separator" ));
        for(int index = 0; index < size; index++){ 
            if ((average * 1.1) < array[index]){ 
                yourfile.write(array[index] + "                Outstanding" + System.getProperty( "line.separator" ));
                yourfile.write("__________________________" + System.getProperty( "line.separator" ));}
            else if ((average * .9) > array[index]){ 
                yourfile.write(array[index] + "                Unsatisfactory" + System.getProperty( "line.separator" ));
                yourfile.write("__________________________" + System.getProperty( "line.separator" ));}
            else{
                 yourfile.write(array[index] + "                Satisfactory" + System.getProperty( "line.separator" ));
                yourfile.write("__________________________" + System.getProperty( "line.separator" ));}
        }
        
        
        yourfile.flush();
        yourfile.close();       
	
        } catch (IOException e) {
			e.printStackTrace();}
 
        
        
}
}
