// Value objects used for expression evaluation and returned by Eval function.

abstract class Val
{
    abstract Val cloneVal();
    abstract double floatVal(); // conversion to double-type floating-point number
    abstract boolean isNumber();
    abstract boolean isZero();
}
class IntVal extends Val
{
    int val;

    IntVal(int i)
    {
        val = i;
    }

    public String toString()
    {
        return val+"";
    }

    Val cloneVal()
    {
        return new IntVal(val);
    }

    double floatVal()
    {
        return (double)val;
    }

    boolean isNumber()
    {
        return true;
    }

    boolean isZero()
    {
        return val == 0;
    }

    public static class BoolVal {
    }
}

class BoolVal extends Val
{
    boolean val;

    BoolVal(boolean b)
    {
        val = b;
    }

    public String toString()
    {
        return val+"";
    }

    Val cloneVal()
    {
        return new BoolVal(val);
    }

    double floatVal()
    {
        if ( val )
            return 1.0;
        else
            return 0.0;
    }

    boolean isNumber()
    {
        return false;
    }

    boolean isZero()
    {
        return false;
    }
}
class FloatVal extends Val
{
    double val;

    FloatVal(double f)
    {
        val = f;
    }

    public String toString()
    {
        return val+"";
    }

    Val cloneVal()
    {
        return new FloatVal(val);
    }

    double floatVal()
    {
        return val;
    }

    boolean isNumber()
    {
        return true;
    }

    boolean isZero()
    {
        return val == 0.0;
    }
}