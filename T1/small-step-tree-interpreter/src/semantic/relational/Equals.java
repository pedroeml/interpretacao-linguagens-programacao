package semantic.relational;

import environment.Environment;
import semantic.AbstractSyntaxTree;
import semantic.arith.ArithmeticExpression;
import semantic.arith.Literal;
import semantic.bool.BooleanExpression;
import semantic.bool.BooleanLiteral;

public class Equals extends BooleanExpression {
    private ArithmeticExpression exp1;
    private ArithmeticExpression exp2;

    public Equals(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        System.out.println("<" + this.toString() + ", " + environmentState.toString() + ">");
        if (!(this.exp1 instanceof Literal)) {
            return new Equals((Literal) this.exp1.smallStep(environmentState), this.exp2).smallStep(environmentState);
        } else if (!(this.exp2 instanceof Literal)) {
            return new Equals(this.exp1, (Literal) this.exp2.smallStep(environmentState)).smallStep(environmentState);
        } else {
            return new BooleanLiteral(((Literal) this.exp1).getNu() == ((Literal) this.exp2).getNu());
        }
    }

    @Override
    public String toString() {
        return "(" + this.exp1.toString() + " = " + this.exp2.toString() + ")";
    }
}
