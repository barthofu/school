/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métier;

import java.util.Comparator;

/**
 *
 * @author Bartho
 */
public class CompareNom implements Comparator {
    

    public int compare(Object o1, Object o2) {
            
        Personnel p1 = (Personnel) o1;
        Personnel p2 = (Personnel) o2;
        
        String nomPersonnelP1 = p1.getNomPersonnel();
        String nomPersonnelP2 = p2.getNomPersonnel();
        
        int compare = nomPersonnelP1.compareTo(nomPersonnelP2);
        
        return compare < 0 ? -1 : compare > 0 ? 1 : 0;      
    }
}
