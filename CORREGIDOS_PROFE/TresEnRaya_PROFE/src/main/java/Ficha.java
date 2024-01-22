/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.mycompany.tresenraya_profe;

import java.util.Objects;

/**
 *
 * @author pepe
 */
public class Ficha implements Comparable<Ficha> {

    private final TipoFicha tipo;

    public Ficha() {
        this.tipo = TipoFicha.VACIA;
    }

    public Ficha(TipoFicha tipo) {
        this.tipo = tipo;
    }

    public TipoFicha getTipo() {
        return tipo;
    }

    public boolean isEmpty() {
        return this.tipo == null 
                || this.tipo == TipoFicha.VACIA;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.tipo);
    }

    @Override
    public boolean equals(Object obxecto) {
        if (this == obxecto) {
            return true;
        }
        if (obxecto == null || getClass() != obxecto.getClass()) {
            return false;
        }
        return this.tipo == ((Ficha) obxecto).tipo;
    }

    @Override
    public String toString() {
        return (tipo!=null) 
                ? tipo.toString() : null;
    }

    @Override
    public int compareTo(Ficha ficha) {
        if (tipo == ficha.tipo) {
            return 0;
        }
        if (tipo == TipoFicha.CRUZ) {
            return 1;
        }
        return -1;
    }

}
