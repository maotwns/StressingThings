/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubesif7_apkkoperasi;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author RANI AMALIYAH
 */
public class LapPenjualan extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;

    /**
     * Creates new form LapPenjualan
     */
    public LapPenjualan() {
        initComponents();
        panelDet.setVisible(false);
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        
        TTransaksi.setModel(TransaksitableModel);
        TDetail.setModel(DetailTableModel);

      
        settableload();
        hitungTotalMaster();
    }
    
    private javax.swing.table.DefaultTableModel TransaksitableModel=getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel()
    {
        
        return new javax.swing.table.DefaultTableModel
        (
                new Object[] []  {},
                new String   []  {"ID TRANSAKSI",
                                          "TANGGAL",
                                          "TOTAL"}
         )
        
                
        {
              boolean[]   canEdit = new boolean[]
              {
                  false, false, false
              };
              
              public  boolean isCellEditable(int   rowIndex, int columnIndex)
              {
                  return canEdit[columnIndex];
              }
        };
    }
    
    private javax.swing.table.DefaultTableModel DetailTableModel=getDefaultTabelModel_det();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel_det()
    {
        
        return new javax.swing.table.DefaultTableModel
        (
                new Object[] []  {},
                new String   []  {"KODE BARANG",
                                          "HARGA JUAL SATUAN",
                                          "QTY",
                                          "SUBTOTAL"}
         )
        
                
        {
              boolean[]   canEdit = new boolean[]
              {
                  false, false, false, false
              };
              
              public  boolean isCellEditable(int   rowIndex, int columnIndex)
              {
                  return canEdit[columnIndex];
              }
        };
    }
    String data[]=new String[3];
    private void settableload()
    {
        String stat = "";
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                                               database,
                                               user,
                                               pass);
            Statement stt=kon.createStatement();
            String SQL = "select * from sales_transactions";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                
              TransaksitableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                                        ex.getMessage(),"Error, Tidak Dapat Menampilkan Laporan",
                                        JOptionPane.INFORMATION_MESSAGE
                                                                    );
            System.exit(0);
        }
    }
    String datadet[]=new String[4];
    private void settabledetload()
    {
        String stat = "";
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(
                                               database,
                                               user,
                                               pass);
            Statement stt=kon.createStatement();
            String SQL = "SELECT kodebrg, sale_price, quantity, total FROM sales_details";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                datadet[0] = res.getString(1);
                datadet[1] = res.getString(2);
                datadet[2] = res.getString(3);
                datadet[3] = res.getString(4);
                
              DetailTableModel.addRow(datadet);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                                        ex.getMessage(),"Error, Tidak Dapat Menampilkan Tabel Detail",
                                        JOptionPane.INFORMATION_MESSAGE
                                                                    );
            System.exit(0);
        }
    }
    
    private void filterTransaksiByDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fromDate = sdf.format(dateFrom.getDate());
    String untilDate = sdf.format(dateUntil.getDate());

    TransaksitableModel.setRowCount(0);

    try 
    {
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(
                                               database,
                                               user,
                                               pass);
        Statement stt=kon.createStatement();
        String SQL = "select * from sales_transactions WHERE date BETWEEN ? AND ?";
        PreparedStatement pst = kon.prepareStatement(SQL);
        pst.setString(1, fromDate);
        pst.setString(2, untilDate);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            TransaksitableModel.addRow(new Object[] {
                rs.getString("sales_id"),
                rs.getString("date"),
                rs.getString("total_amount")
            });
        }
        
        hitungTotalMaster();

        rs.close();
        pst.close();
        kon.close();
    } catch (Exception ex) {
        System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                                        ex.getMessage(),"Error, Tidak Dapat Menampilkan Laporan yang Diminta",
                                        JOptionPane.INFORMATION_MESSAGE
                                                                    );
            System.exit(0);
        }
}
    private void loadDetailBySalesId(String salesId) {
    DetailTableModel.setRowCount(0);

    try {
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(database, user, pass);
        String sql = "SELECT kodebrg, sale_price, quantity, total FROM sales_details WHERE sales_id = ?";
        PreparedStatement pst = kon.prepareStatement(sql);
        pst.setString(1, salesId);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            DetailTableModel.addRow(new Object[] {
                rs.getString("kodebrg"),
                rs.getString("sale_price"),
                rs.getString("quantity"),
                rs.getString("total")
            });
        }

        panelDet.setVisible(true); // tampilkan detail panel

        rs.close();
        pst.close();
        kon.close();
    } catch (Exception ex) {
        System.err.println(ex.getMessage());
        JOptionPane.showMessageDialog(null,
            ex.getMessage(), "Error, Tidak Dapat Menampilkan Detail Laporan\n",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
    private void hitungTotalMaster() {
    double total = 0.0;

    for (int i = 0; i < TransaksitableModel.getRowCount(); i++) {
        String val = TransaksitableModel.getValueAt(i, 2).toString(); // kolom TOTAL
        total += Double.parseDouble(val);
    }

    jLabel4.setText("TOTAL: " + String.format("%,.2f", total));
}
private void cetakLaporanMaster() {
    try {
        java.io.FileWriter writer = new java.io.FileWriter("LaporanPenjualan.txt");
        writer.write("LAPORAN PENJUALAN\n");
        writer.write("=============================\n\n");
        writer.write(String.format("%-15s %-15s %-15s\n", "ID TRANSAKSI", "TANGGAL", "TOTAL"));

        for (int i = 0; i < TransaksitableModel.getRowCount(); i++) {
            String id = TransaksitableModel.getValueAt(i, 0).toString();
            String tanggal = TransaksitableModel.getValueAt(i, 1).toString();
            String total = TransaksitableModel.getValueAt(i, 2).toString();

            writer.write(String.format("%-15s %-15s %-15s\n", id, tanggal, total));
        }

        writer.close();

        JOptionPane.showMessageDialog(this, 
            "Laporan berhasil dicetak ke file LaporanPenjualan.txt",
            "Cetak Laporan", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Gagal mencetak laporan: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnShow = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnPrint = new javax.swing.JButton();
        dateFrom = new com.toedter.calendar.JDateChooser();
        dateUntil = new com.toedter.calendar.JDateChooser();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TTransaksi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        panelDet = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TDetail = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LAPORAN PENJUALAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Dari Tanggal");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Sampai Tanggal");

        btnShow.setText("Tampilkan Laporan");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnPrint.setText("Cetak Laporan");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(65, 65, 65)
                .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(67, 67, 67)
                .addComponent(dateUntil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(dateUntil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow)
                    .addComponent(btnPrint))
                .addContainerGap())
        );

        mainPanel.setLayout(new java.awt.BorderLayout());

        TTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TTransaksi);

        mainPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("TOTAL");
        mainPanel.add(jLabel4, java.awt.BorderLayout.PAGE_END);

        panelDet.setPreferredSize(new java.awt.Dimension(250, 457));

        TDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TDetail);

        javax.swing.GroupLayout panelDetLayout = new javax.swing.GroupLayout(panelDet);
        panelDet.setLayout(panelDetLayout);
        panelDetLayout.setHorizontalGroup(
            panelDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDetLayout.setVerticalGroup(
            panelDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        mainPanel.add(panelDet, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        filterTransaksiByDate();
        panelDet.setVisible(false);
    }//GEN-LAST:event_btnShowActionPerformed

    private void TTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTransaksiMouseClicked
        // TODO add your handling code here:
        int row = TTransaksi.getSelectedRow();
        if (row != -1) {
            String salesId = TransaksitableModel.getValueAt(row, 0).toString();
            loadDetailBySalesId(salesId);
            hitungTotalMaster();
        }
    }//GEN-LAST:event_TTransaksiMouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
 cetakLaporanMaster();
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(LapPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LapPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LapPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LapPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LapPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TDetail;
    private javax.swing.JTable TTransaksi;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnShow;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateUntil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelDet;
    // End of variables declaration//GEN-END:variables
}
