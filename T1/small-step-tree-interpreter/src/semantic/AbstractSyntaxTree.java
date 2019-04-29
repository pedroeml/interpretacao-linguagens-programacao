package semantic;

import environment.Environment;

public abstract class AbstractSyntaxTree {

    public abstract AbstractSyntaxTree smallStep(Environment environmentState);
}
