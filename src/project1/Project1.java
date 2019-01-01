/*
Michael Rios
COSC 600
Project 1
Algorithm
Read data

Compute Average

Compare each garde to average

Assign Letter grade based on ratio of grade to average

Write to a file 

Purpose- Assign a letter grade to students grade based on the class average
 */

package project1;


/**
 *
 * @author mike
 */
public class Project1 {

    int[] arrayData;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double average;
       
        AssignScore myproject1 = new AssignScore();//creates AssignScore object
        
        int size = myproject1.arraySize();//finds how many test scores are in the file.
        //this could be skipped and you could just use a long array, but this makes the program more flexible 
       
        int[] arrayData = myproject1.arrayToData(size);//moves the data from input file to an array, may not 
        //strictly be necessary but made it easier for me to manipulate the data

        average = myproject1.average(arrayData, size);//calculates the average
        System.out.println("The Average is " + average);
        
        myproject1.outPutToScreen(arrayData, size, average);//Assigns letter grade and displays them to screen
        
        myproject1.outPutToFile(arrayData, size, average);//Assigns letter grade and writes them to a file
        }
    
}
    
