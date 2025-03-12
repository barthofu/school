/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;

/**
 *
 * @author Benjamin
 */
public abstract class Personnel {

    
    /**
     * le numéro de personnel
     */
    private final int numeroPersonnel;
    
    
    /**
     * le nom du personnel
     */
    private String nomPersonnel;
    
    
    /**
     * le numéro de bureau du personnel
     */
    private int numeroBureau;
    
    
    /**
     * le prochain numéro de personnel à attribuer
     */
    private static int dernierNumeroPersonnel = 1;

    /**
     * Constructeur de Personnel
     *
     * @param nom nom du personnel
     * @param numBureau numéro de bureau du personnel
     *
     */
    public Personnel(String nom, int numBureau) {
        numeroPersonnel = dernierNumeroPersonnel++;
        nomPersonnel = nom;
        numeroBureau = numBureau;
    }

    
    /**
     * Obtention du numéro d'un personnel
     *
     * @return le numéro du personnel
     */
    public int getNumeroPersonnel() {
        return this.numeroPersonnel; // ou return numeroPersonnel
    }

    
    /**
     * Obtention du nom d'un personnel
     *
     * @return le nom du personnel
     */
    public String getNomPersonnel() {
        return nomPersonnel;
    }

    
    /**
     * Obtention du numéro de bureau d'un personnel
     *
     * @return le numéro de bureau du personnel
     */
    public int getNumeroBureau() {
        return numeroBureau;
    }

    
    /**
     * Affectation d'un numéro de bureau à un personnel
     *
     * @param numBureau le numéro de bureau du personnel
     */
    public void setNumeroBureau(int numBureau) {
        this.numeroBureau = numBureau;
    }

    
    /**
     * Affectation d'un nom à un personnel
     *
     * @param nomPers le nom du personnel
     */
    public void setNomPersonnel(String nomPers) {
        nomPersonnel = nomPers;
    }

    
    /**
     * Calcul du salaire d'un personnel - définition de la méthode
     *
     * @return le salaire du personnel
     */
    public abstract double calculerSalaire();

    
    /**
     * Description d'une personne
     *
     * @return une chaîne de caractères décrivant la personne
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Numero de personnel : " + numeroPersonnel + " \nNom: " + nomPersonnel + " \nBureau: " + numeroBureau;
    }


    // Substitution de equals d'Object pour indexOf et contains
    /**
     * Test d'égalité de 2 personnes
     *
     * @param o un object
     * @return un booléen indiquant l'égalité des 2 personnes
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Personnel)) {
            return false;
        }
        Personnel p = (Personnel) o;
        return this.numeroPersonnel == p.numeroPersonnel;
    }
    
    
    
    /*---------------------------------------*/
    //                Série 8                //
    /*---------------------------------------*/
 
    
    public static Personnel rechercheParBureau(int numBureau, List<Personnel> listePersonnel){
    
        for (int u = listePersonnel.size()-1; u>=0; u--){
        
            if(listePersonnel.get(u).getNumeroBureau() == numBureau){
                return listePersonnel.get(u);
            }
        
        }
    
    
        return null;
 
    }

    
}
