/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_5;

import java.util.Random;

/**
 *
 * @author Bartho
 */
public class Histogram {
    
    private static int leTableau[];
    
    private static int taille;
    
    
    public static void afficherSymboles (int nbFois, char c) {
        
        //Définition des attributs
        
        leTableau = new int[nbFois];
        taille = nbFois;
        
        //Génération du tableau
        
        for (int i = 0; i < taille; i++) {
            Random r = new Random();
            leTableau[i] = r.nextInt(50 + 1);  
        }
        
        //Définition du max du tableau
        
        int max = maxTableau();
        
        //Affichage 
        
        for (int i = 0; i < taille; i++) {
            
            for (int k = 0; k < leTableau[i]; k++) {
                
                System.out.print(leTableau[i] == max ? "+" : c);
            }
            
            System.out.println("");
        }
        
    }
    
    
    
    public static int maxTableau () {
        
        int max = leTableau[0];
        
        for (int i = 1; i < taille; i++) {
            
            if (leTableau[i] > max) max = leTableau[i];
        }
        
        return max;
        
    }
    
}
