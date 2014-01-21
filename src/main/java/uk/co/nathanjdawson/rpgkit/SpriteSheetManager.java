package uk.co.nathanjdawson.rpgkit;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 271678 on 13/01/14.
 */
public class SpriteSheetManager  {
    static HashMap<String, SpriteSheet> spriteSheets = new HashMap<String, SpriteSheet>();

    public static void loadSpriteSheets(){
        File folder = new File("resources/spritesheets");
        File[] spriteSheets = folder.listFiles();
        for(File f : spriteSheets){
            try {
                SpriteSheet spriteSheet = new SpriteSheet(f.getAbsolutePath(), 16, 16);
                addSpriteSheet(f.getName(), spriteSheet);
                System.out.println("Loaded spritesheet " + f.getName());
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addSpriteSheet(String identifier, SpriteSheet spriteSheet){
        spriteSheets.put(identifier, spriteSheet);
    }

    public static SpriteSheet getSpriteSheet(String identifier){
        return spriteSheets.get(identifier);
    }
}
