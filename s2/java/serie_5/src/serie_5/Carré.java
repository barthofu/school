/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_5;

/**
 *
 * @author p2001833
 */
public class Carré {
    
    public static boolean carréParfait (int n) {
        
        boolean test = false;
        
        try {
            
            if (n < 0 || n == 0) throw new NombreNegatifException("Le nombre doit être supérieur à 0");
            
            test = (Math.sqrt(n) * Math.sqrt(n) == n);

        } catch (  ArrayIndexOutOfBoundsException e ) {
            System.out.println(e);
        } catch ( NombreNegatifException e ) {
            System.out.println(e);
        }
        
        return test;
        
    }
}
