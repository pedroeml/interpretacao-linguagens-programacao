package semantic.arith;

import environment.Environment;
import semantic.AbstractSyntaxTree;

public class Literal extends ArithmeticExpression {
    private int nu;

    public Literal(int nu) {
        this.nu = nu;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        System.out.println("<" + this.toString() + ", " + environmentState.toString() + ">");
        return this;
    }

    public int getNu() {
        return nu;
    }

    @Override
    public String toString() {
        return Integer.toString(this.nu);
    }
}
