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
public abstract class Enseignant extends Personnel implements Cloneable {
    /**
     * le numéro de casier de l'enseignant
     */
    protected int numeroCasier;

    
    /**
     * Constructeur de Enseignant
     *
     * @param nom nom de l'enseignant
     * @param numBureau numéro de bureau de l'enseignant
     * @param numCasier numéro de casier de l'enseignant
     *
     */
    public Enseignant(String nom, int numBureau, int numCasier) {
        super(nom, numBureau);
        numeroCasier = numCasier;
    }
    
    
    //
    // calculerSalaire --> abstract inutile ici
    //

    /**
     * Description d'un enseignant
     *
     * @return une chaîne de caractères décrivant l'enseignant
     * @see Personnel#toString()
     */
    @Override
    public String toString() {
        return super.toString() + "\nNuméro de casier: " + numeroCasier;
    }

    
    /**
     * Clonage d'un enseignant
     *
     * @return un clone
     * @throws java.lang.CloneNotSupportedException
     * @see Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    
    /**
     * Affectation d'un numéro de casier
     *
     * @param numC le numéro de casier
     */
    public void setNumeroCasier(int numC) {
        numeroCasier = numC;
    }

    
    /**
     * Obtention du numéro de casier d'un enseignant
     *
     * @return le numéro de casier
     */
    public int getNumeroCasier() {
        return numeroCasier;
    }
    
}
