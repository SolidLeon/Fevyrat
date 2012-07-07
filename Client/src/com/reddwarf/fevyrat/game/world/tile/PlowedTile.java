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
public class PlowedTile extends Tile {

    public PlowedTile(int id) {
        super(id);
    }

    @Override
    public void draw(Area area, int xt, int yt) {
        TileSet.draw(7+15*16, xt*16, yt*16, Color.yellow);
    }
    
}
