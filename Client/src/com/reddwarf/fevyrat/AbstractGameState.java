/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Markus
 */
public abstract class AbstractGameState extends BasicGameState {

    private int id;

    public AbstractGameState(int id) {
        this.id = id;
    }
    
    
    @Override
    public int getID() {
        return id;
    }
    
}
