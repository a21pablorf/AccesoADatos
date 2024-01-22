package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Class.forName("org.sqlite.Driver");

        Connection con= DriverManager.getConnection("jdbc:sqlite:L:\\AccesoADatos\\BD\\zoo.sqlite3");
        System.out.println(con.getMetaData().getDatabaseProductName());

        }
    }
