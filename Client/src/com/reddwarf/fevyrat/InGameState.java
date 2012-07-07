/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat;

import com.reddwarf.fevyrat.cursormode.CursorMode;
import com.reddwarf.fevyrat.cursormode.ScrollMode;
import com.reddwarf.fevyrat.game.world.Area;
import com.reddwarf.fevyrat.game.world.tile.Tile;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Markus
 */
public class InGameState extends AbstractGameState {
    
    public Area area;
    public int xScroll, yScroll;
    public int xCursor, yCursor;
    
    private boolean cursorShow = true;
    private int time;
    
    private CursorMode cursorMode = new ScrollMode();
    private CursorMode changeCursor;
    
    public InGameState(int id) {
        super(id);
    }
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        TileSet.init();
        area = new Area();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        int xt0 = (xScroll>>4)-1;
        int yt0 = (yScroll>>4)-1;
        int w = (container.getWidth()>>4)+1;
        int h = (container.getHeight()>>4)+1;
        
        g.translate(-xScroll, -yScroll);
        for (int x = xt0; x <= xt0+w; x++) {
            for (int y = yt0; y<=yt0+h;y++) {
                Tile t = area.getTile(x,y);
                t.draw(area, x, y);
            }
        }
        if (cursorMode != null && cursorShow) {
            cursorMode.draw(xCursor, yCursor);
        }
        g.translate(xScroll, yScroll);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        time -= delta;
        if (time <= 0) {
            cursorShow = !cursorShow;
            time = 250;
        }
        if (changeCursor != null) {
            cursorMode = changeCursor;
            changeCursor = null;
            centerCursor(container.getWidth(), container.getHeight());
        }
        
    }

    public void changeMode(CursorMode newMode) {
        changeCursor = newMode;
    }
    
    public void centerCursor(int w, int h) {
        int xt = (xScroll>>4) + ((w>>4)/2);
        int yt = (yScroll>>4) + ((h>>4)/2);
        xCursor = xt;
        yCursor = yt;
    }

    @Override
    public void keyPressed(int key, char c) {
        if (cursorMode != null) cursorMode.keyPressed(this, area, xCursor, yCursor, key);
    }
    
    private void plow(int xt, int yt) {
        area.getTile(xt, yt).plow(area, xt, yt);
    }
    
}
