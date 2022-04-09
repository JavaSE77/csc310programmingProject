package edu.cs.ship.rs0699.csc310.programmingproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
  
  private String fileName;

  public FileHandler(String fileName) {
    this.fileName = fileName;
  }
  
  /**
   * appendLine() - adds a line to the end of the file. 
   * @param String line to add to the end of the file
   * */
  public void appendLine(String line) {
    try {
      
     File file = new File(fileName); 
     if(!file.exists()) {
       file.getParentFile().mkdirs(); // Will create parent directories if not exists
       file.createNewFile();
     }
      
      BufferedWriter outputStream = new BufferedWriter(new FileWriter(fileName, true));

      outputStream.append(line + "\n");

      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();  
      
      System.out.println("There was an error writing to the file. Please correct the file before continuing");
    }

  }
  
  /**
   * putDataInFile() - dumps all the data into the file 
   * @param ArrayList data - Lines to add to the file
   * */
  public void putDataInFile(ArrayList<String> data) {
    try {
      
     File file = new File(fileName); 
     if(!file.exists()) {
       file.getParentFile().mkdirs(); // Will create parent directories if not exists
       file.createNewFile();
     }
      
      BufferedWriter outputStream = new BufferedWriter(new FileWriter(fileName, true));

      //iterator for all the data in the arraylist
      for(String line : data) {
        outputStream.append(line + "\n");
      }
      

      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();  
      
      System.out.println("There was an error writing to the file. Please correct the file before continuing");
    }

  }
  
  /**
   * void read file. Fills standard out with the file's contents
 * @return 
   * */
  public ArrayList<Integer> readFile() {
    
	  ArrayList<Integer> contents = new ArrayList<Integer>();
	  
    try {  
      //Open the config file
      FileInputStream inputStream=new FileInputStream(fileName);       
      Scanner scanner=new Scanner(inputStream);
      while(scanner.hasNextLine()) {
          String line = scanner.nextLine();
          contents.add(Integer.parseInt(line));
      }
    
      scanner.close(); 
    }  
      catch(IOException e) {  
          e.printStackTrace();  
          
          System.out.println("There was an error reading the file. Please correct the file before continuing");
  } 
  return contents;
}

  
}
