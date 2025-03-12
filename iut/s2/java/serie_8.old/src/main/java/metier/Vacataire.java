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
public final class Vacataire extends Enseignant {
    

    /**
     * le tarif horaire du vacataire
     */
    private double tarifHoraire;
    /**
     * le nombre d'heures travaillées dans le mois
     */
    private int[] nombreDHeures = new int[31];

    /**
     * Constructeur de Vacataire
     *
     * @param nom nom de l'enseignant
     * @param numBureau numéro de bureau de l'enseignant
     * @param numCasier numéro de casier de l'enseignant
     * @param tarifHeure le tarif horaire
     * @param nbH le nombre d'heures travaillées dans le mois
     *
     */
    public Vacataire(String nom, int numBureau, int numCasier, double tarifHeure, int[] nbH) {
        super(nom, numBureau, numCasier);
        tarifHoraire = tarifHeure;
        nombreDHeures = nbH;
    }

    /**
     * Calcul du salaire du vacataire
     *
     * @return le salaire du vacataire
     * @see Personnel#calculerSalaire()
     */
    @Override
    public double calculerSalaire() {
        int nbTotalMois = 0;
        for (int item : nombreDHeures) {
            nbTotalMois += item;
        }
        return tarifHoraire * nbTotalMois;
    }

    /**
     * Description d'un vacataire
     *
     * @return une chaîne de caractères décrivant le vacataire
     * @see Enseignant#toString()
     */
    @Override
    public String toString() {
        return "\n\n\nVacataire - " + super.toString() + "\nTarif horaire: " + tarifHoraire
                + "\nSalaire mensuel: " + calculerSalaire() + "\n";
    }

    /**
     * Affectation d'un tarif horaire
     *
     * @param tarifH le tarif horaire
     */
    public void setTarifHoraire(double tarifH) {
        tarifHoraire = tarifH;
    }

    /**
     * Obtention du tarif horaire
     *
     * @return le tarif horaire
     */
    public double getTarifHoraire() {
        return tarifHoraire;
    }

    /**
     * Affectation des heures travaillées
     *
     * @param nbH un tableau d'entiers représentant le nombre d'heures
     * travaillées par jour
     */
    public void setNombreDHeures(int[] nbH) {
        nombreDHeures = nbH;
    }

    /**
     * Obtention du nombre d'heures travaillées
     *
     * @return un tableau d'entiers représentant le nombre d'heures travaillées
     * par jour
     */
    public int[] getNombreDHeures() {
        return nombreDHeures;
    }
}
