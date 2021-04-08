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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            int n = Integer.parseInt(args[0]);
            System.out.println(n + (Carré.carréParfait(n) ? " est un carré parfait": " n'est pas un carré parfait"));
            System.out.println("\n\n==========================\n\nAprès " + 19 + " années, votre capital vaudra : " + CaisseEpargne.calculCapital(19));

        } catch (NumberFormatException e) {
            
            System.out.println("L'argument n'est pas un entier" + e);
            
        } catch ( Exception e) {
            
            System.out.println("Une erreur est survenue : " + e);
        }

        
        
    }
    
}
