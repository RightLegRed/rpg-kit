package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import uk.co.nathanjdawson.rpgkit.Game;

/**
 * Created by 271678 on 24/01/14.
 */
public class EmptyTile extends Tile {
    public EmptyTile(Point location) {
        super(location);
    }

    public EmptyTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(getX() * Game.GAME_TILE_SIZE, getY() * Game.GAME_TILE_SIZE, 16, 16);

    }

    @Override
    public void onWalk() {

    }

    @Override
    public void beside() {

    }
}
