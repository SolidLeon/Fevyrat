/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddwarf.fevyrat;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Markus
 */
public class TileSet {
    public static Image image;
    private static Color colorFilter = new Color(1.0f, 0.0f, 1.0f, 1.0f);
    
    private static Color[] colors = new Color[32];
    
    public static void init() {
        try {
//            image = new Image(
//                    TileSet.class.getResourceAsStream("/com/reddwarf/fevyrat/res/curses_square_16x16.bmp"), 
//                    "/com/reddwarf/fevyrat/res/curses_square_16x16.bmp", 
//                    false);
            image = new Image(
                    "gfx/curses_square_16x16.bmp", 
                    Color.magenta);
        } catch (SlickException ex) {
            Logger.getLogger(TileSet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void draw(int tile, int x0, int y0, int x1, int y1, Color color) {
        int sx = (tile%16) * 16;
        int sy = (tile/16) * 16;
        image.draw(x0, y0, x1, y1, sx, sy, sx+16, sy+16, color);
    }

    public static void draw(int tile, int x, int y, int col) {
        draw(tile, x, y, x+16, y+16, new Color(col));
    }
    public static void draw(int tile, int x, int y, Color col) {
        draw(tile, x, y, x+16, y+16, col);
    }
}
