import java.util.*;

class BoolTerm
{
    LinkedList<BoolPrimaryItem> boolPrimaryItemList;

    BoolTerm(LinkedList<BoolPrimaryItem> bpItemList)
    {
        boolPrimaryItemList = bpItemList;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <boolTerm>");
        for ( BoolPrimaryItem bp : boolPrimaryItemList )
            bp.printParseTree(indent+" ");
    }
}

