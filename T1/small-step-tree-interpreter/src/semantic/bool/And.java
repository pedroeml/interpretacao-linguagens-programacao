package semantic.bool;

import environment.Environment;
import semantic.AbstractSyntaxTree;

public class And extends BooleanExpression {
    private BooleanExpression exp1;
    private BooleanExpression exp2;

    public And(BooleanExpression exp1, BooleanExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        System.out.println("<" + this.toString() + ", " + environmentState.toString() + ">");
        if (!(this.exp1 instanceof BooleanLiteral)) {
            return new And((BooleanLiteral) this.exp1.smallStep(environmentState), this.exp2).smallStep(environmentState);
        } else if (!(this.exp2 instanceof BooleanLiteral)) {
            return new And(this.exp1, (BooleanLiteral) this.exp2.smallStep(environmentState)).smallStep(environmentState);
        } else {
            return new BooleanLiteral(((BooleanLiteral) this.exp1).getBl() && ((BooleanLiteral) this.exp2).getBl());
        }
    }

    @Override
    public String toString() {
        return "(" + this.exp1.toString() + " && " + this.exp2.toString() + ")";
    }
}
