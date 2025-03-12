/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métier;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author p2001833
 */
public abstract class Compte implements Serializable {
    
    String numeroCompte ;
    protected double soldeCompte;
    protected LocalDate dateOuverture;
    protected static int dernierNumeroAttribute=0;
    
    public Compte(String numeroCompte,double soldeCompte) {
        
        dernierNumeroAttribute++;
        this.numeroCompte = numeroCompte;
        this.soldeCompte = soldeCompte;
        this.dateOuverture = LocalDate.now();
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public LocalDate getDateOuverture() {
        return dateOuverture;
    }

    public static int getDernierNumeroAttribute() {
        return dernierNumeroAttribute;
    }
    
    abstract void crediter(double args);
    
    abstract void debiter(double args);
        
    @Override
    public String toString(){
        return "Le compte n° "+ this.getNumeroCompte()+" a un solde de : "+this.getSoldeCompte()+" et a été crée le : "+this.getDateOuverture();
    }
    
}
