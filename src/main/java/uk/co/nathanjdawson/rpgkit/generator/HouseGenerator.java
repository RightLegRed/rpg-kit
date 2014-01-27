package uk.co.nathanjdawson.rpgkit.generator;

import uk.co.nathanjdawson.rpgkit.map.tile.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 271678 on 27/01/14.
 */
public class HouseGenerator extends Generator{


    ArrayList<Tile> tiles = new ArrayList<Tile>();
    double maxNoise = 0;
    double minNoise = 0;

    public HouseGenerator(int boundX, int boundY) {
        super(boundX, boundY);
        this.boundX = boundX;
        this.boundY = boundY;
    }

    public ArrayList<Tile> generate(){
        generateBounds();
        generateHouse();
        return tiles;
    }

    public void generateBounds(){
        int maxX = randInt(20, boundX - 2);
        int maxY = randInt(20, boundY - 2);
        if(maxX % 2 == 1){
            maxX = maxX - 1;
        }
        if(maxY % 2 == 1){
            maxY =  maxY - 1;
        }
        startX = (boundX - maxX) / 2;
        startY = (boundY - maxY) / 2;
        boundX = maxX;
        boundY = maxY;
    }

    public void generateHouse(){
        for(int x = startX; x <= boundX; x++){
            for(int y = startY; y <= boundY; y++){
                WoodenFloorTile greenCosmoCarpetTile = new WoodenFloorTile(x, y);
                tiles.add(greenCosmoCarpetTile);
            }
        }

        for(int x = startX; x <= boundX; x++){
            tiles.remove(getTileByLocation(x, startY));
            tiles.add(new InsideWallTile(x, startY));
        }

        tiles.remove(getTileByLocation((boundX - startX) / 2, startY));
        DoorTile doorTile = new DoorTile((boundX - startX) / 2, startY);
        doorTile.setType(3);
        tiles.add(doorTile);
    }

    // http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java || Greg Case
    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
