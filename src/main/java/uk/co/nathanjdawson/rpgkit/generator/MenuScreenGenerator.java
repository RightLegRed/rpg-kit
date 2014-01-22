package uk.co.nathanjdawson.rpgkit.generator;

import org.lwjgl.util.Point;
import uk.co.nathanjdawson.rpgkit.Game;
import uk.co.nathanjdawson.rpgkit.map.tile.GrassTile;
import uk.co.nathanjdawson.rpgkit.map.tile.LetterTile;
import uk.co.nathanjdawson.rpgkit.map.tile.PathTile;
import uk.co.nathanjdawson.rpgkit.map.tile.Tile;

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
        tiles.add(new LetterTile(new Point(0,0), "N"));
        tiles.add(new LetterTile(new Point(1,0), "A"));
        tiles.add(new LetterTile(new Point(2,0), "T"));
        tiles.add(new LetterTile(new Point(3,0), "H"));
        tiles.add(new LetterTile(new Point(4,0), "A"));
        tiles.add(new LetterTile(new Point(5,0), "N"));
        tiles.add(new LetterTile(new Point(6,0), " "));
        tiles.add(new LetterTile(new Point(7,0), "D"));
        tiles.add(new LetterTile(new Point(8,0), "A"));
        tiles.add(new LetterTile(new Point(9,0), "W"));
        tiles.add(new LetterTile(new Point(10,0), "S"));
        tiles.add(new LetterTile(new Point(11,0), "O"));
        tiles.add(new LetterTile(new Point(12,0), "N"));
        tiles.add(new LetterTile(new Point(13,0), "1"));
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

    }

    public ArrayList<Tile> stringToGrid(String str, Point startPoint){
        HashMap<Character, Tile[]> stringMap = new HashMap<Character, Tile[]>();
        stringMap.put('N', new Tile[]{new PathTile(0,0), new PathTile(0,1),
        new PathTile(0, 2), new PathTile(0, 3), new PathTile(0,4),
        new PathTile(1, 1), new PathTile(2, 2), new PathTile(3, 3),
        new PathTile(4, 4), new PathTile(4, 3), new PathTile(4, 2), new PathTile(4, 1),
        new PathTile(4,0)});
        stringMap.put('J', new Tile[]{new PathTile(0,0), new PathTile(1,0), new PathTile(2,0),
        new PathTile(3,0), new PathTile(4,0), new PathTile(3,1), new PathTile(3, 2),
        new PathTile(3,3), new PathTile(2,4), new PathTile(1,4), new PathTile(0, 3)});
        stringMap.put('D', new Tile[]{new PathTile(0,0), new PathTile(0,1), new PathTile(0,2),
        new PathTile(0,3), new PathTile(0,4), new PathTile(1,0), new PathTile(2,0), new PathTile(3,0),
        new PathTile(4,1), new PathTile(4,2), new PathTile(4,3), new PathTile(4, 1), new PathTile(4,2),
        new PathTile(4,3), new PathTile(1,4), new PathTile(2,4), new PathTile(3, 4)});
        ArrayList<Tile> tileList = new ArrayList<Tile>();

        for(int i = 0; i<str.length();i++){
            Character strCharacter = str.charAt(i);
            if(stringMap.containsKey(strCharacter)){
                for(Tile tile : stringMap.get(strCharacter)){
                    tile.setLocation(new Point((startPoint.getX() + tile.getX()) + (i * 6), startPoint.getY() + tile.getY()));
                    tileList.add(tile);
                }
            }
        }
        return tileList;
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
