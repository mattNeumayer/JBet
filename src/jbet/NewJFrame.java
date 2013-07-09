package jbet;

import java.awt.*;
import javax.swing.JPanel;
import jbet.Views.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author schmiedmayerp29
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    private Controller myOwner;
    private JPanel myPanel;
    
    
    public NewJFrame(Controller owner) {
        initComponents();
        myOwner = owner;
        this.setLayout(new GridLayout(1, 1));
        myPanel = new RegistrationView(this);
        this.add(myPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        myPanel.setVisible(true);
        this.setVisible(true);
    }
    
    
    // User Management: -----------------------------------------------------------------------------
    
    
    public String getCurrentUser(){
        return myOwner.getCurrentUsername();
    }
    
    public boolean logout(){
        if(myOwner.logCurrentUserOut()){
            this.remove(myPanel);
            myPanel = new RegistrationView(this);
            this.add(myPanel, BorderLayout.CENTER);
            this.setLocationRelativeTo(null);
            myPanel.setVisible(true);
            this.setVisible(true);
            return true;
        }
        return false;
    }
    
    public boolean isAdmin(String name){
        return myOwner.isAdmin(name);
    }
    
    public boolean setAdmin(String name, boolean isAdmin){
        return myOwner.setAdmin(name, isAdmin);
    }
    
    public void userDidEnterLogin(String name, String passwort){
        System.out.println("Benutzername: " + name + "  Passwort: " + passwort);
        // Ausgeklammert weil keine Datenbank
        boolean valid = myOwner.requestUserLoginValid(name,passwort);
        if (valid) {
            System.out.println("Login True");
            presentJBetUI(isAdmin(name));
        }else{
            System.out.println("Login False - Reenter Username of Password");
        }
        
        //boolean flag = false; // Adminview anzeigen true, Userview false
        //presentJBetUI(flag);
    }

    
    public void creatNewUser(boolean isAdmin, String name, String passwort){
        System.out.println("Neuer Benutzer: (Admin: " + isAdmin + " )Benutzername: " + name + "  Passwort: " + passwort);
        boolean valid = myOwner.addUser(name,passwort,isAdmin);
        if (valid) {
            System.out.println("Login True");
            presentJBetUI(isAdmin);
        }else{
            System.out.println("ERROR: Could not create User");
        }
    }
    
    
    
    
    // present Views Methoden: -----------------------------------------------------------------------------
    
    
    public void showAddUserView(){
        this.remove(myPanel);
        myPanel = new NewUserView(this);
        this.add(myPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        myPanel.setVisible(true);
    }
    
    
    public void presentJBetUI(boolean isAdmin){
        this.remove(myPanel);
        if(isAdmin){
            myPanel = new AdminStartView(this);
        }else{
            myPanel = new UserView(this);
        }
        this.add(myPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        myPanel.setVisible(true);
    }
    
    public void presentLeagueEdit(){
        this.remove(myPanel);
        myPanel = new EnterLeagueDetailAdminView(this);
        this.add(myPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        myPanel.setVisible(true);
    }
    
    public void presentEnterMatchResults(boolean admin){
        this.remove(myPanel);
        if(admin){
            myPanel = new EnterMatchResultsAdminView(this);
        }else{
            myPanel = new EnterUserBetsView(this);
        }
        this.add(myPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        myPanel.setVisible(true);
    }
    
    public void presentLeaderboard(){
        this.remove(myPanel);
        myPanel = new LeaderboardView(this);
        this.add(myPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        myPanel.setVisible(true);
    }
    
    public void presentleagueUI(/* TO DO: HIER VARIABLE ÜBERGEBEN, DIE GEBRAUCHT WERDEN */){
        this.remove(myPanel);
        myPanel = new EnterLeagueDetailAdminView(this);
        this.add(myPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        myPanel.setVisible(true);
    }
    // -----------------------------------------------------------------------------------------------------
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(200, 2090));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
