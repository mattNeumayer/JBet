package jbet.components;

import java.util.Objects;

/**
 *  @author Matthias Neumayer
 */
public class Bet {
    private String username;
    private int score1, score2;
    private Matchup mu;
    
    public Bet(String username, Matchup mu, int score1, int score2) {
        this.username = username;
        this.score1 = score1;
        this.score2 = score2;
        this.mu = mu;
    }
    
    public String getUsername() {
        return username;
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bet other = (Bet) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (this.score1 != other.score1) {
            return false;
        }
        if (this.score2 != other.score2) {
            return false;
        }
        if (!Objects.equals(this.mu, other.mu)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username + "bets: " + score1 + ":" + score2 + ", for match: " + mu;
    }
    
}