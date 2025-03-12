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
public class Administratif extends Personnel implements Gratifie {
    
    private double salaireMensuel;
    
    public Administratif (String nomP, int numB, double salaireM) {
        
        super(nomP, numB);
        salaireMensuel = salaireM;
    }
    
    @Override
    public double calculerSalaire() {
        return salaireMensuel + Gratifie.primeMensuelle;
    }
    
    public void setSalaireMensuel (double salaireMensuel) {
        
        this.salaireMensuel = salaireMensuel;
    }
    
    @Override
    public String toString(){
        return super.toString()
            + "Salaire mensuel : " + salaireMensuel + " €\n"
            + "Sera payé ce mois-ci : " + calculerSalaire() + " €\n";
    }
    
}
