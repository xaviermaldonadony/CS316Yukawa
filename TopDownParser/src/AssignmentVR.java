public class AssignmentVR {
// ⟨assignment⟩ → ⟨var⟩ "=" ⟨right side⟩ ";"
    String var;
    AssignmentVR()
    {
        this.var = var;
    }

    void printParseTree(String indent)
    {
        IO.display(indent + indent.length() + " <Assignment>");
        IO.display(indent + indent + indent.length() + " <var>");

    }

}
abstract class RightSide
{
    void printParseTree(String indent)
    {
        IO.display(indent + indent.length() + " <Right Side>");
    }
}

class ArrayConstructor extends RightSide
{
    EList el;

    ArrayConstructor(String n, EList el)
    {
        this.el = el;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent);
        IO.display(indent + indent.length() + " <Array Constructor>");
        el.printParseTree(indent);
    }
}

class ExprRightSide extends RightSide
{
    Expr expr;

    ExprRightSide(Expr expr)
    {
        this.expr = expr;
    }

    void printParseTree(String indent)
    {
        super.printParseTree(indent);
        IO.display(indent + indent.length() + " <Expr Right Side>");
        expr.printParseTree(indent);
    }
}