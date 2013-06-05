/**
 * 
 */
package jbet;

/**
 * 05.06.2013
 *
 */
public class DbControl {

    private final static DbControl instance = new DbControl();
    
    private DbControl(){}
    
    public static DbControl getInstance(){
	return instance;
    }
}
