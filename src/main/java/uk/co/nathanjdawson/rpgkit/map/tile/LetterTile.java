package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import uk.co.nathanjdawson.rpgkit.Game;
import uk.co.nathanjdawson.rpgkit.SpriteSheetManager;

import java.util.HashMap;

/**
 * Created by Archelaus on 21/01/14.
 */
public class LetterTile extends MultiLayerTile {

    HashMap<String, Point> letterMap = new HashMap<String, Point>();
    Letter letter;

    public LetterTile(Point location, String letter) {
        super(location);

        this.letter = getLetter(letter);

    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        SpriteSheet spriteSheet = SpriteSheetManager.getSpriteSheet("font.bmp");
        Point p = letter.getPoint();
        Image image = spriteSheet.getSubImage(p.getX(), p.getY());
        graphics.drawImage(image, getX() * Game.GAME_TILE_SIZE, getY() * Game.GAME_TILE_SIZE);
    }

    public Letter getLetter(String letter){
        if(isNumeric(letter)){
            switch(Integer.parseInt(letter)){
                case 1:
                    return Letter.ONE;
                case 2:
                    return Letter.TWO;
                case 3:
                    return Letter.THREE;
                case 4:
                    return Letter.FOUR;
                case 5:
                    return Letter.FIVE;
                case 6:
                    return Letter.SIX;
                case 7:
                    return Letter.SEVEN;
                case 8:
                    return Letter.EIGHT;
                case 9:
                    return Letter.NINE;
            }
        }
        if(letter.equals(" ")){
            return Letter.SPACE;
        }
        for(Letter l : Letter.values()){
            if(l.toString().equals(letter)){
                return l;
            }
        }
        return null;
    }

    public boolean isNumeric(String str){
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
