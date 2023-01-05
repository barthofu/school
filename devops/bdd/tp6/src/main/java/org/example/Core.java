package org.example;

import org.example.models.Spell;
import org.example.services.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Core {

    /**
     * Add a spell to the database
     * @param
     * @param ID
     * @param ID_TYPE
     * @param ID_ELEMENT
     * @param DEGAT
     * @param POINTMAGIEINCANTATION
     *
     */
    public void addSpell(Spell newSpell) {

    }


    /**
     * Display the spell table
     */
    public void displaySpellTable() {

        try {
            ResultSet spells = Database.getTable("SORT");

//            System.out.println(spells.toString());
            while (spells.next()) {
                System.out.println(spells.getString("INCANTATION"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
