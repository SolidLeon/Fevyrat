/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat.game;

import com.reddwarf.fevyrat.game.world.Area;
import com.reddwarf.fevyrat.game.world.tile.Tile;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Markus
 */
public class Fevyrat {

    private Area area;
    private int xScroll, yScroll;

    public Fevyrat() {
        area = new Area();
    }
    
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        int xt0 = (xScroll>>4)-1;
        int yt0 = (yScroll>>4)-1;
        int w = (container.getWidth()>>4)+1;
        int h = (container.getHeight()>>4)+1;
        
        for (int x = xt0; x <= xt0+w; x++) {
            for (int y = yt0; y<=yt0+h;y++) {
                Tile t = area.getTile(x,y);
                t.draw(area, x, y);
            }
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
        
    }
    
}
