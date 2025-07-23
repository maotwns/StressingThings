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
/**
 *
 * @author Cheesky
 */
public class TPembelian extends javax.swing.JFrame {

    /**
     * Creates new form TPenjualan
     */
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
  
   

    public TPembelian() {
        
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabelpembelian.setModel(tableModelitem);
        AutoCompleteDecorator.decorate(combo_barang);
        date_tanggal.setDate(new Date());
        hiddentable.setModel(tableModelbarang);
        hiddentable.setVisible(true);

        setcomboload();
        setcomboload2();
        settableload();
        
        
    }
    private javax.swing.table.DefaultTableModel tableModelitem= new DefaultTableModel(
                new Object[][] {},
                new String [] {"ID Item",
                               "Nama",
                               "Supplier",
                               "Stok",
                               "Harga"}
            ){
                boolean[] canEdit = {false,false,false,false,false};
                @Override public boolean isCellEditable(int r,int c){ return canEdit[c]; }
        };
    
    private javax.swing.table.DefaultTableModel tableModelbarang= new DefaultTableModel(
                new Object[][] {},
                new String [] {"ID Item",
                               "Nama",
                               "Harga",
                               "Stok"}
            ){
                boolean[] canEdit = {false,false,false};
                @Override public boolean isCellEditable(int r,int c){ return canEdit[c]; }
        };
    private void setcomboload(){
    
        String stat = "";
        try{
        
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt=kon.createStatement();
            String SQL = "SELECT CONCAT(kodebrg, ' - ', namabrg) AS barangcombo FROM databarang;";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                String namabarang = res.getString("barangcombo"); 
                combo_barang.addItem(namabarang);
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
    private void setcomboload2(){
    
        String stat = "";
        try{
        
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt=kon.createStatement();
            String SQL = "SELECT CONCAT(supplier_id, ' - ', name) AS name FROM suppliers;";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                String namabarang = res.getString("name"); 
                combo_supplier.addItem(namabarang);
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
    String data[]=new String[4];
    private void settableload(){
    
        String stat = "";
        try{
        
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt=kon.createStatement();
            String SQL = "SELECT kodebrg, namabrg, hJual, stok FROM databarang;";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                tableModelbarang.addRow(data);
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
    int row = 0;
    public void tampil_field(){
    
        row = tabelpembelian.getSelectedRow();
        
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
        combo_barang = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        txt_carinama = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_kodebrg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        kuantitas = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        txt_hbeli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        combo_supplier = new javax.swing.JComboBox<String>();
        hiddentable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpembelian = new javax.swing.JTable();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_supply_id = new javax.swing.JTextField();
        date_tanggal = new com.toedter.calendar.JDateChooser();
        txt_totalharga = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Transaksi Pembelian");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian Data Transaksi"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cari Berdasarkan");

        combo_barang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_barangActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nama Barang");

        jButton1.setText("Tampilkan Semua Data");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_barang, 0, 140, Short.MAX_VALUE)
                            .addComponent(txt_carinama))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_carinama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tanggal Transaksi");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Kode Barang");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Jumlah Beli");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Harga Beli");

        txt_hbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hbeliActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Supplier");

        combo_supplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        hiddentable.setModel(new javax.swing.table.DefaultTableModel(
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
        hiddentable.setOpaque(false);
        hiddentable.setRequestFocusEnabled(false);

        tabelpembelian.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelpembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpembelianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpembelian);

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        jButton5.setText("Keluar");

        btn_submit.setText("SUBMIT");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("ID Pembelian");

        txt_supply_id.setText("1");

        txt_totalharga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_totalharga.setText("0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("TOTAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_kodebrg, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_hbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(hiddentable, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(74, 74, 74)
                        .addComponent(txt_totalharga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_supply_id, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(date_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel10)
                                .addComponent(txt_supply_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(date_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(hiddentable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_kodebrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_hbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combo_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_totalharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(btn_submit))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_simpan)
                        .addComponent(btn_hapus)))
                .addGap(108, 108, 108))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_hbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hbeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hbeliActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int harga = Integer.parseInt(tableModelitem.getValueAt(row, 4).toString())  * Integer.parseInt(tableModelitem.getValueAt(row, 3).toString());
        int harga_total = Integer.parseInt(txt_totalharga.getText()) - harga;
        txt_totalharga.setText(Integer.toString(harga_total));
        tableModelitem.removeRow(row);
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        Date selectedDate = date_tanggal.getDate();
        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
        try{
            
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                StringBuilder SQL1 = new StringBuilder();
                stt.executeUpdate("INSERT INTO supply_transactions(supply_id,date,total_amount) "
                              + "VALUES "
                              + "("+txt_supply_id.getText()+","
                              + " '"+sqlDate+"' ,"
                              + " "+txt_totalharga.getText()+");");
                System.out.println(SQL1);
                int ID = Integer.parseInt(txt_supply_id.getText())+1;
                for (int i = 0; i < tableModelitem.getRowCount(); i++) {
                    String selectedItem = tableModelitem.getValueAt(i, 2).toString();
                    String[] parts = selectedItem.split(" - ");
                    String kodespl = parts[0];   
                    String nama = parts[1];
                    int total = 0;
                    total += Integer.parseInt(tableModelitem.getValueAt(i, 3).toString())  * Integer.parseInt(tableModelitem.getValueAt(i, 4).toString());           
                    
                    
                    stt.executeUpdate("INSERT INTO supply_details(supply_id,kodebrg,supplier_id,quantity,purchase_price) "
                              + "VALUES "
                              + "("+txt_supply_id.getText()+","
                              + "'"+tableModelitem.getValueAt(i, 0)+"' ,"
                              + ""+kodespl+" ,"
                              + ""+tableModelitem.getValueAt(i, 3)+" ,"
                              + " "+total+");");
                    String kode = tableModelitem.getValueAt(i, 0).toString();
                    int stokawal = 0;
                    int stok1 = Integer.parseInt(tableModelitem.getValueAt(i, 3).toString());
                    for (int j = 0; j < hiddentable.getRowCount(); j++) {
                        String code = hiddentable.getValueAt(j, 0).toString(); // Column 0 = Code
                    if (code.equals(kode)) {
                        String valueInColumn4 = hiddentable.getValueAt(j, 3).toString(); // Column 4 (index 3)
                        stokawal = Integer.parseInt(valueInColumn4);
                        int stokakhir = stokawal+stok1;
                        tableModelbarang.setValueAt(stokakhir, j, 3);
                        stt.executeUpdate("UPDATE databarang SET stok=" + ""+stokakhir+" WHERE kodebrg=" + "'"+kode+"';");
                    }
                    }
                    
                     
                }

                txt_supply_id.setText(Integer.toString(ID));
                tableModelitem.setRowCount(0);
                JOptionPane.showMessageDialog(null, "Berhasil Checkout!", "Data telah berhasil dicekout", JOptionPane.INFORMATION_MESSAGE);
                stt.close();
                kon.close();
                
            }
            catch (Exception ex){
            
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        MainMenu utama = new MainMenu();
        utama.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void combo_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_barangActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) combo_barang.getSelectedItem();
        String[] parts = selectedItem.split(" - ");
        String kode = parts[0];   
        String nama = parts[1];   
        txt_kodebrg.setText(kode);
        for (int i = 0; i < hiddentable.getRowCount(); i++) {
            String code = hiddentable.getValueAt(i, 0).toString(); 
        if (code.equals(kode)) {
            Object valueInColumn2 = hiddentable.getValueAt(i, 1); 
            String valueInColumn3 = (String) hiddentable.getValueAt(i, 2);
            txt_carinama.setText((String)valueInColumn2);
            txt_hbeli.setText(valueInColumn3);
            break;
            }
        }
    }//GEN-LAST:event_combo_barangActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) combo_barang.getSelectedItem();
        String[] parts = selectedItem.split(" - ");
        String kode = parts[0];   // B001
        String nama = parts[1];   // Teh Botol
        String supplier = (String) combo_supplier.getSelectedItem();

        
        Object value = kuantitas.getValue();
        int kuantitas1 = Integer.parseInt(value.toString());
        int harga = Integer.parseInt(txt_hbeli.getText());
        boolean found = false;

        for (int i = 0; i < tableModelitem.getRowCount(); i++) {
            String existingKode = tableModelitem.getValueAt(i, 0).toString();
            String existingSupplier = tableModelitem.getValueAt(i, 2).toString();

            if (existingKode.equals(kode) && existingSupplier.equals(supplier)) {
                // If match found, update quantity and subtotal
                int currentQty = Integer.parseInt(tableModelitem.getValueAt(i, 3).toString());
                int newQty = currentQty + kuantitas1; // Add new quantity
                tableModelitem.setValueAt(newQty, i, 3);       // Update quantity
                found = true;
                break;
            }
        }

        // If not found, add new row
        if (!found) {

            Object[] rowData = {kode, nama, supplier, kuantitas1, txt_hbeli.getText()};
            tableModelitem.addRow(rowData);
        }
        
        int total = 0;
        for (int i = 0; i < tableModelitem.getRowCount(); i++) {
            total += Integer.parseInt(tableModelitem.getValueAt(i, 4).toString())  * Integer.parseInt(tableModelitem.getValueAt(i, 3).toString()); //
        }
        txt_totalharga.setText(String.valueOf(total));
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void tabelpembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpembelianMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
        
            tampil_field();
        }
    }//GEN-LAST:event_tabelpembelianMouseClicked

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
            java.util.logging.Logger.getLogger(TPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TPembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox<String> combo_barang;
    private javax.swing.JComboBox<String> combo_supplier;
    private com.toedter.calendar.JDateChooser date_tanggal;
    private javax.swing.JTable hiddentable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner kuantitas;
    private javax.swing.JTable tabelpembelian;
    private javax.swing.JTextField txt_carinama;
    private javax.swing.JTextField txt_hbeli;
    private javax.swing.JTextField txt_kodebrg;
    private javax.swing.JTextField txt_supply_id;
    private javax.swing.JTextField txt_totalharga;
    // End of variables declaration//GEN-END:variables
}
