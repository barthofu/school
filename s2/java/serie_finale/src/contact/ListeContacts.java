/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact;

import java.util.ArrayList;

/**
 *
 * @author Bartho
 */
public class ListeContacts {
    
    private ArrayList<Contact> contactList = new ArrayList<Contact>();
    
    public static void main(String[] args) {
    }
 
    
    public void add (Contact c) throws IllegalArgumentException {
                
        //check if a contact with the same firstname, lastname and phonenumber already exists
        for (Contact contact : contactList) {
            if (contact.getLastName() == c.getLastName() &&
                contact.getFirstName() == c.getFirstName() &&
                contact.getPhoneNumber() == c.getPhoneNumber()
                    ) {
                throw new IllegalArgumentException("Un contact avec ces informations existe déjà.");
            }    
        }
        
        contactList.add(c);
                
    }
    
    public void delete (int id) throws IllegalArgumentException {
        
        boolean haveFound = false;
        
        for (int i = 0; i < contactList.size(); i++) {
            
            if (contactList.get(i).getId() == id) {
                haveFound = true;
                contactList.remove(i);
            }
        }
        
        if (!haveFound) throw new IllegalArgumentException("Id not found");
    }
    
    public String toString () {
        
        String str = "";
        
        for (Contact contact : contactList) {
            str += "\nId : " + contact.getId() + " | Nom : " + contact.getLastName() + " | Prénom : " + contact.getFirstName() + " | Tel : " + contact.getPhoneNumber() + " | Type : " + contact.getClass().getName();
        }
        
        return str;
    }
    
    public String printClients () {
        
        String str = "";
        
        for (Contact contact : contactList) {
            if (contact instanceof Client) str += "\nId : " + contact.getId() + " | Nom : " + contact.getLastName() + " | Prénom : " + contact.getFirstName() + " | Tel : " + contact.getPhoneNumber() + " | Type : " + contact.getClass().getName();
        }
        
        return str;
    }
    
    public String printFournisseurs () {
        
        String str = "";
        
        for (Contact contact : contactList) {
            if (contact instanceof Fournisseur) str += "\nId : " + contact.getId() + " | Nom : " + contact.getLastName() + " | Prénom : " + contact.getFirstName() + " | Tel : " + contact.getPhoneNumber() + " | Type : " + contact.getClass().getName();
        }
        
        return str;
    }
    
    
    
    
    
    
}
