package Scenes;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Scene implements Comparable<Scene> {
    public enum STATE {ON, FREEZE, FREEZE_NEXT, INVISIBLE};
    private Scene.STATE state;
    private int prio = 0;
    private Image sence;
    
    public Scene() {
        state = Scene.STATE.ON;
        try {
            sence = new Image(800, 600);
        } catch (SlickException e) {
            Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    protected void CustomRender(GameContainer gc, Graphics g) throws SlickException {}
    protected void CustomUpdate(GameContainer gc, int t) throws SlickException {}
    public void init(GameContainer gc) throws SlickException {}
    
    public void render(GameContainer gc, Graphics g) throws SlickException {
        if (state != Scene.STATE.INVISIBLE) {
            if (state == Scene.STATE.ON) CustomRender(gc, g);
            if (state == Scene.STATE.FREEZE_NEXT) {
                sence.getGraphics().clear();
                CustomRender(gc, sence.getGraphics());
                state = Scene.STATE.FREEZE;
            }
            if (state == Scene.STATE.FREEZE) g.drawImage(sence, 0, 0);
        }
    }
    
    public void update(GameContainer gc, int t) throws SlickException {
        if (state == Scene.STATE.ON) CustomUpdate(gc, t);
    }
    
    public void setPriority(int p) { prio = p; }
    
    @Override
    public String toString() {
        return "default";
    }
    
    public int getPriority() { return prio; }
    
    @Override
    public int compareTo(Scene compareObject) {
        if (getPriority() < compareObject.getPriority()) return 1;
        else if (getPriority() == compareObject.getPriority()) return 0;
        else return -1;
    }
    
    public void setState(Scene.STATE s) { state = s; }
}