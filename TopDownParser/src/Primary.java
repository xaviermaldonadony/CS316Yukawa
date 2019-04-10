import java.util.*;

abstract class Primary
{
    void printParseTree(String indent)
    {
        IO.display(indent + indent.length() + " <primary>");
    }

    abstract Val Eval(HashMap<String,Val> state);
    abstract void emitInstructions();

    static class Id extends Primary
    {
        String id;

        Id(String ident)
        {
            id = ident;
        }

        void printParseTree(String indent)
        {
            super.printParseTree(indent);
            IO.displayln(" " + id);
        }

        Val Eval(HashMap<String,Val> state)
        {
            Val idVal = state.get(id);
            if ( idVal != null )
                return idVal.cloneVal();
            else
            {
                System.out.println( "variable "+id+" does not have a value" );
                return null;
            }
        }

        void emitInstructions()
        {
            IO.displayln("push " + id);
        }
    }

    static class Int extends Primary
    {
        int val;

        Int(int i)
        {
            val = i;
        }

        void printParseTree(String indent)
        {
            super.printParseTree(indent);
            IO.displayln(" " + val);
        }

        Val Eval(HashMap<String,Val> state)
        {
            return new Val.IntVal(val);
        }

        void emitInstructions()
        {
            IO.displayln("push " + val);
        }
    }

    static class Floatp extends Primary
    {
        float val;

        Floatp(float f)
        {
            val = f;
        }

        void printParseTree(String indent)
        {
            super.printParseTree(indent);
            IO.displayln(" " + val);
        }

        Val Eval(HashMap<String,Val> state)
        {
            return new Val.FloatVal(val);
        }

        void emitInstructions()
        {
            IO.displayln("push " + val);
        }
    }

    static class Parenthesized extends Primary
    {
        E e;

        Parenthesized(E exp)
        {
            e = exp;
        }

        void printParseTree(String indent)
        {
            super.printParseTree(indent);
            IO.displayln("");
            e.printParseTree(indent+" ");
        }

        Val Eval(HashMap<String,Val> state)
        {
            return e.Eval(state);
        }

        void emitInstructions()
        {
            e.emitInstructions();
        }
    }
}



