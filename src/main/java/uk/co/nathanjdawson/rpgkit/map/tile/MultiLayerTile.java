package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created by 271678 on 20/01/14.
 */
public class MultiLayerTile extends Tile {

    Tile background;


    @Override
    public void draw(Graphics graphics) {
        if(background != null){
            background.draw(graphics);
        }
    }

    @Override
    public void onWalk() {

    }

    @Override
    public void beside() {

    }

    public void setLocation(int x, int y) {
        super.setX(x);
        super.setY(y);
        background.setX(x);
        background.setY(y);
    }

    public Tile getBackground() {
        return background;
    }

    public void setBackground(Tile background) {
        this.background = background;
    }
}
