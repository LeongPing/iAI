package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TruthTableLogic
{
	private TruthTable fTruthTable;
	
	public TruthTableLogic(String aFileName)
	{
		try
		{
			readFile(aFileName);
		} // end try
		catch (IOException e)
		{
			e.printStackTrace();
		} // end catch
		
		fTruthTable.displayStatements();
	} // end constructor
	
	private void readFile(String aFileName) throws IOException
	{
		BufferedReader lIn = new BufferedReader(new FileReader(aFileName));
		String lLine;
		int lLineNumber = 0;

		while ((lLine = lIn.readLine()) != null)
		{
			//System.out.println("Line " + lLineNumber + ": " + lLine);
			if (lLineNumber == 1)
			{
				fTruthTable = new TruthTable(lLine);
			} // end if

			lLineNumber++;
		} // end while

		lIn.close();
	} // readFile
} // end TruthTableLogic