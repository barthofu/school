package models;

public abstract class Disease {

    protected String name;
    protected int force;
    protected int dangerousness;
    protected String symptoms;

    public abstract int evolution();

    public abstract boolean treat(Drug drug);

    public boolean isCured() {
        return force == 0;
    }

    @Override
    public String toString() {
        return "models.Disease{" +
                "name='" + name + '\'' +
                ", force=" + force +
                ", dangerousness=" + dangerousness +
                ", symptoms='" + symptoms + '\'' +
                '}';
    }
}
