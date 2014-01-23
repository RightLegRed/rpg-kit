package uk.co.nathanjdawson.rpgkit.weather;

import org.newdawn.slick.Graphics;

/**
 * Created by 271678 on 23/01/14.
 */
public abstract class Weather {

    public abstract void draw(Graphics g);

    public abstract void update(int delta);
}
