package models;

public abstract class Disease {

    protected String name;
    protected int force;
    protected int dangerousness;
    protected String symptoms;

    public Disease(String name, int force, int dangerousness, String symptoms) {
        this.name = name;
        this.force = force;
        this.dangerousness = dangerousness;
        this.symptoms = symptoms;
    }

    public abstract int evolution();

    public abstract boolean treat(Drug drug);

    public boolean isCured() {
        return force == 0;
    }

    private String getDiseaseType() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return name + " • " + force + " • " + this.getDiseaseType();
    }
}
