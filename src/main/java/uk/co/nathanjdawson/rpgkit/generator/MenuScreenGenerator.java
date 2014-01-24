package uk.co.nathanjdawson.rpgkit.generator;

import org.lwjgl.util.Point;
import uk.co.nathanjdawson.rpgkit.Game;
import uk.co.nathanjdawson.rpgkit.map.tile.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Archelaus on 21/01/14.
 */
public class MenuScreenGenerator {

    int boundX = 0;
    int boundY = 0;
    ArrayList<Tile> tiles = new ArrayList<Tile>();
    Noise noise;
    double maxNoise = 0;
    double minNoise = 0;

    public MenuScreenGenerator(int boundX, int boundY) {
        this.boundX = boundX;
        this.boundY = boundY;
        noise = new Noise(new Random(), 1, boundX, boundY);
        noise.initialise();
    }

    public ArrayList<Tile> generate(){
        generateGrass();
        generateText();
        return tiles;
    }

    public void generateGrass(){
        for(int x = 0; x <= boundX; x++){
            for(int y = 0; y <= boundY; y++){
                GrassTile above = (GrassTile) getTileByLocation(new Point(x, y - 1));
                GrassTile below = (GrassTile) getTileByLocation(new Point(x, y + 1));
                GrassTile right = (GrassTile) getTileByLocation(new Point(x + 1, y));
                GrassTile left = (GrassTile) getTileByLocation(new Point(x - 1, y));
                int collection = 0;
                if(above != null){
                    collection += above.getDensity();
                }
                if(below != null){
                    collection += below.getDensity();
                }
                if(right != null){
                    collection += right.getDensity();
                }
                if(left != null){
                    collection += left.getDensity();
                }
                int med = collection / 8;
                if(med == 0){
                    med += randInt(0, 2);
                }else if(med == 2){
                    med -= randInt(-1, 2);
                }
                GrassTile grassTile = new GrassTile(new Point(x, y));
                grassTile.setDensity(med);
                tiles.add(grassTile);
            }
        }
    }

    public void generateText(){
        for(Tile t : Letter.stringToGrid("This is a test⤶Test! ", new Point(4, 5))){
            tiles.remove(getTileByLocation(t.getLocation()));
            tiles.add(t);
        }
    }


    public Tile getTileByLocation(Point point){
        for(Tile t : tiles){
            if(t.getLocation().equals(point)){
                return t;
            }
        }
        return null;
    }

    // http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java || Greg Case
    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
