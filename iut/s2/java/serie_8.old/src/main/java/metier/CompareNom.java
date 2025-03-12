/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Comparator;


/**
 *
 * @author Benjamin
 */
public class CompareNom implements Comparator{
    

    public int compare(Object o1, Object o2) {
            
        Personnel p1 = (Personnel) o1;
        Personnel p2 = (Personnel) o2;
        
        String nomPersonnelP1 = p1.getNomPersonnel();
        String nomPersonnelP2 = p2.getNomPersonnel();
        
        int compare = nomPersonnelP1.compareTo(nomPersonnelP2);
        
        if(compare<0){
            return -1;
        }else if(compare>0){
            return 1;
        }else{
            return 0;
        }        
        
          
}
}
