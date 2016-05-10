package classes;

import java.util.Scanner;

/*
 * Author	: Kieran Bates
 * Date	: 10/05/2016
 * Description	:
 */

public class Main
{
	public static void main(String[] args)
	{
		int lOption = 0;
		
		do
		{
			System.out.println("----------------------------------------");
			System.out.println("1: Truth Table");
			System.out.println("2: Exit");
			System.out.println("----------------------------------------");
			
			System.out.print("Enter a menu option: ");
			Scanner lSC = new Scanner(System.in);
			lOption = lSC.nextInt();
			
			switch(lOption)
			{
				case 1:
					System.out.println("Processing Truth Table");
					new TruthTableLogic(args[0]);
					
					break;
				default:
					lOption = 2;
					lSC.close();
					break;
			} // end switch
		}
		while (lOption != 2);
		
		System.out.println("Goodbye");
	} // end main
} // end Main