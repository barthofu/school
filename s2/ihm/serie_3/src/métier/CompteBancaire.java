/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métier;

/**
 *
 * @author p2001833
 */
public class CompteBancaire extends Compte {
    
    double decouvertMax;
    double tauxAgios;
    
    public CompteBancaire(String numeroCompte, double soldeCompte, double decouvertMax, double tauxAgios) {
        
        super(numeroCompte,soldeCompte);
        this.tauxAgios = tauxAgios;
        this.decouvertMax = decouvertMax;
    }
    
    @Override
    public String toString() {
    
        return("Le compte numero : "+this.numeroCompte+" est un compte bancaire avec un decouvert max de : "+this.decouvertMax+" et d'un taux d'agios a : "+this.tauxAgios);    
        }
    @Override
    public void crediter(double args) {
        this.soldeCompte = this.getSoldeCompte()+args;
    }
    
    @Override
    public void debiter(double args) {
        this.soldeCompte = this.getSoldeCompte()- args;
    }

    public double getDecouvertMax() {
        return decouvertMax;
    }

    public double getTauxAgios() {
        return tauxAgios;
    }
    
    
}
