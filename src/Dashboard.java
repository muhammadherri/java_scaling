/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Buana_Dev
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
    private void search(){
        txtfilter.setEditable(true);
    }
    public Dashboard() {
        initComponents();
        comboboxsupplier();
        comboboxload();
        comboboxarmada();
        tampilkandata();
        update();
        search();
        simpan();
        comboport.setVisible(false);
        comboport.setEnabled(true);
        btninput.setVisible(false);
        btninput.setEnabled(true);
        txttara.setVisible(false);
        txttara.setEnabled(true);
        tara.setVisible(false);
        tara.setEnabled(true);
        
        txtid.setEnabled(true);
        txtadj.setEnabled(true);
        btnprintbaru.setVisible(false);
        btnprintbaru.setEnabled(true);
        btnprintori.setVisible(false);
        btnprintori.setEnabled(true);
        btnprint.setVisible(false);
        btnprint.setEnabled(true);

    }
private void update(){
        txtnopol.setText(null);
        txtgross.setText(null);
        txttara.setText(null);
        combosupplier.setSelectedItem(null);
        txtsuratjalan.setText(null);
        txtid.setText(null);
        txtadj.setText(null);

    }
private void simpan(){
        txtnopol.setText(null);
        txtgross.setText(null);
        combosupplier.setSelectedItem(null);
        txtsuratjalan.setText(null);
        comboarmada.setSelectedItem(null);
        combomuatan.setSelectedItem(null);
    }
 private void comboboxsupplier(){
        try{
            String sql="select*from bm_supplier";
            java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                 while(res.next()){
                     String name = res.getString("supplier_name");
                     combosupplier.addItem(name);
                 }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void comboboxload(){
        try{
            String sql="select*from bm_payload";
            java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                 while(res.next()){
                     String name = res.getString("load_name");
                     combomuatan.addItem(name);
                 }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void comboboxarmada(){
        try{
            String sql="select*from bm_armada";
            java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                 while(res.next()){
                     String name = res.getString("armada_name");
                     comboarmada.addItem(name);
                 }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void tampilkandata(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");       
        model.addColumn("Id");        
        model.addColumn("Nopol");
        model.addColumn("Adj");        
        model.addColumn("Gross");
        model.addColumn("Tara");
        model.addColumn("Netto");
        model.addColumn("Supplier");
        model.addColumn("Surat Jalan");
        model.addColumn("Date");
        try{
            String tes = txtfilter.getText();
            if(tes.isEmpty()){
                int no = 1;
                String sql = "SELECT id,nopol,adjustment,gross,tara,act_netto,supplier_name,surat_jalan,created_at,muatan FROM bm_scaling where tara=0";
                java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                while(res.next()){
                    model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)}); 
                }
                datatimbangan.setModel(model); 
            }else{
                int no = 1;
                String sql = "SELECT id,nopol,adjustment,gross,tara,act_netto,supplier_name,surat_jalan,created_at FROM bm_scaling where nopol='"+txtfilter.getText()+"' and tara = 0";
                java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

                while(res.next()){
                    model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9)}); 
                }
                datatimbangan.setModel(model); 
            }          
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
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
        jPanel2 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatimbangan = new javax.swing.JTable();
        leftpanel = new javax.swing.JPanel();
        nopol = new javax.swing.JLabel();
        gross = new javax.swing.JLabel();
        tara = new javax.swing.JLabel();
        supplier = new javax.swing.JLabel();
        suratjalan = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        btninput = new javax.swing.JButton();
        rightpanel = new java.awt.Panel();
        txtgross = new javax.swing.JTextField();
        txttara = new javax.swing.JTextField();
        txtsuratjalan = new javax.swing.JTextField();
        btnprintori = new javax.swing.JButton();
        txtnopol = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        btnprint = new javax.swing.JButton();
        comboarmada = new javax.swing.JComboBox<>();
        combomuatan = new javax.swing.JComboBox<>();
        combosupplier = new javax.swing.JComboBox<>();
        btnprintbaru = new javax.swing.JButton();
        filterleftpanel = new javax.swing.JPanel();
        cari = new javax.swing.JButton();
        filterrightpanel = new javax.swing.JPanel();
        txtfilter = new javax.swing.JTextField();
        connection = new javax.swing.JButton();
        comboport = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtadj = new javax.swing.JLabel();
        txtid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        header.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("APLIKASI TIMBANGAN");

        datatimbangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.Pol", "Gross", "Tara", "Netto", "Muatan", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        datatimbangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatimbanganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(datatimbangan);

        leftpanel.setBackground(new java.awt.Color(0, 102, 102));

        nopol.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nopol.setForeground(new java.awt.Color(255, 255, 255));
        nopol.setText("No.Pol");

        gross.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gross.setForeground(new java.awt.Color(255, 255, 255));
        gross.setText("Gross (kg)");

        tara.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tara.setForeground(new java.awt.Color(255, 255, 255));
        tara.setText("Tara (kg)");

        supplier.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supplier.setForeground(new java.awt.Color(255, 255, 255));
        supplier.setText("Supplier");

        suratjalan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        suratjalan.setForeground(new java.awt.Color(255, 255, 255));
        suratjalan.setText("Surat Jalan (kg)");

        jLabel6.setBackground(new java.awt.Color(51, 153, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Armada");

        jLabel7.setBackground(new java.awt.Color(51, 153, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Muatan");

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        btninput.setText("Kembali");
        btninput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftpanelLayout = new javax.swing.GroupLayout(leftpanel);
        leftpanel.setLayout(leftpanelLayout);
        leftpanelLayout.setHorizontalGroup(
            leftpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nopol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gross, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(supplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(suratjalan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftpanelLayout.createSequentialGroup()
                .addComponent(simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btninput, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        leftpanelLayout.setVerticalGroup(
            leftpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftpanelLayout.createSequentialGroup()
                .addComponent(nopol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gross, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tara, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suratjalan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(leftpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(btninput))
                .addContainerGap())
        );

        txtgross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgrossActionPerformed(evt);
            }
        });

        txttara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttaraKeyTyped(evt);
            }
        });

        txtsuratjalan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsuratjalanKeyTyped(evt);
            }
        });

        btnprintori.setText("Submit Print Ori");
        btnprintori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintoriActionPerformed(evt);
            }
        });

        txtnopol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnopolActionPerformed(evt);
            }
        });
        txtnopol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnopolKeyTyped(evt);
            }
        });

        txtarea.setColumns(20);
        txtarea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtarea.setRows(5);
        jScrollPane2.setViewportView(txtarea);

        btnprint.setText("Print");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        comboarmada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboarmadaActionPerformed(evt);
            }
        });

        combosupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combosupplierActionPerformed(evt);
            }
        });

        btnprintbaru.setText("Simpan Print Baru");
        btnprintbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintbaruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightpanelLayout = new javax.swing.GroupLayout(rightpanel);
        rightpanel.setLayout(rightpanelLayout);
        rightpanelLayout.setHorizontalGroup(
            rightpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightpanelLayout.createSequentialGroup()
                .addGroup(rightpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combomuatan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboarmada, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttara)
                    .addComponent(txtgross, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnopol, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightpanelLayout.createSequentialGroup()
                        .addComponent(btnprintbaru, javax.swing.GroupLayout.PREFERRED_SIZE, 128, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnprintori, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combosupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtsuratjalan, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnprint, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
        );
        rightpanelLayout.setVerticalGroup(
            rightpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightpanelLayout.createSequentialGroup()
                .addGroup(rightpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rightpanelLayout.createSequentialGroup()
                        .addComponent(txtnopol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtgross, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttara, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combosupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsuratjalan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboarmada, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combomuatan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(rightpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnprintori)
                    .addComponent(btnprint)
                    .addComponent(btnprintbaru))
                .addContainerGap())
        );

        filterleftpanel.setBackground(new java.awt.Color(0, 102, 102));

        cari.setText("Cari");
        cari.setToolTipText("");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filterleftpanelLayout = new javax.swing.GroupLayout(filterleftpanel);
        filterleftpanel.setLayout(filterleftpanelLayout);
        filterleftpanelLayout.setHorizontalGroup(
            filterleftpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cari)
        );
        filterleftpanelLayout.setVerticalGroup(
            filterleftpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterleftpanelLayout.createSequentialGroup()
                .addComponent(cari)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtfilter.setToolTipText("");
        txtfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filterrightpanelLayout = new javax.swing.GroupLayout(filterrightpanel);
        filterrightpanel.setLayout(filterrightpanelLayout);
        filterrightpanelLayout.setHorizontalGroup(
            filterrightpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfilter)
        );
        filterrightpanelLayout.setVerticalGroup(
            filterrightpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtfilter, javax.swing.GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
        );

        connection.setText("Connection");
        connection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionActionPerformed(evt);
            }
        });

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtadj.setForeground(new java.awt.Color(0, 102, 102));
        txtadj.setText("jLabel1");

        txtid.setForeground(new java.awt.Color(0, 102, 102));
        txtid.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(leftpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(filterleftpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterrightpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboport, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 624, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(connection)
                        .addGap(31, 31, 31)
                        .addComponent(txtadj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(leftpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rightpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filterleftpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filterrightpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connection)
                    .addComponent(jButton1)
                    .addComponent(txtadj)
                    .addComponent(txtid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        tampilkandata();
        
    }//GEN-LAST:event_cariActionPerformed

    private void txtfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfilterActionPerformed

    private void btnprintbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintbaruActionPerformed
        // TODO add your handling code here:
        Date HariSekarang = new Date( );
            SimpleDateFormat date = 
                new SimpleDateFormat ("yyyy-MM-dd");
            SimpleDateFormat time = 
                new SimpleDateFormat ("hh.mm.ss");
            SimpleDateFormat datetime = 
                new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            
        if(txttara.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Berat Tara Belum Di isi");
                txttara.requestFocus();
        }else if(txtadj.getText().equals("")||txtadj.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Data Tidak Valid");
        }
        else{
            int adj = Integer.parseInt(txtadj.getText());
            int sj =Integer.parseInt(txtsuratjalan.getText());
            Random randomNum = new Random();
            int act_net = Integer.parseInt(txtgross.getText())-Integer.parseInt(txttara.getText());
            if(act_net<=1000){
                System.out.println("if 1");
                int no = Integer.parseInt(txtid.getText());
                int nopol = Integer.parseInt(txtnopol.getText());
                int tara = Integer.parseInt(txttara.getText());

                int adj_net = act_net-(act_net*10/100);
                float pengurang = (float)(act_net*10/100);
                int Intpengurang = (int)pengurang;
                int adj_gross=adj_net+Integer.parseInt(txttara.getText());
                try{
                    String sql = "UPDATE bm_scaling SET updated_at='"+datetime.format(HariSekarang)+"',adjustment='"+Intpengurang+"',tara='"+txttara.getText()+"',adj_netto='"+adj_net+"',adj_gross='"+adj_gross+"',act_netto='"+act_net+"' WHERE id = '"+txtid.getText()+"'";
                    java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                    java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                    pstm.execute();
                    JOptionPane.showMessageDialog(null, "Success");
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                tampilkandata();
                update();
                txtarea.setText(txtarea.getText()+"  No:   "+String.valueOf(no)+"\n");
                txtarea.setText(txtarea.getText()+"Date:"+date.format(HariSekarang)+"\n");
                txtarea.setText(txtarea.getText()+"Date:"+time.format(HariSekarang)+"\n");
                txtarea.setText(txtarea.getText()+"Truk:"+String.valueOf(nopol)+"\n");
                txtarea.setText(txtarea.getText()+"Art.:"+200+"\n");
                txtarea.setText(txtarea.getText()+"G :    "+String.valueOf(adj_gross)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n");
                txtarea.setText(txtarea.getText()+"T :    "+String.valueOf(tara)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n");
                txtarea.setText(txtarea.getText()+"N :    "+String.valueOf(adj_net)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n\n");            
                txtarea.setText(txtarea.getText()+" -----------");
            }else if(act_net < sj){
                System.out.println("if 2");
                int no = Integer.parseInt(txtid.getText());
                int nopol = Integer.parseInt(txtnopol.getText());
                int tara = Integer.parseInt(txttara.getText());

                int pengurangscnd = randomNum.nextInt(100-80+1)+80;
                double tes = pengurangscnd/10;
                double pengurang =Math.ceil(tes)*10;
                int Intpengurang = (int)pengurang;
                int adj_net = act_net-Intpengurang;
                int adj_gross=adj_net+Integer.parseInt(txttara.getText());

                try{
                    String sql = "UPDATE bm_scaling SET updated_at='"+datetime.format(HariSekarang)+"',adjustment='"+Intpengurang+"',tara='"+txttara.getText()+"',adj_netto='"+adj_net+"',adj_gross='"+adj_gross+"',act_netto='"+act_net+"' WHERE id = '"+txtid.getText()+"'";
                    java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                    java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                    pstm.execute();
                    JOptionPane.showMessageDialog(null, "Success");
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                tampilkandata();
                update();
                txtarea.setText(txtarea.getText()+"  No:   "+String.valueOf(no)+"\n");
                txtarea.setText(txtarea.getText()+"Date:"+date.format(HariSekarang)+"\n");
                txtarea.setText(txtarea.getText()+"Date:"+time.format(HariSekarang)+"\n");
                txtarea.setText(txtarea.getText()+"Truk:"+String.valueOf(nopol)+"\n");
                txtarea.setText(txtarea.getText()+"Art.:"+200+"\n");
                txtarea.setText(txtarea.getText()+"G :    "+String.valueOf(adj_gross)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n");
                txtarea.setText(txtarea.getText()+"T :    "+String.valueOf(tara)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n");
                txtarea.setText(txtarea.getText()+"N :    "+String.valueOf(adj_net)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n\n");            
                txtarea.setText(txtarea.getText()+" -----------");
            }else if(act_net > sj){
                System.out.println("if 3");
                int no = Integer.parseInt(txtid.getText());
                int nopol = Integer.parseInt(txtnopol.getText());
                int tara = Integer.parseInt(txttara.getText());
                
                int hasilarmada = adj*20/100;
                int pengurangoriginal = adj-hasilarmada;
                int pengurangscnd = randomNum.nextInt(100-pengurangoriginal+1)+pengurangoriginal;
                double tes = pengurangscnd/10;
                double pengurang =Math.ceil(tes)*10;
                int Intpengurang = (int)pengurang;
                int adj_net = act_net-Intpengurang;
                int adj_gross=adj_net+Integer.parseInt(txttara.getText());
              
                try{
                    String sql = "UPDATE bm_scaling SET updated_at='"+datetime.format(HariSekarang)+"',adjustment='"+Intpengurang+"',tara='"+txttara.getText()+"',adj_netto='"+adj_net+"',adj_gross='"+adj_gross+"',act_netto='"+act_net+"' WHERE id = '"+txtid.getText()+"'";
                    java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                    java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                    pstm.execute();
                    JOptionPane.showMessageDialog(null, "Success");
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                tampilkandata();
                update();
                txtarea.setText(txtarea.getText()+"  No:   "+String.valueOf(no)+"\n");
                txtarea.setText(txtarea.getText()+"Date:"+date.format(HariSekarang)+"\n");
                txtarea.setText(txtarea.getText()+"Date:"+time.format(HariSekarang)+"\n");
                txtarea.setText(txtarea.getText()+"Truk:"+String.valueOf(nopol)+"\n");
                txtarea.setText(txtarea.getText()+"Art.:"+200+"\n");
                txtarea.setText(txtarea.getText()+"G :    "+String.valueOf(adj_gross)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n");
                txtarea.setText(txtarea.getText()+"T :    "+String.valueOf(tara)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n");
                txtarea.setText(txtarea.getText()+"N :    "+String.valueOf(adj_net)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n\n");            
                txtarea.setText(txtarea.getText()+" -----------");
            }else{
                System.out.println("lainnya");
                int no = Integer.parseInt(txtid.getText());
                int nopol = Integer.parseInt(txtnopol.getText());
                int tara = Integer.parseInt(txttara.getText());

                int pengurangscnd = randomNum.nextInt(100-80+1)+80;
                double tes = pengurangscnd/10;
                double pengurang =Math.ceil(tes)*10;
                int Intpengurang = (int)pengurang;
                int adj_net = Integer.parseInt(txtgross.getText())-Integer.parseInt(txttara.getText())-Intpengurang;
                int adj_gross=adj_net+Integer.parseInt(txttara.getText());
                
                try{
                    String sql = "UPDATE bm_scaling SET updated_at='"+datetime.format(HariSekarang)+"',adjustment='"+Intpengurang+"',tara='"+txttara.getText()+"',adj_netto='"+adj_net+"',adj_gross='"+adj_gross+"',act_netto='"+act_net+"' WHERE id = '"+txtid.getText()+"'";
                    java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                    java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                    pstm.execute();
                    JOptionPane.showMessageDialog(null, "Success");
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                tampilkandata();
                update();
                txtarea.setText(txtarea.getText()+"  No:   "+String.valueOf(no)+"\n");
                txtarea.setText(txtarea.getText()+"Date:"+date.format(HariSekarang)+"\n");
                txtarea.setText(txtarea.getText()+"Date:"+time.format(HariSekarang)+"\n");
                txtarea.setText(txtarea.getText()+"Truk:"+String.valueOf(nopol)+"\n");
                txtarea.setText(txtarea.getText()+"Art.:"+200+"\n");
                txtarea.setText(txtarea.getText()+"G :    "+String.valueOf(adj_gross)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n");
                txtarea.setText(txtarea.getText()+"T :    "+String.valueOf(tara)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n");
                txtarea.setText(txtarea.getText()+"N :    "+String.valueOf(adj_net)+"");
                txtarea.setText(txtarea.getText()+" (kg)"+"\n\n");            
                txtarea.setText(txtarea.getText()+" -----------");
            }
        }
    }//GEN-LAST:event_btnprintbaruActionPerformed

    private void datatimbanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatimbanganMouseClicked
        // TODO add your handling code here:
        btnprintbaru.setVisible(true); 
        btnprintori.setVisible(true); 
        btnprint.setVisible(true); 
        txtnopol.setVisible(true); 
        btninput.setVisible(true); 
        tara.setVisible(true); 
        txttara.setVisible(true); 
        txtadj.setVisible(true); 
        txtid.setVisible(true); 

        txtnopol.setEditable(false);
        txtgross.setEditable(false);
        txtsuratjalan.setEditable(false);
        combosupplier.setEditable(false);
        combosupplier.setEnabled(false);
        comboarmada.setVisible(false);        
        combomuatan.setVisible(false);        
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        simpan.setVisible(false);  
        
        txtarea.setText(null);

        int baris = datatimbangan.rowAtPoint(evt.getPoint());
        String id = datatimbangan.getValueAt(baris, 1).toString();
        txtid.setText(id);
        
        String nopol = datatimbangan.getValueAt(baris, 2).toString();
        txtnopol.setText(nopol);
        
         String adj = datatimbangan.getValueAt(baris, 3).toString();
        txtadj.setText(adj);
        
        String gross = datatimbangan.getValueAt(baris, 4).toString();
        txtgross.setText(gross);
        
        String supplier = datatimbangan.getValueAt(baris, 7).toString();
        combosupplier.setSelectedItem(supplier);
        
        String sj = datatimbangan.getValueAt(baris, 8).toString();
        txtsuratjalan.setText(sj);
        String muatan = datatimbangan.getValueAt(baris, 10).toString();
        combomuatan.setSelectedItem(muatan);


    }//GEN-LAST:event_datatimbanganMouseClicked

    private void txtgrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgrossActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgrossActionPerformed

    private void btnprintoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintoriActionPerformed
        // TODO add your handling code here:
        Date HariSekarang = new Date( );
            SimpleDateFormat date = 
                new SimpleDateFormat ("yyyy-MM-dd");
            SimpleDateFormat time = 
                new SimpleDateFormat ("hh.mm.ss");
            SimpleDateFormat datetime = 
                new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            
        if(txttara.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Berat Tara Belum Di isi");
                txttara.requestFocus();
        }else if(txtnopol.getText().equals("")||txtnopol.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Data Tidak Valid");
        }
        else{
            int no = Integer.parseInt(txtid.getText());
            int nopol = Integer.parseInt(txtnopol.getText());
            int tara = Integer.parseInt(txttara.getText());
            int gross = Integer.parseInt(txtgross.getText());

            int act_net = Integer.parseInt(txtgross.getText())-Integer.parseInt(txttara.getText());
            try{
                String sql = "UPDATE bm_scaling SET updated_at='"+datetime.format(HariSekarang)+"',adjustment='0',tara='"+txttara.getText()+"',act_netto='"+act_net+"' WHERE id = '"+txtid.getText()+"'";
                java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Success");
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            tampilkandata();
            update();
            txtarea.setText(txtarea.getText()+"  No:   "+String.valueOf(no)+"\n");
            txtarea.setText(txtarea.getText()+"Date:"+date.format(HariSekarang)+"\n");
            txtarea.setText(txtarea.getText()+"Date:"+time.format(HariSekarang)+"\n");
            txtarea.setText(txtarea.getText()+"Truk:"+String.valueOf(nopol)+"\n");
            txtarea.setText(txtarea.getText()+"Art.:"+200+"\n");
            txtarea.setText(txtarea.getText()+"G :    "+String.valueOf(gross)+"");
            txtarea.setText(txtarea.getText()+" (kg)"+"\n");
            txtarea.setText(txtarea.getText()+"T :    "+String.valueOf(tara)+"");
            txtarea.setText(txtarea.getText()+" (kg)"+"\n");
            txtarea.setText(txtarea.getText()+"N :    "+String.valueOf(act_net)+"");
            txtarea.setText(txtarea.getText()+" (kg)"+"\n\n");            
            txtarea.setText(txtarea.getText()+" -----------");



        }
    }//GEN-LAST:event_btnprintoriActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
        try{
            txtarea.print();
        }catch(PrinterException e){
            
        }
    }//GEN-LAST:event_btnprintActionPerformed

    private void connectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionActionPerformed
        // TODO add your handling code here:
        comboport.setVisible(true); 
        connection.setVisible(false);
    }//GEN-LAST:event_connectionActionPerformed

    private void comboarmadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboarmadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboarmadaActionPerformed

    private void combosupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosupplierActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_combosupplierActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        if(txtnopol.getText().equals("")||txtgross.getText().equals("")||combosupplier.getSelectedItem()==null||txtsuratjalan.getText().equals("")||comboarmada.getSelectedItem()==null||combomuatan.getSelectedItem()==null){
            JOptionPane.showMessageDialog(null, "Mohon Cek Dan Isi Data");
            //                txtnopol.requestFocus();
        }else{
            int adj = Integer.parseInt(txtnopol.getText());
            System.out.println(adj);
            try{
                Date HariSekarang = new Date( );
                SimpleDateFormat ft =
                new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
                String sql = "INSERT INTO bm_scaling(nopol,gross,supplier_name,surat_jalan,created_at,adjustment,art,tara,adj_netto,act_netto,adj_gross,muatan) VALUES ('"+txtnopol.getText()+"','"+txtgross.getText()+"','"+combosupplier.getSelectedItem()+"','"+txtsuratjalan.getText()+"','"+ft.format(HariSekarang)+"','100','200','','','','','"+combomuatan.getSelectedItem()+"')";
                java.sql.Connection conn = (java.sql.Connection)Connection.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil..");
                //            tampilkan_data();
                simpan();
                tampilkandata();
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void btninputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninputActionPerformed
        // TODO add your handling code here:
        simpan.setVisible(true); 
        btninput.setVisible(false);
        btnprintbaru.setVisible(false);
        btnprintori.setVisible(false);
        btnprint.setVisible(false);
        tara.setVisible(false);
        txttara.setVisible(false);
        
        txtadj.setVisible(true);
        txtid.setVisible(true);
        txtadj.setText(null);
        txtid.setText(null);
        
        txtnopol.setText(null);
        txtnopol.setEditable(true);
        txtgross.setText(null);
        txtgross.setEditable(true);
        combosupplier.setSelectedItem(null);
        combosupplier.setEnabled(true);
        txtsuratjalan.setText(null);
        txtsuratjalan.setEditable(true);
        jLabel6.setVisible(true);
        comboarmada.setVisible(true);
        jLabel7.setVisible(true);
        combomuatan.setVisible(true);
        suratjalan.setVisible(true);
    }//GEN-LAST:event_btninputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnopolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnopolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnopolActionPerformed

    private void txtnopolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnopolKeyTyped
        // TODO add your handling code here:
        char d = evt.getKeyChar();
        if(!Character.isDigit(d)){
            evt.consume();
        }
    }//GEN-LAST:event_txtnopolKeyTyped

    private void txttaraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttaraKeyTyped
        // TODO add your handling code here:
        char d = evt.getKeyChar();
        if(!Character.isDigit(d)){
            evt.consume();
        }
    }//GEN-LAST:event_txttaraKeyTyped

    private void txtsuratjalanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsuratjalanKeyTyped
        // TODO add your handling code here:
        char d = evt.getKeyChar();
        if(!Character.isDigit(d)){
            evt.consume();
        }
    }//GEN-LAST:event_txtsuratjalanKeyTyped

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btninput;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnprintbaru;
    private javax.swing.JButton btnprintori;
    private javax.swing.JButton cari;
    private javax.swing.JComboBox<String> comboarmada;
    private javax.swing.JComboBox<String> combomuatan;
    private javax.swing.JComboBox<String> comboport;
    private javax.swing.JComboBox<String> combosupplier;
    private javax.swing.JButton connection;
    private javax.swing.JTable datatimbangan;
    private javax.swing.JPanel filterleftpanel;
    private javax.swing.JPanel filterrightpanel;
    private javax.swing.JLabel gross;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel leftpanel;
    private javax.swing.JLabel nopol;
    private java.awt.Panel rightpanel;
    private javax.swing.JButton simpan;
    private javax.swing.JLabel supplier;
    private javax.swing.JLabel suratjalan;
    private javax.swing.JLabel tara;
    private javax.swing.JLabel txtadj;
    private javax.swing.JTextArea txtarea;
    private javax.swing.JTextField txtfilter;
    private javax.swing.JTextField txtgross;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtnopol;
    private javax.swing.JTextField txtsuratjalan;
    private javax.swing.JTextField txttara;
    // End of variables declaration//GEN-END:variables
}
