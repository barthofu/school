package models;

import models.Disease;

import java.util.HashSet;
import java.util.stream.Collectors;

public class Patient {

    protected String lastName;
    protected String firstName;
    protected double life;
    protected int age;
    protected HashSet<Disease> diseases = new HashSet<>();

    public Patient(String lastName, String firstName, int age, double life) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.life = life;
        this.age = age;
    }

    protected static int numberOfSickPatients;

    public boolean isDead() {
        return life <= 0;
    }

    public boolean isSick() {
        return diseases.size() > 0;
    }

    public void addDisease(Disease disease) {
        if (!this.isSick()) numberOfSickPatients++;
        diseases.add(disease);
    }

    public void heal(Drug drug) {

        for (Disease disease : diseases) {
            disease.treat(drug);
        }

        diseases = diseases.stream().filter((disease) -> !disease.isCured()).collect(Collectors.toCollection(HashSet::new));

        if (!this.isSick()) numberOfSickPatients--;
    }

    public void suffer() {

        for (Disease disease : diseases) {

            int damage = disease.evolution();

            if (age <= 15) life -= (int) (damage * 1.25);
            else if (age <= 50) life -= (int) (damage * 1.33);
            else life -= damage;
        }
    }

    @Override
    public String toString() {

        String diseasesString = "";

        for (Disease disease : diseases) {
            diseasesString += "- " + disease.toString() + "\n";
        }

        return "" +
                lastName + " " + firstName + " (" + age + " ans)\n" +
                "vie: " + life + "\n" +
                "maladies: \n" + diseasesString;
    }
}
