/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Bartho
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //exercice 1 -----------
        
        CaisseEpargne.calculCapital(6);
        
        // ---------------------
        
        System.out.println("\n\n====================\n\n");
        
        //exercice 2 -----------
        
        String hMarche;
        String nbMarche;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            
            System.out.println("entrez le nombre de marche : ");
            nbMarche = reader.readLine();
            
            System.out.println("entrez la hauteur des marches (en cm): ");
            hMarche = reader.readLine();
            
            try {
                
                int nombreMarche = Integer.parseInt(nbMarche);
                double hauteurMarche = Double.parseDouble(hMarche);
                
                System.out.println("Pour " + nombreMarche + " marches de " + hauteurMarche + " cm, le gardien parcourt " + Phare.hauteurParcourue(nombreMarche, hauteurMarche) + " mètres par semaine.");

            } catch(java.lang.NumberFormatException e) {
                System.out.println("Problème de type");
            } catch(Exception e) {
                System.out.println("Une erreur est survenue : " + e);
            } finally {
                System.out.println("\n\n\nAu-revoir !\n");
            }
            
        } catch ( IOException e ) {
            System.out.println("Erreur lors de la saisie");
        }
        

        
    }
    
}
