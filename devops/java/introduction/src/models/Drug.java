package models;

public class Drug {

    protected String name;
    protected DrugType type;

    public Drug(String name, DrugType type) {
        this.name = name;
        this.type = type;
    }

    public DrugType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " • " + type;
    }

}
