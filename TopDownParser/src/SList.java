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
    void printParseTree(String indent)
    {

            IO.display(indent.length() + " <Statement>");

    }

    //abstract void emitInstructions();
}
class Cond extends Statement
{
    private String _if;
    private String _else;
    Expr expr;
    Statement statement;

    Cond(String i, Expr expr, Statement statement,String _else)
    {
        this._if = i;
        this.expr = expr;
        this.statement = statement;
        if (_else != null)
            this._else = _else;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent);
        IO.displayln(indent + indent.length() + " <cond>");
        IO.displayln(indent + indent.length() + this._if);
        if(this._else != null)
            IO.displayln(indent + indent.length() + this._else);

        expr.printParseTree(indent);
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
        super.printParseTree(indent);
        IO.displayln(indent + indent.length() + " <while>");
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
        super.printParseTree(indent);
        IO.displayln(indent + indent.length() + " <SList>");
    }
}

class FunCall extends Statement {
    String funName;
    ExprList exprList;

    FunCall(String funName, ExprList exprList) {
        this.funName = funName;
        this.exprList = exprList;
    }

    void printParseTree(String indent) {
        //String indent = +"  ";
//        String indent3 = indent+"   ";


//        IO.displayln(indent2 + indent2.length() + " <fun call>");
//        IO.displayln(indent3 + indent3.length() + " <fun name> " + funName);
        super.printParseTree(indent);
        IO.displayln(indent + indent.length() + " <fun name> " + funName);
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
        super.printParseTree(indent);
        IO.displayln(indent + indent.length() + " Print");
        expr.printParseTree(indent);
    }
}