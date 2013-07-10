package jbet;

import java.awt.*;
import javax.swing.JPanel;
import jbet.Views.*;

/**
 *
 * @author schmiedmayerp29
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    
    private Controller myOwner;
    private JPanel myPanel;
    
    
    public MainJFrame(Controller owner) {        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        myOwner = owner;        
        myPanel = new RegistrationView(this);
        
        this.getContentPane().add(myPanel);
        pack();
        this.setVisible(true);
    }
    
    public Controller getController(){
        return myOwner;
    }
    
    
    // User Management: -----------------------------------------------------------------------------
    
    
    public String getCurrentUser(){
        return myOwner.getCurrentUsername();
    }
    
    public boolean logout(){
        if(myOwner.logCurrentUserOut()){
            presentRegistrationView();
            return true;
        }
        return false;
    }
    
    public boolean isAdmin(String name){
        return myOwner.isAdmin(name);
    }
    
    public void userDidEnterLogin(String name, String passwort){
        System.out.println("Benutzername: " + name + "  Passwort: " + passwort);
        // Ausgeklammert weil keine Datenbank
        boolean valid = myOwner.requestUserLoginValid(name,passwort);
        if (valid) {
            System.out.println("Login True");
            presentJBetView();
        }else{
            System.out.println("Login False - Reenter Username of Password");
        }
        
        //boolean flag = false; // Adminview anzeigen true, Userview false
        //presentJBetUI(flag);
    }

    
    public void createNewUser(boolean isAdmin, String name, String passwort){
        System.out.println("Neuer Benutzer: (Admin: " + isAdmin + " )Benutzername: " + name + "  Passwort: " + passwort);
        boolean valid = myOwner.addUser(name,passwort,isAdmin);
        if (valid) {
            System.out.println("Login True");
            presentJBetView();
        }else{
            System.out.println("ERROR: Could not create User");
        }
    }
    
    
    
    
    // present Views Methoden: -----------------------------------------------------------------------------
    
    
    public void changePanel(JPanel panelNext){
        this.remove(myPanel);
        myPanel = panelNext;
        this.add(myPanel, BorderLayout.CENTER);
        this.pack();
        myPanel.setVisible(true);
    }
    
    public void presentRegistrationView(){
        changePanel(new RegistrationView(this));
    }
    
    public void presentNewUserView(){
        changePanel(new NewUserView(this));
    }
    
    
    public void presentJBetView(){
        if(myOwner.isCurrentUserAdmin()){
            changePanel(new AdminStartView(this));
        }else{
            changePanel(new UserStartView(this));
        }
    }
    
    public void presentEnterMatchResultsView(){
        if(myOwner.isCurrentUserAdmin()){
            changePanel(new EnterMatchResultsView(this));
        }else{
            changePanel(new EnterUserBetsView(this));
        }
    }
    
    public void presentLeaderboardView(){
        changePanel(new LeaderboardView(this));
    }
    
    public void presentEnterLeagueView(){
        changePanel(new EnterLeagueView(this));
    }
    
     public void presentEnterLeagueDetailView(String leagueName){
        changePanel(new EnterLeagueDetailView(this, leagueName));
    }
}
