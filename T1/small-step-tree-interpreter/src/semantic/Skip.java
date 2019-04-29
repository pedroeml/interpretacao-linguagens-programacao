package semantic;

import environment.Environment;

public class Skip extends AbstractSyntaxTree {

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        return null;
    }
}
