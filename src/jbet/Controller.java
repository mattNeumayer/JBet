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
    
    public static void main(String[] args) {
	DbControl Db = DbControl.getInstance();
	System.out.println(Db.add(new Matchup(new Matchday(new Season(
		new League("Bundesliga"), 2013), 1), new Team(
		"FC Bayern Muenchen"), new Team("Borussia Dortmund"))));
    }
}
