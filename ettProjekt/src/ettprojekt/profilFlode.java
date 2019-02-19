/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

import static ettprojekt.EttProjekt.idb;
import static ettprojekt.EttProjekt.userDir;
import java.awt.Dimension;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author mira
 */
public class profilFlode extends javax.swing.JFrame {

  
public static InfDB idb;
String filename = null;
byte[] person_image=null;
 int id;
    /**
     * Creates new form profil
     */
    public profilFlode() {
        initComponents(); 
        this.setExtendedState(this.MAXIMIZED_BOTH);
        flode();
        userDir = System.getProperty("user.dir"); //Hämtar vart programmet körs ifrån
        userDir += "/lib/DATABASE.FDB"; //Pekar på vart databasen ligger lagrad
        try{
          //Importerar databasen
            idb = new InfDB(EttProjekt.userDir);
           System.out.println(userDir);
        }
        
       catch(InfException e){
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("fel:" + e);
    }
        setinfo();
                     
    User u = User.getInstance();
    id = u.getID();

        
    
    }
   public void setinfo (){
    try{
             
    User u = User.getInstance();
    int id = u.getID();
    System.out.println(id);
    
    String hamtafnamn = "SELECT FIRST_NAME from users where user_id =" +id + ";";
    String fnamn = idb.fetchSingle(hamtafnamn);
    
    String hamtaenamn = "SELECT LAST_NAME from users where user_id = " +id + ";";
    String enamn = idb.fetchSingle(hamtaenamn);
    
    String hamtalosen = "SELECT LOSENORD from users where user_id =" +id + ";";
    System.out.println(hamtalosen);
    
    String hamtatel = "SELECT TELEFON from users where user_id =" +id + ";";
    System.out.println(hamtatel);
    
   String hamtabild = "SELECT BILDER from users where user_id =" +id+ ";";
   System.out.println(hamtabild);
   
   String bild = idb.fetchSingle(hamtabild);
   System.out.println(bild + ".");
   try{
   bild = bild.replaceAll("\\s+","");
   }catch(NullPointerException i ){}
   System.out.println(bild + ".");
    
   /// String losen = idb.fetchSingle(hamtalosen);

    
    /// String tel = idb.fetchSingle(hamtatel);

    
    ///String hamtamejl = "SELECT EMAIL from users where user_id ="+id+ ";";
    ///String mejlen = idb.fetchSingle(hamtamejl);

            lbfnamn.setText(fnamn);
            lbenamn.setText(enamn);
            ///txtlosen.setText(losen);
            ///txtmejl.setText(mejlen);
            ///txttel.setText(tel);
            //String test = ("/Users/mira/NetBeansProjects/ettProjekt/ettProjekt/files/2019-02-08 12.54.06.108-asplund.jpg");
            ImageIcon imageIcon = new ImageIcon (new ImageIcon(bild).getImage().getScaledInstance(lblbild.getWidth(),lblbild.getHeight(),Image.SCALE_SMOOTH));
            lblbild.setIcon(imageIcon);
             
    }catch(InfException e){
            
        
            }
     }
    private void flode(){
         try {
            inlaggFrame layout = new inlaggFrame();
            String profilNamn = layout.getUserId();
            
            String fraga1 = "SELECT USER_ID FROM USERS WHERE FIRST_NAME = '" + profilNamn + "'";
            String projektId = idb.fetchSingle(fraga1);
            int projektIdInt = Integer.parseInt(projektId);
            String fraga2 = "SELECT INLAGG_ID FROM SKAPA_INLAGG WHERE USER_ID = " + projektIdInt + ";";
            ArrayList<String> inlaggLista = idb.fetchColumn(fraga2);
          
            if (inlaggLista == null) {
                return;

            }
            Collections.reverse(inlaggLista);
            int antalInlagg = inlaggLista.size();
            String fragan = "SELECT TEXT FROM INLAGG JOIN SKAPA_INLAGG ON INLAGG.INLAGG_ID = SKAPA_INLAGG.INLAGG_ID WHERE INLAGG_ID = " + projektIdInt + ";";
            ArrayList<String> texter = idb.fetchColumn(fragan);
            Collections.reverse(texter);

            fragan = "SELECT TITEL FROM INLAGG JOIN SKAPA_INLAGG ON INLAGG.INLAGG_ID = SKAPA_INLAGG.INLAGG_ID WHERE INLAGG_ID = " + projektIdInt + ";";
            ArrayList<String> titlar = idb.fetchColumn(fragan);
            Collections.reverse(titlar);

            for (int j = 0; j < antalInlagg; j++) {
                inlaggFrame panel = new inlaggFrame();
                String id = inlaggLista.get(j);
                panelen.setLayout(new BoxLayout(panelen, BoxLayout.PAGE_AXIS));
                panelen.add(Box.createRigidArea(new Dimension(0, 20)));
                panelen.add(panel);
                panelen.setVisible(true);
                String allaTexter = texter.get(j);
                String allaTitlar = titlar.get(j);
                panel.setText(allaTexter);
                panel.setTitel(allaTitlar);
                panel.setID(id);
                System.out.println(id);
               // panel.setinlaggFrame(this);
                //panel.setEditable();
                //panel.utbildningAgare();

                try {
                    String anvandare = "SELECT USER_ID FROM SKAPA_INLAGG WHERE INLAGG_ID = '" + id + "'";
                    String anvandarId = idb.fetchSingle(anvandare);
                    String fornamn = "SELECT FIRST_NAME FROM USERS WHERE USER_ID = '" + anvandarId + "'";
                    String fornamnet = idb.fetchSingle(fornamn);
                    String efternamn = "SELECT LAST_NAME FROM USERS WHERE USER_ID = '" + anvandarId + "'";
                    String efternamnet = idb.fetchSingle(efternamn);
                    String helaNamnet = fornamnet + " " + efternamnet;
                    panel.setSkapare(helaNamnet);
                    panel.inlaggAgare();
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(null, "Användare fel");
                }

            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }

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
        jLabel1 = new javax.swing.JLabel();
        lbfnamn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbenamn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblbild = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelen = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        jLabel1.setText("Förnamn");

        lbfnamn.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        lbfnamn.setText("namn");

        jLabel3.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        jLabel3.setText("Efternamn");

        lbenamn.setFont(new java.awt.Font("Shree Devanagari 714", 0, 14)); // NOI18N
        lbenamn.setText("namn");

        jLabel2.setFont(new java.awt.Font("Shree Devanagari 714", 2, 36)); // NOI18N
        jLabel2.setText("Profil");

        jPanel3.setBackground(new java.awt.Color(0, 51, 255));
        jPanel3.setForeground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        lblbild.setText("bild");

        jButton1.setText("Tillbaka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/loggo_liten.png"))); // NOI18N

        javax.swing.GroupLayout panelenLayout = new javax.swing.GroupLayout(panelen);
        panelen.setLayout(panelenLayout);
        panelenLayout.setHorizontalGroup(
            panelenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 839, Short.MAX_VALUE)
        );
        panelenLayout.setVerticalGroup(
            panelenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(86, 86, 86)
                        .addComponent(lbenamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(95, 95, 95)
                        .addComponent(lbfnamn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addComponent(lblbild, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel5)
                .addGap(68, 68, 68))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbfnamn))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbenamn)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblbild, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbenamn;
    private javax.swing.JLabel lbfnamn;
    private javax.swing.JLabel lblbild;
    private javax.swing.JPanel panelen;
    // End of variables declaration//GEN-END:variables

}