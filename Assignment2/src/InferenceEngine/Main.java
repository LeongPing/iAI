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
  
    
    public static void main(String[] args)
	{
            readFile(args[1]);
            
            
            
        }
    
    public static void readFile(String fileName)
    {
        try
		{
			//create file reading objects
			FileReader reader = new FileReader(fileName);
			BufferedReader kBase = new BufferedReader(reader);
			
                        
                        
			kBase.close();
			
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
    }
}
