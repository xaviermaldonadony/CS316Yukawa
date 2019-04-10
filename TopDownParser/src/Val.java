
// value objects used for expression evaluation and returned by Eval function

abstract class Val
{
    abstract Val cloneVal();
    abstract float floatVal(); // conversion of integer value to float value
    abstract boolean isZero();

    static class IntVal extends Val
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

        float floatVal()
        {
            return (float)val;
        }

        boolean isZero()
        {
            return val == 0;
        }
    }

    static class FloatVal extends Val
    {
        float val;

        FloatVal(float f)
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

        float floatVal()
        {
            return val;
        }

        boolean isZero()
        {
            return val == 0.0f;
        }
    }
}