import java.util.LinkedList;

public class FunDef {

    Header header;
    Body body;

    FunDef(Header header, Body body)
    {
        this.header = header;
        this.body = body;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent + " ";

        IO.displayln(indent + indent.length() + " <header>");
        header.printParseTree(indent1);
        body.printParseTree(indent1);
    }
}
class Header
{
    String funName; //id
    ParameterList parameterList;

    Header(String funName,ParameterList parameterList)
    {
        this.funName = funName;
        this.parameterList = parameterList;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent + " ";

        IO.displayln(indent + indent.length() + " <header>");
        IO.displayln(indent1 + indent1.length() + " <fun name> " + funName);
        parameterList.printParseTree(indent1);

    }
}

class ParameterList
{
//    ⟨parameter list⟩ → ⟨parameter⟩ { "," ⟨parameter⟩ }
//⟨   parameter⟩ → ⟨id⟩
    LinkedList<Parameter> parameterItemList; // parameter turns out to be a idList

    ParameterList(LinkedList<Parameter> parameterItemList)
    {
        this.parameterItemList = parameterItemList;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent + " ";
        IO.displayln(indent + indent.length() + " <parameterList>");
        for ( Parameter t : parameterItemList )
            t.printParseTree(indent1);
    }

//    Val Eval(HashMap<String,Val> state)
//
//    // Evaluate a sequence of terms operated by + or - using left associativity
//
//    {
//        Val eVal = null;
//
//        for ( TermItem t : termItemList )
//            eVal = t.Eval(state, eVal);
//        return eVal;
//    }
//
//    void emitInstructions()
//
//    // Emit instructions to evaluate a sequence of terms operated by + or - using left associativity
//
//    {
//        for ( TermItem t : termItemList )
//            t.emitInstructions();
//    }
}

class Parameter
{

    String funName;

    Parameter(String funName)
    {
        this.funName = funName;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent + " ";

        IO.displayln(indent + indent.length() + " <parameter>" + funName);
        //IO.displayln(indent1 + indent1.length() + " " + funName);
    }
}

class Body
{
    SList sList;
    Body(SList sList)
    {
        this.sList = sList;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent + " ";

        IO.displayln(indent + indent.length() + " <Body>");
        sList.printParseTree(indent);
    }
}