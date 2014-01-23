package uk.co.nathanjdawson.rpgkit.generator;

import org.lwjgl.util.Point;
import uk.co.nathanjdawson.rpgkit.map.tile.LetterTile;
import uk.co.nathanjdawson.rpgkit.map.tile.Tile;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 271678 on 23/01/14.
 */
public class GUIGenerator {

    int boundX = 0;
    int boundY = 0;
    int startX = 0;
    int startY = 0;
    ArrayList<Tile> tiles = new ArrayList<Tile>();

    public GUIGenerator(ArrayList<Tile> tiles, int startX, int startY, int boundX, int boundY) {
        this.boundX = boundX;
        this.boundY = boundY;
        this.tiles = tiles;
        this.startX = startX;
        this.startY = startY;
    }

    public ArrayList<Tile> generate(){
        generateBorders();
        return tiles;
    }

    public void generateBorders(){
        for(int y = 0; y<boundY; y++){
            Tile tile = new LetterTile(new Point(startX, y), "|");
            tile.setCanCollide(true);
            tiles.add(tile);
        }
    }
}
