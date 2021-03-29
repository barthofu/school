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
public class CompteBancaire {
    
    private int numeroCompte;
    private String nomCompte;
    private double soldeCompte;
    private static int dernierNombre = 1;

    public CompteBancaire(String nouveauNom) {
        
        nomCompte = nouveauNom;
        numeroCompte = dernierNombre;
        dernierNombre++;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public String getNomCompte() {
        return nomCompte;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public static int getDernierNombre(){
        return dernierNombre;
    }
    
    public void debiter(double solde) throws DébitImpossibleException, NombreNégatifException{
        
        if(!(solde>=0)){
            throw new NombreNégatifException("Veuillez utiliser des entiers naturels");
        }
        
        if (solde <= soldeCompte) {
            soldeCompte -= solde;
        } else {
            throw new DébitImpossibleException("Débit impossible, votre compte est dans le négatif.");
        }
    }

    public void crediter(double solde) throws NombreNégatifException{
        
        if(!(solde>=0)){
            throw new NombreNégatifException("Veuillez utiliser des entiers naturels");
        }
        
        soldeCompte += solde;
    }

    //---Méthodes Spéciales---//
    public String toString() {

        return "COMPTE BANCAIRE N°" + numeroCompte
                + "\n\t -> NOM : " + nomCompte
                + "\n\t -> SOLDE : " + soldeCompte;
    }

    public boolean equals(Object u) {

        if (!(u instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire p = (CompteBancaire) u;

        return this.nomCompte.equals(p.nomCompte) && this.numeroCompte == p.numeroCompte && this.soldeCompte == p.soldeCompte;

    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}
