/**
 *
 */
package jbet;

import java.sql.*;

import jbet.components.*;

/**
 * 05.06.2013
 *
 */
public class DbControl {

    private final static DbControl instance = new DbControl();
    private Connection con;
    private Statement st;

    private DbControl() {
        connect();
    }

    /**
     *
     * @return
     */
    public static DbControl getInstance() {
        return instance;
    }

    /**
     *
     * @param t
     * @return
     */
    public int add(Team t) {
        String msg = String.format("INSERT INTO team VALUES ('%s')",
                t.getName());
        return executeUpdate(msg);
    }

    /**
     *
     * @param l
     * @return
     */
    public int add(League l) {
        String msg = String.format("INSERT INTO league VALUES ('%s')",
                l.getName());
        return executeUpdate(msg);
    }

    /**
     *
     * @param s
     * @return
     */
    public int add(Season s) {
        String msg = String.format("INSERT INTO season Value(null,%d,'%s')",
                s.getStartYear(), s.getLeague().getName());
        return executeUpdate(msg);
    }

    /**
     *
     * @param md
     * @return
     */
    public int add(Matchday md) {
        int seasonID = getSeasonID(md.getSeason());
        if (seasonID == -1) {
            return -1;
        }
        String msg = String.format("INSERT INTO matchday Value(null,%d,%d)",
                seasonID, md.getNumber());
        return executeUpdate(msg);
    }

    /**
     *
     * @param m
     * @return
     */
    public int add(Matchup m) {
        int matchdayID = getMatchdayID(m.getMatchday());
        if (matchdayID == -1) {
            return -1;
        }
        String msg;
        if (m.hasScores()) {
            msg = String.format("INSERT INTO matchup Value(null,%d,'%s','%s',%d,%d)",
                    matchdayID, m.getTeam1().getName(), m.getTeam2().getName(), m.getScoreTeam1(), m.getScoreTeam2());
        } else {
            msg = String.format("INSERT INTO matchup Value(null,%d,'%s','%s',null,null)",
                    matchdayID, m.getTeam1().getName(), m.getTeam2().getName());
        }
        return executeUpdate(msg);
    }

    public int addUser(String username, String password, boolean isAdmin) {
        String msg;
        if (isAdmin) {
            msg = String.format("INSERT INTO user Value('%s','%s',1",
                    username, password);
        } else {
            msg = String.format("INSERT INTO user Value('%s','%s',0",
                    username, password);
        }
        return executeUpdate(msg);
    }

    public boolean checkLogin(String username, String passwort) {
        String msg = String.format("SELECT name FROM user WHERE name = '%s' AND password = '%s'",
                username, passwort);
        try {
            ResultSet rs = executeQuery(msg);
            rs.first();
            return !rs.isAfterLast();
        } catch (SQLException e) {
            return false;
        }
    }

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

    /**
     * @return
     */
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

    /**
     * @return
     */
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
        }

        try {
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost/JBet?user=root&password=test");
        } catch (SQLException e) {
            System.err.println("Failed connecting to database!");
        }

        try {
            st = con.createStatement();
        } catch (SQLException e) {
            System.err.println("Failed creating a Statement!");
        }
    }
}
