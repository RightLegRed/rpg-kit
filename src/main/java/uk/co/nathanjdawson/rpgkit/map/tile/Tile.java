package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created by 271678 on 13/01/14.
 */
public abstract class Tile {
    int x;
    int y;
    boolean canCollide = false;

    public String walkText = "";
    public String besideText = "";

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCanCollide() {
        return canCollide;
    }

    public void setCanCollide(boolean canCollide) {
        this.canCollide = canCollide;
    }

    // This needs to be overridden
    public abstract void draw(Graphics graphics);

    public abstract void onWalk();
    public abstract void beside();

    public String getWalkText() {
        return walkText;
    }

    public void setWalkText(String walkText) {
        this.walkText = walkText;
    }

    public String getBesideText() {
        return besideText;
    }

    public void setBesideText(String besideText) {
        this.besideText = besideText;
    }
}
