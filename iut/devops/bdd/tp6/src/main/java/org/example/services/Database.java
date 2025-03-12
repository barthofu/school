package org.example.services;


import java.sql.*;

public class Database {

    private static final String DATABASE_URL = "jdbc:oracle:thin:@iutdoua-ora.univ-lyon1.fr:1521:cdb1";
    private static final String USER = "p2001833";
    private static final String PASSWORD = "562933";

    private static Connection connection;


    //base methods
    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }

    public static int executeUpdate(String query) throws SQLException {
        return connection.createStatement().executeUpdate(query);
    }

    public static int executeUpdate(String query, String[] columns) throws SQLException {
        return connection.prepareStatement(query, columns).executeUpdate();
    }

    public static int executeInsert(String query, String[] columns) throws SQLException {
        return connection.prepareStatement(query, columns).executeUpdate();
    }



    //advenced methods

    public static ResultSet getTable(String tableName) throws SQLException {

        PreparedStatement ps = getConnection().prepareStatement("select * from " + tableName);

        return ps.executeQuery();
    }

}
