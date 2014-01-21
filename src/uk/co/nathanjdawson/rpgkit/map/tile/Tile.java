package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created by 271678 on 13/01/14.
 */
public abstract class Tile {
    Point location;
    boolean canCollide = false;

    public Point getLocation(){
        return location;
    }

    public Tile(Point location) {
        this.location = location;
    }

    public int getX(){
        return location.getX();
    }

    public int getY(){
        return location.getY();
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public boolean isCanCollide() {
        return canCollide;
    }

    public void setCanCollide(boolean canCollide) {
        this.canCollide = canCollide;
    }

    // This needs to be overridden
    public abstract void draw(Graphics graphics);
}
