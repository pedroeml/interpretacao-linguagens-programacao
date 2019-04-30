import environment.Environment;
import semantic.*;
import semantic.arith.Literal;
import semantic.arith.Multiply;
import semantic.arith.Subtract;
import semantic.arith.Sum;
import semantic.bool.*;
import semantic.relational.Equals;
import semantic.relational.Greater;

public class Main {
    private static Environment environmentState;

    public static void main(String[] args) {
        environmentState =  new Environment();
        environmentState.addEntry("x", new Literal(10));
        System.out.println(environmentState.toString());

        AbstractSyntaxTree tree = new Assign("x", new Multiply(new Sum(new Variable("x"), new Subtract(new Literal(10), new Literal(5))), new Literal(2)));
        tree.smallStep(environmentState).toString();
        System.out.println(tree.toString());
        System.out.println(environmentState.toString());

        tree = new And(new Or(new Equals(new Literal(5), new Literal(5)), new Greater(new Literal(5), new Literal(3))), new Not(new BooleanLiteral(false)));
        System.out.println(tree.toString() + " = " + tree.smallStep(environmentState).toString());

        tree = new Sequence(new Assign("x", new Multiply(new Literal(10), new Subtract(new Literal(5), new Literal(2)))), new Assign("y", new Variable("x")));
        tree.smallStep(environmentState);
        System.out.println(tree.toString());
        System.out.println(environmentState.toString());

        tree = new If(new Not(new Equals(new Variable("x"), new Literal(30))), new Assign("y", new Literal(15)), new Sequence(new Assign("y", new Literal(20)), new Assign("y", new Sum(new Variable("y"), new Literal(2)))));
        tree.smallStep(environmentState);
        System.out.println(tree.toString());
        System.out.println(environmentState.toString());
    }
}
