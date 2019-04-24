abstract class RightSide
{
    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <right side>");
    }
}


class ArrayConstructor extends RightSide
{
    EList eList;

    ArrayConstructor(EList el)
    {
        eList = el;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln(indent1 + indent1.length() + " <array constructor>");
        eList.printParseTree(indent1+" ");
    }
}



class ExprRightSide extends RightSide
{
    Expr expr;

    ExprRightSide(Expr e)
    {
        expr = e;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln(indent1 + indent1.length() + " <expr right side>");
        expr.printParseTree(indent1+" ");
    }
}