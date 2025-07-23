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
 * @author hana
 */
public class DataBarang extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;

    /**
     * Creates new form DataBarang
     */
    public DataBarang() {
        initComponents();
        ButtonGroup grupCari = new ButtonGroup();
        grupCari.add(radKode);
        grupCari.add(radNama);
        grupCari.add(radKategori);
        
        ByCat.setVisible(false);
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        
        TBarang.setModel(tableModel);
      
        settableload();
    }
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel()
    {
        return new javax.swing.table.DefaultTableModel
        (
                new Object[] []  {},
                new String   []  {"KODE BARANG",
                                          "NAMA BARANG",
                                          "KATEGORI",
                                          "STOK",
                                          "HARGA BELI",
                                          "HARGA JUAL"}
         )
        
                
        {
              boolean[]   canEdit = new boolean[]
              {
                  false, false, false, false, false, false
              };
              
              public  boolean isCellEditable(int   rowIndex, int columnIndex)
              {
                  return canEdit[columnIndex];
              }
        };
    }
    String data[]=new String[6];
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
            String SQL = "select * from databarang";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
              tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                                        ex.getMessage(),"Error",
                                        JOptionPane.INFORMATION_MESSAGE
                                                                    );
            System.exit(0);
        }
    }
    public void membersihkan_teks()
    {
        txtKoBa.setText("");
        txtNamaBa.setText("");
        slct_Kat.setSelectedItem("");
        txtStok.setText("");
        txtBuy.setText("");
        txtSale.setText("");
    }
    public void nonaktif_teks()
    {
        txtKoBa.setEnabled(false);
        txtNamaBa.setEnabled(false);
        slct_Kat.setEnabled(false);
        txtStok.setEnabled(false);
        txtBuy.setEnabled(false);
        txtSale.setEnabled(false);
    }
    public void aktif_teks()
    {
        txtKoBa.setEnabled(true);
        txtNamaBa.setEnabled(true);
        slct_Kat.setEnabled(true);
        txtStok.setEnabled(true);
        txtBuy.setEnabled(true);
        txtSale.setEnabled(true);
    }
    
    int row = 0;
    public void tampil_field()
    {
        row = TBarang.getSelectedRow();
        txtKoBa.setText(tableModel.getValueAt(row,0).toString());
        txtNamaBa.setText(tableModel.getValueAt(row,1).toString());
        String kat = tableModel.getValueAt(row, 2).toString();
    slct_Kat.setSelectedItem(kat);
        txtStok.setText(tableModel.getValueAt(row,3).toString());
        txtBuy.setText(tableModel.getValueAt(row,4).toString());
        txtSale.setText(tableModel.getValueAt(row,5).toString());
        btnSave.setEnabled(false);
        btnCh.setEnabled(true);
        btnDel.setEnabled(true);
        btnBatal.setEnabled(false);
        aktif_teks();
    }
   public void tampilkanData(String query) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("KODE BARANG");
    model.addColumn("NAMA BARANG");
    model.addColumn("KATEGORI");
    model.addColumn("STOK");
    model.addColumn("HARGA BELI");
    model.addColumn("HARGA JUAL");

    try {
        int no = 1;
        Connection conn = DriverManager.getConnection(
                                               database,
                                               user,
                                               pass);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("kodebrg"),
                rs.getString("namabrg"),
                rs.getString("kategori"),
                rs.getString("stok"),
                rs.getString("hBeli"),
                rs.getString("hJual")
            });
        }

        TBarang.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menampilkan data!\n" + e.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblKateg = new javax.swing.JLabel();
        ByCat = new javax.swing.JComboBox<String>();
        btnShow = new javax.swing.JButton();
        radKode = new javax.swing.JRadioButton();
        radNama = new javax.swing.JRadioButton();
        radKategori = new javax.swing.JRadioButton();
        SrcData = new javax.swing.JTextField();
        btnSrc = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtKoBa = new javax.swing.JTextField();
        txtNamaBa = new javax.swing.JTextField();
        slct_Kat = new javax.swing.JComboBox<String>();
        txtStok = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBarang = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnCh = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnOut = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBuy = new javax.swing.JTextField();
        txtSale = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("DATA BARANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian Barang"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Pilih Kategori Pencarian");

        lblKateg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblKateg.setText("Masukkan Data");

        ByCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnShow.setText("Tampilkan Semua Barang");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        radKode.setText("Kode Barang");
        radKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radKodeActionPerformed(evt);
            }
        });

        radNama.setText("Nama Barang");
        radNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamaActionPerformed(evt);
            }
        });

        radKategori.setText("Kategori Barang");
        radKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radKategoriActionPerformed(evt);
            }
        });

        btnSrc.setText("Cari");
        btnSrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSrcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblKateg))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ByCat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radKode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radNama, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radKategori))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(SrcData, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSrc)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(radKode)
                    .addComponent(radNama)
                    .addComponent(radKategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKateg)
                    .addComponent(ByCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SrcData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSrc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnShow)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Kategori");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Kode Barang");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Stok");

        txtKoBa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKoBaActionPerformed(evt);
            }
        });

        slct_Kat.setEditable(true);
        slct_Kat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokActionPerformed(evt);
            }
        });

        TBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TBarang);

        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCh.setText("Ubah");
        btnCh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChActionPerformed(evt);
            }
        });

        btnDel.setText("Hapus");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnOut.setText("Keluar");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Harga Jual");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Harga Beli");

        txtBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuyActionPerformed(evt);
            }
        });

        txtSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(51, 51, 51))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(25, 25, 25)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(23, 23, 23)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNamaBa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(slct_Kat, javax.swing.GroupLayout.Alignment.LEADING, 0, 187, Short.MAX_VALUE)
                            .addComponent(txtKoBa, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStok)
                            .addComponent(txtSale)
                            .addComponent(txtBuy))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKoBa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaBa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(slct_Kat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtBuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCh)
                    .addComponent(btnDel)
                    .addComponent(btnSave)
                    .addComponent(btnBatal)
                    .addComponent(btnOut))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKoBaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKoBaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKoBaActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        // TODO add your handling code here:
        int pilihan = JOptionPane.showConfirmDialog(this,
            "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar",
            JOptionPane.YES_NO_OPTION);

    if (pilihan == JOptionPane.YES_OPTION) {
        dispose(); // Tutup form jika user pilih YES
    }
    }//GEN-LAST:event_btnOutActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        btnSave.setEnabled(true);
        btnCh.setEnabled(true);
        btnDel.setEnabled(true);
        btnAdd.setEnabled(true);
        btnOut.setEnabled(true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokActionPerformed

    private void txtBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuyActionPerformed

    private void txtSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaleActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        MainMenu utama = new MainMenu();
        utama.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        tableModel.setRowCount(0);      // Bersihkan isi tabel
    settableload();                 // Tampilkan semua data

    membersihkan_teks();           // Kosongkan input field


    btnSave.setEnabled(true);  
    btnCh.setEnabled(true);
    btnDel.setEnabled(true);
    btnAdd.setEnabled(true);
    btnOut.setEnabled(true);
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        txtKoBa.requestFocus();
        btnSave.setEnabled(true);
        btnCh.setEnabled(false);
        btnDel.setEnabled(false);
        btnOut.setEnabled(false);
        aktif_teks();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnChActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChActionPerformed
        // TODO add your handling code here:
        String koba=txtKoBa.getText();
        String namabrg=txtNamaBa.getText();
        String slctkat= (String) slct_Kat.getSelectedItem();
        String stok=txtStok.getText();
        String hbeli=txtBuy.getText();
        String hjual=txtSale.getText();
        
        if ((koba.isEmpty()) | (hjual.isEmpty()))
        {
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txtKoBa.requestFocus();
        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `databarang` "
                                    + "SET `kodebrg`='"+koba+"',"
                                    + "`namabrg`='"+namabrg+"',"
                                    + "`kategori`='"+slctkat+"',"
                                    + "`stok`='"+stok+"',"
                                    + "`hBeli`='"+hbeli+"',"
                                    + "`hJual`='"+hjual+"'"
                        +"WHERE"
                        +"`kodebrg`='"+tableModel.getValueAt(row,0).toString()+"';";
                stt.executeUpdate(SQL);
                data[0] = koba;
                data[1] = namabrg;
                data[2] = slctkat;
                data[3] = stok;
                data[4] = hbeli;
                data[5] = hjual;
                tableModel.removeRow(row);
                tableModel.insertRow(row,data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btnSave.setEnabled(false);
                btnBatal.setEnabled(true);
                nonaktif_teks();
            }
            catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }                                        
    }//GEN-LAST:event_btnChActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        int row = TBarang.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String kodebrg = tableModel.getValueAt(row, 0).toString();

    int konfirmasi = JOptionPane.showConfirmDialog(this,
        "Yakin ingin menghapus data dengan kode barang: " + kodebrg + "?",
        "Konfirmasi Hapus",
        JOptionPane.YES_NO_OPTION
    );

    if (konfirmasi == JOptionPane.YES_OPTION) {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();

            String SQL = "DELETE FROM databarang WHERE kodebrg = '" + kodebrg + "'";
            stt.executeUpdate(SQL);

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");

            tableModel.setRowCount(0);
            settableload();
            membersihkan_teks();
            nonaktif_teks();

            btnSave.setEnabled(false);
            btnCh.setEnabled(false);
            btnDel.setEnabled(false);
            btnAdd.setEnabled(true);
            btnOut.setEnabled(true);

            stt.close();
            kon.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String koba = txtKoBa.getText().trim();
        String namabrg = txtNamaBa.getText().trim();
        String kat = slct_Kat.getSelectedItem().toString();
        String stok = txtStok.getText().trim();
        String hbeli = txtBuy.getText().trim();
        String hjual = txtSale.getText().trim();

        // Validasi input
        if (koba.equals("") || namabrg.equals("") || kat.equals("") || stok.equals("") || hbeli.equals("") || hjual.equals("")) {
            JOptionPane.showMessageDialog(null, "Lengkapi semua data!");
            return;
        }

        // Simpan ke database
        try {
            Connection conn = DriverManager.getConnection(database, user, pass);
            String sql = "INSERT INTO databarang (kodebrg, namabrg, kategori, stok, hBeli, hJual) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, koba);
            pst.setString(2, namabrg);
            pst.setString(3, kat);
            pst.setString(4, stok);
            pst.setString(5, hbeli);
            pst.setString(6, hjual);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            pst.close();
            conn.close();

            // Kosongkan form
            txtKoBa.setText("");
            txtNamaBa.setText("");
            slct_Kat.setSelectedIndex(0);
            txtStok.setText("");
            txtBuy.setText("");
            txtSale.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat menyimpan: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void radKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radKodeActionPerformed
        // TODO add your handling code here:
        SrcData.setVisible(true);
        ByCat.setVisible(false);
        lblKateg.setText("Masukkan Kode Barang");
        SrcData.setText(""); // clear input 
    }//GEN-LAST:event_radKodeActionPerformed

    private void radNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamaActionPerformed
        // TODO add your handling code here:
        SrcData.setVisible(true);
        ByCat.setVisible(false);
        lblKateg.setText("Masukkan Nama Barang");
        SrcData.setText(""); // clear input 
    }//GEN-LAST:event_radNamaActionPerformed

    private void radKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radKategoriActionPerformed
        // TODO add your handling code here:
        SrcData.setVisible(false);
        ByCat.setVisible(true);
        lblKateg.setText("Pilih Kategori");
        SrcData.setText(""); // clear input 
    }//GEN-LAST:event_radKategoriActionPerformed

    private void btnSrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSrcActionPerformed
        // TODO add your handling code here:
        String keyword = "";

        if (radKategori.isSelected()) {
            keyword = slct_Kat.getSelectedItem().toString();
        } else {
            keyword = SrcData.getText().trim();
        }

        if (keyword.equals("")) {
            JOptionPane.showMessageDialog(null, "Silakan isi data pencarian!");
            return;
        }

        String kolom = "";
        if (radKode.isSelected()) {
            kolom = "kodebrg";
        } else if (radNama.isSelected()) {
            kolom = "namabrg";
        } else if (radKategori.isSelected()) {
            kolom = "kategori";
        }

        try {
            Connection conn = DriverManager.getConnection(database,
                                                    user,
                                                    pass);
            String sql = "SELECT * FROM databarang WHERE " + kolom + " LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();

            // Kosongkan tabel terlebih dahulu
            DefaultTableModel model = (DefaultTableModel) TBarang.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] data = {
                    rs.getString("kodebrg"),
                    rs.getString("namabrg"),
                    rs.getString("kategori"),
                    rs.getString("stok"),
                    rs.getString("hBeli"),
                    rs.getString("hJual")
                };
                model.addRow(data);
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat pencarian: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSrcActionPerformed

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
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ByCat;
    private javax.swing.JTextField SrcData;
    private javax.swing.JTable TBarang;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCh;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnSrc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKateg;
    private javax.swing.JRadioButton radKategori;
    private javax.swing.JRadioButton radKode;
    private javax.swing.JRadioButton radNama;
    private javax.swing.JComboBox<String> slct_Kat;
    private javax.swing.JTextField txtBuy;
    private javax.swing.JTextField txtKoBa;
    private javax.swing.JTextField txtNamaBa;
    private javax.swing.JTextField txtSale;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
