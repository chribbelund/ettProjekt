/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import static ettprojekt.EttProjekt.idb;
import javax.swing.ImageIcon;
import oru.inf.InfException;

/**
 *
 * @author Christoffer
 */
public class testFil extends javax.swing.JFrame {

    /**
     * Creates new form testFil
     */
    public testFil() {
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

        btn_upload = new javax.swing.JButton();
        bild = new javax.swing.JLabel();
        btnBild = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_upload.setText("Upload File");
        btn_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uploadActionPerformed(evt);
            }
        });

        bild.setMaximumSize(new java.awt.Dimension(250, 250));
        bild.setMinimumSize(new java.awt.Dimension(250, 250));

        btnBild.setText("Bild");
        btnBild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_upload)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBild)
                        .addGap(36, 36, 36)
                        .addComponent(bild, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_upload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bild, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBild))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
        try {
            filePicker.openFilePicker();
        } catch (InfException e) {
        }

    }//GEN-LAST:event_btn_uploadActionPerformed

    private void btnBildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBildActionPerformed
        try {
            int id = 2;
            String fraga = ("SELECT TEXT FROM FILER WHERE FIL_ID = '" + id +"';");
            fraga = idb.fetchSingle(fraga);
            ImageIcon icon = new ImageIcon(fraga);
            bild.setIcon(icon);
            //Lägg in så att bilden scalear
        } catch (InfException ex) {
            System.out.println("det fånkar inte");
        }
    }//GEN-LAST:event_btnBildActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bild;
    private javax.swing.JButton btnBild;
    private javax.swing.JButton btn_upload;
    // End of variables declaration//GEN-END:variables
}
