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
public class Vacataire extends Enseignant {
    
    private double tarifHoraire;
    private int[] nombreDHeures;
    
    public Vacataire (String nomP, int numB, int numC, double tarifH, int[] nbDH) {
        
        super(nomP, numB, numC);
        tarifHoraire = tarifH;
        nombreDHeures = nbDH;
    }
    
    @Override
    public double calculerSalaire () {
        
        int sommeHeures = 0;
        for (int value : nombreDHeures) {
            sommeHeures += value;
        }
  
        return (double) sommeHeures * tarifHoraire;
    }

    public double getTarifHoraire() {
        return tarifHoraire;
    }

    public int[] getNombreDHeures() {
        return nombreDHeures;
    }

    public void setTarifHoraire(double tarifH) {
        this.tarifHoraire = tarifH;
    }

    public void setNombreDHeures(int[] nombreDHeures) {
        this.nombreDHeures = nombreDHeures;
    }
        
    @Override
    public String toString() {
        
        int sommeHeures = 0;
        
        for (int value : nombreDHeures) {
            sommeHeures += value;
        }
        
        return super.toString()
            + "Nombre d'heures : "      + sommeHeures       + "h\n"
            + "Tarif horaire : "        + tarifHoraire      + " €\n"
            + "Sera payé ce mois-ci: "  + calculerSalaire() + " €\n";
    } 
    
}
