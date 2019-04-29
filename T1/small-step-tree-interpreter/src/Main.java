import environment.Environment;
import semantic.*;
import semantic.arith.Literal;
import semantic.arith.Multiply;
import semantic.arith.Subtract;
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

        AbstractSyntaxTree tree = new Assign("x", new Multiply(new Sum(new Variable("x"), new Subtract(new Literal(10), new Literal(5))), new Literal(2)));
        tree.smallStep(environmentState).toString();
        System.out.println(tree.toString());
        System.out.println(environmentState.toString());

        tree = new And(new Or(new BooleanLiteral(true), new BooleanLiteral(false)), new Not(new BooleanLiteral(false)));
        System.out.println(tree.toString() + " = " + tree.smallStep(environmentState).toString());
    }
}
