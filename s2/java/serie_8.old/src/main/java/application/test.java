/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.Collections;
import metier.Administratif;
import metier.CompareNom;
import metier.Permanent;
import metier.Personnel;
import metier.Vacataire;

/**
 *
 * @author Benjamin
 */
public class test {

    public static void main(String[] arg) {

        ArrayList<Personnel> listePersonnel = new ArrayList();
        
        /*
        Administratif(String nom, int numBureau, double sal)
        Vacataire(String nom, int numBureau, int numCasier, double tarifHeure, int[] nbH)
        Permanent(String nom, int numBureau, int numCasier, double sal)
         */

        listePersonnel.add(new Administratif("Jeanne",      0, 4321));
        listePersonnel.add(new Administratif("Claire",      1, 1000000));
        listePersonnel.add(new Administratif("Éleonnore",   2, 6666));
        
        listePersonnel.add(new Permanent("Yu Wang",         3,      0, 1.0001));
        listePersonnel.add(new Permanent("Louise",          4,      1, 2600));
        listePersonnel.add(new Permanent("Emma",            5,      2, 2500));
        listePersonnel.add(new Permanent("Chloé",           6,      3, 1950));
        listePersonnel.add(new Permanent("Sarah",           7,      4, 2600));
        listePersonnel.add(new Permanent("Agathe",          8,      5, 2600));
        listePersonnel.add(new Permanent("Heloïse",         9,      6, 3500));
        listePersonnel.add(new Permanent("Ambre",           10,     7, 1500));
        
        listePersonnel.add(new Vacataire("Marine",            11,     8,  9,      new int[]{1,1,1,3}));
        listePersonnel.add(new Vacataire("Prudence",        12,     9,  8,      new int[]{0,0,0}));
        listePersonnel.add(new Vacataire("Ayla",            13,     10, 0.05,   new int[]{21,18,24,16,23,15}));
        listePersonnel.add(new Vacataire("Eulalie",         14,     11, 220,    new int[]{6,6,6}));
        listePersonnel.add(new Vacataire("Helène",          15,     12, 36,     new int[]{6,5,4,6,5,4}));
        listePersonnel.add(new Vacataire("Ariana",          16,     13, 14,     new int[]{3,14,12,6,3}));
        listePersonnel.add(new Vacataire("Caroline",        17,     14, 15,     new int[]{7}));
        
        for (int u = listePersonnel.size()-1; u>=0; u--){
        
            System.out.println("----\nINDEX N°"+u+""+listePersonnel.get(u)+"\n\n"); //recherche par index
                 
        }
               
        System.out.println("\n-----------------\n");
        int bureau = 6;
        System.out.println("Personnel se trouvant au bureau N°"+bureau);
        System.out.println(Personnel.rechercheParBureau(bureau, listePersonnel)); //recherche par bureau
        
        System.out.println("\n-----------------\n");
        Permanent u = null;
        try {
            u = (Permanent) ((Permanent)listePersonnel.get(8)).clone();
        }catch (CloneNotSupportedException ex) {
            System.out.println("erreur lors du clonage");
        }
        
        if (listePersonnel.contains(u)) System.out.println(u.getNomPersonnel()+" fait partie du personnel"); //test de présence
        else System.out.println(u.getNomPersonnel()+" ne fait pas partie du personnel");
        
        System.out.println("\n-----------------\n");
        
        System.out.println("avant tri, on a :"+concatPersonnel(listePersonnel));
        Collections.sort(listePersonnel, new CompareNom());
        System.out.println("\naprès tri, on a :"+concatPersonnel(listePersonnel));
        
        //System.out.println('a' < 'a');
    }
    
    
    private static String concatPersonnel(ArrayList<Personnel> listePersonnel){
    //méthode utilisée pour mettre tout les nom à la suite en fonction de leurs index
        String u = "";
        
        for (Personnel str:listePersonnel){
        
            u += str.getNomPersonnel()+" ; ";
        
        }
        
        return u;
        
    }
    
}
