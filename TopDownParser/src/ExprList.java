import java.util.LinkedList;

public class ExprList
{
    LinkedList<Expr> exprList;
    ExprList(LinkedList<Expr> exprList)
    {
        this.exprList = exprList;
    }

    void printParseTree(String indent)
    {
        for ( Expr a : exprList )
            a.printParseTree(indent);
    }

//    void emitInstructions()
//    {
//        for ( Expr a : exprList )
//            a.emitInstructions();
//    }

}

class Expr
{
    LinkedList<BoolTerm> boolTermList;

    Expr(LinkedList<BoolTerm> boolTermList)
    {
        this.boolTermList = boolTermList;
    }

    void printParseTree(String indent)
    {
        for ( BoolTerm a :  boolTermList)
            a.printParseTree(indent);
    }

//    void emitInstructions()
//    {
//        for ( BoolTerm a :  boolTermListt )
//            a.emitInstructions();
//    }
}

class BoolTerm
{
    LinkedList<BoolPrimary> boolPrimaryList;

    BoolTerm(LinkedList<BoolPrimary> boolPrimaryList)
    {
        this.boolPrimaryList = boolPrimaryList;
    }

    void printParseTree(String indent)
    {
        for (BoolPrimary a :  boolPrimaryList)
            a.printParseTree(indent);
    }
}
//⟨boolPrimary⟩ → ⟨E⟩ [ ⟨comp op⟩ ⟨E⟩ ] needs to be tested
class BoolPrimary
{
    E e;
    BoolPrimary(E e)
    {
        this.e = e;
    }
    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <E>");
        e.printParseTree(indent);
    }
}

class CompOpBoolPrimary
{
    String compOp;
    E e;

    CompOpBoolPrimary(String compOp, E e)
    {
        this.compOp = compOp;
        this.e = e;
    }
    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + compOp);
        e.printParseTree(indent);
    }
}

