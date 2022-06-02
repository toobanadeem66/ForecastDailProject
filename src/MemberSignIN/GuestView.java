/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberSignIN;
/**
 *
 * @author 18558,18559,18562
 */
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;

class currentconditions implements Observer{
    
    protected String temperature;
    protected String pressure;
    protected String humidity;
    protected String precipitation;
    protected String city;
    protected String state;
    protected String country;
    protected String cloudcover;
    protected String windspeed;
    protected String hightemp;
    protected String lowtemp;
    protected String feelslike;
    protected String description;
    protected String visibility;
    protected String Sunset;
    protected String sunrise;
    protected Subject weatherData;
    protected String location;
    protected String results;
    protected String warn;
    
    currentconditions(Subject weatherdata){
         this.weatherData = weatherdata;
         weatherData.registerObserver(this);
         
    }

    public void update(String city, String country, String temp, String hightemp, String lowtemp, String humidity, String pressure, String cloudcover, String windspeed, String feelslike, String description, String visibility, String sunset,String sunrise, String precipitation, String results){
        
        this.temperature = temp;
        this.humidity = humidity; 
        this.pressure = pressure;
        this.city=city;
        this.country=country;
        this.cloudcover= cloudcover;
        this.hightemp=hightemp;
        this.lowtemp=lowtemp;
        this.visibility=visibility;
        this.windspeed=windspeed;
        this.feelslike=feelslike;
        this.description=description;
        this.Sunset=sunset;
        this.sunrise=sunrise;
        this.results=results;
        //this.precipitation=precipitation;\
    }
    
    @Override
    public void warning(String a){
    warn = a;
    }

    @Override
    public void update(String stats) {
        
    }
}

public class GuestView extends javax.swing.JFrame{
    /**
     * Creates new form GuestView
     */
    public String location; 
    public GuestView() {
        initComponents();
    }
      public void close(){
       WindowEvent closing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
       Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        Searchlocationtxt = new javax.swing.JTextField();
        searchlocationbtn = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Vrinda", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Unknown Location");
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 35));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 720, -1));

        jLabel1.setFont(new java.awt.Font("Vrinda", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("weather type");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 720, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("42");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 720, 40));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 321, 720, -1));

        jLabel4.setFont(new java.awt.Font("Vrinda", 1, 24)); // NOI18N
        jLabel4.setText("Monday");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 300, 22));

        jLabel5.setFont(new java.awt.Font("Vrinda", 1, 18)); // NOI18N
        jLabel5.setText("50");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 60, -1));

        jLabel6.setFont(new java.awt.Font("Vrinda", 1, 18)); // NOI18N
        jLabel6.setText("40");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 70, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setText("8");
        jPanel3.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, 80, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setText("1");
        jPanel3.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 70, 10));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setText("2");
        jPanel3.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 60, -1));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setText("3");
        jPanel3.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 60, 10));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel65.setText("4");
        jPanel3.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 70, 10));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel66.setText("5");
        jPanel3.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 90, -1));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel67.setText("6");
        jPanel3.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 200, -1));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel68.setText("7");
        jPanel3.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 210, -1));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel69.setText("HUMIDITY:");
        jPanel3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setText("PRESSURE:");
        jPanel3.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel71.setText("FEELS LIKE:");
        jPanel3.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel72.setText("VISIBILITY:");
        jPanel3.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel73.setText("WIND:");
        jPanel3.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel74.setText("SUNSET:");
        jPanel3.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel75.setText("SUNRISE:");
        jPanel3.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, -1, -1));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel76.setText("COUNTRY:");
        jPanel3.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, -1, -1));

        jLabel77.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 153));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Forecast Daily");
        jPanel3.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 60));

        Searchlocationtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchlocationtxtActionPerformed(evt);
            }
        });
        jPanel3.add(Searchlocationtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 140, -1));

        searchlocationbtn.setBackground(new java.awt.Color(0, 153, 255));
        searchlocationbtn.setText("OK");
        searchlocationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchlocationbtnActionPerformed(evt);
            }
        });
        jPanel3.add(searchlocationbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 13, -1, 30));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel80.setText("Search location:");
        jPanel3.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 20));

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MemberSignIN/pic33.jpg"))); // NOI18N
        jPanel3.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 60));

        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 620, -1, -1));

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MemberSignIN/pic5.jpg"))); // NOI18N
        jPanel3.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 910, 620));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String setLocation(){
       return this.location;
    }
    
    private void searchlocationbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchlocationbtnActionPerformed
        // TODO add your handling code here:
        try {
            location = Searchlocationtxt.getText();
            WeatherConditions a = new WeatherConditions();
            currentconditions s = new currentconditions(a); 
            a.currentWeatherConditions(location);
            if(s.warn.equals("good")){
                jLabel1.setText(s.description);
                jLabel3.setText(s.temperature);
                jLabel2.setText(s.city);
                jLabel4.setText(LocalDate.now().getDayOfWeek().name());
                jLabel5.setText(s.hightemp);
                jLabel6.setText(s.lowtemp);
                jLabel62.setText(s.visibility);
                jLabel63.setText(s.humidity.substring(0,s.humidity.length()-1));
                jLabel64.setText(s.pressure);
                jLabel65.setText(s.feelslike);
                jLabel66.setText(s.windspeed);
                if(!s.country.equals("no country")){
                    jLabel55.setText(s.country);   
                }
                else{
                    jLabel55.setText(s.city);
                }
                jLabel67.setText(s.Sunset);
                jLabel68.setText(s.sunrise);  
            }
            else if (s.warn.equals("error")){
                JOptionPane.showMessageDialog(null, "Enter correct location", "Warning",JOptionPane.WARNING_MESSAGE);
            } 
        }  
        catch (IOException ex) {
            Logger.getLogger(GuestView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GuestView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchlocationbtnActionPerformed

    private void SearchlocationtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchlocationtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchlocationtxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        close();
         
        MemberSignIN a = new MemberSignIN();
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ParseException, IOException {
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
            java.util.logging.Logger.getLogger(GuestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
         
        
        
        
        
  Scanner input = new Scanner(System.in);
        java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
            public void run() {
                    new GuestView().setVisible(true);
            }   
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Searchlocationtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton searchlocationbtn;
    // End of variables declaration//GEN-END:variables
}





