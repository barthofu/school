/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métier;

/**
 *
 * @author Bartho
 */
public abstract class Personnel {
    
    private int numeroPersonnel;
    private String nomPersonnel;
    private int numeroBureau;
    static private int dernierNumeroPersonnel = 0;
    
    public Personnel (String nom, int numBureau) {
        
        numeroPersonnel = ++dernierNumeroPersonnel;
        nomPersonnel = nom;
        numeroBureau = numBureau;
        
    }
    
    abstract double calculerSalaire();
    
    public String toString() {
        return "";
    }

    public int getNumeroPersonnel() {
        return numeroPersonnel;
    }

    public String getNomPersonnel() {
        return nomPersonnel;
    }

    public int getNumeroBureau() {
        return numeroBureau;
    }

    public void setNomPersonnel(String nom) {
        this.nomPersonnel = nom;
    }

    public void setNumeroBureau(int numBureau) {
        this.numeroBureau = numBureau;
    }
    
    
    
    
    
    
    
    
}
