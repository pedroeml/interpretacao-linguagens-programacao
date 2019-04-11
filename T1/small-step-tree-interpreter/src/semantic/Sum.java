package semantic;

import environment.Environment;

public class Sum<E> extends AbstractSyntaxTree<E> {
    private ArithmeticExpression<E> exp1;
    private ArithmeticExpression<E> exp2;

    public Sum(ArithmeticExpression<E> exp1, ArithmeticExpression<E> exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public AbstractSyntaxTree<E> smallStep(Environment<E> environmentState) {
        if (!(this.exp1 instanceof Literal<E>)) {
            return new Sum(this.exp1.smallStep(environmentState), exp2);
        } else if (!(this.exp2 instanceof Literal<E>)) {
            return new Sum(this.exp1, this.exp2.smallStep(environmentState));
        } else {
            return new Literal<E>(this.exp1.getValue() + this.exp2.getValue());
        }
    }


    @Override
    public String toString() {
        return this.exp1.toString() + " + " + this.exp2.toString();
    }
}
