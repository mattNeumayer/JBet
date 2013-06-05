/**
 * 
 */
package jbet;

import java.sql.*;
/**
 * 05.06.2013
 *
 */
public class DbControl {

    private final static DbControl instance = new DbControl();
    private Connection con;
    private Statement st;
    
    private DbControl(){
	connect();
    }
       
    public static DbControl getInstance(){
	return instance;
    }
    
    private void connect() {
	try {
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	} catch (InstantiationException | IllegalAccessException
		| ClassNotFoundException e) {
	    System.err.println( "Failed loading MySQL driver!" );
	    close();
	}
		
	try {
	    con = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=test");
	} catch (SQLException e) {
	    System.err.println( "Failed connecting to database!" );
	    close();
	}
	
	try {
	    st = con.createStatement();
	} catch (SQLException e) {
	    System.err.println( "Failed creating a Statement!" );
	}
    }
    
    public void close(){
	if ( con != null )
	        try { con.close(); } catch ( SQLException e ) { System.err.println( "Unable to close the database connetion!" ); }
    }
}
