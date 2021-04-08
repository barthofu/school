/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author p2001833
 */
public class CaisseEpargne {
    
    static final double TAILLE = 2.25;

    public static void calculCapital (int nbAns) {
        
        try {
            
            if (nbAns == 0) throw new NombreNegatifException("Le nombre d'années ne doit pas être égal à 0");
            
            double capital;
            
            Scanner reader = new Scanner(System.in);
            System.out.println("Entrez la valeur de votre capital financier : ");
            
            try {
                
                capital = reader.nextDouble();
                
                if (capital == 0.0) throw new NombreNegatifException("Le capital ne doit pas être égal à 0");
                
                int i;
                for (i = 0; i < nbAns; i++) {
                    capital += TAILLE/100*capital;
                }
                
                System.out.printf("Après %d années, le capital de départ vaudra : " + "%.2f %n", nbAns, capital);
                
            } catch ( InputMismatchException e) { //si l'input de l'utilisateur n'est pas de type double
                
                System.out.println("Nombre réel attendu");
                
            } catch (Exception e) {
                
                System.out.println("Une erreur est survenue : " + e);
                
            }
        } catch ( NombreNegatifException e) {
            System.out.println(e);
        } catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println(e);
        }
    }
}
