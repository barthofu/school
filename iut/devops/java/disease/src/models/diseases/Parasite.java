package models.diseases;

import models.Disease;
import models.Drug;
import models.DrugType;

public class Parasite extends Disease {

    public Parasite(String name, int force, int dangerousness, String symptoms) {
        super(name, force, dangerousness, symptoms);
    }

    @Override
    public int evolution() {

        // harm on the patient
        return 3;
    }

    @Override
    public boolean treat(Drug drug) {
        if (drug.getType() == DrugType.Antiparasite) force = 0;
        else force -= 20;

        return true;
    }
}
