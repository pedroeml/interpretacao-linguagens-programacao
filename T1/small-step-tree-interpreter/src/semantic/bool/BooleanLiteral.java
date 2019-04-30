package semantic.bool;

import environment.Environment;
import semantic.AbstractSyntaxTree;

public class BooleanLiteral extends BooleanExpression {
    private boolean bl;

    public BooleanLiteral(boolean bl) {
        this.bl = bl;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        System.out.println("<" + this.toString() + ", " + environmentState.toString() + ">");
        return this;
    }

    public boolean getBl() {
        return this.bl;
    }

    @Override
    public String toString() {
        return Boolean.toString(this.bl);
    }
}
