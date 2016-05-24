package classes;

import java.util.ArrayList;

/*
 * Author		: Kieran Bates
 * Date			: 10/05/2016
 * Description	:
 */

public class TruthTable
{
    private ArrayList<Statement> fStatements;	// the statements
    private int fStateSize;			// the size of fStatements array

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
    } // end constructor

    public ArrayList<Statement> getStatements()
    {
        return this.fStatements;
    } // end getStatement

    public Statement getStatement(int aIndex) throws ArrayIndexOutOfBoundsException
    {
        Statement lTempStatement = null;
        if (aIndex < fStateSize && aIndex > -1)
        {
            lTempStatement = fStatements.get(aIndex);
        } // end if
        else
        {
            throw new ArrayIndexOutOfBoundsException("Error. Index out of range");
        } // end else

        return lTempStatement;
    } // end getStatement

    public int getStatmentsSize()
    {
        return this.fStateSize;
    } // end getStatementsSize

    public void drawTable() throws Exception
    {
        for (Statement lTempState : fStatements)
        {
            try
            {
                lTempState.drawTable();
            }
            catch (Exception e)
            {
                throw new Exception(e);
            }
        } // end foreach
    } // end generateTable

    public void displayVariables()
    {
        System.out.println("\nVariables:");
        
        for (Statement lTempStatement : fStatements)
        {
            System.out.println("Statement: " + lTempStatement.getStatement());
            lTempStatement.displayVariables();
        } // end foreach
    } // end displayVariables
    
    public void displaySymbols()
    {
        System.out.println("\nSymbols:");
        
        for (Statement lTempStatement : fStatements)
        {
            System.out.println("Statement: " + lTempStatement.getStatement());
            lTempStatement.displaySymbols();
        } // end foreach
    } // end displayVariables

    public void displayStatements()
    {
        int i = 1;

        for (Statement lTempStatement : fStatements)
        {
            System.out.println("Line " + i + ": " + lTempStatement.getStatement());
            i++;
        } // end foreach
    } // end displayStatements
} // end TruthTable