package org.example.models;

public class Spell {

    public int ID;
    public int ID_TYPE;
    public int ID_ELEMENT;
    public int DEGAT;
    public int POINT_MAGIE;
    public String INCANTATION;

    private int counterId;


    public Spell(int ID, int ID_TYPE, int ID_ELEMENT, int DEGAT, int POINT_MAGIE, String INCANTATION) {
        this.ID = counterId;
        counterId++;
        this.ID_TYPE = ID_TYPE;
        this.ID_ELEMENT = ID_ELEMENT;
        this.DEGAT = DEGAT;
        this.POINT_MAGIE = POINT_MAGIE;
        this.INCANTATION = INCANTATION;

    }

}


