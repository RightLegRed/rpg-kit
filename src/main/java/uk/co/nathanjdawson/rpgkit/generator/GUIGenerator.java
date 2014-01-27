package uk.co.nathanjdawson.rpgkit.generator;

import org.lwjgl.util.Point;
import uk.co.nathanjdawson.rpgkit.entity.Player;
import uk.co.nathanjdawson.rpgkit.map.tile.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 271678 on 23/01/14.
 */
public class GUIGenerator extends Generator{

    ArrayList<Tile> tiles = new ArrayList<Tile>();

    public GUIGenerator(ArrayList<Tile> tiles, int startX, int startY, int boundX, int boundY) {
        super(boundX, boundY, startX, startY);
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

    public ArrayList<Tile> update(Player player, ArrayList<Tile> currentTiles){
        generateBorders();
        Tile left;
        Tile right;
        Tile up;
        Tile down;
        /**
        if(getTileByLocation(new Point(player.getX(), player.getY() - 1), currentTiles) != null){
            up = getTileByLocation(new Point(player.getX(), player.getY() - 1),currentTiles);
            for(Tile t : Letter.stringToGrid("UP: " + up.besideText, new Point(startX +1,3))){
                tiles.remove(getTileByLocation(t.getX(), t.getY()));
                tiles.add(t);
            }
        }
        if(getTileByLocation(new Point(player.getX(), player.getY() + 1), currentTiles) != null){
            down = getTileByLocation(new Point(player.getX(), player.getY() + 1),currentTiles);
            for(Tile t : Letter.stringToGrid("DOWN: " + down.besideText, new Point(startX +1,4))){
                tiles.remove(getTileByLocation(t.getX(), t.getY()));
                tiles.add(t);
            }
        }
        if(getTileByLocation(new Point(player.getX() - 1, player.getY()), currentTiles) != null){
            left = getTileByLocation(new Point(player.getX() - 1, player.getY()),currentTiles);
            for(Tile t : Letter.stringToGrid("LEFT: " + left.besideText, new Point(startX +1,5))){
                tiles.remove(getTileByLocation(t.getX(), t.getY()));
                tiles.add(t);
            }
        }
        if(getTileByLocation(new Point(player.getX() + 1, player.getY()), currentTiles) != null){
            right = getTileByLocation(new Point(player.getX() + 1, player.getY()),currentTiles);
            for(Tile t : Letter.stringToGrid("RIGHT: " + right.besideText, new Point(startX +1,6))){
                tiles.remove(getTileByLocation(t.getX(), t.getY()));
                tiles.add(t);
            }
        }
         **/
        return tiles;
    }

    public ArrayList<Tile> generateText(){

        return tiles;
    }

    public ArrayList<Tile> generateMenu(){

        return tiles;
    }


    public void generateBorders(){
        for(int y = 0; y<boundY; y++){
            MultiLayerTile tile = new LetterTile(new Point(startX, y), "|");
            tile.setCanCollide(true);
            tiles.add(tile);
        }
    }
}
