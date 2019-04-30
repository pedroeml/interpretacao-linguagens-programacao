package semantic;

import environment.Environment;
import semantic.bool.BooleanExpression;
import semantic.bool.BooleanLiteral;

public class While extends AbstractSyntaxTree {
    private BooleanExpression b;
    private AbstractSyntaxTree c;
    private BooleanExpression rawB;

    public While(BooleanExpression b, AbstractSyntaxTree c) {
        this.b = b;
        this.c = c;
        this.rawB = b;
    }

    private While(BooleanExpression b, AbstractSyntaxTree c, BooleanExpression rawB) {
        this.b = b;
        this.c = c;
        this.rawB = rawB;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        if (!(this.b instanceof BooleanLiteral)) {
            return new While((BooleanExpression) this.b.smallStep(environmentState), this.c, this.rawB).smallStep(environmentState);
        } else {
            return new If(this.b, new Sequence(this.c, new While(this.rawB, this.c)), new Skip()).smallStep(environmentState);
        }
    }

    @Override
    public String toString() {
        return "while " + this.b.toString() + " do { " + this.c.toString() + " } ";
    }
}
