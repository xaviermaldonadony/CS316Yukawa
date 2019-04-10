import java.util.LinkedList;

public class Var
{// <Var primary> -> <var>
    String id;

    Var(String id)
    {
        this.id = id;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent + " ";

        IO.displayln(indent + indent.length() + " <var>");
        IO.displayln(indent + indent + indent.length() + " <id var> " + id);
    }
}

class ArrayVar
{
    String id;
    EList el;
    ArrayVar(String id, EList el)
    {
        this.id = id;
        this.el = el;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent + " ";

        IO.displayln(indent + indent.length() + " <var>");
        IO.displayln(indent +indent + indent.length() + " <array var>");
        IO.displayln(indent + indent + indent + indent.length() + " <array name> " + id);

        el.printParseTree(indent1);
    }
}

class EList
{
    LinkedList<E> eItemList = new LinkedList<>();

    EList(LinkedList<E> eItemList)
    {
        this.eItemList = eItemList;
    }

    void printParseTree(String indent)
    {
        for ( E a : eItemList )
            a.printParseTree(indent);
    }
}


