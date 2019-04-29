package semantic;

import environment.Environment;

public class Variable extends ArithmeticExpression {
    private String varName;

    public Variable(String varName) {
        this.varName = varName;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        if (environmentState.getValue(this.varName) == null) {
            return new Literal(0);
        } else {
            return environmentState.getValue(this.varName);
        }
    }
}
