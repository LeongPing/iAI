package classes;

public class Statement
{
	private String fStatement;
	private String[] fVariables;
	private int fVarSize;
	
	public Statement(String aStatement)
	{
		this.fStatement = aStatement;
		
		String[] lContents = fStatement.split(" ");
		this.fVariables = new String[lContents.length];
		
		for (int i = 0; i < lContents.length; i++)
		{
			fVariables[i] = lContents[i];
		} // end for
		
		this.fVarSize = fVariables.length;
	} // end constructor
	
	public String getStatement()
	{
		return fStatement;
	} // end getStatement
	
	public String[] getVariables()
	{
		return this.fVariables;
	} // end getVariables
	
	public String getVariable(int aIndex) throws ArrayIndexOutOfBoundsException
	{
		if (aIndex < fVarSize)
		{
			return fVariables[aIndex];
		}
		else
			throw new ArrayIndexOutOfBoundsException("Error. Index given out of range");
	} // end getVariable
	
	public void displayVariables()
	{
		for (int i = 0; i < fVarSize; i++)
		{
			System.out.println("Line " + i + ": " + fVariables[i]);
		} // end for
	} // end displayVariables
} // end Statement