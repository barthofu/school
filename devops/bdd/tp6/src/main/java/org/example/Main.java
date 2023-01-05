package org.example;

import org.example.services.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static Core core = new Core();

    public static void main(String[] args) {

        try {

            Database.connect();

            core.displaySpellTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}