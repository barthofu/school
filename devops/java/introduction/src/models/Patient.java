package models;

import models.Disease;

import java.util.HashSet;

public class Patient {

    protected String lastName;
    protected String firstName;
    protected Double life;
    protected Double age;
    protected HashSet<Disease> diseases;

    public Patient(String lastName, String firstName, Double life, Double age) {
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
            if (disease.isCured()) diseases.remove(disease);
        }

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
        return "models.Patient{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", life=" + life +
                ", age=" + age +
                ", diseases=" + diseases +
                '}';
    }
}
