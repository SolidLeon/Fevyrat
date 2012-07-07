/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat.cursormode;

import com.reddwarf.fevyrat.InGameState;
import com.reddwarf.fevyrat.game.world.Area;
import org.newdawn.slick.Input;

/**
 *
 * @author Markus
 */
public class ScrollMode extends CursorMode {

    @Override
    public void keyPressed(InGameState game, Area area, int xCursor, int yCursor, int key) {
        if (key == Input.KEY_K) game.changeMode(new SelectionMode());
        if (key == Input.KEY_P) game.changeMode(new PlowMode());
        if (key == Input.KEY_LEFT) game.xScroll -= 16;
        if (key == Input.KEY_RIGHT) game.xScroll += 16;
        if (key == Input.KEY_DOWN) game.yScroll += 16;
        if (key == Input.KEY_UP) game.yScroll -= 16;
    }

    
    
    
}
