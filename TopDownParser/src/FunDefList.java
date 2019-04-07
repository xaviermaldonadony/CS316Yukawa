import java.util.*;

class FunDefList
{
    // ⟨fun def list⟩ → { ⟨fun def⟩ }+
    //⟨fun def⟩ → ⟨header⟩ ⟨body⟩
    //⟨header⟩ → ⟨fun name⟩ "(" [ ⟨parameter list⟩ ] ")"
    //⟨fun name⟩ → ⟨id⟩
    LinkedList<FunDef> funDefList;

    FunDefList(LinkedList<FunDef> fl)
    {
        funDefList = fl;
    }

    void printParseTree(String indent)
    {
        for ( FunDef a : funDefList )
            a.printParseTree(indent);
    }

    void M(HashMap<String,Val> state) // function to interpret this assignment list
    {
//        for ( FunDef a : funDefList )
//            a.M(state);
    }

    void emitInstructions()
    {
//        for ( FunDef a : funDefList )
//            a.emitInstructions();
    }
}