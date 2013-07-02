/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jbet.components;

/**
 *
 * @author neumayerm08
 */
public class Bet {
    private int score1, score2;
    private Matchup mu;
    
    public Bet(Matchday mu, int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
        this.mu = mu;
    }
    
    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public Matchup getMatchup() {
        return mu;
    }   
}