package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import uk.co.nathanjdawson.rpgkit.Game;
import uk.co.nathanjdawson.rpgkit.SpriteSheetManager;

/**
 * Created by 271678 on 13/01/14.
 */
public class TreeTile extends MultiLayerTile {

    boolean living = true;

    public TreeTile(Point location) {
        super(location);
        setCanCollide(true);
        background = new GrassTile(location);

    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        SpriteSheet spriteSheet = SpriteSheetManager.getSpriteSheet("tileset.png");
        Image image = spriteSheet.getSubImage(7, 5);
        if(!living){
            image = spriteSheet.getSubImage(8, 5);
        }
        graphics.drawImage(image, getX() * Game.GAME_TILE_SIZE, getY() * Game.GAME_TILE_SIZE);
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public void onWalk() {

    }

    @Override
    public void beside() {

    }
}
