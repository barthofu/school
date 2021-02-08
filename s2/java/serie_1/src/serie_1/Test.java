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
        
        int n = Integer.parseInt(args[0]);
        System.out.println(n + (Carré.carréParfait(n) ? " est un carré parfait": " n'est pas un carré parfait"));
        
        System.out.println("Après " + 19 + " années, votre capital vaudra : " + CaisseEpargne.calculCapital(19));
    }
    
}
