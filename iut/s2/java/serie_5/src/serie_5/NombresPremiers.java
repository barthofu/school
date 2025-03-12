/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_5;

import java.lang.reflect.Array;

/**
 *
 * @author Bartho
 */
public class NombresPremiers {
    
    
    public static void afficherNombresPremiers (int nbElts) {
        
        try {
            
            if (nbElts == 0) {
                System.out.println("[]");
                return;
            }

            int tabPremier [] = new int[nbElts];
            tabPremier[0] = 1;
            int i = 2;
            int iTab = 1;
            boolean flag = true;

            while (iTab < nbElts) {

                flag = true;

                for (int k = 2; k <= i/2; ++k) {

                    if (i%k == 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    tabPremier[iTab] = i;
                    iTab++;
                }

                i++;

            }

            for (int element: tabPremier) {

                System.out.print(element + ", ");
            }
        
        } catch ( NegativeArraySizeException e ) {
            System.out.println(e);
        }
        
        
        
    }
    
}
