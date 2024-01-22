package org.example;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class CreadorDePoetas implements InstanceCreator<Poeta> {
    @Override
    public Poeta createInstance(Type tipo) {
        Poeta poeta = new Poeta();
        poeta.setCategoria("Poesía");
        return poeta;
    }



}