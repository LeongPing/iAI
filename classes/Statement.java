package classes;

import java.util.ArrayList;

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
            if (!((lTempVar.equals("") || lTempVar == null)))
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
        //this.fColumns = ((int) Math.pow(2, fVariableSize)) + 1;
        this.fColumns = fSymbolSize + fVariableSize;
    } // end setColumnAmount

    // get the amount of rows
    public int getRowSize()
    {
        return this.fRows;
    } // end getRowSize

    private void calculateRows()
    {
        //this.fRows = fSymbolSize + fVariableSize;
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
    
    private void initTruthVariables()
    {
        for (int i = 0; i < fVariableSize; i++)
        {
            fTruthTable[i][0] = fVariables.get(i);
        } // end for i
        
        int lAlternate = (fRows - 1) / 2;
        int lAltTimes = 0;
        String lAltValue = "T";

        for (int i = 0; i < fVariableSize; i++)
        {
            for (int j = 1; j < fRows; j++)
            {
                fTruthTable[i][j] = lAltValue;
                lAltTimes++;

                if (lAltTimes == lAlternate)
                {
                    lAltTimes = 0;

                    if (lAltValue.equals("T"))
                        lAltValue = "F";
                    else
                        lAltValue = "T";
                } // end if
            } // end for j
            lAlternate = lAlternate / 2;
        } // end for i
    } // end initTruthVariables
    
    private void hasNot()
    {
        int lNotLoc = -1;

        // get the location of the not symbol
        for (String lSymbol : fSymbols)
        {
            if (lSymbol.equals("~"))
            {
                lNotLoc = fSymbols.indexOf(lSymbol);
                break;
            } // end if
        } // end foreach

        fTruthTable[lNotLoc + fVariableSize][0] = fSymbols.get(lNotLoc) + fVariables.get(lNotLoc);

        for (int i = 1; i < fRows; i++)
        {
            if (fTruthTable[lNotLoc][i].equals("T"))
                fTruthTable[fVariableSize + lNotLoc][i] = "F";
            else
                fTruthTable[fVariableSize + lNotLoc][i] = "T";
        } // end for i
    } // end hasNot
    
    private void hasAnd()
    {
        int lAndLoc = -1;
        int lSpot = -1;
        int lVarCol1 = -1;
        int lVarCol2 = -1;
        String lVar1 = "";
        String lVar2 = "";
        
        for (String lSymbol : fSymbols)
        {
            if (lSymbol.equals("&"))
            {
                lAndLoc = fSymbols.indexOf(lSymbol);
                break;
            } // end if
        } // end foreach
        
        // set the variables of the two columns to compare
        if (lAndLoc > 0)
        {
            if (fSymbols.get(lAndLoc - 1).equals("~"))
            {
                hasNot();
                lVar1 = "~" + fVariables.get(lAndLoc - 1);
            }
            else
                lVar1 = fVariables.get(lAndLoc - 1);
            if (lAndLoc + 1 < fSymbolSize)
            {
                if (fSymbols.get(lAndLoc + 1).equals("~"))
                {
                    hasNot();
                    lVar2 = "~" + fVariables.get(lAndLoc);
                }
            }
            else
                lVar2 = fVariables.get(lAndLoc);
        } // end if
        else
        {
            lVar1 = fVariables.get(lAndLoc);
            
            if (lAndLoc + 1 < fSymbolSize)
            {
                if (fSymbols.get(lAndLoc + 1).equals("~"))
                {
                    hasNot();
                    lVar2 = "~" + fVariables.get(lAndLoc + 1);
                }
                else
                    lVar2 = fVariables.get(lAndLoc + 1);
            } // end if
            else
                lVar2 = fVariables.get(lAndLoc + 1);
        } // end else
        
        // set the location of the two variables
        for (int i = 0; i < fColumns; i++)
        {
            if (lVar1.equals(fTruthTable[i][0]))
                lVarCol1 = i;
            if (lVar2.equals(fTruthTable[i][0]))
                lVarCol2 = i;
        } // end for
        
        // get the location to add truth values
        for (int i = 0; i < fColumns; i++)
        {
            if (fTruthTable[i][0] == null)
            {
                lSpot = i;
                break;
            } // end if
        } // end for
            
        fTruthTable[lSpot][0] = fTruthTable[lVarCol1][0] + fSymbols.get(lAndLoc) + fTruthTable[lVarCol2][0];
        
        for (int i = 1; i < fRows; i++)
        {
            if (fTruthTable[lVarCol1][i].equals("T") && fTruthTable[lVarCol2][i].equals("T"))
                fTruthTable[lSpot][i] = "T";
            else
                fTruthTable[lSpot][i] = "F";
        } // end for
    } // end hasAnd
    
    private void hasOr()
    {
        int lOrLoc = -1;
        int lSpot = -1;
        int lVarCol1 = -1;
        int lVarCol2 = -1;
        String lVar1 = "";
        String lVar2 = "";
        
        // get the location of the symbol
        for (String lSymbol : fSymbols)
        {
            if (lSymbol.equals("\\/"))
            {
                lOrLoc = fSymbols.indexOf(lSymbol);
                break;
            } // end if
        } // end foreach
        
        // set the variables of the two columns to compare
        if (lOrLoc > 0)
        {
            if (fSymbols.get(lOrLoc - 1).equals("~"))
            {
                hasNot();
                lVar1 = "~" + fVariables.get(lOrLoc - 1);
            }
            else
                lVar1 = fVariables.get(lOrLoc - 1);
            if (lOrLoc + 1 < fSymbolSize)
            {
                if (fSymbols.get(lOrLoc + 1).equals("~"))
                {
                    hasNot();
                    lVar2 = "~" + fVariables.get(lOrLoc);
                }
            }
            else
                lVar2 = fVariables.get(lOrLoc);
        } // end if
        else
        {
            lVar1 = fVariables.get(lOrLoc);
            
            if (lOrLoc + 1 < fSymbolSize)
            {
                System.out.println("lOrLoc + 1: " + lOrLoc + 1);
                if (fSymbols.get(lOrLoc + 1).equals("~"))
                {
                    hasNot();
                    System.out.println("lOrLoc + 1: " + lOrLoc + 1);
                    lVar2 = "~" + fVariables.get(lOrLoc + 1);
                }
                else
                    lVar2 = fVariables.get(lOrLoc + 1);
            } // end if
            else
                lVar2 = fVariables.get(lOrLoc + 1);
        } // end else
        
        // set the location of the two variables
        for (int i = 0; i < fColumns; i++)
        {
            if (lVar1.equals(fTruthTable[i][0]))
                lVarCol1 = i;
            if (lVar2.equals(fTruthTable[i][0]))
                lVarCol2 = i;
        } // end for
        
        // get the location to add truth values
        for (int i = 0; i < fColumns; i++)
        {
            if (fTruthTable[i][0] == null)
            {
                lSpot = i;
                break;
            } // end if
        } // end for
        
        fTruthTable[lSpot][0] = fTruthTable[lVarCol1][0] + fSymbols.get(lOrLoc) + fTruthTable[lVarCol2][0];
        
        for (int i = 1; i < fRows; i++)
        {
            if (fTruthTable[lVarCol1][i].equals("T") || fTruthTable[lVarCol2][i].equals("T"))
                fTruthTable[lSpot][i] = "T";
            else
                fTruthTable[lSpot][i] = "F";
        } // end for
    } // end hasOr
    
    private void hasImplication()
    {
        int lImpLoc = -1;
        int lSpot = -1;
        int lVarCol1 = -1;
        int lVarCol2 = -1;
        String lVar1 = "";
        String lVar2 = "";
        String[] lConditions = fStatement.split("(?<=(=>))|(?=(=>))");
        
        // get the location of the symbol
        for (String lSymbol : fSymbols)
        {
            if (lSymbol.equals("=>"))
            {
                lImpLoc = fSymbols.indexOf(lSymbol);
                break;
            } // end if
        } // end foreach
        
        for (int i = 0; i < lConditions.length; i++)
        {
            if (lConditions[i].equals("=>"))
            {
                lVar1 = lConditions[i - 1];
                lVar2 = lConditions[i + 1];
            } // end if
        } // end for
        
        for (int i = 0; i < lConditions.length; i++)
        {
            if (lConditions[i].contains("&"))
                hasAnd();
            else if (lConditions[i].contains("\\/"))
                hasOr();
        } // end for
        
        for (int i = 0; i < fColumns; i++)
        {
            if (fTruthTable[i][0] == null)
            {
                lSpot = i;
                break;
            } // end if
        } // end for
        
        for (int i = 0; i < fColumns; i++)
        {
            if (fTruthTable[i][0].equals(lVar1))
                lVarCol1 = i;
            if (fTruthTable[i][0].equals(lVar2))
                lVarCol2 = i;
        } // end for
        
        fTruthTable[lSpot][0] = fTruthTable[lVarCol1][0] + fSymbols.get(lImpLoc) + fTruthTable[lVarCol2][0];
        
        for (int i = 0; i < fColumns; i++)
        {
            if ((fTruthTable[lVarCol1][i].equals("T")) && (fTruthTable[lVarCol2][i].equals("T")))
                fTruthTable[lSpot][i] = "T";
            else if ((fTruthTable[lVarCol1][i].equals("T")) && (fTruthTable[lVarCol2][i].equals("F")))
                fTruthTable[lSpot][i] = "F";
            else if ((fTruthTable[lVarCol1][i].equals("F")) && (fTruthTable[lVarCol2][i].equals("T")))
                fTruthTable[lSpot][i] = "T";
            else if ((fTruthTable[lVarCol1][i].equals("T")) && (fTruthTable[lVarCol2][i].equals("F")))
                fTruthTable[lSpot][i] = "F";
        }
    } // end hasImplication
    
    private void hasBiconditional()
    {
        int lImpLoc = -1;
        int lSpot = -1;
        int lVarCol1 = -1;
        int lVarCol2 = -1;
        String lVar1 = "";
        String lVar2 = "";
        String[] lConditions = fStatement.split("(?<=(=>))|(?=(=>))");
        
        // get the location of the symbol
        for (String lSymbol : fSymbols)
        {
            if (lSymbol.equals("=>"))
            {
                lImpLoc = fSymbols.indexOf(lSymbol);
                break;
            } // end if
        } // end foreach
        
        for (int i = 0; i < lConditions.length; i++)
        {
            if (lConditions[i].equals("<=>"))
            {
                lVar1 = lConditions[i - 1];
                lVar2 = lConditions[i + 1];
            } // end if
        } // end for
        
        for (int i = 0; i < lConditions.length; i++)
        {
            if (lConditions[i].contains("&"))
                hasAnd();
            else if (lConditions[i].contains("\\/"))
                hasOr();
        } // end for
        
        for (int i = 0; i < fColumns; i++)
        {
            if (fTruthTable[i][0] == null)
            {
                lSpot = i;
                break;
            } // end if
        } // end for
        
        for (int i = 0; i < fColumns; i++)
        {
            if (fTruthTable[i][0].equals(lVar1))
                lVarCol1 = i;
            if (fTruthTable[i][0].equals(lVar2))
                lVarCol2 = i;
        } // end for
        
        fTruthTable[lSpot][0] = fTruthTable[lVarCol1][0] + fSymbols.get(lImpLoc) + fTruthTable[lVarCol2][0];
        
        for (int i = 0; i < fColumns; i++)
        {
            if ((fTruthTable[lVarCol1][i].equals("T")) && (fTruthTable[lVarCol2][i].equals("T")))
                fTruthTable[lSpot][i] = "T";
            else if ((fTruthTable[lVarCol1][i].equals("T")) && (fTruthTable[lVarCol2][i].equals("F")))
                fTruthTable[lSpot][i] = "F";
            else if ((fTruthTable[lVarCol1][i].equals("F")) && (fTruthTable[lVarCol2][i].equals("T")))
                fTruthTable[lSpot][i] = "F";
            else if ((fTruthTable[lVarCol1][i].equals("F")) && (fTruthTable[lVarCol2][i].equals("F")))
                fTruthTable[lSpot][i] = "T";
        }
    } // end hasBiconditional
    
    private void initTruthSymbols()
    {
        for (String lSymbol : fSymbols)
        {
            if (lSymbol.equals("~"))
                hasNot();
            if (lSymbol.equals("&"))
                hasAnd();
            if (lSymbol.equals("\\/"))
                hasOr();
            if (lSymbol.equals("=>"))
                hasImplication();
            if (lSymbol.equals("<=>"))
                hasBiconditional();
        } // end foreach
    } // end initTruthSymbols

    // generate a truth table for the statement
    public void generateTable() //throws Exception
    {
        calculateRows();
        calculateColumns();
        fTruthTable = new String[fColumns][fRows];
        
        initTruthVariables();
        initTruthSymbols();
    } // end generateTable
    
    // print the truth table to the console
    public void drawTable()
    {
        String lOutput = "";
        
        generateTable();
        
        for (int i = 0; i < fRows; i++)
        {
            for (int j = 0; j < fColumns; j++)
            {
                lOutput += fTruthTable[j][i] + " | ";
            } // end for j
            lOutput += "\n";
        } // end for i
        
        System.out.println(lOutput);
    } // end draw
} // end Statement