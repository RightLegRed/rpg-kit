package uk.co.nathanjdawson.rpgkit.map.tile;

/**
 * Created by 271678 on 27/01/14.
 */
public abstract class Interactable {
    public String walkText = "";
    public String besideText = "";

    public abstract void onWalk();
    public abstract void beside();

    public String getWalkText() {
        return walkText;
    }

    public void setWalkText(String walkText) {
        this.walkText = walkText;
    }

    public String getBesideText() {
        return besideText;
    }

    public void setBesideText(String besideText) {
        this.besideText = besideText;
    }
}
