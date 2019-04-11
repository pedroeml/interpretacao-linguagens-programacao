package environment;

import semantic.Literal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Environment<E> {
    private Map<String, Literal<E>> mapping = new HashMap<>();

    public void addEntry(String varName, Literal<E> value) {
        this.mapping.put(varName, value);
    }

    public void updateEntry(String varName, Literal<E> value) {
        this.mapping.replace(varName, value);
    }

    public Literal<E> getValue(String varName) {
        return this.mapping.get(varName);
    }

    @Override
    public String toString() {
        StringBuilder environment = new StringBuilder("[");
        Iterator<Map.Entry<String, Literal<E>>> iterator = this.mapping.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Literal<E>> e = iterator.next();
            environment.append(e.getKey());
            environment.append(" |-> ");
            environment.append(e.getValue().toString());
            if (iterator.hasNext()) {
                environment.append(", ");
            }
        }

        environment.append("]");

        return environment.toString();
    }
}
