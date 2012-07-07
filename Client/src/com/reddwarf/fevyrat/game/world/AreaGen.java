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
public class AreaGen {
    private static PerlinNoise pn = new PerlinNoise(0x1000, System.currentTimeMillis());
    
    public static byte[][] generate(int w, int h) {
        byte[] tiles = new byte[w*h];
        byte[] data = new byte[w*h];
        
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                float v = pn.pn2d(x*0.05f, y*0.05f);
//                double v = SimplexNoise.noise(x*0.05, y*0.05);
//                System.out.println(v+"");
                if (v < -0.5) {
                    tiles[x+y*w] = Tile.water.id;
                }
                if (v > -0.5f) {
                    tiles[x+y*w] = Tile.gras.id;
                } 
            }
        }
        
        return new byte[][]{tiles,data};
    }
}
