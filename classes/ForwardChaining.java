package classes;
import java.io.*;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leong
 */
public class ForwardChaining {
   
    String kb;
    String query;
    
    public ForwardChaining(String fileName)
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
    
    public boolean check(List sList)
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
    }
    
    public void run()
    {
        String[] kbArray = kb.split(";");
        List kbList = new ArrayList();
        List searchedList = new ArrayList();
        boolean solved = false;
        
        
        
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
        
        while(solved == false)
        {
            for(int i = 0; i < kbList.size(); i++)    
            {
                if(!kbList.get(i).toString().contains("=>"))
                {
                    searchedList.add(kbList.get(i).toString());
                }
            }
            for(int i = 0; i < kbList.size(); i++)    
            {
                if(searchedList.contains(kbList.get(i)))
                {
                    kbList.set(i, "");
                }
            }
            
            if(solved == false)
            {
                solved = check(searchedList);
                
                for(int i = 0; i < kbList.size(); i++)
                {
                    if(kbList.get(i).toString().contains("=>"))
                    {
                        String clause[] = kbList.get(i).toString().split("=>");
                        for(int j = 0; j < searchedList.size(); j++)
                        {
                            if(clause[0].contains("&") && solved == false)
                            {
                                String andClause[] = clause[0].split("&");
                                boolean and1 = false;
                                boolean and2 = false;
                                for(int k = 0; k < searchedList.size(); k++)
                                {
                                    if(andClause[0].contains(searchedList.get(k).toString()))
                                    {
                                        and1 = true;
                                    }
                                    if(andClause[1].contains(searchedList.get(k).toString()))
                                    {
                                        and2 = true;
                                    }
                                }
                                
                                if(and1 == true && and2 == true)        //only if both conditions are true, this value is added to the searched list
                                {
                                searchedList.add(clause[1]);
                                //kbList.set(i, "null");
                                }
                            }
                            else if(clause[0].contains(searchedList.get(j).toString()) && solved == false)
                            {
                                searchedList.add(clause[1]);
                                //kbList.set(i, "null");
                                solved = check(searchedList);
                            }
                        }
                    }
                }
            }
            /*for(int i = 0; i < kbList.size(); i++)    
            {
                if(kbList.get(i).toString() == "")
                {
                    kbList.remove(i);
                }
            } */
        }
    }
}

