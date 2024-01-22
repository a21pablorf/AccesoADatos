package org.example;


import org.example.controlador.ControladorChiste;
import org.example.controlador.IControladorChiste;
import org.example.vista.IVistaChiste;
import org.example.vista.VistaChisteSwing;

public class Main {
    public static void main(String[] args) {

        IChisteDao chisteDao=new ChisteDao();
        IVistaChiste vista=new VistaChisteSwing();
        IControladorChiste controlador=new ControladorChiste(chisteDao,vista);
        vista.setController(controlador);
    }
}