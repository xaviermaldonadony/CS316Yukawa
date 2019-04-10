import java.util.*;

abstract class TermItem
{
    Term term;

    abstract void printParseTree(String indent);
    abstract Val Eval(HashMap<String,Val> state, Val eVal);
    abstract void emitInstructions();

    static class SingleTermItem extends TermItem

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

        Val Eval(HashMap<String,Val> state, Val eVal)
        {
            eVal = term.Eval(state);
            return eVal;
        }

        void emitInstructions()
        {
            term.emitInstructions();
        }
    }
}