package jbet;

import jbet.components.*;
import java.util.HashMap;

/**
 * @author Andreas Pinzek und Binsmaier Florian
 */
public class Controller {

    private static DbControl model;
    private static NewJFrame frame;
    private String loggedInUser;

    public Controller() {
        model = DbControl.getInstance();
        frame = new NewJFrame(this);
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean isAdmin(String name) {
        return model.isAdmin(name);
    }

    /**
     *
     * @param name
     * @param passwort
     * @param admin
     * @return
     */
    public boolean addUser(String name, String passwort, boolean admin) {
        model.add(new User(name, passwort, admin));
        return true;
    }

    /**
     *
     * @param name Benutzername
     * @param passwort Benutzerpasswort
     * @return true wenn es die Kombination gibt/ false wenn es sie nicht gibt
     */
    public boolean requestUserLoginValid(String name, String passwort) {
        if (model.checkLogin(name, passwort))
            loggedInUser = name;                 
        return model.checkLogin(name, passwort);
    }
    
    public String getCurrentUsername(){
        return loggedInUser;
    }
    // public void ergebnisseEintragen(String mannschaft1, String mannschaft2, int ergebnis1, int ergebnis2){
    //     frame.ergebnisseEintragen(mannschaft1,mannschaft2,ergebnis1,ergebnis2);
    // }
    // public HashMap<String, Boolean> getAllUser(){
    //     return DbControl.getAllUser();
    // }
    
    // public void addLeague(String name)
    // {
    //     DBControl.addLeague(name);
    // }
    
    // public String[] getAllLeague()
    // {
    //     return DBControl.getAllLeague();
    // }
    
    // public void addSeason(String name)
    // {
    //     DBControl.addSeason(name);
    // }
    // public void addBet(String name,String Matchup,int score1, int score2)
    // {
    //     DBControl.addBet(name,Matchup,score1,score2);
    // }
}