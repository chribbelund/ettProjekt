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

        jPanel1 = new javax.swing.JPanel();
        anvandarList = new javax.swing.JComboBox();
        motenList = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/loggo_liten.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel2.setText("Bjud in användare till möten");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/untitled.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(anvandarList, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(motenList, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(anvandarList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(motenList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox motenList;
    // End of variables declaration//GEN-END:variables
}
