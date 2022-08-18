//*********************************************************************************************************************************************************************************************************************
// DuplicatedTitles.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 3 exceptions
// this program detects duplicated book titles from an input file, then it saves and exports the duplicated book titles into one single file.
//**********************************************************************************************************************************************************************************************************************

import java.io.*; 
import java.util.*;
 
public class DuplicatedTitles {
   public static void main(String[] args) {
       File file = new File("/Users/Koki/Desktop/bookTitles.inp.txt"); // reading file from a txt file (it contains list of book titles)
       Scanner reader; 
       String line=""; // variable to hold book title from input book list  

       
       String uniqueNames[] = new String[50];
       int currentCount=0; // variable to hold current book title list 
       try {
           PrintWriter outputFile = new PrintWriter("duplicateTitles.out.txt"); // creating output file and its name  
           reader = new Scanner(file); // read a list of book title
           boolean found = true; // variable to hold whether book is recorded before or not 
           
           while(reader.hasNextLine()){ // scanning input items 
               line = reader.nextLine(); // read each single book title 
               line = line.toUpperCase(); // make each single book title to uppercase to avoid lower&upper duplicates
               found = false; // jot down the book title status is recorded before
               
               for (int i = 0; i < currentCount; i++) { // if book title is recorded in array before, skip adding the book title in array 
                   if(line.equals(uniqueNames[i])){
                       found = true;
                       break;
                   }
               }
               
               if(!found){ // if book title is not recorded in array before, add the book title in array 
                   outputFile.write(line+"\n");
                   uniqueNames[currentCount] = line;
                   currentCount++;
               }
               
           }
           outputFile.close(); // complete inserting new data into output file 
            System.out.println("file created");

       } catch (FileNotFoundException e) { // notice user to re enter new file
           System.out.println("file not found");
       }
    
   }
} // end line of code 