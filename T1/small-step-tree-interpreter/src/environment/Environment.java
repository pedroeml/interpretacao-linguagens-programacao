package environment;

import semantic.Literal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Environment {
    private Map<String, Literal> mapping = new HashMap<>();

    public void addEntry(String varName, Literal value) {
        this.mapping.put(varName, value);
    }

    public void updateEntry(String varName, Literal value) {
        this.mapping.replace(varName, value);
    }

    public Literal getValue(String varName) {
        return this.mapping.get(varName);
    }

    @Override
    public String toString() {
        StringBuilder environment = new StringBuilder("[");
        Iterator<Map.Entry<String, Literal>> iterator = this.mapping.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Literal> e = iterator.next();
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
