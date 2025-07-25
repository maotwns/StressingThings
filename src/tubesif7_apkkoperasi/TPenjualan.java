/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesif7_apkkoperasi;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.JOptionPane;



public class TPenjualan extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;

    /**
     * Creates new form TPenjualan
     */
    public TPenjualan() {
        SpinnerNumberModel spinnermodel = new SpinnerNumberModel(1,1,100,1);
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        

        
        AutoCompleteDecorator.decorate(combo_barang);
        tabelitem.setModel(tableModelitem);
        tabelbelanja.setModel(tableModelbelanja);
        setcomboload();
        settableloaditem();
        txt_harga.setEditable(false);
        txt_sales_id.setEditable(false);
        btn_cash.setEnabled(false);
        date_tanggal.setDate(new Date());
        
        
        tableModelbelanja.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) { // Quantity column
            int row = e.getFirstRow();

            try {
                int qty = Integer.parseInt(tableModelbelanja.getValueAt(row, 2).toString());
                int price = Integer.parseInt(tableModelbelanja.getValueAt(row, 3).toString());
                int subtotal = qty * price;

                tableModelbelanja.setValueAt(subtotal, row, 4); // Set subtotal
                int total = 0;
                for (int i = 0; i < tableModelbelanja.getRowCount(); i++) {
                    total += (int) tableModelbelanja.getValueAt(i, 4); //
                }
                txt_totalharga.setText(String.valueOf(total));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid untuk kuantitas");
            }
        }
    }
});
        
        
    }
    //Tabel Daftar Item
       private javax.swing.table.DefaultTableModel tableModelitem= new DefaultTableModel(
                new Object[][] {},
                new String [] {"ID Item",
                               "Nama",
                               "Stok",
                               "Harga"}
            ){
                boolean[] canEdit = {false,false,false,false};
                @Override public boolean isCellEditable(int r,int c){ return canEdit[c]; }
        };
    //Tabel List Belanjaan
    private javax.swing.table.DefaultTableModel tableModelbelanja = new DefaultTableModel(
    new Object[][] {},
                new String [] {"ID Item",
                               "Nama",
                               "Kuantitas",
                               "Harga",
                               "Subtotal"}
            ){
                boolean[] canEdit = {false,false,true,false,false};
                @Override public boolean isCellEditable(int r,int c){ return canEdit[c]; }
        };
    
    
    String data[]=new String[5];
    private void settableloaditem(){

    
        tableModelitem.setRowCount(0);
        try{
        
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt=kon.createStatement();
            String SQL = "select * from databarang";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
            
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(4);
                data[3] = res.getString(6);
                tableModelitem.addRow(data);
                
            }
            res.close();
            stt.close();
            kon.close();
            
            
        }
        catch(Exception ex){
        
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
    }
    
        private void setcomboload(){
    
        String stat = "";
        try{
        
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt=kon.createStatement();
            String SQL = "SELECT CONCAT(kodebrg, ' - ', namabrg) AS barang, hbeli, (SELECT IFNULL(MAX(sales_id), 0) + 1 FROM sales_transactions) AS sales_id FROM databarang;";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                String namabarang = res.getString("barang");
                String hargabarang = res.getString("hbeli");
                String salesID = res.getString("sales_id");
                combo_barang.addItem(namabarang);
                txt_harga.setText(hargabarang);
                txt_sales_id.setText(salesID);
                
            
                
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex){
        
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
        private SpinnerNumberModel spinnerModel;
        int row = 0;
        public void tampil_field(){
    
        row = tabelbelanja.getSelectedRow();
        
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
        jLabel3 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        combo_barang = new javax.swing.JComboBox();
        spinnerModel = new SpinnerNumberModel(1, 1, 10, 1);
        kuantitas = new javax.swing.JSpinner();
        kuantitas.setModel(spinnerModel);
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        date_tanggal = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txt_sales_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbelanja = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_totalharga = new javax.swing.JTextField();
        btn_cash = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelitem = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaksi Penjualan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian Item"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MASUKKAN BARANG");

        btn_tambah.setText("+");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        combo_barang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cari Barang" }));
        combo_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_barangActionPerformed(evt);
            }
        });

        kuantitas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kuantitas.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QTY");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("HARGA BARANG");

        txt_harga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_harga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_harga.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(combo_barang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kuantitas, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(btn_tambah)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Keranjang Belanja"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TANGGAL PENJUALAN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("(MMDDYYY)");

        txt_sales_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sales_idActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ID PENJUALAN");

        tabelbelanja.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelbelanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbelanjaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbelanja);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("TOTAL BAYAR");

        txt_totalharga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_totalharga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_totalharga, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_totalharga, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap())
        );

        btn_cash.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cash.setText("BAYAR");
        btn_cash.setPreferredSize(new java.awt.Dimension(140, 23));
        btn_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cashActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(date_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_sales_id, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_cash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date_tanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_sales_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Item"));

        tabelitem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelitem);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_sales_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sales_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sales_idActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        MainMenu utama = new MainMenu();
        utama.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void combo_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_barangActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) combo_barang.getSelectedItem();
        String[] parts = selectedItem.split(" - ");
        String kode = parts[0];   // B001
        String nama = parts[1];   // Teh Botol
        for (int i = 0; i < tabelitem.getRowCount(); i++) {
            String code = tabelitem.getValueAt(i, 0).toString(); // Column 0 = Code
        if (code.equals(kode)) {
            Object valueInColumn4 = tabelitem.getValueAt(i, 3); // Column 4 (index 3)
            String valueInColumn3 = (String) tabelitem.getValueAt(i, 2);
            txt_harga.setText((String)valueInColumn4);
            spinnerModel.setValue(1);
            spinnerModel.setMaximum(Integer.parseInt(valueInColumn3));
            break; // stop after finding the first match
            }
        }
        
    }//GEN-LAST:event_combo_barangActionPerformed

    private void btn_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cashActionPerformed
        // TODO add your handling code here:
        Date selectedDate = date_tanggal.getDate();
        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
        try{
            
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                StringBuilder SQL1 = new StringBuilder();
                stt.executeUpdate("INSERT INTO sales_transactions(sales_id,date,total_amount) "
                              + "VALUES "
                              + "("+txt_sales_id.getText()+","
                              + " '"+sqlDate+"' ,"
                              + " "+txt_totalharga.getText()+");");
                System.out.println(SQL1);
                int ID = Integer.parseInt(txt_sales_id.getText())+1;
                for (int i = 0; i < tableModelbelanja.getRowCount(); i++) {
                    stt.executeUpdate("INSERT INTO sales_details(sales_id,kodebrg,sale_price,quantity,total) "
                              + "VALUES "
                              + "("+txt_sales_id.getText()+","
                              + "'"+tableModelbelanja.getValueAt(i, 0)+"' ,"
                              + ""+tableModelbelanja.getValueAt(i, 3)+" ,"
                              + ""+tableModelbelanja.getValueAt(i, 2)+" ,"
                              + " "+tableModelbelanja.getValueAt(i, 4)+");");
                    String kode = (String) tableModelbelanja.getValueAt(i, 0);
                    
                    
                    
                    int stokawal = 0;
                    int stok1 = Integer.parseInt(tableModelbelanja.getValueAt(i, 2).toString());
                    for (int j = 0; j < tabelitem.getRowCount(); j++) {
                        String code = tabelitem.getValueAt(j, 0).toString(); // Column 0 = Code
                    if (code.equals(kode)) {
                        String valueInColumn4 = (String) tabelitem.getValueAt(j, 2); // Column 4 (index 3)
                        stokawal = Integer.parseInt(valueInColumn4.toString());
                        int stokakhir = stokawal-stok1;
                        stt.executeUpdate("UPDATE databarang SET stok=" + ""+stokakhir+" WHERE kodebrg=" + "'"+kode+"';");
                    }
                    }
                    
                    
                }
                txt_sales_id.setText(Integer.toString(ID));
                tableModelbelanja.setRowCount(0);
                settableloaditem();
                JOptionPane.showMessageDialog(null, "Berhasil Checkout!", "Data telah berhasil dicekout", JOptionPane.INFORMATION_MESSAGE);
                stt.close();
                kon.close();
                
            }
            catch (Exception ex){
            
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            // 1. Prompt user for payment amount
            String bayarStr = JOptionPane.showInputDialog(null, "Masukkan jumlah uang pelanggan:", "Input Uang", JOptionPane.QUESTION_MESSAGE);

            if (bayarStr == null) {
                // User pressed cancel
                return;
            }

            try {
                int bayar = Integer.parseInt(bayarStr);
                int total = Integer.parseInt(txt_totalharga.getText());

                if (bayar < total) {
                    JOptionPane.showMessageDialog(null, "Uang tidak cukup!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int kembalian = bayar - total;

                // 2. Show change
                JOptionPane.showMessageDialog(null,
                    "Total Belanja: Rp" + total + "\n" +
                    "Uang Dibayar: Rp" + bayar + "\n" +
                    "Kembalian: Rp" + kembalian,
                    "Transaksi Berhasil", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            txt_totalharga.setText("0");
            btn_cash.setEnabled(false);
            
    }//GEN-LAST:event_btn_cashActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) combo_barang.getSelectedItem();
        String[] parts = selectedItem.split(" - ");
        String kode = parts[0];   // B001
        String nama = parts[1];   // Teh Botol
        Object value = kuantitas.getValue();
        int kuantitas1 = Integer.parseInt(value.toString());
        int harga = Integer.parseInt(txt_harga.getText());
        int subtotal = kuantitas1*harga;
        boolean found = false;

        for (int i = 0; i < tableModelbelanja.getRowCount(); i++) {
            String existingKode = tableModelbelanja.getValueAt(i, 0).toString();
            String existingNama = tableModelbelanja.getValueAt(i, 1).toString();

            if (existingKode.equals(kode) && existingNama.equals(nama)) {
                // If match found, update quantity and subtotal
                int currentQty = Integer.parseInt(tableModelbelanja.getValueAt(i, 2).toString());
                int newQty = currentQty + kuantitas1; // Add new quantity
                int newSubtotal = newQty * harga;

                tableModelbelanja.setValueAt(newQty, i, 2);       // Update quantity
                tableModelbelanja.setValueAt(newSubtotal, i, 4);  // Update subtotal
                found = true;
                break;
            }
        }

        // If not found, add new row
        if (!found) {

            Object[] rowData = {kode, nama, kuantitas1, txt_harga.getText(), subtotal};
            tableModelbelanja.addRow(rowData);
        }
        
        int total = 0;
        for (int i = 0; i < tableModelbelanja.getRowCount(); i++) {
            total += (int) tableModelbelanja.getValueAt(i, 4); //
        }
        txt_totalharga.setText(String.valueOf(total));
        btn_cash.setEnabled(true);
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void tabelbelanjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbelanjaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
        
            tampil_field();
        }
    }//GEN-LAST:event_tabelbelanjaMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int harga = (int) tableModelbelanja.getValueAt(row, 4);
        int harga_total = Integer.parseInt(txt_totalharga.getText()) - harga;
        txt_totalharga.setText(Integer.toString(harga_total));
        tableModelbelanja.removeRow(row);
    }//GEN-LAST:event_btn_hapusActionPerformed

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
            java.util.logging.Logger.getLogger(TPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cash;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox combo_barang;
    private com.toedter.calendar.JDateChooser date_tanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner kuantitas;
    private javax.swing.JTable tabelbelanja;
    private javax.swing.JTable tabelitem;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_sales_id;
    private javax.swing.JTextField txt_totalharga;
    // End of variables declaration//GEN-END:variables
}
