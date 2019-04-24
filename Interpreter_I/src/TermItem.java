abstract class TermItem
{
    Term term;

    abstract void printParseTree(String indent);
}

class SingleTermItem extends TermItem

// Represents the first <term> in <E>

{
    // Term term; inherited from TermItem

    SingleTermItem(Term t)
    {
        term = t;
    }

    void printParseTree(String indent)
    {
        term.printParseTree(indent);
    }
}

class AddTermItem extends TermItem

// Represents "+ <term>"

{
    // Term term; inherited from TermItem

    AddTermItem(Term t)
    {
        term = t;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " +");
        term.printParseTree(indent);
    }
}


class SubTermItem extends TermItem

// Represents "- <term>"

{
    // Term term; inherited from TermItem

    SubTermItem(Term t)
    {
        term = t;
    }

    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " -");
        term.printParseTree(indent);
    }
}