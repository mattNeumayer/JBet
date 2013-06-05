/**
 * 
 */
package jbet.components;

/**
 * 05.06.2013
 *
 */
public class Season {
    private League l;
    private int startYear;
    /**
     * @param l
     * @param startYear
     */
    public Season(League l, int startYear) {
	this.l = l;
	this.startYear = startYear;
    }
    /**
     * @return the l
     */
    public League getLeague() {
        return this.l;
    }
    /**
     * @return the startYear
     */
    public int getStartYear() {
        return this.startYear;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((this.l == null) ? 0 : this.l.hashCode());
	result = prime * result + this.startYear;
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
	Season other = (Season) obj;
	if (this.l == null) {
	    if (other.l != null)
		return false;
	} else if (!this.l.equals(other.l))
	    return false;
	if (this.startYear != other.startYear)
	    return false;
	return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return this.l + " "+ this.startYear;
    }
    
}
