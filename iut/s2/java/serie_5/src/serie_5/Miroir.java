/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_5;

/**
 *
 * @author Bartho
 */
public class Miroir {
    
    public static String miroir (String str) {
        
        StringBuilder builder = new StringBuilder(str);
        int length = builder.length();
        
        for (int i = 0; i < length/2; i++) {
            
            char temp = builder.charAt(i);
            builder.setCharAt(i, builder.charAt(length-i-1));
            builder.setCharAt(length-i-1, temp);
        }
        
        return builder.toString();
    }
    
}