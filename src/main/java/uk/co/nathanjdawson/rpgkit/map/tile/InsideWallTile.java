package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import uk.co.nathanjdawson.rpgkit.Game;
import uk.co.nathanjdawson.rpgkit.SpriteSheetManager;

/**
 * Created by 271678 on 27/01/14.
 */
public class InsideWallTile extends Tile {
    public InsideWallTile(Point location) {
        super(location);
    }

    public InsideWallTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        SpriteSheet spriteSheet = SpriteSheetManager.getSpriteSheet("tileset.png");
        Image image = spriteSheet.getSubImage(4, 4);
        graphics.drawImage(image, getX() * Game.GAME_TILE_SIZE, getY() * Game.GAME_TILE_SIZE);
    }
}
