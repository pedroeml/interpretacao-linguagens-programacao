import environment.Environment;
import semantic.*;
import semantic.arith.*;
import semantic.bool.*;
import semantic.relational.*;

public class Main {
    private static Environment environmentState;

    public static void main(String[] args) {
        environmentState = sampleEnvironment();

        AbstractSyntaxTree treeWhile = new Sequence(
                new Assign("z", new Literal(0)),
                new While(
                        new Or(
                                new Less(new Variable("y"), new Variable("x")),
                                new Equals(new Variable("y"), new Variable("x"))),
                        new Sequence(
                                new Assign("z", new Sum(new Variable("z"), new Literal(1))),
                                new Assign("x", new Subtract(new Variable("x"), new Variable("y"))))));
        treeWhile.smallStep(environmentState);

        environmentState = sampleEnvironment();

        AbstractSyntaxTree treeFor = new For(
                new Assign("z", new Literal(0)),
                new Or(
                        new Less(new Variable("y"), new Variable("x")),
                        new Equals(new Variable("y"), new Variable("x"))),
                new Assign("z", new Sum(new Variable("z"), new Literal(1))),
                new Assign("x", new Subtract(new Variable("x"), new Variable("y"))));
        treeFor.smallStep(environmentState);

    }

    private static Environment sampleEnvironment() {
        Environment environment =  new Environment();
        environment.addEntry("x", new Literal(17));
        environment.addEntry("y", new Literal(5));

        return environment;
    }
}
