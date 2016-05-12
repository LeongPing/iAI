package classes;

import java.util.ArrayList;

/*
 * Author		: Kieran Bates
 * Date			: 10/05/2016
 * Description	:
 */

public class TruthTable {
	private ArrayList<Statement> fStatements;	// the statements
	private int fColumns;						// the amount of columns in the truth table
	private int fRows;							// the amount of rows in the truth table
	private int fStateSize;						// the size of fStatements array
	
	public TruthTable(String aInput)
	{
		String[] lStatement = aInput.split(";");
		this.fStatements = new ArrayList<Statement>();
		
		for (String lTempString : lStatement)
		{
			Statement lTempState = new Statement(lTempString);
			fStatements.add(lTempState);
		} // end foreach
		
		this.fStateSize = fStatements.size();
		this.fColumns = calculateColumns();
		this.fRows = calculateRows();
	} // end constructor
	
	public ArrayList<Statement> getStatement()
	{
		return this.fStatements;
	} // end getStatement
	
	public int getColumns()
	{
		return this.fColumns;
	} // end getColumns
	
	public int getRows()
	{
		return this.fRows;
	} // end getRows
	
	public int getStatmentsSize()
	{
		return this.fStateSize;
	} // end getStatementsSize
	
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
		int i = 0;
		
		for (Statement lTempStatement : fStatements)
		{
			System.out.println("Statement: " + i);
			lTempStatement.displayVariables();
			
			i++;
		} // end foreach
	} // end displayVariables
	
	public void displayStatements()
	{
		int i = 0;
		
		for (Statement lTempStatement : fStatements)
		{
			System.out.println("Line " + i + ": " + lTempStatement.getStatement());
			i++;
		} // end foreach
	} // end displayStatements
} // end TruthTable