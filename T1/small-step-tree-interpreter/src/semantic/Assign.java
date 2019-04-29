package semantic;

import environment.Environment;
import semantic.arith.ArithmeticExpression;
import semantic.arith.Literal;

public class Assign extends AbstractSyntaxTree {
    private String varName;
    private ArithmeticExpression exp;

    public Assign(String varName, ArithmeticExpression exp) {
        this.varName = varName;
        this.exp = exp;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        if (!(this.exp instanceof Literal)) {
            return new Assign(this.varName, (Literal) this.exp.smallStep(environmentState)).smallStep(environmentState);
        } else {
            if (environmentState.getValue(this.varName) == null) {
                environmentState.addEntry(this.varName, (Literal) this.exp);
            } else {
                environmentState.updateEntry(this.varName, (Literal) this.exp);
            }

            return new Skip().smallStep(environmentState);
        }
    }

    @Override
    public String toString() {
        return "x := " + this.exp.toString();
    }
}
