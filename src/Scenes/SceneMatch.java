package Scenes;

import Constantes.Ctes;
import entities.Match;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private Image retour;
    private Image btMoreInfo;
    private int numJour;
    private List<Match> matchs = new ArrayList<>();
    
    public SceneMatch() throws SlickException {
        super();
        setPriority(1);
    }

    @Override
    protected void CustomRender(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(fond, 0, 0);
        g.drawImage(titre, Ctes.PLANNING_X_TITRE, Ctes.PLANNING_Y_TITRE);
        if (numJour != 22) g.drawImage(btPrec, Ctes.PLANNING_X_PREC, Ctes.PLANNING_Y_PREC);
        if (numJour != 30) g.drawImage(btSuiv, Ctes.PLANNING_X_SUIV, Ctes.PLANNING_Y_SUIV);
        g.drawImage(ajouter, Ctes.PLANNING_X_ADD, Ctes.PLANNING_Y_ADD);
        g.drawImage(modifier, Ctes.PLANNING_X_MODIF, Ctes.PLANNING_Y_MODIF);
        g.drawImage(supprimer, Ctes.PLANNING_X_SUPP, Ctes.PLANNING_Y_SUPP);
        g.drawImage(retour, Ctes.PLANNING_X_RETOUR, Ctes.PLANNING_Y_RETOUR);
        remplirPlanning(g);
    }

    @Override
    protected void CustomUpdate(GameContainer gc, int t) throws SlickException {
        Input input = gc.getInput();
        if (input.getMouseX() > Ctes.PLANNING_X_PREC && input.getMouseX() < Ctes.PLANNING_X_PREC + btPrec.getWidth() && 
                input.getMouseY() > Ctes.PLANNING_Y_PREC && input.getMouseY() < Ctes.PLANNING_Y_PREC + btPrec.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) { //Si on appuie sur bouton precedent
                if (numJour != 22) numJour--;
            }
            else { //Si on survol bouton precedent
                btPrec = new Image("ressources/menuprincipal/btPrec_hover.png");
                btSuiv = new Image("ressources/menuprincipal/btSuiv.png");
                ajouter = new Image("ressources/menuprincipal/ajouter.png");
                modifier = new Image("ressources/menuprincipal/modifier.png");
                supprimer = new Image("ressources/menuprincipal/supprimer.png");
                retour = new Image("ressources/planning/retour.png");
            }
        }
        else if (input.getMouseX() > Ctes.PLANNING_X_SUIV && input.getMouseX() < Ctes.PLANNING_X_SUIV + btSuiv.getWidth() && 
                input.getMouseY() > Ctes.PLANNING_Y_SUIV && input.getMouseY() < Ctes.PLANNING_Y_SUIV + btSuiv.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) { //Si on appuie sur bouton suivant
                if (numJour != 30) numJour++;
            }
            else { //Si on survol bouton suivant
                btPrec = new Image("ressources/menuprincipal/btPrec.png");
                btSuiv = new Image("ressources/menuprincipal/btSuiv_hover.png");
                ajouter = new Image("ressources/menuprincipal/ajouter.png");
                modifier = new Image("ressources/menuprincipal/modifier.png");
                supprimer = new Image("ressources/menuprincipal/supprimer.png");
                retour = new Image("ressources/planning/retour.png");
            }
        }
        else if (input.getMouseX() > Ctes.PLANNING_X_RETOUR && input.getMouseX() < Ctes.PLANNING_X_RETOUR + retour.getWidth() && 
                input.getMouseY() > Ctes.PLANNING_Y_RETOUR && input.getMouseY() < Ctes.PLANNING_Y_RETOUR + retour.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) { //Si on appuie sur bouton retour
                Main.Game.manager.addSence(new SceneMenuPrincipal());
                Main.Game.manager.removeSence(this);
            }
            else { //Si on survol bouton retour
                btPrec = new Image("ressources/menuprincipal/btPrec.png");
                btSuiv = new Image("ressources/menuprincipal/btSuiv.png");
                ajouter = new Image("ressources/menuprincipal/ajouter.png");
                modifier = new Image("ressources/menuprincipal/modifier.png");
                supprimer = new Image("ressources/menuprincipal/supprimer.png");
                retour = new Image("ressources/planning/retour_hover.png");
            }
        }
        else if (input.getMouseX() > Ctes.PLANNING_X_ADD && input.getMouseX() < Ctes.PLANNING_X_ADD + ajouter.getWidth() && 
                input.getMouseY() > Ctes.PLANNING_Y_ADD && input.getMouseY() < Ctes.PLANNING_Y_ADD + ajouter.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) { //Si on appuie sur bouton ajouter
                //A gérer plus tard;
            }
            else { //Si on survol bouton ajouter
                btPrec = new Image("ressources/menuprincipal/btPrec.png");
                btSuiv = new Image("ressources/menuprincipal/btSuiv.png");
                ajouter = new Image("ressources/menuprincipal/ajouter_hover.png");
                modifier = new Image("ressources/menuprincipal/modifier.png");
                supprimer = new Image("ressources/menuprincipal/supprimer.png");
                retour = new Image("ressources/planning/retour.png");
            }
        }
        else if (input.getMouseX() > Ctes.PLANNING_X_MODIF && input.getMouseX() < Ctes.PLANNING_X_MODIF + modifier.getWidth() && 
                input.getMouseY() > Ctes.PLANNING_Y_MODIF && input.getMouseY() < Ctes.PLANNING_Y_MODIF + modifier.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) { //Si on appuie sur bouton modifier
                //A gérer plus tard;
            }
            else { //Si on survol bouton modifier
                btPrec = new Image("ressources/menuprincipal/btPrec.png");
                btSuiv = new Image("ressources/menuprincipal/btSuiv.png");
                ajouter = new Image("ressources/menuprincipal/ajouter.png");
                modifier = new Image("ressources/menuprincipal/modifier_hover.png");
                supprimer = new Image("ressources/menuprincipal/supprimer.png");
                retour = new Image("ressources/planning/retour.png");
            }
        }
        else if (input.getMouseX() > Ctes.PLANNING_X_SUPP && input.getMouseX() < Ctes.PLANNING_X_SUPP + supprimer.getWidth() && 
                input.getMouseY() > Ctes.PLANNING_Y_SUPP && input.getMouseY() < Ctes.PLANNING_Y_SUPP + supprimer.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) { //Si on appuie sur bouton supprimer
                //A gérer plus tard;
            }
            else { //Si on survol bouton supprimer
                btPrec = new Image("ressources/menuprincipal/btPrec.png");
                btSuiv = new Image("ressources/menuprincipal/btSuiv.png");
                ajouter = new Image("ressources/menuprincipal/ajouter.png");
                modifier = new Image("ressources/menuprincipal/modifier.png");
                supprimer = new Image("ressources/menuprincipal/supprimer_hover.png");
                retour = new Image("ressources/planning/retour.png");
            }
        }
        else {
            btPrec = new Image("ressources/menuprincipal/btPrec.png");
            btSuiv = new Image("ressources/menuprincipal/btSuiv.png");
            ajouter = new Image("ressources/menuprincipal/ajouter.png");
            modifier = new Image("ressources/menuprincipal/modifier.png");
            supprimer = new Image("ressources/menuprincipal/supprimer.png");
            retour = new Image("ressources/planning/retour.png");
        }
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
        retour = new Image("ressources/planning/retour.png");
        btMoreInfo = new Image("ressources/planning/moreinfo.png");
        
        //ResultSet rs = selectMatchByDay(numJour);
        //while (rs.next) { matchs.add(new Match(rs.getInt("IDMATCH")); }
        //
    }

    @Override
    public String toString() {
        return "Match";
    }
    
    public void remplirPlanning(Graphics g) {
        ;
    }
}
