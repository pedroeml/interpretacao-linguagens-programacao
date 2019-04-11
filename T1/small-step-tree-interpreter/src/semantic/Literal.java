package semantic;

public class Literal<E> {
    private E nu;

    public Literal(E nu) {
        this.nu = nu;
    }

    public E getNu() {
        return nu;
    }

    @Override
    public String toString() {
        return this.nu.toString();
    }
}
