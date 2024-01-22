package org.example;

import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Student extends Thread{
    private final String id;
    private final Book[] libros;

    public Student(String id, Book[] libros) {
        this.id = id;
        this.libros = libros;
    }

    @Override
    public void run() {
        Random r=new Random();

        synchronized (id){
            int tiempo= r.nextInt(1,40);
            int indice1=r.nextInt(libros.length);
            int indice2;
            do {
                indice2=r.nextInt(libros.length);
            }while(indice1==indice2 && libros[indice2].isTaken()==true);

            Book libro1=libros[indice1];
            Book libro2=libros[indice2];

            libro1.setTaken(true);
            libro2.setTaken(true);

            System.out.println("Student numer: "+this.id+" is reading books: "+libro1+" and: "+libro2);
            try {
                TimeUnit.SECONDS.sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (libros){
                System.out.println("Student numer: "+this.id+" has returned books: "+libro1+" and: "+libro2);
            }

        }
    }
}
