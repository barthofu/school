package models.diseases;

import models.Disease;
import models.Drug;
import models.DrugType;
import utils.RandomUtil;

import java.util.List;
import java.util.Random;

enum BacteriaStage {
    Low,
    Moderate,
    Dangerous,
    Critic
}

public class Bacteria extends Disease {

    private BacteriaStage stage;

    public Bacteria(String name, int force, int dangerousness, String symptoms) {
        super(name, force, dangerousness, symptoms);

        // get a random stage from the enum
        List<BacteriaStage> stages = List.of(BacteriaStage.values());

        stage = RandomUtil.getRandomFromList(stages);
    }

    @Override
    public int evolution() {

        // define the evolution action randomly
        if (RandomUtil.randomInt(0, 1) == 0) {
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
            if (drug.getType() == DrugType.Antibiotic) force = 0;
            else if (drug.getType() == DrugType.Antiviral) force -= 10;
        }
        else if (stage == BacteriaStage.Moderate) {
            if (drug.getType() == DrugType.Antibiotic) force -= 10;
            else if (drug.getType() == DrugType.Antiviral) force -= 3;
        }
        else if (stage == BacteriaStage.Dangerous) {
            if (drug.getType() == DrugType.Antibiotic) {
                stage = BacteriaStage.Moderate;
                return true;
            }
        }
        else if (stage == BacteriaStage.Critic) {
            if (drug.getType() == DrugType.Antibiotic) force -= 10;
        }

        if (initialForce != force) return true;
        else return false;
    }
}
