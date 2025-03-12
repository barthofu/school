package models.diseases;

import models.Disease;
import models.Drug;
import models.DrugType;

public class Virus extends Disease {

    public Virus(String name, int force, int dangerousness, String symptoms) {
        super(name, force, dangerousness, symptoms);
    }

    @Override
    public int evolution() {

        // force evolution of the disease
        force += 2 * (force / 25);

        // harm on the patient
        Double ratioForce = force * 0.1;
        return ratioForce.intValue() * dangerousness;
    }

    @Override
    public boolean treat(Drug drug) {

        if (drug.getType() == DrugType.Antiviral) this.force -= 10;
        else if (drug.getType() == DrugType.Antibiotic) this.force -=1;
        else return false;

        return true;
    }
}
