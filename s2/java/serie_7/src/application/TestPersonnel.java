/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import métier.Administratif;
import métier.Permanent;
import métier.Personnel;
import métier.Vacataire;


/**
 *
 * @author Bartho
 */
public class TestPersonnel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List <Personnel> listePersonnes = new ArrayList<>();
        
        listePersonnes.add(new Administratif("Ethan",1,1234.0));
        listePersonnes.add(new Vacataire("Juan",2,1,9.0, new int[]{2, 8, 4} ));
        listePersonnes.add(new Permanent("Quentin",3,2,1480.0));
        listePersonnes.add(new Permanent("Lucas",4,3,1550.70));
        listePersonnes.add(new Permanent("Léna",5,4,1650.50));
        listePersonnes.add(new Administratif("Claire",6,1700.14));
        listePersonnes.add(new Vacataire("Rémy",7,5,12.0, new int[]{3,9,5,1} ));
       
        Vacataire vacataire = (Vacataire) listePersonnes.get(1);
        vacataire.setNombreDHeures(new int[]{2, 6, 10, 3});
        
        System.out.println(vacataire.hasGratification()); //vérifie si l'objet donné possède la gratification ou non
        
        for (int i = 0; i <= listePersonnes.size()-1; i++){
                        
            System.out.println("==========\n");
            System.out.println(listePersonnes.get(i));
        }
    }
}
