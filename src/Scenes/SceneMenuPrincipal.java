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
public class SceneMenuPrincipal extends Scene implements Serializable {
    private Image fond;
    private Image titre;
    private Image btQuit;
    private Image btVIP;
    private Image btMatch;
    
    public SceneMenuPrincipal() throws SlickException {
        super();
        setPriority(1);
    }

    @Override
    protected void CustomRender(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(fond, 0, 0);
        g.drawImage(titre, Ctes.MENUPRINC_X_TITRE, Ctes.MENUPRINC_Y_TITRE);
        g.drawImage(btQuit, Ctes.MENUPRINC_X_QUIT, Ctes.MENUPRINC_Y_QUIT);
        g.drawImage(btVIP, Ctes.MENUPRINC_X_VIP, Ctes.MENUPRINC_Y_VIP);
        g.drawImage(btMatch, Ctes.MENUPRINC_X_MATCH, Ctes.MENUPRINC_Y_MATCH);
    }

    @Override
    protected void CustomUpdate(GameContainer gc, int t) throws SlickException {
        Input input = gc.getInput();
        if (input.getMouseX() > Ctes.MENUPRINC_X_MATCH && input.getMouseX() < Ctes.MENUPRINC_X_MATCH + btMatch.getWidth() && 
                input.getMouseY() > Ctes.MENUPRINC_Y_MATCH && input.getMouseY() < Ctes.MENUPRINC_Y_MATCH + btMatch.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) { //Si on appuie sur bouton match
                
            }
            else { //Si on survol bouton match
                btQuit = new Image("ressources/menuprincipal/btQuit.png");
                btVIP = new Image("ressources/menuprincipal/btVIP.png");
                btMatch = new Image("ressources/menuprincipal/btMatch_hover.png");
            }
        }
        else if (input.getMouseX() > Ctes.MENUPRINC_X_VIP && input.getMouseX() < Ctes.MENUPRINC_X_VIP + btVIP.getWidth() && 
                input.getMouseY() > Ctes.MENUPRINC_Y_VIP && input.getMouseY() < Ctes.MENUPRINC_Y_VIP + btVIP.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) { //Si on appuie sur bouton VIP
                
            }
            else { //Si on survol bouton VIP
                btQuit = new Image("ressources/menuprincipal/btQuit.png");
                btVIP = new Image("ressources/menuprincipal/btVIP_hover.png");
                btMatch = new Image("ressources/menuprincipal/btMatch.png");
            }
        }
        else if (input.getMouseX() > Ctes.MENUPRINC_X_QUIT && input.getMouseX() < Ctes.MENUPRINC_X_QUIT + btQuit.getWidth() && 
                input.getMouseY() > Ctes.MENUPRINC_Y_QUIT && input.getMouseY() < Ctes.MENUPRINC_Y_QUIT + btQuit.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) { //Si on appuie sur bouton quitter
                //Main.Game.manager.removeAll();
                gc.exit();
            }
            else { //Si on survol bouton quitter
                btQuit = new Image("ressources/menuprincipal/btQuit_hover.png");
                btVIP = new Image("ressources/menuprincipal/btVIP.png");
                btMatch = new Image("ressources/menuprincipal/btMatch.png");
            }
        }
        else {
            btQuit = new Image("ressources/menuprincipal/btQuit.png");
            btVIP = new Image("ressources/menuprincipal/btVIP.png");
            btMatch = new Image("ressources/menuprincipal/btMatch.png");
        }
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        fond = new Image("ressources/menuprincipal/fond.png");
        titre = new Image("ressources/menuprincipal/titre.png");
        btQuit = new Image("ressources/menuprincipal/btQuit.png");
        btVIP = new Image("ressources/menuprincipal/btVIP.png");
        btMatch = new Image("ressources/menuprincipal/btMatch.png");
    }

    @Override
    public String toString() {
        return "MenuPrincipal";
    }
}
