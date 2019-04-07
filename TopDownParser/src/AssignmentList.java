import java.util.*;

class AssignmentList
{
    LinkedList<Assignment> assignmentList;

    AssignmentList(LinkedList<Assignment> al)
    {
        assignmentList = al;
    }

    void printParseTree(String indent)
    {
        for ( Assignment a : assignmentList )
            a.printParseTree(indent);
    }

    void M(HashMap<String,Val> state) // function to interpret this assignment list
    {
        for ( Assignment a : assignmentList )
            a.M(state);
    }

    void emitInstructions()
    {
        for ( Assignment a : assignmentList )
            a.emitInstructions();
    }
}