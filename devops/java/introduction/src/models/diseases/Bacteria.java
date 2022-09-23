package models.diseases;

import models.Disease;
import models.Drug;
import models.DrugType;

import java.util.Random;

enum BacteriaStage {
    Low,
    Moderate,
    Dangerous,
    Critic
}

public class Bacteria extends Disease {

    private BacteriaStage stage;

    public Bacteria() {

        // get a random stage from the enum
        Random random = new Random();
        BacteriaStage[] stages = BacteriaStage.values();

        stage = stages[random.nextInt(stages.length)];
    }

    @Override
    public int evolution() {

        Random random = new Random();

        // define the evolution action randomly
        if (random.nextBoolean()) {
            force += 5;
        } else {
            if (stage == BacteriaStage.Low) stage = BacteriaStage.Moderate;
            else if (stage == BacteriaStage.Moderate) stage = BacteriaStage.Dangerous;
            else if (stage == BacteriaStage.Dangerous) stage = BacteriaStage.Critic;
        }

        // harm on the patient
        Double harm;
        if (stage == BacteriaStage.Low) harm = force * 0.2;
        else if (stage == BacteriaStage.Moderate) harm = force * 0.3;
        else if (stage == BacteriaStage.Dangerous) harm = force * 0.7;
        else harm = force * 0.9;

        return harm.intValue();
    }

    @Override
    public boolean treat(Drug drug) {

        int initialForce = force;

        if (stage == BacteriaStage.Low) {
            if (drug.type == DrugType.Antibiotic) force = 0;
            else if (drug.type == DrugType.Antiviral) force -= 10;
        }
        else if (stage == BacteriaStage.Moderate) {
            if (drug.type == DrugType.Antibiotic) force -= 10;
            else if (drug.type == DrugType.Antiviral) force -= 3;
        }
        else if (stage == BacteriaStage.Dangerous) {
            if (drug.type == DrugType.Antibiotic) {
                stage = BacteriaStage.Moderate;
                return true;
            }
        }
        else if (stage == BacteriaStage.Critic) {
            if (drug.type == DrugType.Antibiotic) force -= 10;
        }

        if (initialForce != force) return true;
        else return false;
    }
}
