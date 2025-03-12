/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import métier.Compte;
import métier.CompteBancaire;
import métier.CompteEpargne;
import utilitaire.Conteneur;

/**
 *
 * @author p2001833
 */
public class TestCompte{
    
    public static void main(String[] args){
    
        List<Compte> listeComptes = ajouterComptes();
        
        afficherComptes(listeComptes);
        
        try {
            Conteneur<Compte> monConteneur = new Conteneur<>(listeComptes);
            monConteneur.sauvegarder("F-SAUV-Conteneur");
        } catch (Exception ex) {
            Logger.getLogger(TestCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static List<Compte> ajouterComptes() {
        
        List<Compte> listeComptes = new ArrayList<>();
        
        listeComptes.add(new CompteBancaire("1", 150, -100, 1));
        listeComptes.add(new CompteBancaire("2", 2000, -1000, 1));
        listeComptes.add(new CompteBancaire("3", 0.34, 0, 1));
        listeComptes.add(new CompteBancaire("4", 200000, 0, 1.5));
        
        listeComptes.add(new CompteEpargne("5", 10000000, 1000000000, 1.5));
        listeComptes.add(new CompteEpargne("6", 275, 2000, 1.2));
        listeComptes.add(new CompteEpargne("7", 667, 3000, 2));
        listeComptes.add(new CompteEpargne("8", 1000, 1000, 1.015));
        
        return listeComptes;
        
    }
    
    
    public static void afficherComptes(List<Compte> comptes) {
        
        for (Compte compte : comptes) {
            
            System.out.println("===================");
            System.out.println(compte);
        }
    }
    
   
    
}
