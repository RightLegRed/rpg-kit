package uk.co.nathanjdawson.rpgkit.generator;

import org.lwjgl.util.Point;
import uk.co.nathanjdawson.rpgkit.generator.dungeon.DungeonRoom;
import uk.co.nathanjdawson.rpgkit.map.tile.DungeonFloorTile;
import uk.co.nathanjdawson.rpgkit.map.tile.EmptyTile;
import uk.co.nathanjdawson.rpgkit.map.tile.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Created by 271678 on 24/01/14.
 */
public class DungeonGenerator {


    int boundX = 0;
    int boundY = 0;
    ArrayList<Tile> tiles = new ArrayList<Tile>();

    public DungeonGenerator(int boundX, int boundY) {
        this.boundX = boundX;
        this.boundY = boundY;

    }

    public ArrayList<Tile> generate(){
        generateBackground();
        generateRooms();
        return tiles;
    }

    public void generateBackground(){
        for(int x = 0; x <= boundX; x++){
            for(int y = 0; y <= boundY; y++){
                tiles.add(new EmptyTile(x, y));
            }
        }
    }

    public void generateRooms(){
        int rooms = randInt(1, 10);
        for(int i = 1; i<rooms; i++){
            for(Tile t : buildRoom()){
                tiles.remove(getTileByLocation(new Point(t.getX(), t.getY())));
                tiles.add(t);
            }
        }
    }

    public ArrayList<Tile> buildRoom(){
        ArrayList<Tile> changedTiles = new ArrayList<Tile>();
        int x = randInt(0, boundX);
        int y = randInt(0, boundY);
        int width = randInt(0, 10);
        int height = randInt(0, 10);
        for(int iX = 0; iX<(x+width);iX++){
            for(int iY = 0; iY<(y+height);iY++){
                if(getTileByLocation(new Point(iX, iY)) instanceof DungeonFloorTile){
                    return buildRoom();
                }else{
                    changedTiles.add(new DungeonFloorTile(iX, iY));
                    System.out.println("Wasn't a dungeon floor tile");
                }
            }
        }
        return changedTiles;
    }

    public Tile getTileByLocation(Point point){
        for(Tile t : tiles){
            if(t.getLocation().equals(point)){
                return t;
            }
        }
        return null;
    }

    public static Tile getTileByLocation(ArrayList<Tile> ti, Point point){
        for(Tile t : ti){
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

    public static void main(String[] args){
        DungeonGenerator d = new DungeonGenerator(100, 100);
        ArrayList<Tile> tiles = d.generate();
        LinkedHashMap<Integer, String> lines = new LinkedHashMap<Integer, String>();
        for(int y = 0; y <= d.boundY; y++){
            for(int x = 0; x <= d.boundX; x++){
                Tile t = getTileByLocation(tiles, new Point(x,y));
                String s = t instanceof EmptyTile ? " " : "#";
                if(!lines.containsKey(y)){
                    lines.put(y, s);
                }else{
                    lines.put(y, lines.get(y) + s);
                }
            }
        }

        for(String s : lines.values()){
            System.out.println(s);
        }
    }
}
