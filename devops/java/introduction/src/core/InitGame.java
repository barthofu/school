package core;

import models.Disease;
import models.Drug;
import models.DrugType;
import models.Patient;
import models.diseases.Bacteria;
import models.diseases.Parasite;
import models.diseases.Virus;
import utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class InitGame {

    private static final int MAX_PATIENTS = 10;

    public static List<Disease> initDiseases() {

        return List.of(

                new Bacteria("Gastro", 100, 1, "Troubles digestifs"),
                new Bacteria("Rhume", 100, 4, "Mal à la gorge, fatigue, nez qui coule"),
                new Bacteria("Tuberculose", 125, 6, "Fièvre, douleur poitrine, fatigue"),
                new Bacteria("Tétanos", 4, 9, "Douleurs muscles de la mâchoire et de la nuque"),

                new Virus("Angine", 70, 1, "Mal à la gorge, fatigue"),
                new Virus("Grippe", 100, 4, "État grippal"),
                new Virus("Hépatite C", 125, 6, "Fièvre, nausées, vomissements"),
                new Virus("Herpès", 45, 4, "Boutons"),

                new Parasite("Poux", 1, 1, "Démangeaisons au niveau des cheveux"),
                new Parasite("Gale", 4, 6, "Importantes démangeaisons au niveau de la peau"),
                new Parasite("Ténia", 6, 4, "Perte importante de poids, Maux de ventre violents"),
                new Parasite("Malaria", 9, 7, "Fièvre élevée soudaine, en poussées ou constante")
        );
    }

    public static List<Drug> initDrugs() {
        return List.of(

                new Drug("Amoxicilline", DrugType.Antibiotic),
//                new Drug("Bristopen", DrugType.Antibiotic),
//                new Drug("Clamoxyl", DrugType.Antibiotic),
//                new Drug("Orbénine", DrugType.Antibiotic),

                new Drug("Prioderm", DrugType.Antiparasite),
//                new Drug("Ascabiol", DrugType.Antiparasite),
//                new Drug("Fluvermal", DrugType.Antiparasite),
//                new Drug("Combantrin", DrugType.Antiparasite),

//                new Drug("Aciclovir", DrugType.Antiviral),
                new Drug("Iduviran", DrugType.Antiviral)
        );
    }

    public static List<Patient> initPatient(List<Disease> diseases) {

        List<Patient> patients = new ArrayList<>();

        for (int i = 0; i <= RandomUtil.randomInt(0, MAX_PATIENTS); i++) {

            int age = RandomUtil.randomInt(5, 100);
            Patient p = new Patient("Bartho ", "Test " + i, age, RandomUtil.randomInt(3, 99));

            for (int u = 0; u < RandomUtil.randomInt(1, 3); u++) {
                p.addDisease(RandomUtil.getRandomFromList(diseases));
            }

            patients.add(p);
        }

        return patients;
    }


}
