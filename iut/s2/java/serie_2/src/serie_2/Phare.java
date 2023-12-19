/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_2;

/**
 *
 * @author Bartho
 */
public class Phare {
    
    
    public static double hauteurParcourue (int nbMarches, double hauteurMarches) {
        
            double hauteurParcourue = (((nbMarches * hauteurMarches)*5*7*2)/100);
            
            return hauteurParcourue;
        
    }
}
