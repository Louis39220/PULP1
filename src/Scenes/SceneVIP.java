package Scenes;

import Constantes.Ctes;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Jérôme
 */
public class SceneVIP extends Scene implements Serializable {
    
    public SceneVIP() throws SlickException {
        super();
        setPriority(1);
    }

    @Override
    protected void CustomRender(GameContainer gc, Graphics g) throws SlickException {
    }

    @Override
    protected void CustomUpdate(GameContainer gc, int t) throws SlickException {
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
    }

    @Override
    public String toString() {
        return "VIP";
    }
}
