/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InferenceEngine;
import java.io.*;
import java.util.*;

/**
 *
 * @author Leong
 */
public class Main {
  
    public static KnowledgeBase kBase;
    //public static Method[] lMethods;   //Algorithms to be implemented TT, FC, BC
    
    public static void main(String[] args)
	{
            //args contains:
		//  [0] - method name
		//  [1] - filename containing Knowledge Base and Query
            
            readFile(args[1]);    //Accept the second argument as the file name
            String method = args[0];
            //set the current method
            
            
        }
    
    public static KnowledgeBase readFile(String fileName)
    {
        try
		{
			//create file reading objects
			FileReader reader = new FileReader(fileName);
			BufferedReader kBaseReader = new BufferedReader(reader);
		        KnowledgeBase result = null;
                        
                        
                        
			kBaseReader.close();
                       
			return result;
		}
		catch(FileNotFoundException ex)
		{
			//The file didn't exist, show an error
			System.out.println("Error: File \"" + fileName + "\" not found.");
			System.out.println("Please check the path to the file.");
			System.exit(1);
		}
		catch(IOException ex)
		{
			//There was an IO error, show and error message
			System.out.println("Error in reading \"" + fileName + "\". Try closing it and programs that may be accessing it.");
			System.out.println("If you're accessing this file over a network, try making a local copy.");
			System.exit(1);
		}
        //this code should be unreachable. This statement is simply to satisfy Eclipse.
	return null;
    }
}
