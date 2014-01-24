package uk.co.nathanjdawson.rpgkit.generator.dungeon;

import uk.co.nathanjdawson.rpgkit.map.tile.Tile;

import java.util.ArrayList;

/**
 * Created by 271678 on 24/01/14.
 */
public class DungeonRoom {
    ArrayList<Tile> tiles = new ArrayList<Tile>();

    public DungeonRoom(ArrayList<Tile> tiles){
        this.tiles = tiles;
    }

}
