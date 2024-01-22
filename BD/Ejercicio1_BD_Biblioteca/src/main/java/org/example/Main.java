package org.example;

import org.example.model.ConnectionManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static InputStream getPortada(String isbn){
        final String IMGURL="L:\\AccesoADatos\\BD\\BasesDeDatos\\biblioteca\\cover_books\\";

        try {
            return Files.newInputStream(Path.of(IMGURL+isbn+".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws SQLException {



        ConnectionManager connectionManager = ConnectionManager.getInstance();

        Connection con=connectionManager.getConexion();

        if(con!=null){
            System.out.println("Conexión establecida");
        }else{
            System.out.println("Conexión no establecida");
        }

        try(PreparedStatement ps=con.prepareStatement("Select * from Book")){
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("title"));
            }
        }


//        assert con != null;
//        try(PreparedStatement ps=con.prepareStatement("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) VALUES (?, ?, ?, ?, ?, ?);")){
//            ps.setString(1,"9788499088150");
//            ps.setString(2,"Verano");
//            ps.setString(3,"J. M. Coetzee");
//            ps.setInt(4,2009);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9788499088150"));
//            ps.addBatch();
//
//            ps.setString(1,"9788433960023");
//            ps.setString(2,"Niveles de Vida");
//            ps.setString(3,"Julian Barnes");
//            ps.setInt(4,2013);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9788433960023"));
//            ps.addBatch();
//
//            ps.setString(1,"9788478884452");
//            ps.setString(2,"Harry Potter y la piedra filosofal");
//            ps.setString(3,"J.K. Rowling");
//            ps.setInt(4,1997);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9788478884452"));
//            ps.addBatch();
//
//            ps.setString(1,"9788408238218");
//            ps.setString(2,"El gran Gatsby");
//            ps.setString(3,"F. Scott Fitzgerald");
//            ps.setInt(4,1925);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9788408238218"));
//            ps.addBatch();
//
////            ps.setString(1,"9780241984758");
////            ps.setString(2,"The Catcher in the Rye");
////            ps.setString(3,"J.D. Salinger");
////            ps.setInt(4,1951);
////            ps.setBoolean(5,true);
////            ps.setBlob(6, getPortada("9780241984758"));
////            ps.addBatch();
//
//            ps.setString(1,"9788433977373");
//            ps.setString(2,"The Sense of an Ending");
//            ps.setString(3,"Julian Barnes");
//            ps.setInt(4,2011);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9788433977373"));
//            ps.addBatch();
//
//            //VALUES ('9788439741114', 'No es país para viejos: No Country for Old Men', 'Cormac McCarthy', 2005, TRUE, NULL)
//            ps.setString(1,"9788439741114");
//            ps.setString(2,"No es pais para viejos");
//            ps.setString(3,"Cormac McCarthy");
//            ps.setInt(4,2005);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9788439741114"));
//            ps.addBatch();
//
//            //VALUES ('9788483468685', 'The Road', 'Cormac McCarthy', 2006, TRUE, NULL)
//            ps.setString(1,"9788483468685");
//            ps.setString(2,"The Road");
//            ps.setString(3,"Cormac McCarthy");
//            ps.setInt(4,2006);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9788483468685"));
//            ps.addBatch();
//
//            //VALUES ('9788433979551', 'El ruido del tiempo', 'Julian Barnes', 2016, TRUE, NULL)
//            ps.setString(1,"9788433979551");
//            ps.setString(2,"El ruido del tiempo");
//            ps.setString(3,"Julian Barnes");
//            ps.setInt(4,2016);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9788433979551"));
//            ps.addBatch();
//
//            //VALUES ('9781035003754', 'All the Pretty Horses', 'Cormac McCarthy', 1992, TRUE, NULL)
//            ps.setString(1,"9781035003754");
//            ps.setString(2,"All the Pretty Horses");
//            ps.setString(3,"Cormac McCarthy");
//            ps.setInt(4,1992);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9781035003754"));
//            ps.addBatch();
//
//            //VALUES ('9788433960023', 'Levels of Life', 'Julian Barnes', 2013, TRUE, NULL)
//            ps.setString(1,"9788433960023");
//            ps.setString(2,"Levels of Life");
//            ps.setString(3,"Julian Barnes");
//            ps.setInt(4,2013);
//            ps.setBoolean(5,true);
//            ps.setBlob(6, getPortada("9788433960023"));
//            ps.addBatch();
//
//            int[] updateCounts = ps.executeBatch();
//            con.commit();
//        }


    }

}