/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Feisal
 */
public class bjudIn extends javax.swing.JFrame {

    /**
     * Creates new form bjudIn
     */
    private InfDB idb;
    private String namn;
    private Integer aID;
    private Integer mID;

    public bjudIn(InfDB idb, String namn) {
        initComponents();
        this.idb = idb;
        this.namn = namn;

    }

    public bjudIn(InfDB idb) {
        initComponents();
        this.idb = idb;
        this.namn = namn;
        getAnvandare();
        getMoten();

    }

    public void getAnvandare() {

        try {
            ArrayList<HashMap<String, String>> anvandareList = idb.fetchRows("SELECT USER_ID, FIRST_NAME, LAST_NAME FROM USERS ");
            for (HashMap<String, String> anvandare : anvandareList) {
                String allanamn = anvandare.get("FIRST_NAME") + " " + anvandare.get("LAST_NAME");
                anvandarList.addItem(allanamn);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, n.getMessage());
        }
    }

    public void getMoten() {

        try {
            ArrayList<HashMap<String, String>> moteList = idb.fetchRows("SELECT MOTE_ID, TITEL FROM MOTEN ");
            for (HashMap<String, String> mote : moteList) {
                String allamote = mote.get("TITEL");
                motenList.addItem(allamote);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, n.getMessage());    
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anvandarList = new javax.swing.JComboBox();
        motenList = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        anvandarList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Välj användare" }));
        anvandarList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anvandarListActionPerformed(evt);
            }
        });

        motenList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Välj möte" }));
        motenList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motenListActionPerformed(evt);
            }
        });

        jButton1.setText("Bjud in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anvandarList, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(motenList, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jButton1)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(anvandarList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(motenList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void testMetod() throws InfException {
        String mail = ("SELECT EMAIL FROM USERS WHERE USER_ID = '" + aID + "';");
        String svar = idb.fetchSingle(mail);
        System.out.println(svar + ".");
        String meddelande = ("Hej '" + anvandarList.getSelectedItem() + "' du är inbjuden till '" + motenList.getSelectedItem() + "';");
        String amne = "Mötesnotis!";
        Mejl.SkickaMejlet(svar, amne, meddelande);
        JOptionPane.showMessageDialog(this, "Ditt mejl har skickats!");
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String a = (String) anvandarList.getSelectedItem();
            String fornamn = a.split(" ")[0];
            String efternamn = a.split(" ")[1];
            String id = ("SELECT USER_ID FROM USERS WHERE FIRST_NAME = '" + fornamn + "' AND LAST_NAME = '" + efternamn + "';");
            String idSvar = idb.fetchSingle(id);
            String mail = ("SELECT EMAIL FROM USERS WHERE USER_ID = '" + idSvar + "';");
            System.out.println(mail);
            String svar = idb.fetchSingle(mail);
            String meddelande = ("Hej '" + ((String) anvandarList.getSelectedItem()) + "' du är inbjuden till '" + ((String) motenList.getSelectedItem()) + "';");
            String amne = "Mötesnotis!";
            Mejl.SkickaMejlet(svar, amne, meddelande);
            JOptionPane.showMessageDialog(this, "Ditt mejl har skickats!");
            String m = (String) motenList.getSelectedItem();
            String titel = m.split(" ")[0];
            String mid = ("SELECT MOTE_ID FROM MOTEN WHERE TITEL = '" + titel + "';");
            String moteID = idb.fetchSingle(mid);
            String fraga = ("INSERT INTO SKAPAR_MOTE VALUES ('" + idSvar + "', '" + moteID + "');");
            System.out.println(fraga);
            idb.insert(fraga);
            
            JOptionPane.showMessageDialog(null, "Inbjudan lyckad!");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void motenListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motenListActionPerformed

    }//GEN-LAST:event_motenListActionPerformed

    private void anvandarListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anvandarListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anvandarListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox anvandarList;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox motenList;
    // End of variables declaration//GEN-END:variables
}
