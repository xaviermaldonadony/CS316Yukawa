import java.util.*;

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

    Val Eval(HashMap<String,Val> state, Val eVal)
    {
        Val termVal = term.Eval(state);

        if ( eVal == null || termVal == null )
            return null;

        // The result will be float if one or both of the arguments are float.

        Class    eClass =    eVal.getClass();
        Class termClass = termVal.getClass();

        if ( eClass == Val.IntVal.class && termClass == Val.IntVal.class )
        {
            ((Val.IntVal)eVal).val = ((Val.IntVal)eVal).val - ((Val.IntVal)termVal).val;
            return eVal;
        }
        else if ( eClass == Val.IntVal.class ) // termClass == Val.FloatVal.class
        {
            ((Val.FloatVal)termVal).val = ((Val.IntVal)eVal).val - ((Val.FloatVal)termVal).val;
            return termVal;
        }
        else // eClass == Val.FloatVal.class
        {
            ((Val.FloatVal)eVal).val = eVal.floatVal() - termVal.floatVal();
            return eVal;
        }
    }

    void emitInstructions()
    {
        term.emitInstructions();
        IO.displayln("sub");
    }
}