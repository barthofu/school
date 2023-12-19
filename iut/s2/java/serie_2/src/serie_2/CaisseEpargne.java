/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author p2001833
 */
public class CaisseEpargne {
    
    static final double TAILLE = 2.25;
        
    public static void calculCapital (int nbAns) {
        
        double capital;
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Entre la valeur de ton capital financier : ");
        
        try {
            
            capital = reader.nextDouble();
            int i;
            for (i = 0; i < nbAns; i++) {
                capital += TAILLE/100*capital;
            }
            
            System.out.printf("Après %d années, le capital de départ vaudra : " + "%.2f %n", nbAns, capital);
            
        } catch ( InputMismatchException e) { //si l'input de l'utilisateur n'est pas de type double
            
            System.out.println("Nombre réel attendu");
            
        } catch (Exception e) {
           
            System.out.println("une erreur est survenue : " + e);
            
        }        
    }
}
