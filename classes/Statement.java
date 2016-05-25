package classes;

import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Author		: Kieran Bates
 * Date			: 12/05/2016
 * Description	: a class that holds a statement. Can generate a truth table
 for the statement.
 */
public class Statement
{
    private String fStatement;              // The statement
    private ArrayList<String>fVariables;    // The variables in the statement
    private ArrayList<String> fSymbols;   // All of the symbols that can be used
    private String[][] fTruthTable;         // The truth table
    private int fVariableSize;              // The amount of variables
    private int fSymbolSize;                // The amount of symbols
    private int fColumns;                   // The amount of columns in the truth table
    private int fRows;                      // The amount of rows in the truth table

    public Statement(String aStatement)
    {
        this.fStatement = aStatement.trim();
        String[] lVariables = fStatement.split("~|&|(\\/)|(=>)|(<=>)");
        String[] lSymbols = fStatement.split("[0-9]|[a-z]|[A-Z]");
        this.fVariables = new ArrayList<String>();
        this.fSymbols = new ArrayList<String>();
        
        // trim each variable and each symbol
        for (int i = 0; i < lVariables.length; i++)
        {
            lVariables[i] = lVariables[i].trim();
            lVariables[i] = removeSymbols(lVariables[i]);
        } // end for
        for (int i = 0; i < lSymbols.length; i++)
        {
            lSymbols[i] = lSymbols[i].trim();
            lSymbols[i] = removeAlphaNumeric(lSymbols[i]);
        }
        for (String lTempVar : lVariables)
        {
            if (!(lTempVar.equals("") || lTempVar == null))
                this.fVariables.add(lTempVar.trim());
        } // end for
        for (String lTempSym : lSymbols)
        {
            if (!(lTempSym.trim().equals("") || lTempSym == null))
                this.fSymbols.add(lTempSym.trim());
        } // end for
        
        this.fVariableSize = fVariables.size();
        this.fSymbolSize = fSymbols.size();
        this.fColumns = 0;
        this.fRows = 0;
    } // end constructor

    // return the statement
    public String getStatement()
    {
        return fStatement;
    } // end getStatement

    // return all of the variables
    public ArrayList<String> getVariables()
    {
        return this.fVariables;
    } // end getVariables

    // get a variable at given index
    public String getVariable(int aIndex) throws ArrayIndexOutOfBoundsException
    {
        if (aIndex < fVariableSize && aIndex > -1)
        {
            return fVariables.get(aIndex);//fVariables[aIndex];
        } // end if
        else
            throw new ArrayIndexOutOfBoundsException("Error. Array index out of range");
    } // end getVariable

    public ArrayList<String> getSymbols()
    {
        return fSymbols;
    } // end getSymbols

    public String getSymbol(int aIndex) throws ArrayIndexOutOfBoundsException
    {
        if (aIndex < fSymbolSize && aIndex > -1)
            return fSymbols.get(aIndex);
        else
            throw new ArrayIndexOutOfBoundsException("Error. Array index out of range");
    } // end getSymbol

    // get the size of variable array
    public int getVariableSize()
    {
        return this.fVariableSize;
    } // end getVariableSize

    public int getSymbolSize()
    {
        return fSymbolSize;
    } // end getSymbolSize

    // get the amount of columns
    public int getColumnSize()
    {
        return this.fColumns;
    } // end getColumnSize
    
    private void calculateColumns()
    {
        this.fColumns = fSymbolSize + fVariableSize;
    } // end setColumnAmount

    // get the amount of rows
    public int getRowSize()
    {
        return this.fRows;
    } // end getRowSize

    private void calculateRows()
    {
        this.fRows = ((int) Math.pow(2, fVariableSize)) + 1;
    } // end setRowAmount

    public String[][] getTruthTable()
    {
        return fTruthTable;
    } // end getTruthTable
    
    public String getTruthTableVariable(int aX, int aY) throws ArrayIndexOutOfBoundsException
    {
        if ((aX < fRows) && (aY < fColumns) && (aX > -1) && (aY > -1))
        {
            return fTruthTable[aX][aY];
        }
        else
            throw new ArrayIndexOutOfBoundsException("Error. Array index out of range");
    } // end getTruthTableVariable
    
    // check if there is a symbol with the variable if there is 
    // remove the symbol, else return the variable.
    private String removeSymbols(String aString)
    {
        char[] lTempChars = aString.toCharArray();
        String lTempString = "";
        
        for (int i = 0; i < aString.length(); i++)
        {
            if (Character.isLetterOrDigit(lTempChars[i]) == false)
                lTempChars[i] = 0;
            else
                lTempChars[i] = aString.charAt(i);
        } // end for
        
        for (int i = 0; i < lTempChars.length; i++)
        {
            lTempString += lTempChars[i];
        } // end for
        
        if (lTempString.equals(aString))
            return aString;
        else
            return lTempString;
    } // end removeCharacters
    
    // check if there is a variable with the symbol if there is
    // remove the character, else return the symbol
    private String removeAlphaNumeric(String aString)
    {
        char[] lTempChars = aString.toCharArray(); // = new char[aString.length()];
        String lTempString = "";
        
        for (int i = 0; i < aString.length(); i++)
        {
            if (Character.isLetterOrDigit(aString.charAt(i)))
                lTempChars[i] = 0;
            else
                lTempChars[i] = aString.charAt(i);
        } // end for
        
        for (int i = 0; i < lTempChars.length; i++)
        {
            lTempString += lTempChars[i];
        } // end for
        
        if (lTempString.equals(aString))
            return aString;
        else
            return lTempString;
    } // end removeAlphaNumeric

    // display all of the variables
    public void displayVariables()
    {
        int i = 1;
        
        for (String lTempString : fVariables)
        {
            System.out.println("Line " + i + ": " + lTempString);
            i++;
        } // end foreach
    } // end displayVariables
    
    public void displaySymbols()
    {
        int i = 1;
        
        for (String lTempString : fSymbols)
        {
            System.out.println("Line " + i + ": " + lTempString);
            i++;
        } // end for
    } // end displaySymbols
    
    public void drawTable() throws Exception
    {
        String lOutput = "";
        
        try
        {
            generateTable();
        } // end try
        catch (Exception e)
        {
            throw new Exception(e);
        } // end catch
        
        for (int i = 0; i < fRows; i++)
        {
            for (int j = 0; j < fColumns; j++)
            {
                lOutput += fTruthTable[i][j] + " | ";
            } // end for j
            lOutput += "\n";
        } // end for i
        
        System.out.println(lOutput);
    } // end draw
    
    private void setTruthTableVariables()
    {
        for (int i = 0; i < fVariableSize; i++)
        {
            fTruthTable[i][0] = fVariables.get(i);
            for (int j = 1; j < fColumns; j++)
            {
                if (i == 0)
                {
                    if (j < fRows / 2)
                        fTruthTable[i][j] = "T";
                    else
                        fTruthTable[i][j] = "F";
                } // end if
                else if (i == 1)
                {
                    /*if (j == 0 || j == 1 || j == 4 || j == 5)
                        fTruthTable[i][j] = "T";
                    else
                        fTruthTable[i][j] = "F";*/
                } // end else if
                else
                {
                    if (j % 2 == 0)
                        fTruthTable[i][j] = "T";
                    else
                        fTruthTable[i][j] = "F";
                } // end else if
            } // end for j
        } // end for i
    } // end setTruthTableVariables

    // generate a truth table for the statement
    public void generateTable() throws Exception
    {
        calculateRows();
        calculateColumns();
        fTruthTable = new String[fRows][fColumns];
        
        setTruthTableVariables();
        
        for (int i = 0; i < fRows; i++)
        {
            for (int j = 0; j < fColumns; j++)
            {
                if ((i == 0) && (j < fColumns / 2))
                {
                    fTruthTable[i][j] = "T";
                } // end if
                else if ((i == 0) && !(j < fColumns / 2))
                {
                    fTruthTable[i][j] = "F";
                } // end else if
                else if ((i == 2) && ((j == 0) || (j == 1) || (j == 4) || (j == 5)))
                {
                    fTruthTable[i][j] ="T";
                } // end else if
                else if ((i == 2) && ((j == 2)))
                {
                    
                } // end else if
            } // end for j
        } // end for i
    } // end generateTable
} // end Statement