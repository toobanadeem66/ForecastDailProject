/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberSignIN;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author 18559,18558,18562
 */
public class MemberSignIN extends javax.swing.JFrame implements Subject{
    /**
     * Creates new form MemberSignIN
     */
    public MemberSignIN() {
        initComponents();
    }
   
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
   
     public void close(){
       WindowEvent closing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
       Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
       
   }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtemailID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Forecast Daily");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 12, 350, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sign IN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 96, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 156, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 228, -1, -1));
        jPanel1.add(txtemailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 144, 348, 36));

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 228, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Don't have an account?");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        jButton2.setText("Create one");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 300, -1, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 444));
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 216, 348, 36));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("View as a guest?");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 348, -1, -1));

        jButton3.setText("Guest View");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 348, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MemberSignIN/ProjectMemberimaga.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 792, 444));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String emailID;
        String password;
        emailID=txtemailID.getText();
        password=txtpassword.getText();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con= DriverManager.getConnection("jdbc:ucanaccess://E:/AccountDetails.accdb");
            pst= con.prepareStatement("Select * from userinformation where EmailID='"+emailID+"' and Password='"+password+"'");
            rs=pst.executeQuery();
            if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Successfully signed in");
                     rs.close();
                     pst.close();
                     close();
                    MainMenu edit= new MainMenu();
                    edit.setVisible(true);
                   
                }  
                else{
                JOptionPane.showMessageDialog(this, "Incorrect Email ID/Password");
                }
            
            txtemailID.setText("");
            txtpassword.setText("");
            txtemailID.requestFocus();
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberSignIN.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(MemberSignIN.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,ex);
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        close();
        MemberCreateAccount edit= new MemberCreateAccount();
        edit.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        close();
        GuestView edit= new GuestView();
        edit.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MemberSignIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberSignIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberSignIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberSignIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberSignIN().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtemailID;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables

    @Override
    public void registerObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
