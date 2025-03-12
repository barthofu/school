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
public abstract class Enseignant extends Personnel {
    
    protected int numeroCasier;
    
    public Enseignant (String nom, int numB, int numCasier) {
        
        super(nom, numB);
        numeroCasier = numCasier;
    }

    public int getNumeroCasier() {
        return numeroCasier;
    }

    public void setNumeroCasier(int numeroC) {
        this.numeroCasier = numeroC;
    }
    
    @Override
    public String toString() {
        return super.toString() 
            + "numeroCasier : " + numeroCasier + "\n";
    }
    
    
}
