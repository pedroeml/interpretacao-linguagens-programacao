import environment.Environment;
import semantic.*;

public class Main {
    private static Environment environmentState;

    public static void main(String[] args) {
        environmentState =  new Environment();
        environmentState.addEntry("x", new Literal(10));
        System.out.println(environmentState.toString());

        AbstractSyntaxTree tree = new Assign("x", new Sum(new Variable("x"), new Sum(new Literal(5), new Literal(5))));
        AbstractSyntaxTree resultingTree = tree.smallStep(environmentState);
        System.out.println(environmentState.toString());

    }
}
