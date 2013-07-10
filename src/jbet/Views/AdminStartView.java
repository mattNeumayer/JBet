/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jbet.Views;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import jbet.MainJFrame;

/**
 *
 * @author schmiedmayerp29
 */
public class AdminStartView extends javax.swing.JPanel implements ListSelectionListener{

    private MainJFrame mySuperFrame;
    private String currentselection;
    private DefaultListModel userListModel;
    
    /**
     * Creates new form AdminStartView
     */
    
    public AdminStartView (MainJFrame superFrame) {
        initComponents();
        mySuperFrame = superFrame;
        mySuperFrame.setSize(getPreferredSize());
        isAdminCheckBox.setEnabled(false);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        userList.addListSelectionListener(this);
        
        userListModel = new DefaultListModel();
        String[] user = mySuperFrame.getController().getAllUser();
        for(int i = 0; i < user.length; i++){
            userListModel.addElement(user[i]);
        }
        userList.setModel(userListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();
        enterLeagueButton = new javax.swing.JButton();
        enterResultsButton = new javax.swing.JButton();
        isAdminCheckBox = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        logoutButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome admin");

        userList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(userList);

        enterLeagueButton.setText("League eintragen");
        enterLeagueButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        enterLeagueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterLeagueButtonActionPerformed(evt);
            }
        });

        enterResultsButton.setText("Ergebnisse eintragen");
        enterResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterResultsButtonActionPerformed(evt);
            }
        });

        isAdminCheckBox.setText("Is Admin");
        isAdminCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isAdminCheckBoxActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.setToolTipText("");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isAdminCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enterResultsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterLeagueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(enterLeagueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enterResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(isAdminCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enterLeagueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterLeagueButtonActionPerformed
        mySuperFrame.presentEnterLeagueView();
    }//GEN-LAST:event_enterLeagueButtonActionPerformed

    private void enterResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterResultsButtonActionPerformed
        mySuperFrame.presentEnterMatchResultsView();
    }//GEN-LAST:event_enterResultsButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        mySuperFrame.logout();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void isAdminCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isAdminCheckBoxActionPerformed
        boolean temp = mySuperFrame.getController().setAdmin(currentselection,isAdminCheckBox.isSelected());
    }//GEN-LAST:event_isAdminCheckBoxActionPerformed

    @Override
    public void valueChanged(ListSelectionEvent e) {
        currentselection = userList.getSelectedValue().toString();
        isAdminCheckBox.setEnabled(true);
        isAdminCheckBox.setSelected(mySuperFrame.getController().isAdmin(currentselection)); 
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enterLeagueButton;
    private javax.swing.JButton enterResultsButton;
    private javax.swing.JCheckBox isAdminCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JList userList;
    // End of variables declaration//GEN-END:variables
}
