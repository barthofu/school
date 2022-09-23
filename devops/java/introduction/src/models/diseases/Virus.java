package models.diseases;

import models.Disease;
import models.Drug;
import models.DrugType;

public class Virus extends Disease {

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

        if (drug.type == DrugType.Antiviral) this.force -= 10;
        else if (drug.type == DrugType.Antibiotic) this.force -=1;
        else return false;

        return true;
    }
}
