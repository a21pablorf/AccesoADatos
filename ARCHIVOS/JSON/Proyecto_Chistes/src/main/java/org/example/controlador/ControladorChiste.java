package org.example.controlador;

import org.example.IChisteDao;
import org.example.vista.IVistaChiste;

public class ControladorChiste implements IControladorChiste{
    private final IChisteDao chisteDao;
    private final IVistaChiste vistaChiste;

    public ControladorChiste(IChisteDao chisteDao, IVistaChiste vistaChiste) {
        this.chisteDao = chisteDao;
        this.vistaChiste = vistaChiste;
    }

    @Override
    public String getRandomJoke() {
        return chisteDao.getRandomJoke();
    }
}
