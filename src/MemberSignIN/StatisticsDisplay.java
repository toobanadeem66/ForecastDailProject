/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberSignIN;
/**
 *
 * @author Dell
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import java.io.IOException;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.plot.CategoryPlot;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class stats{
    
    protected ArrayList<String> temp;
    protected ArrayList<String> wind;
    protected ArrayList<String> humidity;
    protected ArrayList<String> precipitation;
    protected ArrayList<String> clouds;
    protected ArrayList<String> pressure;
    protected ArrayList<String> timearray;
    protected ArrayList<String> hoursarray;
    //protected Subject weatherData;
    protected String results;
    protected String warn;
    protected JSONArray stats;

    stats() {
    }
   
    public void WeatherConditions(stats a){
        
    }
   

    public void warning(String a) {
       warn = a;
    }
    
    public void StatsParse(String Lat, String Long) throws ParseException{
        WeatherConditions f= new WeatherConditions();
        this.results=f.HourlyWeather(Lat,Long);
        if(!results.contains("error")){
        System.out.println(results);
        JSONObject JsonResult = new JSONObject(results);
        this.stats = JsonResult.getJSONArray("hourly");
        String temperature;
        String hour;
        String p;
        String h;
        this.temp = new ArrayList();
        this.timearray = new ArrayList();
        this.pressure = new ArrayList();
        this.humidity = new ArrayList();
        for(int i=0; i<stats.length();i++){
            JSONObject Forecast = stats.getJSONObject(i);
            temperature = Forecast.getString("temp");
            temp.add(temperature);
            hour = Forecast.getString("dt");
            timearray.add(hour);
            p = Forecast.getString("pressure");
            pressure.add(p);
            h =Forecast.getString("humidity");
            humidity.add(h);
        }
        getHours();
    }
        else 
            JOptionPane.showMessageDialog(null, "Enter correct Co ordinates", "Warning",JOptionPane.WARNING_MESSAGE);
    }
    
    public ArrayList<String> getTemperature(String results){
        return temp;
    }
    
    public void getHours(){
        this.hoursarray = new ArrayList();
            for(int i=0;i<timearray.size();i++){
                Long millis = Long.parseLong(timearray.get(i));
                System.out.println(millis);
                java.util.Date date = new java.util.Date(millis*1000L); 
                SimpleDateFormat jdf = new SimpleDateFormat("HH");
                jdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                String java_date = jdf.format(date);
                hoursarray.add(java_date);
            } 
    }    
}

public class StatisticsDisplay extends javax.swing.JFrame {
    /**
     * Creates new form StatisticsDisplay
     */
    String LAT;
    String LONG;
    WeatherData a;
    stats m;
 
    public StatisticsDisplay() {
    initComponents();
    }
    
    public Object passingObjects(Object m){
       return m;
    } 
      public void close(){
       WindowEvent closing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
       Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
       
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CPanel = new javax.swing.JPanel();
        Lattxt = new javax.swing.JTextField();
        Searchbtn = new javax.swing.JButton();
        Longtxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Tempbtn = new javax.swing.JButton();
        Pressurebtn = new javax.swing.JButton();
        Humiditybtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPanel.setPreferredSize(new java.awt.Dimension(300, 200));
        CPanel.setLayout(new javax.swing.BoxLayout(CPanel, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(CPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 803, 430));

        Lattxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LattxtActionPerformed(evt);
            }
        });
        getContentPane().add(Lattxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 12, 59, -1));

        Searchbtn.setText("Search");
        Searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 11, -1, -1));
        getContentPane().add(Longtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 12, 61, -1));

        jLabel1.setText("LATITUDE:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        jLabel2.setText("LONGITUDE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 15, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hours", "Temperature", "Humidity", "Pressure"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 301, 196));

        Tempbtn.setText("Temperature");
        Tempbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TempbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Tempbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 307, -1, -1));

        Pressurebtn.setText("Pressure");
        Pressurebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressurebtnActionPerformed(evt);
            }
        });
        getContentPane().add(Pressurebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 358, 95, -1));

        Humiditybtn.setText("Humidity");
        Humiditybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HumiditybtnActionPerformed(evt);
            }
        });
        getContentPane().add(Humiditybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 95, -1));

        jButton1.setText("Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 95, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Forecast Daily ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 730, 50));

        jLabel5.setFont(new java.awt.Font("Corbel", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Statistics ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 730, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MemberSignIN/pic5.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LattxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LattxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LattxtActionPerformed

    private void SearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnActionPerformed
        // TODO add your handling code here:
        LAT = Lattxt.getText();
        LONG = Longtxt.getText();
        this.m = new stats();
        try {
            m.StatsParse(LAT, LONG);
              DefaultTableModel dft = (DefaultTableModel)jTable1.getModel();
        dft.setRowCount(0);
        for(int i=1;i<m.temp.size();i++){
            Vector v2 = new Vector();
            v2.add(m.hoursarray.get(i)); 
            v2.add(m.temp.get(i));
            v2.add(m.humidity.get(i));
            v2.add(m.pressure.get(i));
            dft.addRow(v2);}
        } catch (ParseException ex) {
            Logger.getLogger(StatisticsDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }//GEN-LAST:event_SearchbtnActionPerformed

    private void TempbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempbtnActionPerformed

        String[] array = m.temp.toArray( new String[0]);
        Comparable[] array2 = m.hoursarray.toArray(new String[0]);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(m.stats.getJSONObject(0).getInt("temp"),"Temperature",array2[0]);
        dataset.setValue(m.stats.getJSONObject(1).getInt("temp"),"Temperature",array2[1]);
        dataset.setValue(m.stats.getJSONObject(2).getInt("temp"),"Temperature",array2[2]);
        dataset.setValue(m.stats.getJSONObject(3).getInt("temp"),"Temperature",array2[3]);
        dataset.setValue(m.stats.getJSONObject(4).getInt("temp"),"Temperature",array2[4]);
        dataset.setValue(m.stats.getJSONObject(5).getInt("temp"),"Temperature",array2[5]);
        dataset.setValue(m.stats.getJSONObject(6).getInt("temp"),"Temperature",array2[6]);
        dataset.setValue(m.stats.getJSONObject(7).getInt("temp"),"Temperature",array2[7]);
        dataset.setValue(m.stats.getJSONObject(8).getInt("temp"),"Temperature",array2[8]);
        dataset.setValue(m.stats.getJSONObject(9).getInt("temp"),"Temperature",array2[9]);
        JFreeChart chart = ChartFactory.createBarChart3D("Temperature Stats","Hours","Temperature",dataset,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartPanel chartP = new ChartPanel(chart);
        chartP.setSize(300,200);
        CPanel.removeAll();
        CPanel.add(chartP);
        CPanel.updateUI();
    }//GEN-LAST:event_TempbtnActionPerformed

    private void PressurebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PressurebtnActionPerformed
        Comparable[] array2 = m.hoursarray.toArray(new String[0]);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(m.stats.getJSONObject(0).getInt("pressure"),"Pressure",array2[0]);
        dataset.setValue(m.stats.getJSONObject(1).getInt("pressure"),"Pressure",array2[1]);
        dataset.setValue(m.stats.getJSONObject(2).getInt("pressure"),"Pressure",array2[2]);
        dataset.setValue(m.stats.getJSONObject(3).getInt("pressure"),"Pressure",array2[3]);
        dataset.setValue(m.stats.getJSONObject(4).getInt("pressure"),"Pressure",array2[4]);
        dataset.setValue(m.stats.getJSONObject(5).getInt("pressure"),"Pressure",array2[5]);
        dataset.setValue(m.stats.getJSONObject(6).getInt("pressure"),"Pressure",array2[6]);
        dataset.setValue(m.stats.getJSONObject(7).getInt("pressure"),"Pressure",array2[7]);
        dataset.setValue(m.stats.getJSONObject(8).getInt("pressure"),"Pressure",array2[8]);
        dataset.setValue(m.stats.getJSONObject(9).getInt("pressure"),"Pressure",array2[9]);
        JFreeChart chart = ChartFactory.createBarChart("Pressure Stats","Hours","Pressure",dataset,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartPanel chartP = new ChartPanel(chart);
        chartP.setSize(300,200);
        CPanel.removeAll();
        CPanel.add(chartP);
        CPanel.updateUI();
    }//GEN-LAST:event_PressurebtnActionPerformed

    private void HumiditybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HumiditybtnActionPerformed
        Comparable[] array2 = m.hoursarray.toArray(new String[0]);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(m.stats.getJSONObject(0).getInt("humidity"),"humidity",array2[0]);
        dataset.setValue(m.stats.getJSONObject(1).getInt("humidity"),"humidity",array2[1]);
        dataset.setValue(m.stats.getJSONObject(2).getInt("humidity"),"humidity",array2[2]);
        dataset.setValue(m.stats.getJSONObject(3).getInt("humidity"),"humidity",array2[3]);
        dataset.setValue(m.stats.getJSONObject(4).getInt("humidity"),"humidity",array2[4]);
        dataset.setValue(m.stats.getJSONObject(5).getInt("humidity"),"humidity",array2[5]);
        dataset.setValue(m.stats.getJSONObject(6).getInt("humidity"),"humidity",array2[6]);
        dataset.setValue(m.stats.getJSONObject(7).getInt("humidity"),"humidity",array2[7]);
        dataset.setValue(m.stats.getJSONObject(8).getInt("humidity"),"humidity",array2[8]);
        dataset.setValue(m.stats.getJSONObject(9).getInt("humidity"),"humidity",array2[9]);
        JFreeChart chart = ChartFactory.createLineChart("Humidity Stats","Hours","Humidity",dataset,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartPanel chartP = new ChartPanel(chart);
        chartP.setSize(300,200);
        CPanel.removeAll();
        CPanel.add(chartP);
        CPanel.updateUI();
        
            
    }//GEN-LAST:event_HumiditybtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
        MainMenu i = new MainMenu();
    
        i.setVisible(true);
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
            java.util.logging.Logger.getLogger(StatisticsDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticsDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticsDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticsDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       StatisticsDisplay n = new StatisticsDisplay();
        /* Create and display the form */

     /* WeatherData a = new WeatherData();
          stats m = new stats(a);
          a.HourlyWeather("24.8607","67.0011");
*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticsDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CPanel;
    private javax.swing.JButton Humiditybtn;
    private javax.swing.JTextField Lattxt;
    private javax.swing.JTextField Longtxt;
    private javax.swing.JButton Pressurebtn;
    private javax.swing.JButton Searchbtn;
    private javax.swing.JButton Tempbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

  
}


