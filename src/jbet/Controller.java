package jbet;

import java.util.ArrayList;
import jbet.components.*;
import java.util.HashMap;

/**
 * @author Andreas Pinzek und Binsmaier Florian
 */
public class Controller {

    private static DbControl model;
    private static MainJFrame frame;
    private User loggedInUser;

    public Controller() {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern (wie gerade gemacht))
        /*System.out.println("Methode isAdmin in Controller ist wegen Test ausgaklammert"); // Wieder ausklammern beim Commit
        // ------- 
        
        frame = new MainJFrame(this);
        
        // -------  */
        
        model = DbControl.getInstance();  
        frame = new MainJFrame(this);
    }
    
    // ---------------------------- USER -------------------------------

    /**
     *
     * @param name
     * @return
     */
    public boolean isAdmin(String name) {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern (wie gerade gemacht))
        /*System.out.println("Methode isAdmin in Controller ist wegen Test ausgaklammert");
        // ------- 
        
        return true;
        
        // ------- */
        
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
        User newUser = new User(name, passwort, admin);
        model.add(newUser);
        loggedInUser = newUser;
        return true;
    }

    /**
     *
     * @param name Benutzername
     * @param passwort Benutzerpasswort
     * @return true wenn es die Kombination gibt/ false wenn es sie nicht gibt
     */
    public boolean requestUserLoginValid(String name, String passwort) {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern (wie gerade gemacht))
        /*System.out.println("Methode requestUserLoginValid in Controller ist wegen Test ausgaklammert");
        // ------- 
        
        return true;
        
        // ------- */
        
        if (model.checkLogin(name, passwort)) {
            loggedInUser = new User(name, passwort, model.isAdmin(name));
        }
        return model.checkLogin(name, passwort);
    }

    public String getCurrentUsername() {
        return loggedInUser.getUsername();
    }

    public boolean isCurrentUserAdmin() {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern (wie gerade gemacht))
        /*System.out.println("Methode isCurrentUserAdmin in Controller ist wegen Test ausgaklammert");
        // ------- 
        
        return true;
        
        // ------- */
        
        return loggedInUser.isAdmin();
    }

    public boolean logCurrentUserOut() {
        loggedInUser = null;
        return true;

    }
    
    public boolean setAdmin(String name, boolean admin) {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern)
        System.out.println("Methode setAdmin in Controller ist wegen Test ausgaklammert");
        // ------- 
        
        return true;
        
        // -------
        
        // TODO Implement this Methode
    }

    public ArrayList<String> getAllUser() {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern)
        System.out.println("Methode getAllUser in Controller ist wegen Test ausgaklammert");
        // -------  
        
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Paul");
        temp.add("Jakob");
        temp.add("Loreen");
        return temp;
        
        // -------  
        
        //return model.listAllUsername();
    }
    
    
    // ---------------------------- LEAGUES -------------------------------
    
    // public void ergebnisseEintragen(String mannschaft1, String mannschaft2, int ergebnis1, int ergebnis2){
    //     frame.ergebnisseEintragen(mannschaft1,mannschaft2,ergebnis1,ergebnis2);
    // }
    /*public ArrayList<String> getAllUser(){
     return model.listAllUsername();
     }*/
    
    // public void addLeague(String name)
    // {
    //     DBControl.addLeague(name);
    // }
    public ArrayList<String> getAllLeagues() {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern)
        System.out.println("Methode getAllLeague in Controller ist wegen Test ausgaklammert");
        // -------  
        
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Bundesliga");
        temp.add("2. Liga");
        temp.add("3. Liga");
        return temp;
        
        // -------  
        
        //return model.listAllLeague();
    }

    // public void addSeason(String name)
    // {
    //     DBControl.addSeason(name);
    // }
    public ArrayList<Season> getAllSeasons() {
        return model.listAllSeason();
    }

    // public void addBet(String name,String Matchup,int score1, int score2)
    // {
    //     DBControl.addBet(name,Matchup,score1,score2);
    // }

    public boolean changeLeagueName(String currentLeagueName, String futureLeagueName) {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern)
        System.out.println("Methode changeLeagueName in Controller ist wegen Test ausgaklammert");
        // -------

        return true;

        // -------

        // TODO: implement Methode
    }

    public String[] getAllTeamsFromLeagueAndSaison(String league, String saison) {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern)
        System.out.println("Methode getAllTeamsFromLeagueAndSaison in Controller ist wegen Test ausgaklammert");
        // -------

        String[] temp = {"FC Bayer", "Dortmund", "Bochum", "hamburg",};
        return temp;

        // -------

        // TODO: implement Methode
    }

    public String[] getAllSaisonsFromLeague(String league) {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern)
        System.out.println("Methode getAllSaisonsFromLeague in Controller ist wegen Test ausgaklammert");
        // -------

        String[] temp = {"2011", "2012", "2013", "2014",};
        return temp;

        // -------

        // TODO: implement Methode
    }

    public boolean removeTeamFromLeague(String team, String league) {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern)
        System.out.println("Methode removeTeamFromLeague in Controller ist wegen Test ausgaklammert");
        // -------

        return true;

        // -------

        // TODO: implement Methode
    }

    public boolean addSaisonForLeague(String newSaison, String League) {
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern)
        System.out.println("Methode addSaisonForLeague in Controller ist wegen Test ausgaklammert");
        // -------

        return true;

        // -------

        // TODO: implement Methode
    }
    
    public int getNumberOfMatchdaysForLeagueAndSeason(String league, String season){
        // Bitte lassen, ich brauche die zum Testen !!! (höchstens Ausklammern)
        System.out.println("Methode getNumberOfMatchdaysForLeagueAndSeason in Controller ist wegen Test ausgaklammert");
        // -------

        return 20;

        // -------

        // TODO: implement Methode
    }
}
