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
/**
 *
 * @author HOME
 */
public class MemberCreateAccount extends javax.swing.JFrame {

    /**
     * Creates new form MemberSignIN
     */
    public MemberCreateAccount() {
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
        txtname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtage = new javax.swing.JTextField();
        txtgender = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Forecast Daily");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 12, 348, 48));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Create Account");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 96, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 144, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 204, -1, -1));

        txtemailID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtemailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 132, 348, 36));

        jButton1.setText("Create One");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 372, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 264, -1, -1));
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 252, 348, 36));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Age");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 324, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 372, -1, -1));
        jPanel1.add(txtage, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 324, 120, 24));
        jPanel1.add(txtgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 372, 120, 24));
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 192, 348, 36));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MemberSignIN/ProjectMemberimaga.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 792, 444));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String emailID,password,name,gender;
        int age;
        emailID=txtemailID.getText();
        password=txtpassword.getText();
        name=txtname.getText();
        age=Integer.parseInt(txtage.getText());
        gender=txtgender.getText();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con= DriverManager.getConnection("jdbc:ucanaccess://E:/AccountDetails.accdb");
            pst=con.prepareStatement("insert into userinformation(EmailID,Password,Name,Age,Gender)values(?,?,?,?,?)");
            pst.setString(1, emailID);
            pst.setString(2, password);
            pst.setString(3, name);
            pst.setInt(4, age);
            pst.setString(5, gender);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Account created");
            txtemailID.setText("");
            txtpassword.setText("");
            txtname.setText("");
            txtage.setText("");
            txtgender.setText("");
            txtemailID.requestFocus();
            close();
            MemberSignIN edit= new MemberSignIN();
            edit.setVisible(true);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(MemberCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtemailIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailIDActionPerformed

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
            java.util.logging.Logger.getLogger(MemberCreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberCreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberCreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberCreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberCreateAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtemailID;
    private javax.swing.JTextField txtgender;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
