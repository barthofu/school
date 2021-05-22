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
public final class Permanent extends Enseignant implements Gratifié {

    /**
     * le salaire mensuel du permanent
     */
    private double salaireMensuel;

    /**
     * Constructeur de Permanent
     *
     * @param nom nom de l'enseignant
     * @param numBureau numéro de bureau de l'enseignant
     * @param numCasier numéro de casier de l'enseignant
     * @param sal le salaire du permanent
     */
    public Permanent(String nom, int numBureau, int numCasier, double sal) {
        super(nom, numBureau, numCasier);
        salaireMensuel = sal + PRIME;
    }

    /**
     * Calcul du salaire du permanent
     *
     * @return le salaire du permanent
     * @see Personnel#calculerSalaire()
     */
    @Override
    public double calculerSalaire() {
        return salaireMensuel;
    }

    /**
     * Description d'un permanent
     *
     * @return une chaîne de caractères décrivant le permanent
     * @see Enseignant#toString()
     */
    @Override
    public String toString() {
        return "\n\n\nPermanent - " + super.toString() + "\nSalaire mensuel + prime: " + salaireMensuel + "\n";
    }

    /**
     * Affectation d'un salaire
     *
     * @param sal le salaire de l'enseignant
     */
    public void setSalaireMensuel(double sal) {
        salaireMensuel = sal + PRIME;
    }
    
   
    
    
}
