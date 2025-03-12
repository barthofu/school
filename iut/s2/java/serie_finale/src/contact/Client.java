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
public class Client extends Contact {
    
    private int sales;
    
    public Client(String lastName, String firstName, String phoneNumber, int sales){
        super(lastName,firstName,phoneNumber);
        this.sales = sales;
    }
    
    public int getSales() {
        return sales;
    }
    
    public void setSales(int sales) {
        this.sales = sales;
    }
    
}
