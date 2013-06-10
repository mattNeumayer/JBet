/**
 * 
 */
package jbet;

import jbet.components.*;

/**
 * 07.06.2013
 * 
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	DbControl Db = DbControl.getInstance();
	System.out.println(Db.add(new Matchup(new Matchday(new Season(
		new League("Bundesliga"), 2013), 1), new Team(
		"FC Bayern München"), new Team("Borussia Dortmund"))));
    }
}
