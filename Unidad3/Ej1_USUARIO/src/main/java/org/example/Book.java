package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {
    //isbn, title, author, year, available, image
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String isbn;
    private String title;
    private String author;
    private int ano;
    private boolean available;
    private byte[] portada;

    public Book() {
    }

    public Book(String isbn, String title, String author, int ano, boolean available, byte[] image) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.ano = ano;
        this.available = available;
        this.portada = image;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int year) {
        this.ano = year;
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

    public void setPortada(byte[] image) {
        this.portada = image;
    }

    //toString
    @Override
    public String toString() {
        return "Book{" + "idBook=" + idBook + ", isbn=" + isbn + ", title=" +
                title + ", author=" + author + ", year=" + ano + ", available="
                + available + ", image=" + portada + '}';
    }
}
