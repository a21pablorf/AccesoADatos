/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tresenraya_profe;

/**
 *
 * @author A21PabloRF
 */
public interface GameDAO {
    public Game getGame();
    public void saveGame(Game g);
    public Game getGameFromTextFile();
    public void saveGameToTextFile(Game g);
}
