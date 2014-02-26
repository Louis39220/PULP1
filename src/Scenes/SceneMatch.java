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
public class SceneMatch extends Scene implements Serializable {
    private Image titre;
    private Image fond;
    private Image btPrec;
    private Image btSuiv;
    private Image ajouter;
    private Image modifier;
    private Image supprimer;
    
    public SceneMatch() throws SlickException {
        super();
        setPriority(1);
    }

    @Override
    protected void CustomRender(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(fond, 0, 0);
        g.drawImage(titre, Ctes.PLANNING_X_TITRE, Ctes.PLANNING_Y_TITRE);
        g.drawImage(btPrec, Ctes.PLANNING_X_PREC, Ctes.PLANNING_Y_PREC);
        g.drawImage(btSuiv, Ctes.PLANNING_X_SUIV, Ctes.PLANNING_Y_SUIV);
        g.drawImage(ajouter, Ctes.PLANNING_X_ADD, Ctes.PLANNING_Y_ADD);
        g.drawImage(modifier, Ctes.PLANNING_X_MODIF, Ctes.PLANNING_Y_MODIF);
        g.drawImage(supprimer, Ctes.PLANNING_X_SUPP, Ctes.PLANNING_Y_SUPP);
    }

    @Override
    protected void CustomUpdate(GameContainer gc, int t) throws SlickException {
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        fond = new Image("ressources/menuprincipal/fond.png");
        titre = new Image("ressources/planning/titre.png");
        btPrec = new Image("ressources/planning/prec.png");
        btSuiv = new Image("ressources/planning/suiv.png");
        ajouter = new Image("ressources/planning/add.png");
        modifier = new Image("ressources/planning/modif.png");
        supprimer = new Image("ressources/planning/supp.png");
    }

    @Override
    public String toString() {
        return "Match";
    }
}
