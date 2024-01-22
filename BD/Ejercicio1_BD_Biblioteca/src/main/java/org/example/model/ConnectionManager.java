package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager instance;

    private String DB_URL="jdbc:h2:L:\\AccesoADatos\\BD\\BasesDeDatos\\library";

    private String DB_DRIVERS="org.h2.Driver";

    private Connection conexion;

    private ConnectionManager(){
        try {
            Class.forName(DB_DRIVERS);
            conexion= DriverManager.getConnection(DB_URL);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver de H2 "+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al cargar la base de datos "+e.getMessage());
        }
    }

    public synchronized static ConnectionManager getInstance(){
        if(instance==null){
            instance=new ConnectionManager();
        }
        return instance;
    }

    public Connection getConexion(){
        return conexion;
    }
}
