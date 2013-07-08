/**
 *
 */
package jbet;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import jbet.components.*;

/**
 * 05.06.2013
 *
 */
public class DbControl {

    private final static DbControl instance = new DbControl();
    //@Home:
    private final static String mySqlDriverManagerArg = "jdbc:mysql://localhost/Q11_gruppe4";
    private final static String mySqlUsername = "root";
    private final static String mySqlPassword = "";
    //@School:
    //private final static String mySqlDriverManagerArg = "jdbc:mysql://172.16.11.1/Q11_gruppe4";
    //private final static String mySqlUsername = "Q11_gruppe4";
    //private final static String mySqlPassword = "1234";
    private Connection con;
    private Statement st;

    /**
     * Singleton constructor
     */
    private DbControl() {
        connect();
    }

    /**
     *
     * @return the DbControl instance
     */
    public static DbControl getInstance() {
        return instance;
    }

    
    //Adding methods
    
    /**
     * Adds the given Team to the Database. Fails if the Team already exists.
     *
     * @param team
     * @return 1 if the SQL command was executed, -1 of it failed.
     */
    public int add(Team team) {
        String msg = String.format("INSERT INTO team VALUES('%s')",
                team.getName());
        return executeUpdate(msg);
    }

    /**
     * Adds the given League to the Database. Fails if the League already exists.
     *
     * @param league
     * @return 1 if the SQL command was executed, -1 if it failed.
     */
    public int add(League league) {
        String msg = String.format("INSERT INTO league VALUES ('%s')",
                league.getName());
        return executeUpdate(msg);
    }

    /**
     * Adds the given Season to the Database. Fails if the Season already exists. Does
     * not add the underlying League. (The method will fail if the League wasn´t
     * added previously)
     *
     * @param season
     * @return 1 if the SQL command was executed, -1 if it failed.
     */
    public int add(Season season) {
        String msg = String.format("INSERT INTO season Value(null,'%s',%d)",
                season.getLeague().getName(), season.getStartYear());
        return executeUpdate(msg);
    }

    /**
     * Adds the given Matchday to the Database. Fails if the Matchday already exists.
     * Does not add the underlying Season. (The method will fail if the Season
     * wasn´t added previously)
     *
     * @param matchday
     * @return 1 if the SQL command was executed, -1 if it failed.
     */
    public int add(Matchday matchday) {
        int seasonID = getSeasonID(matchday.getSeason());
        if (seasonID == -1) {
            return -1;
        }
        String msg = String.format("INSERT INTO matchday Value(null,%d,%d)",
                seasonID, matchday.getNumber());
        return executeUpdate(msg);
    }

    /**
     * Adds the given Matchup to the Database. Fails if the Matchup already exists.
     * Does not add the underlying Matchday. (The method will fail if the
     * Matchday wasn´t added previously)
     *
     * @param matchup
     * @return 1 if the SQL command was executed, -1 if it failed.
     */
    public int add(Matchup matchup) {
        int matchdayID = getMatchdayID(matchup.getMatchday());
        if (matchdayID == -1) {
            return -1;
        }
        String msg;
        if (matchup.hasScores()) {
            msg = String.format("INSERT INTO matchup Value(null,%d,'%s','%s',%d,%d)",
                    matchdayID, matchup.getTeam1().getName(), matchup.getTeam2().getName(), matchup.getScoreTeam1(), matchup.getScoreTeam2());
        } else {
            msg = String.format("INSERT INTO matchup Value(null,%d,'%s','%s',null,null)",
                    matchdayID, matchup.getTeam1().getName(), matchup.getTeam2().getName());
        }
        return executeUpdate(msg);
    }

    /**
     * Adds the given User to the Database. Fails if the User already exists.
     * @param user
     * @return 1 if the SQL command was executed, -1 if it failed.
     */
    public int add(User user) {
        String msg;
        if (user.isAdmin()) {
            msg = String.format("INSERT INTO user Value('%s','%s',1)",
                    user.getUsername(), user.getPassword());
        } else {
            msg = String.format("INSERT INTO user Value('%s','%s',0)",
                    user.getUsername(), user.getPassword());
        }
        return executeUpdate(msg);
    }

    /**
     * Adds the given Bet to the Database. Fails if the Bet already exists.
     * @param bet
     * @return 1 if the SQL command was executed, -1 if it failed.
     */
    public int add(Bet bet) {
        int matchupID = getMatchupID(bet.getMatchup());
        if (matchupID == -1) {
            return -1;
        }
        String msg;
        msg = String.format("INSERT INTO bet Value(null,'%s',%d,%d,%d)",
                bet.getUsername(), matchupID, bet.getScore1(), bet.getScore2());
        return executeUpdate(msg);
    }

    
    //List methods
    
    public ArrayList<String> listAllUsername(){
        ResultSet rs = executeQuery("SELECT name FROM user ORDER BY name");
        ArrayList<String> list = new ArrayList();
        try {
            while(rs.next()){
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public ArrayList<String> listAllLeague(){
        ResultSet rs = executeQuery("SELECT name FROM league ORDER BY name");
        ArrayList<String> list = new ArrayList();
        try {
            while(rs.next()){
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public ArrayList<Season> listAllSeason(){
        ResultSet rs = executeQuery("SELECT league, startyear FROM season ORDER BY league,startyear");
        ArrayList<Season> list = new ArrayList();
        try {
            while(rs.next()){
                list.add(new Season(rs.getString(1),rs.getInt(2)));
            }
            return list;
        } catch (SQLException e){ 
            return null;
        }
    }
    
    //User and Login methods    
    
    /**
     * Checks if a User with the given Username exists.
     *
     * @param username
     * @return whether the user exists or not. (or false if the SQL command
     * failed)
     */
    public boolean exists(String username) {
        String msg = String.format("SELECT username FROM user WHERE username = '%s'", username);
        ResultSet rs = executeQuery(msg);
        try {
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Checks if the given login data (username, password) was correct.
     *
     * @param username
     * @param passwort
     * @return whether the login was correct or not. (or false if the SQL
     * command failed)
     */
    public boolean checkLogin(String username, String passwort) {
        String msg = String.format("SELECT name FROM user WHERE name = '%s' AND password = '%s'",
                username, passwort);
        ResultSet rs = executeQuery(msg);
        try {
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Checks if the User with the given Username is Admin.
     *
     * @param username
     * @return whether the user is Admin or not. (or false if the SQL command
     * failed)
     */
    public boolean isAdmin(String username) {
        String msg = String.format("SELECT isadmin FROM user WHERE name = '%s'",
                username);
        try {
            ResultSet rs = executeQuery(msg);
            rs.first();
            return rs.getBoolean(1);
        } catch (SQLException e) {
            return false;
        }
    }

    
    //internal database ID getter
    
    private int getSeasonID(Season s) {
        String msg = String.format("SELECT S_ID FROM season WHERE startyear = %d AND league = '%s'",
                s.getStartYear(), s.getLeague());
        try {
            ResultSet rs = executeQuery(msg);
            rs.first();
            return rs.getInt(1);
        } catch (SQLException e) {
            return -1;
        }
    }

    private int getMatchdayID(Matchday md) {
        int seasonID = getSeasonID(md.getSeason());
        if (seasonID == -1) {
            return -1;
        }
        String msg = String.format("SELECT MD_ID FROM matchday WHERE number = %d AND season = '%d'",
                md.getNumber(), seasonID);
        try {
            ResultSet rs = executeQuery(msg);
            rs.first();
            return rs.getInt(1);
        } catch (SQLException e) {
            return -1;
        }
    }

    private int getMatchupID(Matchup mu) {
        int MatchdayID = getMatchdayID(mu.getMatchday());
        if (MatchdayID == -1) {
            return -1;
        }
        String msg = String.format("SELECT MU_ID FROM matchup WHERE matchday = %d AND team1 = '%s' AND team2 = '%s'",
                MatchdayID, mu.getTeam1().getName(), mu.getTeam2().getName());
        try {
            ResultSet rs = executeQuery(msg);
            rs.first();
            return rs.getInt(1);
        } catch (SQLException e) {
            return -1;
        }
    }

    
    //SQL methods
    
    private ResultSet executeQuery(String sql) {
        try {
            return st.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }

    private int executeUpdate(String sql) {
        try {
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            return -1;
        }
    }

    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Failed loading MySQL driver!");
            e.printStackTrace();
        }

        try {
            con = DriverManager
                    .getConnection(mySqlDriverManagerArg, mySqlUsername, mySqlPassword);
        } catch (SQLException e) {
            System.err.println("Failed connecting to database!");
            e.printStackTrace();
        }

        try {
            st = con.createStatement();
        } catch (SQLException e) {
            System.err.println("Failed creating a Statement!");
            e.printStackTrace();
        }
    }
}
