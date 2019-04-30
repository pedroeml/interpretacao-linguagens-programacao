package semantic;

import environment.Environment;
import semantic.bool.BooleanExpression;
import semantic.bool.BooleanLiteral;

/**
 * Abstract syntax:
 *      c ::= ... | for (c1; b; c2) do c3
 * Small-Step semantic:
 *      _______________________________________________________________
 *      <for (c1; b; c2) do { c3 }, s> ->c <c1;while b do { c3;c2 }, s>
 *
 */
public class For extends AbstractSyntaxTree {
    private BooleanExpression b;
    private AbstractSyntaxTree c1;
    private AbstractSyntaxTree c2;
    private AbstractSyntaxTree c3;

    public For(AbstractSyntaxTree c1, BooleanExpression b, AbstractSyntaxTree c2, AbstractSyntaxTree c3) {
        this.b = b;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        System.out.println("<" + this.toString() + ", " + environmentState.toString() + ">");
        return new Sequence(this.c1, new While(this.b, new Sequence(this.c3, this.c2))).smallStep(environmentState);
    }

    @Override
    public String toString() {
        return "for (" + this.c1.toString() + "; " + this.b.toString() + "; " + this.c2.toString() + ") do { " + this.c3.toString() + " }";
    }
}
