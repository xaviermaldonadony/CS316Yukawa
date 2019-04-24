abstract class BoolPrimary
{
    void printParseTree(String indent)
    {
        IO.displayln(indent + indent.length() + " <boolPrimary>");
    }
}

class SingleE extends BoolPrimary
{
    E e;

    SingleE(E e_)
    {
        e = e_;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent);
        e.printParseTree(indent+" ");
    }
}

abstract class CompBoolPrimary extends BoolPrimary
{
    E e1;
    E e2;

    CompBoolPrimary(E e_1, E e_2)
    {
        e1 = e_1;
        e2 = e_2;
    }

    abstract String getOp();

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        e1.printParseTree(indent1);
        IO.displayln(indent1 + indent1.length() + getOp());
        e2.printParseTree(indent1);
    }
}

class Lt extends CompBoolPrimary
{
    Lt(E e_1, E e_2)
    {
        super(e_1, e_2);
    }

    String getOp()
    {
        return " <";
    }
}

class Le extends CompBoolPrimary
{
    Le(E e_1, E e_2)
    {
        super(e_1, e_2);
    }

    String getOp()
    {
        return " <=";
    }
}

class Gt extends CompBoolPrimary
{
    Gt(E e_1, E e_2)
    {
        super(e_1, e_2);
    }

    String getOp()
    {
        return " >";
    }
}

class Ge extends CompBoolPrimary
{
    Ge(E e_1, E e_2)
    {
        super(e_1, e_2);
    }

    String getOp()
    {
        return " >=";
    }
}

class Eq extends CompBoolPrimary
{
    Eq(E e_1, E e_2)
    {
        super(e_1, e_2);
    }

    String getOp()
    {
        return " ==";
    }
}

class Neq extends CompBoolPrimary
{
    Neq(E e_1, E e_2)
    {
        super(e_1, e_2);
    }

    String getOp()
    {
        return " !=";
    }
}