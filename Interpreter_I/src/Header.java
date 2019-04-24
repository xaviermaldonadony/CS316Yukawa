abstract class Header
{
    FunName funName;

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <header>");
        funName.printParseTree(indent+" ");
    }
}



class HeaderWithoutParameters extends Header
{
    //FunName funName; inherited from Header

    HeaderWithoutParameters(FunName fName)
    {
        funName = fName;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent);
    }
}



class HeaderWithParameters extends Header
{
    //FunName funName; inherited from Header

    ParameterList parameterList;

    HeaderWithParameters(FunName fName, ParameterList pList)
    {
        funName = fName;
        parameterList = pList;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent);
        parameterList.printParseTree(indent+" ");
    }
}