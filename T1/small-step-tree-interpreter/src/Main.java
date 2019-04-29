import environment.Environment;
import semantic.*;
import semantic.arith.Literal;
import semantic.arith.Sum;
import semantic.bool.And;
import semantic.bool.BooleanLiteral;
import semantic.bool.Not;
import semantic.bool.Or;

public class Main {
    private static Environment environmentState;

    public static void main(String[] args) {
        environmentState =  new Environment();
        environmentState.addEntry("x", new Literal(10));
        System.out.println(environmentState.toString());

        AbstractSyntaxTree tree = new Assign("x", new Sum(new Variable("x"), new Sum(new Literal(5), new Literal(5))));
        AbstractSyntaxTree resultingTree = tree.smallStep(environmentState);
        System.out.println(environmentState.toString());

        tree = new And(new Or(new BooleanLiteral(true), new BooleanLiteral(false)), new Not(new BooleanLiteral(false)));
        System.out.printf(tree.toString() + " = " + tree.smallStep(environmentState).toString());
    }
}
