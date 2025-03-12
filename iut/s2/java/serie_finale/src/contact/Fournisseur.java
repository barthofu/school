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
public class Fournisseur extends Contact{
    
    private double totalAmount;
    private double averageDiscount;
    
    public Fournisseur(String lastName, String firstName, String phoneNumber, int totalAmount, int averageDiscount){
        
        super(lastName,firstName,phoneNumber);
        this.totalAmount = totalAmount;
        this.averageDiscount = averageDiscount;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public double getAverageDiscount() {
        return averageDiscount;
    }
    
    public void setAverageDiscount(int averageDiscount) {
        this.averageDiscount = averageDiscount;
    }
    
    
    
}