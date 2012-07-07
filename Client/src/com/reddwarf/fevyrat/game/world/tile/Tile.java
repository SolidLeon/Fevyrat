/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat.game.world.tile;

import com.reddwarf.fevyrat.game.world.Area;

/**
 *
 * @author Markus
 */
public class Tile {
    public static final Tile[] tiles = new Tile[256];
    public static final Tile empty = new EmptyTile(0);
    public static final Tile gras = new GrasTile(1);
    public static final Tile water = new WaterTile(2);
    public static final Tile plowed = new PlowedTile(3);
    
    public final byte id;
    
    public Tile(int id) {
        this.id = (byte) id;
        tiles[id] = this;
    }
    
    public void draw(Area area, int xt, int yt) {}

    public boolean plow(Area area, int xt, int yt) {
        return false;
    }
}
