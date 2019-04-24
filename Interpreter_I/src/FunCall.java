abstract class FunCall
{
    FunName funName;

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <fun call>");
        funName.printParseTree(indent+" ");
    }
}



class FunCallWithoutParameters extends FunCall
{
    // FunName funName; inherited from FunCall

    FunCallWithoutParameters(FunName fName)
    {
        funName = fName;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent+" ");
    }
}


class FunCallWithParameters extends FunCall
{
    // FunName funName; inherited from FunCall

    ExprList exprList;

    FunCallWithParameters(FunName fName, ExprList eList)
    {
        funName = fName;
        exprList = eList;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent1);
        exprList.printParseTree(indent1+" ");
    }
}