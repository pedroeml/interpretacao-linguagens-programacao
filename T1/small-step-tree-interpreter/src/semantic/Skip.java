package semantic;

import environment.Environment;

public class Skip extends AbstractSyntaxTree {

    @Override
    public AbstractSyntaxTree smallStep(Environment environmentState) {
        System.out.println("<" + this.toString() + ", " + environmentState.toString() + ">");
        return this;
    }

    @Override
    public String toString() {
        return "skip";
    }
}
