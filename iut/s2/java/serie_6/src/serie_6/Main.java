/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_6;

/**
 *
 * @author Bartho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CompteBancaire c[] = new CompteBancaire[3];

        c[0] = new CompteBancaire("A");
        c[1] = new CompteBancaire("B");
        try {
            c[2] = (CompteBancaire) c[1].clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Erreur lors du clonage du compte N°"+ c[1].getNumeroCompte());
        }
        
        try {
            c[1].crediter(666.0);
        } catch (NombreNégatifException ex) {
            System.out.println(ex);
        }
        
        try {
            c[0].crediter(138);
            c[0].debiter(69.0);
        } catch (DébitImpossibleException | NombreNégatifException ex) {
            System.out.println(ex);
        }
        
        for (CompteBancaire i : c) {
            System.out.println(i.toString() + '\n');
        }

        System.out.println("->  \"c[2].equals(c[1])\" retourne : "+c[2].equals(c[1]));
        
        System.out.println("->  le prochain compte créé aura le numéro : "+CompteBancaire.getDernierNombre());
    }
    
}
