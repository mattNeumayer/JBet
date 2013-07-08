package jbet.components;

/**
 * @author Matthias Neumayer
 */
public class Matchday {
    private Season season;
    private int number;

    /**
     * @param season
     * @param startYear
     */
    public Matchday(Season season, int number) {
	this.season = season;
	this.number = number;
    }

    /**
     * @return the season
     */
    public Season getSeason() {
	return this.season;
    }

    /**
     * @return the startYear
     */
    public int getNumber() {
	return this.number;
    }

    @Override
    public String toString() {
	return this.season + " " + this.number;
    }


    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((this.season == null) ? 0 : this.season.hashCode());
	result = prime * result + this.number;
	return result;
    }


    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Matchday other = (Matchday) obj;
	if (this.season == null) {
	    if (other.season != null)
		return false;
	} else if (!this.season.equals(other.season))
	    return false;
	if (this.number != other.number)
	    return false;
	return true;
    }

}
