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
public class Contact {
    
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private int id;
    private static int counter = 0;
    
    public Contact(String Nom, String Prenom, String NumeroTel){
        this.id = counter++;
        this.lastName = Nom;
        this.firstName = Nom;
        this.phoneNumber = NumeroTel;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public static int getCounter() {
        return counter;
    }
    public static void setCounter(int counter) {
        Contact.counter = counter;
    }
    
    
}