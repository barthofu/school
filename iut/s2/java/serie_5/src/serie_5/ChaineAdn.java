/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Bartho
 */
public class ChaineAdn {
    
    public static boolean valid(String str){
        
        if (str == null || str.equals("")) return false;
        
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (!(c == 'a' || c == 't' || c == 'g' || c == 'c')) return false;
        }
        
        return true;
    }
    
    public static String saisie(){
        
        String str = "";
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        while (!valid(str)) {
            
            try {
                
                System.out.println("Enrez une chaine ADN valide ou \"Q\" pour quitter:");
                str=buffer.readLine();
                if (str.equals("Q")) System.exit(0);
                
            } catch(IOException e) {
                System.out.println(e);;
            }
            
        }
        
        return str;
    }
    
    public static double proportion(String chaineAdn, String sequenceAdn){
        
        int occur = 0;
        
        try {
            
            if (chaineAdn.length() < sequenceAdn.length()) throw new Exception("La séquence est plus longue que la chaine d'ADN de base");
                    
            Matcher matcher = Pattern.compile(sequenceAdn).matcher(chaineAdn);

            while (matcher.find()) {
                occur++;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return ((occur*sequenceAdn.length()/(double)chaineAdn.length()))*100;
        
    }
    
}
