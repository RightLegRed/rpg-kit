package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

/**
 * Created by 271678 on 27/01/14.
 */
public class TransportTile extends Tile {
    ArrayList<Tile> tileWorld = new ArrayList<Tile>();

    public TransportTile(Point location) {
        super(location);
    }

    public TransportTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {

    }

    @Override
    public void onWalk() {

    }

    @Override
    public void beside() {

    }

    public ArrayList<Tile> getTileWorld() {
        return tileWorld;
    }

    public void setTileWorld(ArrayList<Tile> tileWorld) {
        this.tileWorld = tileWorld;
    }
}
