import environment.Environment;
import semantic.*;
import semantic.arith.*;
import semantic.bool.*;
import semantic.relational.*;

public class Main {
    private static Environment environmentState;

    public static void main(String[] args) {
        environmentState =  new Environment();
        environmentState.addEntry("x", new Literal(17));
        environmentState.addEntry("y", new Literal(5));

        AbstractSyntaxTree tree = new Sequence(
                new Assign("z", new Literal(0)),
                new While(
                        new Or(
                                new Less(new Variable("y"), new Variable("x")),
                                new Equals(new Variable("y"), new Variable("x"))),
                        new Sequence(
                                new Assign("z", new Sum(new Variable("z"), new Literal(1))),
                                new Assign("x", new Subtract(new Variable("x"), new Variable("y"))))));
        tree.smallStep(environmentState);

    }
}
