package semantic;

import environment.Environment;
import semantic.bool.BooleanExpression;
import semantic.bool.BooleanLiteral;

public class If extends AbstractSyntaxTree {
    private BooleanExpression b;
    private AbstractSyntaxTree c1;
    private AbstractSyntaxTree c2;

    public If(BooleanExpression b, AbstractSyntaxTree c1, AbstractSyntaxTree c2) {
        this.b = b;
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        if (!(this.b instanceof BooleanLiteral)) {
            return new If((BooleanExpression) this.b.smallStep(environmentState), this.c1, this.c2).smallStep(environmentState);
        } else if (((BooleanLiteral) this.b).getBl()) {
            return this.c1.smallStep(environmentState);
        } else {
            return this.c2.smallStep(environmentState);
        }
    }

    @Override
    public String toString() {
        return "if " + this.b.toString() + " then { " + this.c1.toString() + " } else { " + this.c2.toString() + " }";
    }
}
