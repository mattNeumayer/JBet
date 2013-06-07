/**
 * 
 */
package jbet.components;

/**
 * 05.06.2013
 * 
 */
public class Matchup {
    private Matchday matchday;
    private Team team1;
    private Team team2;
    private int scoreTeam1;
    private int scoreTeam2;
    private boolean hasScores;

    public Matchup(Matchday matchday, Team team1, Team team2) {
	this.matchday = matchday;
	this.team1 = team1;
	this.team2 = team2;
	this.hasScores = false;
    }

    public Matchup(Matchday matchday, Team team1, Team team2, int scoreTeam1,
	    int scoreTeam2) {
	this(matchday, team1, team2);
	this.scoreTeam1 = scoreTeam1;
	this.scoreTeam2 = scoreTeam2;
	this.hasScores = true;
    }

    /**
     * @return the scoreTeam1
     */
    public int getScoreTeam1() {
	return this.scoreTeam1;
    }

    /**
     * @param scoreTeam1
     *            the scoreTeam1 to set
     */
    public void setScores(int scoreTeam1, int scoreTeam2) {
	this.scoreTeam1 = scoreTeam1;
	this.scoreTeam2 = scoreTeam2;
	this.hasScores = true;
    }

    /**
     * @return the scoreTeam2
     */
    public int getScoreTeam2() {
	return this.scoreTeam2;
    }

    /**
     * @return the team1
     */
    public Team getTeam1() {
	return this.team1;
    }

    /**
     * @return the team2
     */
    public Team getTeam2() {
	return this.team2;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (this.hasScores ? 1231 : 1237);
	result = prime * result
		+ ((this.matchday == null) ? 0 : this.matchday.hashCode());
	result = prime * result + this.scoreTeam1;
	result = prime * result + this.scoreTeam2;
	result = prime * result
		+ ((this.team1 == null) ? 0 : this.team1.hashCode());
	result = prime * result
		+ ((this.team2 == null) ? 0 : this.team2.hashCode());
	return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Matchup other = (Matchup) obj;
	if (this.hasScores != other.hasScores)
	    return false;
	if (this.matchday == null) {
	    if (other.matchday != null)
		return false;
	} else if (!this.matchday.equals(other.matchday))
	    return false;
	if (this.scoreTeam1 != other.scoreTeam1)
	    return false;
	if (this.scoreTeam2 != other.scoreTeam2)
	    return false;
	if (this.team1 == null) {
	    if (other.team1 != null)
		return false;
	} else if (!this.team1.equals(other.team1))
	    return false;
	if (this.team2 == null) {
	    if (other.team2 != null)
		return false;
	} else if (!this.team2.equals(other.team2))
	    return false;
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return this.matchday + "=" + this.team1 + this.scoreTeam1 + ":"
		+ this.scoreTeam2 + this.team2;
    }

    /**
     * @return the matchday
     */
    public Matchday getMatchday() {
	return this.matchday;
    }

    /**
     * @return the hasScores
     */
    public boolean hasScores() {
        return this.hasScores;
    }

}
