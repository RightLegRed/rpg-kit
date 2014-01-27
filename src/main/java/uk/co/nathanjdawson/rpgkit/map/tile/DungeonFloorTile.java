package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import uk.co.nathanjdawson.rpgkit.Game;
import uk.co.nathanjdawson.rpgkit.SpriteSheetManager;

/**
 * Created by 271678 on 24/01/14.
 */
public class DungeonFloorTile extends Tile {

    public DungeonFloorTile(Point location) {
        super(location);
    }

    public DungeonFloorTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        SpriteSheet spriteSheet = SpriteSheetManager.getSpriteSheet("tileset.png");
        Image image = spriteSheet.getSubImage(5, 1);
        graphics.drawImage(image, getX() * Game.GAME_TILE_SIZE, getY() * Game.GAME_TILE_SIZE);
    }

    @Override
    public void onWalk() {

    }

    @Override
    public void beside() {

    }
}
