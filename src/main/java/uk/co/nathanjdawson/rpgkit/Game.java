package uk.co.nathanjdawson.rpgkit;

import org.lwjgl.util.Point;
import org.newdawn.slick.*;
import uk.co.nathanjdawson.rpgkit.entity.Entity;
import uk.co.nathanjdawson.rpgkit.entity.Player;
import uk.co.nathanjdawson.rpgkit.generator.ForestGenerator;
import uk.co.nathanjdawson.rpgkit.generator.GUIGenerator;
import uk.co.nathanjdawson.rpgkit.generator.MenuScreenGenerator;
import uk.co.nathanjdawson.rpgkit.map.tile.*;
import uk.co.nathanjdawson.rpgkit.weather.Rain;
import uk.co.nathanjdawson.rpgkit.weather.Weather;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 271678 on 13/01/14.
 */
public class Game extends BasicGame {

    public static int GAME_TILE_SIZE = 16;
    public static int screenX = 60;
    public static int screenY = 36;
    ArrayList<Tile> tiles = new ArrayList<Tile>();
    ArrayList<Entity> entities = new ArrayList<Entity>();
    GUIGenerator guiGenerator;
    Player player = new Player();

    ArrayList<Weather> weathers = new ArrayList<Weather>();

    public Game(){
        super("Game");
    }

    public Game(String title) {
        super(title);
        //ForestGenerator forestGenerator = new ForestGenerator(screenX - 1, screenY - 1);
        MenuScreenGenerator screenGenerator = new MenuScreenGenerator(screenX - 16, screenY - 1);
        tiles = screenGenerator.generate();
        guiGenerator = new GUIGenerator(tiles, screenX - 15, 0, screenX - 1, screenY );
        player.setLocation(new Point(0,0));
        weathers.add(new Rain(screenX - 15, screenY));
    }

    public Tile getRandomTile(){
        ArrayList<Tile> t = new ArrayList<Tile>();
        t.add(new GrassTile(new Point(0, 0)));
        t.add(new TreeTile(new Point(0, 0)));
        t.add(new WaterTile(new Point(0, 0)));
        Integer randomInt = randInt(0, t.size() - 1);
        return t.get(randomInt);
    }

    // http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java || Greg Case
    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        SpriteSheetManager.loadSpriteSheets();
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        tiles = guiGenerator.generate();
        for(Weather w : weathers){
            w.update(i);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
        if(key == Input.KEY_W){
            Point point = player.getLocation();
            Tile t = getTileByLocation(new Point(point.getX(), point.getY() - 1));
            if(t != null && !t.isCanCollide()){
                player.setLocation(new Point(point.getX(), point.getY() - 1));
            }
        }
        if(key == Input.KEY_S){
            Point point = player.getLocation();
            Tile t = getTileByLocation(new Point(point.getX(), point.getY() + 1));
            if(t != null && !t.isCanCollide()){
                player.setLocation(new Point(point.getX(), point.getY() + 1));
            }        }
        if(key == Input.KEY_A){
            Point point = player.getLocation();
            Tile t = getTileByLocation(new Point(point.getX() - 1, point.getY()));
            if(t != null && !t.isCanCollide()){
                player.setLocation(new Point(point.getX() - 1, point.getY()));
            }        }
        if(key == Input.KEY_D){
            Point point = player.getLocation();
            Tile t = getTileByLocation(new Point(point.getX() + 1, point.getY()));
            if(t != null && !t.isCanCollide()){
                player.setLocation(new Point(point.getX() + 1, point.getY()));
            }        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for(Tile t : tiles){
            t.draw(graphics);
        }
        for(Entity e : entities){
            e.draw(graphics);
        }

        player.draw(graphics);
        for(Weather w : weathers){
            w.draw(graphics);
        }
    }

    public static void main(String[] args){
        System.setProperty("java.library.path", new File("lib/").getAbsolutePath());
        try{

            AppGameContainer appgc;
            appgc = new AppGameContainer(new Game("Simple Slick Game"));
            appgc.setDisplayMode(screenX * GAME_TILE_SIZE, screenY * GAME_TILE_SIZE, false);
            appgc.start();
        }catch (SlickException ex){
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tile getTileByLocation(Point point){
        for(Tile t : tiles){
            if(t.getLocation().equals(point)){
                return t;
            }
        }
        return null;
    }
}
