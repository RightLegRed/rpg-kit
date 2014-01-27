package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import uk.co.nathanjdawson.rpgkit.Game;
import uk.co.nathanjdawson.rpgkit.SpriteSheetManager;


/**
 * Created by 271678 on 13/01/14.
 */
public class GrassTile extends Tile {

    int density = 0; // 0 (0, 5) || 1 (2, 5) || 2 (3, 5)
    int health = 2;
    public GrassTile(Point location) {
        super(location);
        setBesideText("Grass!");
    }

    @Override
    public void draw(Graphics graphics) {
        SpriteSheet spriteSheet = SpriteSheetManager.getSpriteSheet("tileset.png");
        Image image = null;
        switch(density){
            case 0:
                image = spriteSheet.getSubImage(0, 5);
                break;
            case 1:
                image = spriteSheet.getSubImage(2, 5);
                break;
            case 2:
                image = spriteSheet.getSubImage(3, 5);
                break;
        }
        Color color = null;
        switch(health){
            case 0:
                color = Color.green;
                break;
            case 1:
                color = Color.orange;
                break;
            case 2:
                color = Color.red;
                break;
        }
        graphics.drawImage(image, getX() * Game.GAME_TILE_SIZE, getY() * Game.GAME_TILE_SIZE);
    }

    @Override
    public void onWalk() {

    }

    @Override
    public void beside() {

    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }
}
