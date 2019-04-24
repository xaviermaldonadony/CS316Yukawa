abstract class Var
{
    void printParseTree(String indent)
    {
        IO.display(indent + indent.length() + " <var>");
    }
}



class IdVar extends Var
{
    Id id;

    IdVar(Id ident)
    {
        id = ident;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln("");
        IO.display(indent1 + indent1.length() + " <id var>");
        id.printParseTree();
    }
}



class ArrayVar extends Var
{
    ArrayName arrayName;
    EList eList;

    ArrayVar(ArrayName aName, EList el)
    {
        arrayName = aName;
        eList = el;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";
        String indent2 = indent+"  ";

        super.printParseTree(indent);
        IO.displayln("");
        IO.displayln(indent1 + indent1.length() + " <array var>");
        arrayName.printParseTree(indent2);
        eList.printParseTree(indent2);
    }
}



class ReturnVal extends Var
{
    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln("");
        IO.displayln(indent1 + indent1.length() + " returnVal");
    }
}