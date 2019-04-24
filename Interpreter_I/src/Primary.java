abstract class Primary
{
    void printParseTree(String indent)
    {
        IO.display(indent + indent.length() + " <primary>");
    }
}

class VarPrimary extends Primary
{
    Var var;

    VarPrimary(Var v)
    {
        var = v;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent);
        IO.displayln("");
        var.printParseTree(indent+" ");
    }
}


class Int extends Primary
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
}

class Floatp extends Primary
{
    double val;

    Floatp(double d)
    {
        val = d;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent);
        IO.displayln(" " + val);
    }
}


class Parenthesized extends Primary
{
    Expr expr;

    Parenthesized(Expr e)
    {
        expr = e;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent);
        IO.displayln("");
        expr.printParseTree(indent+" ");
    }
}

class NegPrimary extends Primary
{
    Primary primary;

    NegPrimary(Primary p)
    {
        primary = p;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln("");
        IO.displayln(indent1 + indent1.length() + " -");
        primary.printParseTree(indent1);
    }
}

class InvPrimary extends Primary
{
    Primary primary;

    InvPrimary(Primary p)
    {
        primary = p;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln("");
        IO.displayln(indent1 + indent1.length() + " !");
        primary.printParseTree(indent1);
    }
}

class FunCallPrimary extends Primary
{
    FunCall funCall;

    FunCallPrimary(FunCall fCall)
    {
        funCall = fCall;
    }

    void printParseTree(String indent)
    {
        String indent1 = indent+" ";

        super.printParseTree(indent);
        IO.displayln("");
        IO.displayln(indent1 + indent1.length() + " <fun call primary>");
        funCall.printParseTree(indent1);
    }
}