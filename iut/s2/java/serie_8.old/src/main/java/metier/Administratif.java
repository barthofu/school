/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Benjamin
 */
public final class Administratif extends Personnel implements Gratifié {

    /**
     * le salaire mensuel de l'administratif
     */
    private double salaireMensuel;

    
    /**
     * Constructeur de Administratif
     *
     * @param nom nom de l'administratif
     * @param numBureau numéro de bureau de l'administratif
     * @param sal le salaire de l'administratif
     */
    public Administratif(String nom, int numBureau, double sal) {
        super(nom, numBureau);
        salaireMensuel = sal + PRIME;
    }
    
    
    // code de calculSalaire --> polymorphisme

    /**
     * Calcul du salaire d'un administratif
     *
     * @return le salaire de l'administratif
     * @see Personnel#calculerSalaire()
     */
    @Override
    public double calculerSalaire() {
        return salaireMensuel;
    }
    
    
    // redefinition de toString() -> polymorphisme

    /**
     * Description d'un administratif
     *
     * @return une chaîne de caractères décrivant l'administratif
     * @see Personnel#toString()
     */
    @Override
    public String toString() {
        return "\n\n\nAdministratif - " + super.toString() + "\nSalaire mensuel + prime: " + salaireMensuel + "\n";
    }

    
    /**
     * Affectation d'un salaire
     *
     * @param sal le salaire de l'administratif
     */
    public void setSalaireMensuel(double sal) {
        salaireMensuel = sal + PRIME;
    }

    
}
