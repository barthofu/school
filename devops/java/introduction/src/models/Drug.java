package models;

enum DrugType {
    Antibiotic,
    Antiviral,
    Antiparasite
}

public class Drug {

    protected String name;
    protected DrugType type;
    protected int efficiency;

    public Drug(String name, DrugType type, int efficiency) {
        this.name = name;
        this.type = type;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return "models.Drug{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", efficiency=" + efficiency +
                '}';
    }

}
