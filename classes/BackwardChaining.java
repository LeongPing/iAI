/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.io.*;
import java.util.*;
/**
 *
 * @author Leong
 */
public class BackwardChaining {
    String kb;
    String query;
    
    public BackwardChaining(String fileName)
    {
        readFile(fileName);     //reads input file
        run();                  //runs the main logic of Forward Chaining
    }
    
    public void readFile(String fileName)       //read problem file into two strings, -kb -query
    {
        try
		{
			//create file reading objects
			FileReader reader = new FileReader(fileName);
			BufferedReader problem = new BufferedReader(reader);
			
			for(int i = 0; i < 4; i++)
                        {
                            if(i == 1)
                            {
                                kb = problem.readLine();                //creates the knowledge base string
                                kb = kb.replaceAll("\\s","");           //removes all spaces 
                                System.out.println("Knowledge Base:");
                                System.out.println(kb);
                            }else if(i == 3)
                            {
                                query = problem.readLine();             //creates the query string
                                query = query.replaceAll("\\s","");
                                System.out.println("Query:");
                                System.out.println(query);
                                System.out.println("");
                            }else
                            {
                                problem.readLine();
                            }
                        }
                        		
			problem.close();
			
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
    
    /*public boolean check(List sList)
    {
        boolean result = false;
        for(int i = 0; i < sList.size(); i++)
            {
                if(sList.get(i).toString().contains(query))
                {
                    System.out.print("YES: ");
                    System.out.print(sList);        //Print out the searched list
                    System.out.println("");
                    result = true;
                }
            }
        return result;
    }*/
    
    public void run()
    {
        String[] kbArray = kb.split(";");
        //String[] searchedArray;
        List kbList = new ArrayList();
        List searchedList = new ArrayList();
        boolean solved = false;
        List solutions = new ArrayList();
        
        for(int i = 0; i < kbArray.length; i++) 
        {
            kbList.add(kbArray[i]);
            //System.out.println(kbList[i]);
        } 
        
        if(!kbList.toString().contains(query))
        {
            System.out.println("No Solutions");
            solved = true;
        }
        
        for(int i = 0; i < kbList.size(); i++) 
        {
            if(!kbList.get(i).toString().contains("=>"))
            {
                solutions.add(kbList.get(i));
            }
        }
        
        for(int i = 0; i < kbList.size(); i++)    
        {
            if(solutions.contains(kbList.get(i)))
            {
                kbList.set(i, "");
            }
        }
        
        searchedList.add(query);
        
        while(solved == false)
        {
            for(int i = 0; i < kbList.size(); i++)
            {
                if(kbList.get(i).toString().contains("=>"))
                {
                    String clause[] = kbList.get(i).toString().split("=>");
                    for(int j = 0; j < searchedList.size(); j++)
                    {
                        if(clause[1].contains(searchedList.get(j).toString()))
                        {
                            searchedList.add(clause[0]);
                            kbList.set(i, "");
                        }   
                    }
                }
            }
            
            for(int i = 0; i < solutions.size(); i++)
                        {
                            for(int j = 0; j < searchedList.size(); j++)
                            if(searchedList.get(j).toString().contains(solutions.get(i).toString()))
                            {
                                System.out.print("YES: ");
                                System.out.print(searchedList);
                                System.out.println("");
                                solved = true;
                            }
                        }
        }
    }
}
