/**
 * 
 */
package jbet.components;

/**
 * 05.06.2013
 *
 */
public class Team {
    private String name;

    public Team(String name){
	this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return this.name;		
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((this.name == null) ? 0 : this.name.hashCode());
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
	Team other = (Team) obj;
	if (this.name == null) {
	    if (other.name != null)
		return false;
	} else if (!this.name.equals(other.name))
	    return false;
	return true;
    }
}
