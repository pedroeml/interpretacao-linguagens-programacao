package semantic.arith;

import environment.Environment;
import semantic.AbstractSyntaxTree;

public class Multiply extends ArithmeticExpression {
    private ArithmeticExpression exp1;
    private ArithmeticExpression exp2;

    public Multiply(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        if (!(this.exp1 instanceof Literal)) {
            return new Multiply((Literal) this.exp1.smallStep(environmentState), this.exp2).smallStep(environmentState);
        } else if (!(this.exp2 instanceof Literal)) {
            return new Multiply(this.exp1, (Literal) this.exp2.smallStep(environmentState)).smallStep(environmentState);
        } else {
            return new Literal(((Literal) this.exp1).getNu() * ((Literal) this.exp2).getNu());
        }
    }

    @Override
    public String toString() {
        return "(" + this.exp1.toString() + " * " + this.exp2.toString() + ")";
    }
}