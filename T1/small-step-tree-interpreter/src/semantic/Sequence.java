package semantic;

import environment.Environment;

public class Sequence extends AbstractSyntaxTree {
    private AbstractSyntaxTree exp1;
    private AbstractSyntaxTree exp2;

    public Sequence(AbstractSyntaxTree exp1, AbstractSyntaxTree exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        if (!(this.exp1 instanceof Skip)) {
            return new Sequence(this.exp1.smallStep(environmentState), this.exp2).smallStep(environmentState);
        } else if (!(this.exp2 instanceof Skip)) {
            return this.exp2.smallStep(environmentState);
        } else {
            return new Skip();
        }
    }

    @Override
    public String toString() {
        return this.exp1.toString() + "; " + this.exp2.toString();
    }
}
