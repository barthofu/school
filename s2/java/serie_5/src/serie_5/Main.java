/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_5;

<<<<<<< HEAD
/**
 *
 * @author p2001833
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Bartho
>>>>>>> 4504634e237b2b7504b41f33c62fbcbd3a92473e
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
<<<<<<< HEAD
        // TODO code application logic here
=======

        int exo;
        boolean enCours = true;
        
        while (enCours) {
            
            System.out.print("\n\n======================\n\nVeuillez choisir l'exercice à executer :\n\n1. Carré Parfait\n2. Caisse Epargne\n3. Phare\n4. Miroir\n5. Chaine ADN\n6. Nombres Premiers\n7. Histogramme\n\nChoix : ");
            
            try {
                Scanner reader = new Scanner(System.in);
                exo = reader.nextInt();
            } catch ( InputMismatchException e ) {
                continue;
            }
            
            switch (exo) {
                
                case 1: 
                    
                    try {
                        
                        System.out.print("Veuillez indiquer un nombre : ");
                    
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                    
                        int n = parseInt(buffer.readLine());
                        
                        System.out.println(n + (Carré.carréParfait(n) ? " est un carré parfait": " n'est pas un carré parfait"));
                        
                    } catch ( IOException e ) {
                        System.out.println(e);
                    } catch ( NumberFormatException e ) {
                        System.out.println(e);
                    }
                    
                    break;
                 
                case 2:
                    
                    try {
                        
                        System.out.print("Veuillez indiquer le nombre d'année : ");
                    
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                    
                        int nbAns = parseInt(buffer.readLine());
                        
                        CaisseEpargne.calculCapital(nbAns);   
                        
                    } catch ( IOException e ) {
                        System.out.println(e);
                    } catch ( NumberFormatException e ) {
                        System.out.println(e);
                    }

                    
                    break;
                
                case 3:
                    
                    String hMarche;
                    String nbMarche;
        
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        
                    try {

                        System.out.print("Entrez le nombre de marche : ");
                        nbMarche = reader2.readLine();

                        System.out.print("Entrez la hauteur des marches (en cm): ");
                        hMarche = reader2.readLine();
                        
                        try {

                            int nombreMarche = Integer.parseInt(nbMarche);
                            double hauteurMarche = Double.parseDouble(hMarche);
                            
                            if (nombreMarche == 0 || hauteurMarche == 0) throw new NombreNegatifException("Nécessite un nombre de marche et de hauteur de marche supérieur à 0");

                            System.out.println("Pour " + nombreMarche + " marches de " + hauteurMarche + " cm, le gardien parcourt " + Phare.hauteurParcourue(nombreMarche, hauteurMarche) + " mètres par semaine.");

                        } catch(java.lang.NumberFormatException e) {
                            System.out.println("Problème de type");
                        } catch ( NombreNegatifException e ) {
                            System.out.println(e);
                        } catch(Exception e) {
                            System.out.println("Une erreur est survenue : " + e);
                        } 

                    } catch ( IOException e ) {
                        System.out.println("Erreur lors de la saisie : " + e);
                    } 
                    
                    
                case 4: 
                    
                    try {
                    
                        System.out.print("Veuillez entrer du texte à inverser : ");
                        
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                    
                        String str = buffer.readLine();
                        
                        System.out.println(Miroir.miroir(str));
                        
                    } catch ( IOException e ) {
                        System.out.println(e);
                    }

                    break;
                    
                case 5:
                    
                    String sequenceAdn = ChaineAdn.saisie();
                    String seq = ChaineAdn.saisie();
                    System.out.printf("Il y a %.2f%% de la sequence donnée dans la chaine renseignée", ChaineAdn.proportion(sequenceAdn, seq));
                    
                    break;
                    
                    
                case 6:
                    
                    try {
                        
                        System.out.print("Veuillez entrer le nombre de nombres premiers que vous désirez : ");
                    
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                    
                        int nbElts = parseInt(buffer.readLine());
                        
                        NombresPremiers.afficherNombresPremiers(nbElts);
                        
                    } catch ( IOException e ) {
                        System.out.println(e);
                    } catch ( NumberFormatException e ) {
                        System.out.println(e);
                    }
                    
                    break;
                    
                    
                case 7:
                    
                    try {
                        
                        System.out.println("Veuillez entrer le nombre de ligne que fera l'histogramme : ");
                    
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                    
                        int nbFois = parseInt(buffer.readLine());
                        
                        Histogram.afficherSymboles(nbFois, '*');
                        
                    } catch ( IOException e ) {
                        System.out.println(e);
                    } catch ( NumberFormatException e ) {
                        System.out.println(e);
                    }
                    
                    break;

                default:
                    enCours = false;
                    break;
                    
                    
                    
                
            }
            
        }
        

        
>>>>>>> 4504634e237b2b7504b41f33c62fbcbd3a92473e
    }
    
}
