package semantic.bool;

import environment.Environment;
import semantic.AbstractSyntaxTree;

public class Not extends BooleanExpression {
    private BooleanExpression exp;

    public Not(BooleanExpression exp1) {
        this.exp = exp1;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        System.out.println("<" + this.toString() + ", " + environmentState.toString() + ">");
        if (!(this.exp instanceof BooleanLiteral)) {
            return new Not((BooleanLiteral) this.exp.smallStep(environmentState)).smallStep(environmentState);
        } else {
            return new BooleanLiteral(!((BooleanLiteral) this.exp).getBl());
        }
    }

    @Override
    public String toString() {
        return "!" + this.exp.toString();
    }
}
