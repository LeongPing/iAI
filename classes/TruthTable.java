package classes;

import java.util.ArrayList;

/*
 * Author		: Kieran Bates
 * Date			: 10/05/2016
 * Descripton	:
 */

public class TruthTable {
	private String[] fVariables;	// the variables 
	private String[] fStatements;	// the statements
	private int fColumns;			// the amount of columns in the truth table
	private int fRows;				// the amount of rows in the truth table
	private int fVarSize;			// the size of fVariables array
	private int fStateSize;			// the size of fStatements array
	
	public TruthTable(String aInput)
	{
		String[] lContents = aInput.split(" ");
		String[] lStat = aInput.split(";");
		ArrayList<String> lStatements = new ArrayList<String>();
		this.fVariables = new String[lContents.length];
		
		for (String lTempString : lStat)
		{
			lStatements.add(lTempString);
		} // end foreach
		for (int i = 0; i < lContents.length; i++)
		{
			fVariables[i] = lContents[i];
		} // end for
		
		this.fVarSize = fVariables.length;
		this.fStatements = lStatements.toArray(new String[lStatements.size()]);
		this.fStateSize = fStatements.length;
		this.fColumns = calculateColumns();
		this.fRows = calculateRows();
	} // end constructor
	
	public String[] getVariables()
	{
		return this.fVariables;
	} // end getVariables
	
	public String getVariable(int aIndex) throws ArrayIndexOutOfBoundsException
	{
		if (aIndex < fVarSize && aIndex > -1)
			return this.fVariables[aIndex];
		else
			throw new ArrayIndexOutOfBoundsException("Error. Index outside of array bounds");
	} // end getVariable
	
	public String[] getStatements()
	{
		return this.fStatements;
	} // end getStatements
	
	public String getStatement(int aIndex) throws ArrayIndexOutOfBoundsException
	{
		if (aIndex < fStateSize)
		{
			return this.fStatements[aIndex];
		} // end if
		else
			throw new ArrayIndexOutOfBoundsException("Error. Index outside of array bounds");
	} // end getStatement
	
	public int getColumns()
	{
		return this.fColumns;
	} // end getColumns
	
	public int getRows()
	{
		return this.fRows;
	} // end getRows
	
	public int getSize()
	{
		return this.fVarSize;
	} // end getSize
	
	public int calculateColumns()
	{
		return 0;
	} // end calculateColumns
	
	public int calculateRows()
	{
		return 0;
	} // end calculateRows
	
	public void generateTable()
	{
		String lOutput = "";
		
		System.out.println(lOutput);
	} // end generateTable
	
	public void displayVariables()
	{
		for (int i = 0; i < fVarSize; i++)
		{
			System.out.println("Line " + i + ": " + fVariables[i]);
		} // end for
	} // end displayVariables
	
	public void displayStatements()
	{
		for (int i = 0; i < fStateSize; i++)
		{
			System.out.println("Line " + i + ": " + fStatements[i]);
		} // end for
	} // end displayStatements
} // end TruthTable