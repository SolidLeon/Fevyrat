/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat.game.world.tile;

import com.reddwarf.fevyrat.TileSet;
import com.reddwarf.fevyrat.game.world.Area;
import org.newdawn.slick.Color;

/**
 *
 * @author Markus
 */
public class GrasTile extends Tile {

    private Color col =  new Color(0.0f, 0.5f, 0.0f); 
    
    public GrasTile(int id) {
        super(id);
    }

    @Override
    public void draw(Area area, int xt, int yt) {
        TileSet.draw(12+2*16, xt*16, yt*16, col);
    }

    @Override
    public boolean plow(Area area, int xt, int yt) {
        area.setTile(xt, yt, Tile.plowed, 0);
        return true;
    }
    
    
    
    
}
