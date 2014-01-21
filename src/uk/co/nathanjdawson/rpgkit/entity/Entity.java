package uk.co.nathanjdawson.rpgkit.entity;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;

/**
 * Created by 271678 on 20/01/14.
 */
public abstract class Entity {

    Point location;

    public abstract void draw(Graphics graphics);

    public int getX(){
        return location.getX();
    }

    public int getY(){
        return location.getY();
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
