/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import static ettprojekt.EttProjekt.idb;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author EmelieD
 */
public class nyttInlagg extends javax.swing.JFrame {
    private bloggLayout layout;
    private inlaggFrame panelInlagg;
    
    

    /**
     * Creates new form nyttInlagg
     * @param idb
     */
    public nyttInlagg() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        layout = new bloggLayout();
        panelInlagg = new inlaggFrame();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(panelInlagg);
        panelInlagg.setVisible(true);
        panelInlagg.setOsynlig();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        nytt = new javax.swing.JButton();
        tillbaka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        nytt.setText("Nytt inlagg");
        nytt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nyttActionPerformed(evt);
            }
        });

        tillbaka.setText("Tillbaka");
        tillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tillbaka)
                .addGap(70, 70, 70)
                .addComponent(nytt)
                .addGap(30, 161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nytt)
                    .addComponent(tillbaka))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    
    private void nyttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nyttActionPerformed
      try{
          
          
           String text = panelInlagg.getText();
           
           String titel = panelInlagg.getTitel();
          
           String pattern = "yyyy-MM-dd";
           SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
           String date = simpleDateFormat.format(new Date());
           
           String increment = idb.getAutoIncrement("INLAGG", "INLAGG_ID");
           
           bloggLayout l = new bloggLayout();
           String projektNamn = l.getProjektNamn();
           System.out.println(projektNamn);
           
           String fraga1 = "SELECT PROJEKT_ID FROM PROJEKT WHERE PROJEKTNAMN = '" + projektNamn + "'";
           String projektId = idb.fetchSingle(fraga1);
           int projektIdInt = Integer.parseInt(projektId);
           System.out.println(projektIdInt);
           String fraga2 = "INSERT INTO PROJEKT_INLAGG VALUES (" + increment + "," + projektIdInt + ")";
           String fraga3 = "INSERT INTO INLAGG VALUES ('" + date + "','" + text + "','" + titel + "'," + increment + ")";
           System.out.println(fraga3);
           idb.insert(fraga3);
           idb.insert(fraga2);
           JOptionPane.showMessageDialog(null, "Inlägg har tillagts");
      }
      catch (InfException e)
      {
          JOptionPane.showConfirmDialog(null, "Något gick fel");
      }
    }//GEN-LAST:event_nyttActionPerformed

    private void tillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillbakaActionPerformed
     new projektBloggen().setVisible(true);
     this.dispose();
    }//GEN-LAST:event_tillbakaActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton nytt;
    private javax.swing.JPanel panel;
    private javax.swing.JButton tillbaka;
    // End of variables declaration//GEN-END:variables
}
