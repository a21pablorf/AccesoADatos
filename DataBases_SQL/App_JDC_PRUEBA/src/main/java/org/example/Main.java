package org.example;

import javax.xml.transform.Result;
import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        try(Connection conexion= DriverManager.getConnection("jdbc:sqlite:L:\\AccesoADatos\\BD\\zoo.sqlite3");
            Statement st=conexion.createStatement()) {

            ResultSet rs=st.executeQuery("SELECT * FROM animal");

            while (rs.next()){
                String nome=rs.getString("nome");
                String dataNacemento= rs.getString("dataNacemento");
                int especie= rs.getInt("idEspecie");
                System.out.printf("%10s %20s %2d%n", nome, dataNacemento, especie);
            }

            System.out.println("Conexion pechada");
        } catch (SQLException e) {
            System.err.println("Erro de conexion");
        }
    }
}