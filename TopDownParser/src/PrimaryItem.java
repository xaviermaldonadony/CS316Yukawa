import java.util.*;

abstract class PrimaryItem
{
    Primary primary;

    abstract void printParseTree(String indent);
    abstract Val Eval(HashMap<String,Val> state, Val termVal);
    abstract void emitInstructions();

    static class SinglePrimaryItem extends PrimaryItem

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

        Val Eval(HashMap<String,Val> state, Val termVal)
        {
            termVal = primary.Eval(state);
            return termVal;
        }

        void emitInstructions()
        {
            primary.emitInstructions();
        }
    }

    static class MulPrimaryItem extends PrimaryItem

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

        Val Eval(HashMap<String,Val> state, Val termVal)
        {
            Val primaryVal = primary.Eval(state);

            if ( termVal == null || primaryVal == null )
                return null;

            // The result will be float if one or both of the arguments are float.

            Class    termClass = termVal.getClass();
            Class primaryClass = primaryVal.getClass();

            if ( termClass == Val.IntVal.class && primaryClass == Val.IntVal.class )
            {
                ((Val.IntVal)termVal).val = ((Val.IntVal)termVal).val * ((Val.IntVal)primaryVal).val;
                return termVal;
            }
            else if ( termClass == Val.IntVal.class ) // primaryClass == Val.FloatVal.class
            {
                ((Val.FloatVal)primaryVal).val = ((Val.IntVal)termVal).val * ((Val.FloatVal)primaryVal).val;
                return primaryVal;
            }
            else // termClass == Val.FloatVal.class
            {
                ((Val.FloatVal)termVal).val = termVal.floatVal() * primaryVal.floatVal();
                return termVal;
            }
        }

        void emitInstructions()
        {
            primary.emitInstructions();
            IO.displayln("mul");
        }
    }

    static class DivPrimaryItem extends PrimaryItem

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

        Val Eval(HashMap<String,Val> state, Val termVal)
        {
            Val primaryVal = primary.Eval(state);

            if ( termVal == null || primaryVal == null )
                return null;
            if ( primaryVal.isZero() )
            {
                System.out.println("division by 0");
                return null;
            }

            // The result will be float if one or both of the arguments are float.

            Class    termClass = termVal.getClass();
            Class primaryClass = primaryVal.getClass();

            if ( termClass == Val.IntVal.class && primaryClass == Val.IntVal.class )
            {
                ((Val.IntVal)termVal).val = ((Val.IntVal)termVal).val / ((Val.IntVal)primaryVal).val;
                return termVal;
            }
            else if ( termClass == Val.IntVal.class ) // primaryClass == Val.FloatVal.class
            {
                ((Val.FloatVal)primaryVal).val = ((Val.IntVal)termVal).val / ((Val.FloatVal)primaryVal).val;
                return primaryVal;
            }
            else // termClass == Val.FloatVal.class
            {
                ((Val.FloatVal)termVal).val = termVal.floatVal() / primaryVal.floatVal();
                return termVal;
            }
        }

        void emitInstructions()
        {
            primary.emitInstructions();
            IO.displayln("div");
        }
    }
}