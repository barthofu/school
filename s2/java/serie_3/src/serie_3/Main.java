/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Bartho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Entrez la chaine ADN");
        String sequenceAdn = saisie();
        System.out.println("entrez la séquence ADN");
        String seq = saisie();
        System.out.printf("Il y a %.2f%% de la sequence donnée dans la chaine renseignée", proportion(sequenceAdn, seq));
    }
    
    public static String reverse(String str){
        
        StringBuilder builder = new StringBuilder(str);
        int length = builder.length();
        
        for (int i = 0; i < length/2; i++){
            
            char temp = builder.charAt(i);
            builder.setCharAt(i, builder.charAt(length-i-1));
            builder.setCharAt(length-i-1, temp);
        }
        
        return builder.toString();
    }
    
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
            
            try{
                System.out.println("Enrez une chaine ADN valide ou \"Q\" pour quitter:");
                str=buffer.readLine();
                if (str.equals("Q")) System.exit(0);
            }catch(IOException e) {
                System.exit(1);
            }
        }
        
        return str;
    }
    
    public static double proportion(String chaineAdn, String sequenceAdn){
        
        int occur = 0;
        Matcher matcher = Pattern.compile(sequenceAdn).matcher(chaineAdn);
        
        while (matcher.find()) {
            occur++;
        }
        
        return ((occur*sequenceAdn.length()/(double)chaineAdn.length()))*100;
    }
    
    
    
}
