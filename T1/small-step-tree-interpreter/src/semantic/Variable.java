package semantic;

import environment.Environment;

public class Variable<E> {
    private String varName;
    private Environment<E> environmentState;

    public Variable(String varName, Environment<E> environmentState) {
        this.varName = varName;
        this.environmentState = environmentState;
    }

    public Literal<E> smallStep() throws Exception {
        Literal<E> literal = this.environmentState.getValue(this.varName);
        if (literal != null) {
            return literal;
        } else {
            throw new Exception("Variable " + this.varName + " not found in the Environment State");
        }
    }

}
