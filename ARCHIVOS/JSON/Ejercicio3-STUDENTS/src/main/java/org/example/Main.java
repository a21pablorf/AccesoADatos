package org.example;


public class Main {
    public static void main(String[] args) {
        int numBooks = 9;
        Book[] books = new Book[numBooks];

        for (int i = 0; i < numBooks; i++) {
            books[i] = new Book(i);
            books[i].setName("Libro "+i);
        }

        int numStudents = 4;
        for (int i = 0; i < numStudents; i++) {
            Thread t= new  Student(i + "1", books);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}