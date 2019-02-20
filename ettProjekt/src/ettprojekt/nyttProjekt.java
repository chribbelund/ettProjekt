/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import static ettprojekt.EttProjekt.idb;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author EmelieD
 */
public class nyttProjekt extends javax.swing.JFrame {

    /**
     * Creates new form nyttProjekt
     *
     * @param idb
     */
    public nyttProjekt() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        skapaProjekt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        projektBeskrivning = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        projektNamn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Shree Devanagari 714", 1, 24)); // NOI18N
        jLabel4.setText("Nytt projekt ");

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jButton1.setText("Tillbaka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        skapaProjekt.setText("Skapa projekt");
        skapaProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skapaProjektActionPerformed(evt);
            }
        });

        projektBeskrivning.setColumns(20);
        projektBeskrivning.setRows(5);
        jScrollPane1.setViewportView(projektBeskrivning);

        jLabel6.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        jLabel6.setText("Projekt namn:");

        jLabel1.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        jLabel1.setText("Projekt beskrivning:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jButton1)
                .addGap(72, 72, 72)
                .addComponent(skapaProjekt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(projektNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(142, 142, 142))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projektNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(skapaProjekt))
                .addGap(21, 21, 21))
        );

        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/edit-file.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/loggo_liten.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void skapaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skapaProjektActionPerformed
        try {
            User u = User.getInstance();
            int agare = u.getID();
            String namn = projektNamn.getText();
            String beskrivning = projektBeskrivning.getText();

            if (EttProjekt.siffraVilken == 1) {
                String cykla = idb.fetchSingle("SELECT PROJEKTNAMN FROM PROJEKT WHERE PROJEKTNAMN = '" + namn + "';");
                if ((cykla == null)) {
                    String increment = idb.getAutoIncrement("PROJEKT", "PROJEKT_ID");
                    if (increment == null) {
                        increment = ("1");
                    }
                    System.out.println(increment + ".increment");

                    String fraga1 = "Insert into projekt values ( '" + namn + "', " + increment + "," + agare + ",'" + beskrivning + "')";
                    String fraga2 = "Insert into deltar_i_projekt values ( " + increment + "," + agare + ")";
                    idb.insert(fraga1);
                    idb.insert(fraga2);
                    JOptionPane.showMessageDialog(null, "Projekt har lagts till");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Det finns redan ett projekt med det namnet");
                }
            } else if (EttProjekt.siffraVilken == 2) {
                String cykla = idb.fetchSingle("SELECT UTBILDNINGSNAMN FROM UTBILDNING WHERE UTBILDNINGSNAMN = '" + namn + "';");
                if ((cykla == null)) {
                    String increment = idb.getAutoIncrement("UTBILDNING", "UTBILDNINGS_ID");
                    if (increment == null) {
                        increment = ("1");
                    }
                    String fraga3 = "Insert into utbildning values ( '" + namn + "', '" + beskrivning + "'," + agare + "," + increment + ")";
                    String fraga4 = "insert into deltar_i_utbildning values (" + increment + "," + agare + ")";
                    idb.insert(fraga3);
                    idb.insert(fraga4);
                    JOptionPane.showMessageDialog(null, "Projekt har lagts till");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Det finns redan ett projekt med det namnet");
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick snett");
        }
    }//GEN-LAST:event_skapaProjektActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new bloggLayout().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea projektBeskrivning;
    private javax.swing.JTextField projektNamn;
    private javax.swing.JButton skapaProjekt;
    // End of variables declaration//GEN-END:variables
}
