/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jbet;

import jbet.components.*;

/**
 *
 * @author pinzeka19
 */
public class Controller {
    
    private static DbControl model;
    private static NewJFrame frame;
    
    public Controller(){
        //model = DbControl.getInstance();
        frame = new NewJFrame(this);
    }
    /**
     * 
     * @param name Benutzername
     * @param passwort Benutzerpasswort
     * @return true wenn    es die Kombination gibt/ false wenn es sie nicht gibt
     */    
    //public boolean requestUserLoginValid(String name,String passwort){
        //return model.checkLogin(name,passwort);
    //}

}
