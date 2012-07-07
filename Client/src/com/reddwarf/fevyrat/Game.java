/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Markus
 */
public class Game extends StateBasedGame {

    public static void main(String []args) {
        try {
            AppGameContainer app = new AppGameContainer(new Game("Fevyrat"));
            app.setDisplayMode(640, 480, false);
            app.setAlwaysRender(true); //otherwise, if the game is in background, it would not run ... maybe change it back
            app.setShowFPS(true);
            app.setSmoothDeltas(true);
            app.setTargetFrameRate(60);
            app.start();
        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Game(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new InGameState(1));
    }
    
}
