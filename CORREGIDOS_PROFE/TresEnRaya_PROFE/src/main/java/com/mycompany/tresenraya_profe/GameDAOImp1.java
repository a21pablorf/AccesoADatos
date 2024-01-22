/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tresenraya_profe;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A21PabloRF
 */
public class GameDAOImp1 implements GameDAO {

    private static final File ARQUIVO_DATOS = new File("L:\\AccesoADatos\\datos.dat");
    private static final File ARQUIVO_TEXTO = new File("L:\\AccesoADatos\\datos.txt");

    public static void main(String[] args) {
        Game g = new Game();
        g.doComputerMovement();
        System.out.println(g.getTablero());
    }

    @Override
    public Game getGame() {
        try ( ObjectInputStream entrada = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(ARQUIVO_DATOS)));) {
            return (Game) entrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {

        }
        return null;
    }

    @Override
    public void saveGame(Game g) {

    }

    @Override
    public Game getGameFromTextFile() {
        Game xogo = null;
        try ( BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_TEXTO));) {
            xogo = new Game();
            boolean linTurno=false;
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#")) {
                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        if(!linTurno){
                            xogo.setTipoJugador(TipoFicha.getTipoFicha(c));
                            linTurno=true;
                        }  
                        else{
                            Point p = Tablero.getCoordenadas(posicion++);
                            xogo.getTablero().addFicha(p.x, , ficha)
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("mal");
        }
        return null;
    }

    @Override
    public void saveGameToTextFile(Game game) {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_TEXTO));) {
            bw.write("Turno: \n");
            bw.write("" + game.getTipoJugador());
            bw.newLine();
            bw.write("# Tablero \n");
            Tablero tab = game.getTablero();
            for (int i = 0; i < Tablero.TAMANO; i++) {
                for (int j = 0; j < Tablero.TAMANO; j++) {
                    bw.write(tab.getFicha(i, j) + "");
                }
                bw.newLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(GameDAOImp1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
