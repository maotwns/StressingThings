
package tubesif7_apkkoperasi;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class DataAnggota extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    
    public DataAnggota() {
        initComponents();
        
        ButtonGroup grupCari = new ButtonGroup();
        grupCari.add(radNoA);
        grupCari.add(radNama);
        grupCari.add(radJab);
        
        slctSrcj.setVisible(false);

        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        
        TAnggota.setModel(tableModel);
      
        settableload();
    }
    
    
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel()
    {
        
        return new javax.swing.table.DefaultTableModel
        (
                new Object[] []  {},
                new String   []  {"NO ANGGOTA",
                                          "NAMA ANGGOTA",
                                          "JABATAN",
                                          "NO TELP",
                                          "ALAMAT"}
         )
        
                
        {
              boolean[]   canEdit = new boolean[]
              {
                  false, false, false, false, false
              };
              
              public  boolean isCellEditable(int   rowIndex, int columnIndex)
              {
                  return canEdit[columnIndex];
              }
        };
    }
    
    String data[]=new String[5];
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
            String SQL = "select * from t_anggota";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
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
        txtNoA.setText("");
        txtNama.setText("");
        slctJab.setSelectedItem("");
        txtTelp.setText("");
        AreAlmt.setText("");
    }
    public void nonaktif_teks()
    {
        txtNoA.setEnabled(false);
        txtNama.setEnabled(false);
        slctJab.setEnabled(false);
        txtTelp.setEnabled(false);
        AreAlmt.setEnabled(false);
    }
    public void aktif_teks()
    {
        txtNoA.setEnabled(true);
        txtNama.setEnabled(true);
        slctJab.setEnabled(true);
        txtTelp.setEnabled(true);
        AreAlmt.setEnabled(true);
    }
    int row = 0;
    public void tampil_field()
    {
        row = TAnggota.getSelectedRow();
        txtNoA.setText(tableModel.getValueAt(row,0).toString());
        txtNama.setText(tableModel.getValueAt(row,1).toString());
        String jab = tableModel.getValueAt(row, 2).toString();
    slctJab.setSelectedItem(jab);
        txtTelp.setText(tableModel.getValueAt(row,3).toString());
        AreAlmt.setText(tableModel.getValueAt(row,4).toString());
        btnSave.setEnabled(false);
        btnCh.setEnabled(true);
        btnDel.setEnabled(true);
        btnBatal.setEnabled(false);
        aktif_teks();
    }
    public void tampilkanData(String query) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("NO ANGGOTA");
    model.addColumn("NAMA");
    model.addColumn("JABATAN");
    model.addColumn("NO TELP");
    model.addColumn("ALAMAT");

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
                rs.getString("no_anggota"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("telepon"),
                rs.getString("alamat")
            });
        }

        TAnggota.setModel(model);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        InpData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        btnShow = new javax.swing.JButton();
        radNama = new javax.swing.JRadioButton();
        radNoA = new javax.swing.JRadioButton();
        radJab = new javax.swing.JRadioButton();
        btnSrc = new javax.swing.JButton();
        slctSrcj = new javax.swing.JComboBox();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNoA = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreAlmt = new javax.swing.JTextArea();
        slctJab = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAnggota = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnCh = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("DATA ANGGOTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(301, 301, 301)
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nama");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian Anggota"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Pilih Indikator Pencarian");

        InpData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        InpData.setText("Masukkan Data");

        btnShow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnShow.setText("Tampilkan Semua Data");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        radNama.setText("Nama");
        radNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamaActionPerformed(evt);
            }
        });
        radNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                radNamaKeyTyped(evt);
            }
        });

        radNoA.setText("No Anggota");
        radNoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNoAActionPerformed(evt);
            }
        });

        radJab.setText("Jabatan");
        radJab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radJabActionPerformed(evt);
            }
        });

        btnSrc.setText("Cari");
        btnSrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSrcActionPerformed(evt);
            }
        });

        slctSrcj.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ketua", "Sekretaris", "Bendahara", "Seksi Usaha", "Pembantu Umum", "Anggota" }));
        slctSrcj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slctSrcjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(InpData))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radNoA)
                                .addGap(18, 18, 18)
                                .addComponent(radNama)
                                .addGap(18, 18, 18)
                                .addComponent(radJab))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slctSrcj, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSrc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(radNoA)
                    .addComponent(radNama)
                    .addComponent(radJab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InpData)
                    .addComponent(btnSrc)
                    .addComponent(slctSrcj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("No Anggota");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Jabatan");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("No. Telp");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Alamat");

        AreAlmt.setColumns(20);
        AreAlmt.setRows(5);
        jScrollPane1.setViewportView(AreAlmt);

        slctJab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ketua", "Sekretaris", "Bendahara", "Seksi Usaha", "Pembantu Umum", "Anggota" }));
        slctJab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slctJabActionPerformed(evt);
            }
        });

        TAnggota.setModel(new javax.swing.table.DefaultTableModel(
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
        TAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TAnggotaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TAnggota);

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

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnOut.setText("Keluar");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama)
                            .addComponent(txtNoA)
                            .addComponent(slctJab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(slctJab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCh)
                    .addComponent(btnDel)
                    .addComponent(btnSave)
                    .addComponent(btnBatal)
                    .addComponent(btnOut))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void slctJabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slctJabActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_slctJabActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        MainMenu utama = new MainMenu();
        utama.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        btnSave.setEnabled(true);
        btnCh.setEnabled(true);
        btnDel.setEnabled(true);
        btnAdd.setEnabled(true);
        btnOut.setEnabled(true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        txtNoA.requestFocus();
        btnSave.setEnabled(true);
        btnCh.setEnabled(false);
        btnDel.setEnabled(false);
        btnOut.setEnabled(false);
        aktif_teks();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnChActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChActionPerformed
        // TODO add your handling code here:
        String noa=txtNoA.getText();
        String nama=txtNama.getText();
        String slctjab= (String) slctJab.getSelectedItem();
        String telp=txtTelp.getText();
        String alamat=AreAlmt.getText();
        
        if ((noa.isEmpty()) | (alamat.isEmpty()))
        {
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txtNoA.requestFocus();
        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `t_anggota` "
                                    + "SET `no_anggota`='"+noa+"',"
                                    + "`nama`='"+nama+"',"
                                    + "`jabatan`='"+slctjab+"',"
                                    + "`telepon`='"+telp+"',"
                                    + "`alamat`='"+alamat+"'"
                        +"WHERE"
                        +"`no_anggota`='"+tableModel.getValueAt(row,0).toString()+"';";
                stt.executeUpdate(SQL);
                data[0] = noa;
                data[1] = nama;
                data[2] = slctjab;
                data[3] = telp;
                data[4] = alamat;
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
        int row = TAnggota.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String no_anggota = tableModel.getValueAt(row, 0).toString();

    int konfirmasi = JOptionPane.showConfirmDialog(this,
        "Yakin ingin menghapus data dengan no anggota: " + no_anggota + "?",
        "Konfirmasi Hapus",
        JOptionPane.YES_NO_OPTION
    );

    if (konfirmasi == JOptionPane.YES_OPTION) {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();

            String SQL = "DELETE FROM t_anggota WHERE no_anggota = '" + no_anggota + "'";
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
        String noA = txtNoA.getText().trim();
        String nama = txtNama.getText().trim();
        String jabatan = slctJab.getSelectedItem().toString();
        String telepon = txtTelp.getText().trim();
        String alamat = AreAlmt.getText().trim();

        // Validasi input
        if (noA.equals("") || nama.equals("") || alamat.equals("") || telepon.equals("")) {
            JOptionPane.showMessageDialog(null, "Lengkapi semua data!");
            return;
        }

        // Cek apakah jabatan khusus sudah ada
        if (jabatan.equals("Ketua") || jabatan.equals("Bendahara") || jabatan.equals("Sekretaris")) {
            try {
                Connection conn = DriverManager.getConnection(database, user, pass);
                String sql = "SELECT COUNT(*) FROM t_anggota WHERE jabatan = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, jabatan);
                ResultSet rs = pst.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "Jabatan " + jabatan + " sudah terisi!");
                    rs.close();
                    pst.close();
                    conn.close();
                    return;
                }

                rs.close();
                pst.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error saat cek jabatan: " + e.getMessage());
                return;
            }
        }

        // Simpan ke database
        try {
            Connection conn = DriverManager.getConnection(database, user, pass);
            String sql = "INSERT INTO t_anggota (no_anggota, nama, jabatan, alamat, telepon) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, noA);
            pst.setString(2, nama);
            pst.setString(3, jabatan);
            pst.setString(4, telepon);
             pst.setString(5, alamat);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            pst.close();
            conn.close();

            // Kosongkan form
            txtNoA.setText("");
            txtNama.setText("");
            slctJab.setSelectedIndex(0);
            txtTelp.setText("");
            AreAlmt.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat menyimpan: " + e.getMessage());
        }
    
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        // TODO add your handling code here:
        int pilihan = JOptionPane.showConfirmDialog(this,
            "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar",
            JOptionPane.YES_NO_OPTION);

    if (pilihan == JOptionPane.YES_OPTION) {
        dispose(); // Tutup form jika user pilih YES
    }
    }//GEN-LAST:event_btnOutActionPerformed

    private void radJabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radJabActionPerformed
        // TODO add your handling code here:
        txtData.setVisible(false);
        slctSrcj.setVisible(true);
        InpData.setText("Masukkan Jabatan");
        txtData.setText(""); // clear input 
    }//GEN-LAST:event_radJabActionPerformed

    private void radNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamaActionPerformed
        // TODO add your handling code here:
        txtData.setVisible(true);
        slctSrcj.setVisible(false);
        InpData.setText("Masukkan Nama");
        txtData.setText(""); // clear input 
        
    }//GEN-LAST:event_radNamaActionPerformed

    private void radNoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNoAActionPerformed
        // TODO add your handling code here:
        txtData.setVisible(true);
        slctSrcj.setVisible(false);
        InpData.setText("Masukkan No Anggota");
        txtData.setText(""); // clear input 
    }//GEN-LAST:event_radNoAActionPerformed

    private void btnSrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSrcActionPerformed
        // TODO add your handling code here:
        String keyword = "";

        if (radJab.isSelected()) {
            keyword = slctSrcj.getSelectedItem().toString();
        } else {
            keyword = txtData.getText().trim();
        }

        if (keyword.equals("")) {
            JOptionPane.showMessageDialog(null, "Silakan isi data pencarian!");
            return;
        }

        String kolom = "";
        if (radNoA.isSelected()) {
            kolom = "no_anggota";
        } else if (radNama.isSelected()) {
            kolom = "nama";
        } else if (radJab.isSelected()) {
            kolom = "jabatan";
        }

        try {
            Connection conn = DriverManager.getConnection(database,
                                                    user,
                                                    pass);
            String sql = "SELECT * FROM t_anggota WHERE " + kolom + " LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();

            // Kosongkan tabel terlebih dahulu
            DefaultTableModel model = (DefaultTableModel) TAnggota.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] data = {
                    rs.getString("no_anggota"),
                    rs.getString("nama"),
                    rs.getString("jabatan"),
                    rs.getString("alamat"),
                    rs.getString("telepon")
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

    private void TAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAnggotaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            tampil_field();
        }
    }//GEN-LAST:event_TAnggotaMouseClicked

    private void radNamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radNamaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if (radNama.isSelected()) {
            // Hanya izinkan huruf, spasi, dan backspace
            if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != '\b') {
                evt.consume(); // Batalkan input karakter
            }
        }
    }//GEN-LAST:event_radNamaKeyTyped

    private void slctSrcjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slctSrcjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slctSrcjActionPerformed

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
            java.util.logging.Logger.getLogger(DataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreAlmt;
    private javax.swing.JLabel InpData;
    private javax.swing.JTable TAnggota;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCh;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnSrc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radJab;
    private javax.swing.JRadioButton radNama;
    private javax.swing.JRadioButton radNoA;
    private javax.swing.JComboBox slctJab;
    private javax.swing.JComboBox slctSrcj;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoA;
    private javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}
