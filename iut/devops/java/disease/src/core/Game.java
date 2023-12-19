package core;

import models.Disease;
import models.Drug;
import models.Patient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static java.lang.System.exit;

public class Game {

    private List<Patient> patients;
    private List<Drug> drugs;

    public void run() {

        this.initGame();

        int numberOfPatientsHealed = 0;

        while (numberOfPatientsHealed < patients.size()) {

            int numOfPatient = 0;
            for (Patient patient : patients) {

                if (!patient.isSick()) continue;

                System.out.println("\n-----");
                System.out.println("Patient n°" + (++numOfPatient));
                System.out.println("-----");

                this.displayPatientState(patient);

                Drug choosenDrug = this.chooseDrug();

                // apply drug to all diseases
                patient.heal(choosenDrug);

                // evolution of diseases
                patient.suffer();

                if (patient.isDead()) {
                    System.out.println("\n-----\nCe patient est mort, GAME OVER !");
                    exit(0);
                } else if (!patient.isSick()) {
                    numberOfPatientsHealed++;
                    System.out.println("\nLe patient est guéri !");
                }
            }
        }

        System.out.println("\n-----\nTous les patients sont guéris, vous avez gagné !");
    }

    private Drug chooseDrug() {

        System.out.println("Choisissez un médicament :");
        for (int i = 0; i < drugs.size(); i++) {
            System.out.println(i + " - " + drugs.get(i).toString());
        }

        try {

            // get int from user
            InputStreamReader i = new InputStreamReader(System.in);
            BufferedReader b = new BufferedReader(i);
            System.out.print("\n>> ");

            // return the corresponding drug
            return drugs.get(Integer.parseInt(b.readLine()));

        } catch (Exception e) {

            System.out.println("--------------");
            System.out.println(e.getMessage());
            System.out.println("--------------");

            return chooseDrug();
        }
    }

    private void displayPatientState(Patient patient) {
        System.out.println(patient);
    }

    private void initGame() {

        List<Disease> diseases = InitGame.initDiseases();
        drugs = InitGame.initDrugs();
        patients = InitGame.initPatient(diseases);
    }
}
