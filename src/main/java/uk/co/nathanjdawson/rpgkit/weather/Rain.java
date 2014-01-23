package uk.co.nathanjdawson.rpgkit.weather;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 271678 on 23/01/14.
 */
public class Rain extends Weather {

    ArrayList<Line> rainDrops = new ArrayList<Line>();
    int boundX;
    int boundY;

    public Rain(int boundX, int boundY) {
        this.boundX = boundX;
        this.boundY = boundY;
    }

    @Override
    public void draw(Graphics g) {
        for(Line line : rainDrops){
            g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        }
    }

    @Override
    public void update(int delta) {
        for(Line line : rainDrops){
            int size = distance(line.getX1(), line.getY1(), line.getX2(), line.getY2());
            line.set(line.getX1(), n, x2, y2);
    }
        int chance = randInt(0, 10);
        if(chance == 0){
            rainDrops.add(createLine());
        }
    }


    public double distance(int x1, int y1, int x2, int y2){
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        return  point1.distance(point2);
    }

    public Line createLine(){
        int spawnX = randInt(0, boundX);
        int spawnY = randInt(0, 5);
        int spawnSizeX = spawnX + randInt(-5, 5);
        int spawnSizeY = spawnY + randInt(-5, 5);
        return new Line(spawnX, spawnY, spawnSizeX, spawnSizeY);
    }
    // http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java || Greg Case
    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
