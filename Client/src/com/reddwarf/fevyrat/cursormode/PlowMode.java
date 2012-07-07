/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat.cursormode;

import com.reddwarf.fevyrat.InGameState;
import com.reddwarf.fevyrat.TileSet;
import com.reddwarf.fevyrat.game.world.Area;
import org.newdawn.slick.Color;
import org.newdawn.slick.Input;

/**
 *
 * @author Markus
 */
public class PlowMode extends CursorMode{

    @Override
    public void keyPressed(InGameState game, Area area, int xCursor, int yCursor, int key) {
        if (key == Input.KEY_ESCAPE) game.changeMode(new ScrollMode());
        if (key == Input.KEY_ENTER) {
            area.getTile(xCursor, yCursor).plow(area, xCursor, yCursor);
        }
        if (key == Input.KEY_LEFT) game.xCursor -= 1;
        if (key == Input.KEY_RIGHT) game.xCursor += 1;
        if (key == Input.KEY_DOWN) game.yCursor += 1;
        if (key == Input.KEY_UP) game.yCursor -= 1;
    }
    @Override
    public void draw(int xCursor, int yCursor) {
        TileSet.draw(7+15*16, xCursor*16, yCursor*16, Color.green);
    }
    
}
