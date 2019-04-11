import environment.Environment;
import semantic.Literal;

public class Main {
    private static Environment<Integer> environmentState;

    public static void main(String[] args) {
        environmentState =  new Environment<>();
        environmentState.addEntry("x", new Literal<>(123));
        System.out.println(environmentState.toString());
    }
}
