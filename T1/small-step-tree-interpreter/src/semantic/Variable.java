package semantic;

import environment.Environment;
import semantic.arith.ArithmeticExpression;
import semantic.arith.Literal;

public class Variable extends ArithmeticExpression {
    private String varName;

    public Variable(String varName) {
        this.varName = varName;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        System.out.println("<" + this.toString() + ", " + environmentState.toString() + ">");
        if (environmentState.getValue(this.varName) == null) {
            return new Literal(0);
        } else {
            return environmentState.getValue(this.varName);
        }
    }

    @Override
    public String toString() {
        return this.varName;
    }
}
