/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_1;

/**
 *
 * @author p2001833
 */
public class CaisseEpargne {
    
    static final double TAILLE = 2.25;
        
    public static float calculCapital (int nbAns) {
        
        int i;
        float capital = 66769;
        for (i = 0; i < nbAns; i++) {
            
            capital += TAILLE/100*capital;
        }
        
        return capital;
    }
}
