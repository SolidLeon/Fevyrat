/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat.game.world;

import com.reddwarf.fevyrat.game.world.tile.Tile;

/**
 *
 * @author Markus
 */
public class Area {
    public byte []tiles;
    public byte []data;

    public int w, h;
    
    public Area() {
        this.w = 256;
        this.h = 256;
        
        byte[][] map = AreaGen.generate(w, h);
        
        tiles = map[0];
        data = map[1];
    }

    public Tile getTile(int xt, int yt) {
        if (xt < 0 || yt < 0 || xt >= w || yt >= h) return Tile.gras;
        return Tile.tiles[tiles[xt+yt*w]];
    }
    
    
    public void render() {
        int xt0 = 0;
        int yt0 = 0;
        int xt1 = 0;
        int yt1 = 0;
        
        for (int x = xt0; x <= xt1; x++) {
            for (int y = yt0; y<=yt1;y++) {
                Tile t = getTile(x,y);
                t.draw(this, x, y);
            }
        }
    }

    public void setTile(int xt, int yt, Tile tile, int dataValue) {
        if (xt < 0 || yt < 0 || xt >= w || yt >= h) return;
        tiles[xt+yt*w] = tile.id;
        data[xt+yt*w] = (byte) dataValue;
    }
    
    
}
