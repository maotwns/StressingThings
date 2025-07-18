package tubesif7_apkkoperasi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hana
 */
public class MainMenu extends javax.swing.JFrame {

    /** Creates new form MainMenu */
    public MainMenu() {
        initComponents();

   

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LBLJudul = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblPetugas = new javax.swing.JLabel();
        btnAnggota = new javax.swing.JButton();
        btnBarang = new javax.swing.JButton();
        btnPembelian = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btnPenjualan = new javax.swing.JButton();
        Laporan = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Main Menu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        LBLJudul.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        LBLJudul.setText("SISTEM INFORMASI KOPERASI \"\" SMA PASUNDAN 1 BANDUNG");
        jPanel1.add(LBLJudul);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 246, 216));
        jPanel2.setLayout(new java.awt.GridLayout(8, 1));

        lblPetugas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPetugas.setText("\"\"");
        jPanel3.add(lblPetugas);

        jPanel2.add(jPanel3);

        btnAnggota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAnggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubesif7_apkkoperasi/1.png"))); // NOI18N
        btnAnggota.setText("Data Anggota");
        btnAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnggotaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAnggota);

        btnBarang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubesif7_apkkoperasi/2.png"))); // NOI18N
        btnBarang.setText("Data Barang");
        btnBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangActionPerformed(evt);
            }
        });
        jPanel2.add(btnBarang);

        btnPembelian.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubesif7_apkkoperasi/3.png"))); // NOI18N
        btnPembelian.setText("Transaksi Pembelian");
        btnPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPembelianActionPerformed(evt);
            }
        });
        jPanel2.add(btnPembelian);

        btn_supplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_supplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubesif7_apkkoperasi/logifix (2) (1).png"))); // NOI18N
        btn_supplier.setText("Data Supplier");
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        jPanel2.add(btn_supplier);

        btnPenjualan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubesif7_apkkoperasi/4.png"))); // NOI18N
        btnPenjualan.setText("Transaksi Penjualan");
        btnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanActionPerformed(evt);
            }
        });
        jPanel2.add(btnPenjualan);

        Laporan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubesif7_apkkoperasi/5.png"))); // NOI18N
        Laporan.setText("Laporan");
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });
        jPanel2.add(Laporan);

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubesif7_apkkoperasi/6.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogout);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnggotaActionPerformed
        // TODO add your handling code here:
        DataAnggota anggota = new DataAnggota();
        anggota.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAnggotaActionPerformed

    private void btnBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangActionPerformed
        // TODO add your handling code here:
        DataBarang barang = new DataBarang();
        barang.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBarangActionPerformed

    private void btnPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPembelianActionPerformed
        // TODO add your handling code here:
        TPembelian beli = new TPembelian();
        beli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPembelianActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Login loginmenu = new Login();
        loginmenu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        // TODO add your handling code here:
        Supplier sppl = new Supplier();
        sppl.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanActionPerformed
        // TODO add your handling code here:
        TPenjualan jual = new TPenjualan();
        jual.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPenjualanActionPerformed

    private void LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LaporanActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLJudul;
    private javax.swing.JButton Laporan;
    private javax.swing.JButton btnAnggota;
    private javax.swing.JButton btnBarang;
    javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPembelian;
    private javax.swing.JButton btnPenjualan;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblPetugas;
    // End of variables declaration//GEN-END:variables

}
