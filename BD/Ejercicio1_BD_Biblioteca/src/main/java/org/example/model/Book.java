package org.example.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Book {
    private long idBook;
    private String title;
    private String ISBN;
    private String author;
    private int year;
    private boolean available;
    byte[] portada;

    public Book() {
    }

    //Haz este constructor: Book(String isbn, String title, String author, int year, boolean available)
    public Book(String isbn, String title, String author, int year, boolean available) {
        this.ISBN = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    //Ahora este Book(Integer idBook, String isbn, String title, String author,
    // Integer year, Boolean available, byte[] portada)
    public Book(Long idBook, String isbn, String title, String author, Integer year, Boolean available, byte[] portada) {
        this.idBook = idBook;
        this.ISBN = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
        this.portada = portada;
    }

    //Get y set para cada atributo y los set devuelven una referencia al objeto


    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(Path f) {
        try {
            this.portada = Files.readAllBytes(f);
        } catch (IOException e) {
            System.err.println("Error al leer la portada desde el archivo: " + e.getMessage());
        }
    }

    public void setPortada(String f){
        try {
            this.portada = Files.readAllBytes(Path.of(f));
        } catch (IOException e) {
            System.err.println("Error al leer la portada desde el archivo: " + e.getMessage());
        }
    }

    public void getImage(Byte[] p){
        if(p!=null){
            for (int i = 0; i < p.length; i++) {
                System.out.print(p[i]);
            }
        }
    }

}
