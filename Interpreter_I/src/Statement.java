import java.util.*;
abstract class Statement
{
    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <statement>");
    }
}



class Assignment extends Statement
{
    Var var; // variable on the left side of the assignment
    RightSide rightSide; // right side of the assignment

    Assignment(Var v, RightSide rs)
    {
        var = v;
        rightSide = rs;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";
        String indent2 = indent+"  ";

        super.printParseTree(indent);
        IO.displayln(indent1 + indent1.length() + " <assignment>");
        var.printParseTree(indent2);
        IO.displayln(indent2 + indent2.length() + " =");
        rightSide.printParseTree(indent2);
    }
}



abstract class Cond extends Statement
{
    Expr expr;
    Statement statement1;

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln(indent1 + indent1.length() + " <cond>");
    }
}

class If1 extends Cond
{
    // Expr expr; inherited from Cond
    // Statement statement1; inherited from Cond

    If1(Expr e, Statement s)
    {
        expr = e;
        statement1 = s;
    }

    void printParseTree(String indent)
    {
        String indent2 = indent+"  ";

        super.printParseTree(indent);
        IO.displayln(indent2 + indent2.length() + " if");
        expr.printParseTree(indent2);
        statement1.printParseTree(indent2);
    }
}



class If2 extends Cond
{
    // Expr expr; inherited from Cond
    // Statement statement1; inherited from Cond

    Statement statement2;

    If2(Expr e, Statement s1, Statement s2)
    {
        expr = e;
        statement1 = s1;
        statement2 = s2;
    }

    void printParseTree(String indent)
    {
        String indent2 = indent+"  ";

        super.printParseTree(indent);
        IO.displayln(indent2 + indent2.length() + " if");
        expr.printParseTree(indent2);
        statement1.printParseTree(indent2);
        IO.displayln(indent2 + indent2.length() + " else");
        statement2.printParseTree(indent2);
    }
}


class While extends Statement
{
    Expr expr;
    Statement statement;

    While(Expr e, Statement s)
    {
        expr = e;
        statement = s;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";
        String indent2 = indent+"  ";

        super.printParseTree(indent);
        IO.displayln(indent1 + indent1.length() + " <while>");
        IO.displayln(indent2 + indent2.length() + " while");
        expr.printParseTree(indent2);
        statement.printParseTree(indent2);
    }

    void M(HashMap<String,Val> state)

    // The M function is implemented by a while-loop instead of recursion to avoid runtime stack buildup.
    // The null value represents the runtime error value.

    {
        Val exprVal = expr.Eval(state);
        while ( exprVal != null )
        {
            if ( exprVal instanceof BoolVal )
                if ( ((BoolVal)exprVal).val )
                {
                    statement.M(state);
                    exprVal = expr.Eval(state);
                }
                else
                    return;
            else
            {
                System.out.println( "Error: Boolean expression of while statement evaluated to non-Boolean value: " + exprVal.toString() );
                return;
            }
        }
    }
}



class Block extends Statement
{
    SList sList;

    Block(SList s)
    {
        sList = s;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln(indent1 + indent1.length() + " <block>");
        sList.printParseTree(indent1+" ");
    }
}



class FunCallStatement extends Statement
{
    FunCall funCall;

    FunCallStatement(FunCall fCall)
    {
        funCall = fCall;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln(indent1 + indent1.length() + " <fun call statement>");
        funCall.printParseTree(indent1);
    }
}



class Print extends Statement
{
    Expr expr;

    Print(Expr e)
    {
        expr = e;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln(indent1 + indent1.length() + " <print>");
        expr.printParseTree(indent1+" ");
    }
}