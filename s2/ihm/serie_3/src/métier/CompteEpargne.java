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
public class CompteEpargne extends Compte {
    
    double plafondMax;
    double tauxRemuneration;
    
    public CompteEpargne(String numeroCompte, double soldeCompte, double plafondMax, double tauxRemuneration) {
        super(numeroCompte,soldeCompte);
        this.tauxRemuneration = tauxRemuneration;
        this.plafondMax = plafondMax;
    }
    
    @Override
    public void crediter(double args) {
        this.soldeCompte = this.soldeCompte+args;
    }
    
    @Override
    public void debiter(double args) {
        this.soldeCompte = this.soldeCompte-args;
    }
    
    @Override
    public String toString() {
        return ("Le compte eparge n°" + this.getNumeroCompte() + " a un taux de r&emuneration de " + this.getTauxRemuneration() + "et un plafond de " + this.getPlafondMax());
    }

    public double getPlafondMax() {
        return plafondMax;
    }

    public double getTauxRemuneration() {
        return tauxRemuneration;
    }
    
}
