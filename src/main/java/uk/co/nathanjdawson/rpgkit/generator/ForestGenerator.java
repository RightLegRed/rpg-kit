package uk.co.nathanjdawson.rpgkit.generator;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import org.lwjgl.util.Point;
import sun.reflect.generics.tree.Tree;
import uk.co.nathanjdawson.rpgkit.map.tile.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 271678 on 20/01/14.
 */
public class ForestGenerator {

    int boundX = 0;
    int boundY = 0;
    ArrayList<Tile> tiles = new ArrayList<Tile>();
    Noise noise;
    double maxNoise = 0;
    double minNoise = 0;

    public ForestGenerator(int boundX, int boundY) {
        this.boundX = boundX;
        this.boundY = boundY;
        noise = new Noise(new Random(), 1, boundX, boundY);
        noise.initialise();
    }

    public ArrayList<Tile> generate(){
        generateGrass();
        generateTrees();
        generateWaterBodies();
        generateObjects();
        return tiles;
    }

    public void generateGrass(){
        for(int x = 0; x <= boundX; x++){
            for(int y = 0; y <= boundY; y++){
                GrassTile above = (GrassTile) getTileByLocation(new Point(x, y - 1));
                GrassTile below = (GrassTile) getTileByLocation(new Point(x, y + 1));
                GrassTile right = (GrassTile) getTileByLocation(new Point(x + 1, y));
                GrassTile left = (GrassTile) getTileByLocation(new Point(x - 1, y));
                int collection = 0;
                if(above != null){
                    collection += above.getDensity();
                }
                if(below != null){
                    collection += below.getDensity();
                }
                if(right != null){
                    collection += right.getDensity();
                }
                if(left != null){
                    collection += left.getDensity();
                }
                int med = collection / 4;
                if(med == 0){
                    med += randInt(0, 2);
                }else if(med == 2){
                    med -= randInt(0, 2);
                }
                GrassTile grassTile = new GrassTile(new Point(x, y));
                grassTile.setDensity(med);
                tiles.add(grassTile);
            }
        }
    }

    public void generateTrees(){
        // Group together bodies of trees to create forests.
        for(int x=0;x<noise.grid_.length;x++){
            for(int y=0;y<noise.grid_[x].length;y++){
                double depth = noise.grid_[x][y];
                if(depth > 0.75){
                    TreeTile treeTile = new TreeTile(new Point(x, y));
                    treeTile.setBackground(getTileByLocation(new Point(x,y)));
                    tiles.remove(getTileByLocation(new Point(x,y)));
                    tiles.add(treeTile);
                }
            }
        }
    }

    public void generateWaterBodies(){
        for(int x=0;x<noise.grid_.length;x++){
            for(int y=0;y<noise.grid_[x].length;y++){
                double depth = noise.grid_[x][y];
                if(depth < -0.50){
                    tiles.remove(getTileByLocation(new Point(x,y)));
                    tiles.add(new WaterTile(new Point(x, y)));
                }
                System.out.println(noise.grid_[x][y]);
            }
        }
        generateSand();
    }

    public void generateSand(){
        for(int x = 0; x <= boundX; x++){
            for(int y = 0; y <= boundY; y++){
                Tile above = getTileByLocation(new Point(x, y - 1));
                Tile below = getTileByLocation(new Point(x, y + 1));
                Tile right = getTileByLocation(new Point(x + 1, y));
                Tile left = getTileByLocation(new Point(x - 1, y));
                Tile current = getTileByLocation(new Point(x,y));
                if(above instanceof WaterTile || below instanceof WaterTile || right instanceof WaterTile || left instanceof WaterTile){
                    if(current instanceof GrassTile){
                        tiles.remove(getTileByLocation(new Point(x,y)));
                        tiles.add(new PathTile(new Point(x, y)));
                    }
                }
            }
        }
    }

    public void generateObjects(){
        for(int x = 0; x <= boundX; x++){
            for(int y = 0; y <= boundY; y++){
                Tile above = getTileByLocation(new Point(x, y - 1));
                Tile below = getTileByLocation(new Point(x, y + 1));
                Tile right = getTileByLocation(new Point(x + 1, y));
                Tile left = getTileByLocation(new Point(x - 1, y));
                boolean spawn = randInt(0, 500) == 0;
                spawn = spawn == true ? getTileByLocation(new Point(x, y)) instanceof GrassTile : false;
                if(spawn){
                    PathTile abovePath = new PathTile(new Point(x, y - 1));
                    PathTile belowPath = new PathTile(new Point(x, y + 1));
                    PathTile rightPath = new PathTile(new Point(x + 1, y));
                    PathTile leftPath = new PathTile(new Point(x - 1, y));
                    if(above != null) tiles.remove(getTileByLocation(above.getLocation()));
                    if(below != null)tiles.remove(getTileByLocation(below.getLocation()));
                    if(right != null)tiles.remove(getTileByLocation(right.getLocation()));
                    if(left != null)tiles.remove(getTileByLocation(left.getLocation()));
                    tiles.add(abovePath);
                    tiles.add(belowPath);
                    tiles.add(rightPath);
                    tiles.add(leftPath);
                    FireTile fireTile = new FireTile(new Point(x, y));
                    fireTile.setBackground(new PathTile(new Point(x, y)));
                    tiles.remove(getTileByLocation(new Point(x, y)));
                    tiles.add(fireTile);
                }
            }
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

    // http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java || Greg Case
    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}
