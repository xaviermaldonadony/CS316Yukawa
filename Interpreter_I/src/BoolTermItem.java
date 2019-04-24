abstract class BoolTermItem
{
    BoolTerm boolTerm;

    abstract void printParseTree(String indent);
}


class SingleBoolTermItem extends BoolTermItem

// Represents the first <boolTerm> in <Expr>

{
    // BoolTerm boolTerm; inherited from BoolTermItem

    SingleBoolTermItem(BoolTerm bt)
    {
        boolTerm = bt;
    }

    void printParseTree(String indent)
    {
        boolTerm.printParseTree(indent);
    }
}


class OrBoolTermItem extends BoolTermItem

// Represents "|| <boolTerm>"

{
    // BoolTerm boolTerm; inherited from BoolTermItem

    OrBoolTermItem(BoolTerm bt)
    {
        boolTerm = bt;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " ||");
        boolTerm.printParseTree(indent);
    }
}