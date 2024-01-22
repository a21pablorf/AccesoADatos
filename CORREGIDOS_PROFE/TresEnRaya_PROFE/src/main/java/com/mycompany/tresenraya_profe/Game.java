/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.s
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.mycompany.tresenraya_profe;

import static com.mycompany.tresenraya_profe.Tablero.getCoordenadas;
import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Random;

/**
 *
 * @author pepe
 */
public class Game {

    public final static int MOVIMIENTOS[] = {4, 0, 2, 6, 8, 1, 3, 5, 7};
    private static File ARQUIVO_DATOS = new File("L:\\AccesoADatos\\datos.dat");

    private Tablero tablero;
    private TipoFicha tipoJugador;
    private final BufferedReader lector;

    public Game() {
        Random r = new Random();
        tablero = new Tablero();
        tipoJugador = r.nextInt(2) == 0 ? TipoFicha.CRUZ : TipoFicha.CIRCULO;  // El jugador siempre comienza con X
        lector = new BufferedReader(new InputStreamReader(System.in));
    }
    
    
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setTipoJugador(TipoFicha tipoJugador) {
        this.tipoJugador = tipoJugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public TipoFicha getTipoJugador() {
        return tipoJugador;
    }

    public void play() {
        System.out.println("¡Bienvenido al juego del 3 en raya!");
        boolean fin = false;
        while (!fin) {
            System.out.println(tablero);
            if (tablero.isFull()) {
                System.out.println("¡El juego ha terminado en empate!");
                fin = true;
            } else if (tipoJugador == TipoFicha.CRUZ) {
                String linea = null;
                try {
                    System.out.print("Turno del jugador (X)."
                            + "Introduce el número de casilla (de 0 a 8): ");
                    linea = lector.readLine();
                    Point p = getCoordenadas(Integer.parseInt(linea));
                    if (!tablero.addFicha(p.x, p.y, new Ficha(tipoJugador))) {
                        System.out.println("Movimiento no válido. Inténtalo de nuevo.");
                        continue;
                    }

                } catch (IOException ex) {
                    System.out.println("Movimiento no válido. Inténtalo de nuevo.");
                    continue;
                } catch (NumberFormatException e) {
                    if (linea != null && linea.length() >= 0) {
                        if (linea.toLowerCase().charAt(0) == 'g') {
                            saveGame();
                        } else {
                            getGame();
                        }
                    }
                }
            } else {
                System.out.println("Turno del ordenador (O).");
                doComputerMovement();
            }

            if (tablero.isWinner(new Ficha(tipoJugador))) {
                System.out.println(tablero);
                System.out.println("¡Felicidades! El jugador " + tipoJugador + " ha ganado.");
                fin = true;
            } else {
                tipoJugador = (tipoJugador == TipoFicha.CRUZ) ? TipoFicha.CIRCULO
                        : TipoFicha.CRUZ;  // Cambiar turno
            }
        }

        System.out.println("¡Gracias por jugar!");
    }

//    private void realizarMovimientoOrdenador() {
//        for (int i = 0; i < Tablero.TAMANO; i++) {
//            for (int j = 0; j < Tablero.TAMANO; j++) {
//                if (tablero.isEmpty(i, j)) {
//                    tablero.addFicha(i, j, new Ficha(TipoFicha.CIRCULO));
//                    return;
//                }
//            }
//        }
//    }
    public void doComputerMovement() {
        // Posición dentro de los movimientos.
        for (int i : MOVIMIENTOS) {
            Point p = getCoordenadas(i);
            if (tablero.isEmpty(p.x, p.y)) {
                tablero.addFicha(p.x, p.y, new Ficha(TipoFicha.CIRCULO));
                return;
            }
        }
    }

    private void saveGame() {
        try ( ObjectOutputStream saida = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(ARQUIVO_DATOS)));) {
            saida.writeObject(this);
            System.out.println("Xogo gardado.");
        } catch (IOException ex) {
            System.err.println("Erro ó gardar o xogo: " + ex.getMessage());
        }
    }

    public void getGame() {
        try ( ObjectInputStream entrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ARQUIVO_DATOS)));) {
            Game xogo = (Game) entrada.readObject();
            this.tablero = xogo.tablero;
            this.tipoJugador = xogo.tipoJugador;
        } catch (IOException | ClassNotFoundException ex) {

        }
        System.out.println("Xogo cargado");
    }

    public static void main(String[] args) {
        Game juego = new Game();
        juego.play();
    }
}
