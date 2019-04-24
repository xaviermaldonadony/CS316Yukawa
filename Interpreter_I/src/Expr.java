import java.util.*;

class Expr
{
    LinkedList<BoolTermItem> boolTermItemList;

    Expr(LinkedList<BoolTermItem> btItemList)
    {
        boolTermItemList = btItemList;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <expr>");
        for ( BoolTermItem bt : boolTermItemList )
            bt.printParseTree(indent+" ");
    }
}