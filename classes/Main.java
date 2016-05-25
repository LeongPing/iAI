package classes;

import java.util.Scanner;

/*
 * Author	: Kieran Bates & Leong Ping Lee
 * Date	: 26/05/2016
 * Description	: The main file for the assignment
 */

public class Main
{
	// menu system for the assignment
	public static void main(String[] args)
	{
		int lOption = 0;
		
		do
		{
			// menu options
			System.out.println("----------------------------------------");
			System.out.println("1: Truth Table");
			System.out.println("2: Forward Chaining");
                        System.out.println("3: Backward Chaining");
                        System.out.println("4: Exit");
			System.out.println("----------------------------------------");
			
			System.out.print("Enter a menu option: ");
			
			// get input from console
			Scanner lSC = new Scanner(System.in);
			lOption = lSC.nextInt();
			
			// execute each of the menu options if chosen
			switch(lOption)
			{
				case 1:
					System.out.println("Processing Truth Table");
					new TruthTableLogic(args[0]);
					
					break;
                                case 2:
                                    System.out.println("Calculating Forward Chaining");
                                    new ForwardChaining(args[0]);
                                    break;
                                    
                                case 3:
                                    System.out.println("Calculating Backward Chaining");
                                    new BackwardChaining(args[0]);
                                    break;
                                    
				case 4:
					lSC.close();
				default:
					lOption = 4;
					lSC.close();
					break;
			} // end switch
		} // end do
		while (lOption != 4);
		
		System.out.println("Goodbye");
	} // end main
} // end Main