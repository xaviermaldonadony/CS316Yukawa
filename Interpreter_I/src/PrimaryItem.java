abstract class PrimaryItem
{
    Primary primary;

    abstract void printParseTree(String indent);
}

class SinglePrimaryItem extends PrimaryItem

// Represents the first <primary> in <term>

{
    // Primary primary; inherited from PrimaryItem

    SinglePrimaryItem(Primary p)
    {
        primary = p;
    }

    void printParseTree(String indent)
    {
        primary.printParseTree(indent);
    }
}


class MulPrimaryItem extends PrimaryItem

// Represents "* <primary>"

{
    // Primary primary; inherited from PrimaryItem

    MulPrimaryItem(Primary p)
    {
        primary = p;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " *");
        primary.printParseTree(indent);
    }
}



class DivPrimaryItem extends PrimaryItem

// Represents "/ <primary>"

{
    // Primary primary; inherited from PrimaryItem

    DivPrimaryItem(Primary p)
    {
        primary = p;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " /");
        primary.printParseTree(indent);
    }
}