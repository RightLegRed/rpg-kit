package uk.co.nathanjdawson.rpgkit.generator;

import org.lwjgl.util.Point;
import uk.co.nathanjdawson.rpgkit.map.tile.Tile;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 271678 on 27/01/14.
 */
public abstract class Generator {

    int boundX;
    int boundY;
    int startX;
    int startY;

    ArrayList<Tile> tiles = new ArrayList<Tile>();

    protected Generator(int boundX, int boundY) {
        this.boundX = boundX;
        this.boundY = boundY;
    }

    protected Generator(int boundX, int boundY, int startX, int startY) {
        this.boundX = boundX;
        this.boundY = boundY;
        this.startX = startX;
        this.startY = startY;
    }

    public abstract ArrayList<Tile> generate();

    public Tile getTileByLocation(Point point){
        for(Tile t : tiles){
            if(t.getLocation().equals(point)){
                return t;
            }
        }
        return null;
    }

    public Tile getTileByLocation(int x, int y){
        Point point = new Point(x, y);
        for(Tile t : tiles){
            if(t.getLocation().equals(point)){
                return t;
            }
        }
        return null;
    }

    public Tile getTileByLocation(Point point, ArrayList<Tile> newT){
        for(Tile t : newT){
            if(t.getLocation().equals(point)){
                return t;
            }
        }
        return null;
    }

    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    public void setBoundX(int boundX) {
        this.boundX = boundX;
    }

    public void setBoundY(int boundY) {
        this.boundY = boundY;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    public int getBoundX() {
        return boundX;
    }

    public int getBoundY() {
        return boundY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
