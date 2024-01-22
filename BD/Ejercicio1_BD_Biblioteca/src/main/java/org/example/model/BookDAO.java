package org.example.model;

import org.h2.command.Prepared;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book>{

    ConnectionManager connectionManager = ConnectionManager.getInstance();
    Connection con=connectionManager.getConexion();


    @Override
    public Book get(long id) {
        try(PreparedStatement st=con.prepareStatement("SELECT * FROM Book WHERE idBook = ?")) {
            st.setLong(1,id);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                return mapResultSetToBook(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el libro: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books=new ArrayList<Book>();
        try(PreparedStatement st=con.prepareStatement("SELECT * FROM Book")) {
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                Book book=mapResultSetToBook(rs);
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los libros: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public void save(Book book) {
        try(PreparedStatement st=con.prepareStatement("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) VALUES (?, ?, ?, ?, ?, ?);")){
            st.setString(1,book.getISBN());
            st.setString(2,book.getTitle());
            st.setString(3,book.getAuthor());
            st.setInt(4,book.getYear());
            st.setBoolean(5,book.isAvailable());
            st.setBytes(6, book.getPortada());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar el libro: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Book book) {
        try(PreparedStatement st=con.prepareStatement(
                "UPDATE PUBLIC.Book SET isbn = ?, title = ?, author = ?, ano = ?, available = ?, portada = ? WHERE idBook = ?")){
            st.setString(1,book.getISBN());
            st.setString(2,book.getTitle());
            st.setString(3,book.getAuthor());
            st.setInt(4,book.getYear());
            st.setBoolean(5,book.isAvailable());
            st.setBytes(6, book.getPortada());
            st.setLong(7,book.getIdBook());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el libro: "+e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Book book) {
        deleteById(book.getIdBook());
    }

    @Override
    public boolean deleteById(long id) {
        try(PreparedStatement ps=con.prepareStatement(
                "DELETE FROM PUBLIC.Book WHERE idBook = ?")){
            ps.setLong(1,id);
            int row= ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Integer> getAllIds() {
        List<Integer> ids=new ArrayList<Integer>();
        try(PreparedStatement st=con.prepareStatement("SELECT idBook FROM Book")) {
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                ids.add(rs.getInt("idBook"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los ids de los libros: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return ids;
    }

    @Override
    public void updateImage(Book book, String f) {


    }

    @Override
    public void updateImageById(long id, String f) {

    }

    @Override
    public void deleteAll() {
        try(PreparedStatement ps=con.prepareStatement(
                "DELETE * FROM PUBLIC.Book")){
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar todos los libros: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private Book mapResultSetToBook(ResultSet resultSet) throws SQLException {
        long idBook = resultSet.getLong("idBook");
        String isbn = resultSet.getString("isbn");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        int year = resultSet.getInt("year");
        boolean available = resultSet.getBoolean("available");
        byte[] portada = resultSet.getBytes("portada");
        return new Book(idBook, isbn, title, author, year, available, portada);
    }
}
