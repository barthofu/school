/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métier;

/**
 *
 * @author p2001833
 */
public class Client {
    
    private String numeroClient;
    private String nomClient;
    private double revenuAnnuel;
    private String adresseClient;
    protected static int dernierNumClient;
    
    public Client(String numeroClient,String nomClient,double revenuAnnuel,String adresseClient){
        this.nomClient= nomClient;
        this.numeroClient= numeroClient;
        this.adresseClient= adresseClient;
        this.revenuAnnuel= revenuAnnuel;
    }

    public String getNomClient() {
        return nomClient;
    }

    public double getRevenuAnnuel() {
        return revenuAnnuel;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setRevenuAnnuel(double revenuAnnuel) {
        this.revenuAnnuel = revenuAnnuel;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }
    
}
