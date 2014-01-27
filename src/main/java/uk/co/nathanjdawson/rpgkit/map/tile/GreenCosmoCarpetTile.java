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
public class GreenCosmoCarpetTile extends Tile {
    public GreenCosmoCarpetTile(Point location) {
        super(location);
    }

    public GreenCosmoCarpetTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        SpriteSheet spriteSheet = SpriteSheetManager.getSpriteSheet("tileset.png");
        Image image = spriteSheet.getSubImage(8, 2);
        graphics.drawImage(image, getX() * Game.GAME_TILE_SIZE, getY() * Game.GAME_TILE_SIZE);
    }

    @Override
    public void onWalk() {

    }

    @Override
    public void beside() {

    }
}
