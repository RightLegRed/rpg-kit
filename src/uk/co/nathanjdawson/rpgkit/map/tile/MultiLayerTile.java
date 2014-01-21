package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created by 271678 on 20/01/14.
 */
public class MultiLayerTile extends Tile {

    Tile background;

    public MultiLayerTile(Point location) {
        super(location);
    }

    @Override
    public void draw(Graphics graphics) {
        background.draw(graphics);
    }

    @Override
    public void setLocation(Point location) {
        super.setLocation(location);
        background.setLocation(location);
    }

    public Tile getBackground() {
        return background;
    }

    public void setBackground(Tile background) {
        this.background = background;
    }
}
