package semantic;

import environment.Environment;

public abstract class AbstractSyntaxTree<E> {

    public abstract AbstractSyntaxTree smallStep(Environment<E> environmentState);
}
