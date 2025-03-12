/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact; 

/**
 *
 * @author Bartho
 */
public class Test {
    
    public static void main (String[] args) {
        
        ListeContacts contacts = new ListeContacts();
        
        Client c1 = new Client("Faverot", "Benjamin", "027628272", 162);
        Client c2 = new Client("Gueffaf", "Mohamed", "027626282", 100);
        Client c3 = new Client("Lagache", "Quentin", "8257291", 0);
        
        Fournisseur f1 = new Fournisseur("Gili", "Bartholomé", "5R2627972", 10, 15);

        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        contacts.add(f1);
        
        System.out.println(contacts);
        
        contacts.delete(1);
        
        System.out.println("\n\n===========================\n\n" + contacts.toString());   
        
        System.out.println("\n\n===========================\n\n" + contacts.printClients());
        
        System.out.println("\n\n===========================\n\n" + contacts.printFournisseurs());   
        
    }
}
