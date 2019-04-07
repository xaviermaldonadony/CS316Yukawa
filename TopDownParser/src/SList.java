public class SList
{
   Statement statement;

   SList(Statement statement)
   {
       this.statement = statement;
   }

   void printParseTree(String indent)
   {
    String indent1 = indent + " ";

    IO.displayln(indent + indent.length() + " <s list>");
   }
}

abstract class Statement
{
    abstract void printParseTree(String indent);

    //abstract void emitInstructions();
}
class Cond extends Statement
{
    private String i;
    Expr expr;

    Cond(Expr expr)
    {
        this.i = "if";
        this.expr = expr;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <cond>");
        IO.displayln(indent + indent.length() + i);

    }
}

class While extends Statement
{
    private String w;
    Expr expr;
    Statement statement;

    While(Expr expr, Statement statement)
    {
        this.w = "while";
        this.expr = expr;
        this.statement = statement;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <cond>");
        IO.displayln(indent + indent.length() + w);
    }
}

class Block extends Statement
{
    SList sList;

    Block(SList sList)
    {
        this.sList = sList;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <SList>");
    }
}

class FunCallStatement extends Statement {
    String funName;
    ExprList exprList;

    FunCallStatement(String funName, ExprList exprList) {
        this.funName = funName;
        this.exprList = exprList;
    }

    void printParseTree(String indent) {
        //String indent = +"  ";
//        String indent3 = indent+"   ";


//        IO.displayln(indent2 + indent2.length() + " <fun call>");
//        IO.displayln(indent3 + indent3.length() + " <fun name> " + funName);
        IO.displayln(indent.length() + " <fun name> " + funName);
        exprList.printParseTree(indent);
    }
}

class Print extends Statement
{
    String p;
    Expr expr;

    Print(String p, Expr expr)
    {
        this.p = p;
        this.expr = expr;
    }
    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " Print");
    }
}