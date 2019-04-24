abstract class BoolPrimaryItem
{
    BoolPrimary boolPrimary;

    abstract void printParseTree(String indent);
}

class SingleBoolPrimaryItem extends BoolPrimaryItem

// Represents the first <boolPrimary> in <boolTerm>

{
    // BoolPrimary boolPrimary; inherited from BoolPrimaryItem

    SingleBoolPrimaryItem(BoolPrimary bp)
    {
        boolPrimary = bp;
    }

    void printParseTree(String indent)
    {
        boolPrimary.printParseTree(indent);
    }
}



class AndBoolPrimaryItem extends BoolPrimaryItem

// Represents "&& <boolPrimary>"

{
    // BoolPrimary boolPrimary; inherited from BoolPrimaryItem

    AndBoolPrimaryItem(BoolPrimary bp)
    {
        boolPrimary = bp;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " &&");
        boolPrimary.printParseTree(indent);
    }
}