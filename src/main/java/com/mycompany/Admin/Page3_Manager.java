/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Admin;

import com.mycompany.Database.AdminCredentials;
import com.mycompany.Database.AdminPageLogout;
import com.mycompany.Database.AccessManager_Credentials;
import com.mycompany.Database.DBConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoeAlpha
 */
public class Page3_Manager extends javax.swing.JFrame implements Runnable {
    SimpleDateFormat timeFormat;// setting variable for time Format
    SimpleDateFormat dayFormat;// setting variable for day Format
    SimpleDateFormat dateFormat;// setting variable for date Format
    String time; // setting variable for current time
    String day; // setting variable for day
    String date; // setting variable for date
    
    
    /**
     * Creates new form Page2_Dashboard
     */
    public Page3_Manager() {
        initComponents();
        managers_table();

        // center the form
        this.setLocationRelativeTo(this);
        
        Thread t = new Thread(this);
        t.start();
        
        // creating button group for gender radio buttons
        ButtonGroup bgGroup = new ButtonGroup();
        bgGroup.add(btnMale);
        bgGroup.add(btnFemale);
        
        btnViewMg.setVisible(false);
        btnDelMg.setVisible(false);
        btnGoBack.setVisible(false);
        
        // displaying users info
        sideBarFname.setText(AdminCredentials.fullname);
        sideBarOperator.setText(AdminCredentials.operator_id); 
        topBarRegNo.setText(AdminCredentials.serial_no);
    }
    
    // universal variables
    SimpleDateFormat dateofbirth; 
    
    DefaultTableModel defaulttbl_1_query;
    DefaultTableModel defaulttbl_2_delete;
    DefaultTableModel defaulttbl_3_view;
    
    PreparedStatement sqlQueryCheck;
    PreparedStatement sqlQueryInsert;
    PreparedStatement sqlQueryLogout;
    ResultSet res;
    Connection conn;
    
    private void managers_table() {
        try {
            conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_managers");
            res = sqlQueryCheck.executeQuery();
            
            while(res.next()) {
                String mgId     = res.getString("id");
                String mgSerial = res.getString("serial_no");
                String mgFname  = res.getString("fullname");
                String mgPhone  = "0"+res.getString("phone");
                String mgGender = res.getString("gender");
                
                Object[] obj = {mgId, mgSerial, mgFname, mgPhone, mgGender};
                
                defaulttbl_1_query = (DefaultTableModel)tbl_managers.getModel();
                defaulttbl_1_query.addRow(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page3_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clear_form() {
        // serial no
        txtSerialNo.setText("");
        errorReg.setText(null);
        if(txtSerialNo.getText().trim().equals("")){
            txtSerialNo.setText("serial no.(mg1234567890)");
            txtSerialNo.setForeground(Color.gray);
            serialLine.setBackground(Color.black);
        }
        
        // full name
        txtFullname.setText("");
        errorFname.setText(null);
        if(txtFullname.getText().trim().equals("")){
            txtFullname.setText("fullname");
            txtFullname.setForeground(Color.gray);
            fnameLine.setBackground(Color.black);
        }
        
        // id no
        txtIdNo.setText("");
        errorId.setText(null);
        if(txtIdNo.getText().trim().equals("")){
            txtIdNo.setText("id no. (123456789)");
            txtIdNo.setForeground(Color.gray);
            idnoLine.setBackground(Color.black);
        }
        
        // date of birth        
        txtDob.setDate(null);
        
        // email
        txtEmail.setText("");
        errorEmail.setText(null);
        if(txtEmail.getText().trim().equals("")){
            txtEmail.setText("someone@newmail.com");
            txtEmail.setForeground(Color.gray);
            emailLine.setBackground(Color.black);
        }
        
        // phone
        txtPhone.setText("");
        errorPhone.setText(null);
        if(txtPhone.getText().trim().equals("")){
            txtPhone.setText("07xxxxxxxx");
            txtPhone.setForeground(Color.gray);
            phoneLine.setBackground(Color.black);
        }
        
        // password
        txtPassword.setText("");
        errorPassword.setText(null);
        if(txtPassword.getText().trim().equals("")){
            txtPassword.setText("yourpassword");
            txtPassword.setForeground(Color.gray);
            passwordLine.setBackground(Color.black);
        }
        
        txtSerialNo.requestFocus();
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
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        topBarRegNo = new javax.swing.JLabel();
        txtDay = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_managers = new rojeru_san.complementos.RSTableMetro();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        mgEmail = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        mgPhone = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        mgFname = new javax.swing.JLabel();
        mgIdNo = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        mgSerial = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        mgDob = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        mgGender = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        fnameLine = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        errorFname = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnFemale = new javax.swing.JRadioButton();
        btnMale = new javax.swing.JRadioButton();
        jPanel21 = new javax.swing.JPanel();
        txtDob = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        passwordLine = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        errorPassword = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        serialLine = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSerialNo = new javax.swing.JTextField();
        errorReg = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        phoneLine = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        errorPhone = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        idnoLine = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtIdNo = new javax.swing.JTextField();
        errorId = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        emailLine = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        errorEmail = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        btnShowAll = new javax.swing.JButton();
        btnAddStud = new javax.swing.JButton();
        btnViewMg = new javax.swing.JButton();
        btnDelMg = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        sideBarFname = new javax.swing.JLabel();
        sideBarOperator = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        GoToLogout = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        goToDashbord = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        goToManagers = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        goToSettings = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        goToRooms = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        goToCustomers = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        goToReport = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(java.awt.Color.white);
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel17.setText("My Managers");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 30));

        topBarRegNo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jPanel10.add(topBarRegNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 60, 120, 17));

        txtDay.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        txtDay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel10.add(txtDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 100, 17));

        jLabel24.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel24.setForeground(java.awt.SystemColor.windowBorder);
        jLabel24.setText("Serial No:");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        txtTime.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel10.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 90, 17));

        txtDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel10.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 100, 17));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 1, 648, 90));

        jPanel11.setBackground(java.awt.Color.white);
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(java.awt.Color.white);

        tbl_managers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Serial No", "Name", "Phone", "Gender"
            }
        ));
        tbl_managers.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_managers.setColorBordeHead(new java.awt.Color(0, 112, 192));
        tbl_managers.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_managers.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_managers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_managers.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_managers.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_managers.setFuenteHead(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_managers.setGrosorBordeFilas(0);
        tbl_managers.setGrosorBordeHead(0);
        tbl_managers.setMultipleSeleccion(false);
        tbl_managers.setRowHeight(25);
        tbl_managers.setShowHorizontalLines(false);
        tbl_managers.setShowVerticalLines(false);
        tbl_managers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_managersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_managers);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel15);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("View Manager Info");
        jPanel12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 584, 20));

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setOpaque(false);
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel28.setForeground(java.awt.SystemColor.windowBorder);
        jLabel28.setText("Email Address:");
        jPanel14.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        mgEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel14.add(mgEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 280, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Contact Information:");
        jPanel14.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 5, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel29.setForeground(java.awt.SystemColor.windowBorder);
        jLabel29.setText("Phone No:");
        jPanel14.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        mgPhone.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel14.add(mgPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 145, 20));

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 530, 100));

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setOpaque(false);
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel32.setForeground(java.awt.SystemColor.windowBorder);
        jLabel32.setText("Full Name:");
        jPanel20.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel33.setForeground(java.awt.SystemColor.windowBorder);
        jLabel33.setText("ID No:");
        jPanel20.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        mgFname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel20.add(mgFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 280, 20));

        mgIdNo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel20.add(mgIdNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 145, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("General Information:");
        jPanel20.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 5, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel34.setForeground(java.awt.SystemColor.windowBorder);
        jLabel34.setText("Serial No:");
        jPanel20.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        mgSerial.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel20.add(mgSerial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 145, 20));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel35.setForeground(java.awt.SystemColor.windowBorder);
        jLabel35.setText("Date of Birth:");
        jPanel20.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        mgDob.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel20.add(mgDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 140, 20));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel36.setForeground(java.awt.SystemColor.windowBorder);
        jLabel36.setText("Gender:");
        jPanel20.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        mgGender.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel20.add(mgGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 140, 20));

        jPanel12.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 530, 150));

        jTabbedPane1.addTab("tab2", jPanel12);

        jPanel29.setOpaque(false);
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("New Manager Account");
        jPanel29.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 586, 30));

        jPanel8.setBackground(java.awt.Color.white);
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fnameLine.setBackground(java.awt.Color.darkGray);
        fnameLine.setText("jTextField2");
        fnameLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.add(fnameLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 33, 220, 1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        txtFullname.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtFullname.setForeground(java.awt.Color.gray);
        txtFullname.setText("fullname");
        txtFullname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        txtFullname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFullnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFullnameFocusLost(evt);
            }
        });
        txtFullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFullnameKeyReleased(evt);
            }
        });
        jPanel8.add(txtFullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 3, 185, 25));

        errorFname.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        errorFname.setForeground(java.awt.Color.red);
        jPanel8.add(errorFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 226, 18));

        jPanel29.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 230, 53));

        jPanel9.setBackground(java.awt.Color.white);
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFemale.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnFemale.setText("Female");
        btnFemale.setOpaque(false);
        jPanel9.add(btnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 15, -1, -1));

        btnMale.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnMale.setSelected(true);
        btnMale.setText("Male");
        btnMale.setOpaque(false);
        jPanel9.add(btnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, -1, -1));

        jPanel29.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 230, 53));

        jPanel21.setBackground(java.awt.Color.white);
        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDob.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jPanel21.add(txtDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setText("Date of Birth:");
        jPanel21.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        jPanel29.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 230, 53));

        jPanel23.setBackground(java.awt.Color.white);
        jPanel23.setOpaque(false);
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton3.setText("Clear");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 0, 96, 30));

        jButton4.setBackground(java.awt.SystemColor.textHighlight);
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton4.setForeground(java.awt.Color.white);
        jButton4.setText("Register");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 96, 30));

        jPanel29.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 230, 30));

        jPanel24.setBackground(java.awt.Color.white);
        jPanel24.setOpaque(false);
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        passwordLine.setBackground(java.awt.Color.darkGray);
        passwordLine.setText("jTextField2");
        passwordLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel24.add(passwordLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 33, 220, 1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lock.png"))); // NOI18N
        jPanel24.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPassword.setForeground(java.awt.Color.gray);
        txtPassword.setText("yourpassword");
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        jPanel24.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 3, 185, 25));

        errorPassword.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        errorPassword.setForeground(java.awt.Color.red);
        jPanel24.add(errorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 226, 18));

        jPanel29.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 230, 53));

        jPanel13.setBackground(java.awt.Color.white);
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        serialLine.setBackground(java.awt.Color.darkGray);
        serialLine.setText("jTextField2");
        serialLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel13.add(serialLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 33, 220, 1));
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        txtSerialNo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSerialNo.setForeground(java.awt.Color.gray);
        txtSerialNo.setText("serial no.(mg1234567890)");
        txtSerialNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        txtSerialNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSerialNoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerialNoFocusLost(evt);
            }
        });
        txtSerialNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerialNoKeyReleased(evt);
            }
        });
        jPanel13.add(txtSerialNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 3, 185, 25));

        errorReg.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        errorReg.setForeground(java.awt.Color.red);
        jPanel13.add(errorReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 226, 18));

        jPanel29.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 230, 53));

        jPanel26.setBackground(java.awt.Color.white);
        jPanel26.setOpaque(false);
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        phoneLine.setBackground(java.awt.Color.darkGray);
        phoneLine.setText("jTextField2");
        phoneLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel26.add(phoneLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 33, 220, 1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/phone.png"))); // NOI18N
        jPanel26.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPhone.setForeground(java.awt.Color.gray);
        txtPhone.setText("07xxxxxxxx");
        txtPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });
        jPanel26.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 3, 185, 25));

        errorPhone.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        errorPhone.setForeground(java.awt.Color.red);
        jPanel26.add(errorPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 226, 18));

        jPanel29.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 230, 53));

        jPanel27.setBackground(java.awt.Color.white);
        jPanel27.setOpaque(false);
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idnoLine.setBackground(java.awt.Color.darkGray);
        idnoLine.setText("jTextField2");
        idnoLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel27.add(idnoLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 33, 220, 1));
        jPanel27.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        txtIdNo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtIdNo.setForeground(java.awt.Color.gray);
        txtIdNo.setText("id no. (123456789)");
        txtIdNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        txtIdNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdNoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdNoFocusLost(evt);
            }
        });
        txtIdNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdNoKeyReleased(evt);
            }
        });
        jPanel27.add(txtIdNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 3, 185, 25));

        errorId.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        errorId.setForeground(java.awt.Color.red);
        jPanel27.add(errorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 226, 18));

        jPanel29.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 230, 53));

        jPanel28.setBackground(java.awt.Color.white);
        jPanel28.setOpaque(false);
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailLine.setBackground(java.awt.Color.darkGray);
        emailLine.setText("jTextField2");
        emailLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel28.add(emailLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 33, 220, 1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Email Icon.png"))); // NOI18N
        jPanel28.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtEmail.setForeground(java.awt.Color.gray);
        txtEmail.setText("someone@newmail.com");
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        jPanel28.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 3, 185, 25));

        errorEmail.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        errorEmail.setForeground(java.awt.Color.red);
        jPanel28.add(errorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 226, 18));

        jPanel29.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 230, 53));

        jTabbedPane1.addTab("tab3", jPanel29);

        jPanel11.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 590, 420));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 145, 590, 390));

        jPanel25.setOpaque(false);
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnShowAll.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnShowAll.setText("Show All");
        btnShowAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });
        jPanel25.add(btnShowAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        btnAddStud.setBackground(java.awt.SystemColor.textHighlight);
        btnAddStud.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAddStud.setForeground(java.awt.Color.white);
        btnAddStud.setText("Add");
        btnAddStud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddStud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudActionPerformed(evt);
            }
        });
        jPanel25.add(btnAddStud, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 70, 30));

        btnViewMg.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnViewMg.setText("View");
        btnViewMg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewMg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMgActionPerformed(evt);
            }
        });
        jPanel25.add(btnViewMg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 70, 30));

        btnDelMg.setBackground(java.awt.Color.red);
        btnDelMg.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnDelMg.setForeground(java.awt.Color.white);
        btnDelMg.setText("Delete");
        btnDelMg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelMg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMgActionPerformed(evt);
            }
        });
        jPanel25.add(btnDelMg, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 70, 30));

        btnGoBack.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnGoBack.setText("Go Back");
        btnGoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        jPanel25.add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 100, 30));

        jPanel1.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 105, 590, 32));

        jPanel2.setBackground(java.awt.SystemColor.textHighlight);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Greens");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 0, 70, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Milimani");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 17, 170, -1));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideBarFname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sideBarFname.setForeground(java.awt.Color.white);
        jPanel4.add(sideBarFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1, 130, 20));

        sideBarOperator.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sideBarOperator.setForeground(java.awt.Color.white);
        jPanel4.add(sideBarOperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 21, 130, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/holder1.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 40, 40));

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setOpaque(true);
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 50, 170, 1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 60));

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 30, 25));

        GoToLogout.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        GoToLogout.setForeground(java.awt.Color.white);
        GoToLogout.setText("Logout");
        GoToLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        GoToLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GoToLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GoToLogoutMouseClicked(evt);
            }
        });
        jPanel5.add(GoToLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 2, -1, 25));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 150, 30));

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Manager.png"))); // NOI18N
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 30, 25));

        goToDashbord.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        goToDashbord.setForeground(new java.awt.Color(255, 255, 255));
        goToDashbord.setText("Dashboard");
        goToDashbord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goToDashbord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToDashbordMouseClicked(evt);
            }
        });
        jPanel6.add(goToDashbord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, -1, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 30));

        jPanel7.setBackground(java.awt.Color.white);
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lecturer.png"))); // NOI18N
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 30, 25));

        goToManagers.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        goToManagers.setForeground(new java.awt.Color(255, 255, 255));
        goToManagers.setText("Managers");
        goToManagers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goToManagers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToManagersMouseClicked(evt);
            }
        });
        jPanel7.add(goToManagers, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, -1, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 150, 30));

        jPanel16.setBackground(java.awt.Color.white);
        jPanel16.setOpaque(false);
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.png"))); // NOI18N
        jPanel16.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 30, 25));

        goToSettings.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        goToSettings.setForeground(new java.awt.Color(255, 255, 255));
        goToSettings.setText("Settings");
        goToSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goToSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToSettingsMouseClicked(evt);
            }
        });
        jPanel16.add(goToSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, -1, -1));

        jPanel2.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 150, 30));

        jPanel17.setBackground(java.awt.Color.white);
        jPanel17.setOpaque(false);
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        jPanel17.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 30, 25));

        goToRooms.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        goToRooms.setForeground(new java.awt.Color(255, 255, 255));
        goToRooms.setText("Rooms");
        goToRooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goToRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToRoomsMouseClicked(evt);
            }
        });
        jPanel17.add(goToRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, -1, -1));

        jPanel2.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 30));

        jPanel18.setBackground(java.awt.Color.white);
        jPanel18.setOpaque(false);
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Student.png"))); // NOI18N
        jPanel18.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 30, 25));

        goToCustomers.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        goToCustomers.setForeground(new java.awt.Color(255, 255, 255));
        goToCustomers.setText("Customers");
        goToCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goToCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToCustomersMouseClicked(evt);
            }
        });
        jPanel18.add(goToCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, -1, -1));

        jPanel2.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 150, 30));

        jPanel19.setBackground(java.awt.Color.white);
        jPanel19.setOpaque(false);
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        jPanel19.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 30, 25));

        goToReport.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        goToReport.setForeground(new java.awt.Color(255, 255, 255));
        goToReport.setText("Report");
        goToReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goToReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToReportMouseClicked(evt);
            }
        });
        jPanel19.add(goToReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, -1, -1));

        jPanel2.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 150, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        btnGoBack.setVisible(false);
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnAddStudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        btnGoBack.setVisible(true);
    }//GEN-LAST:event_btnAddStudActionPerformed

    private void btnViewMgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMgActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        btnGoBack.setVisible(true);
    }//GEN-LAST:event_btnViewMgActionPerformed

    private void btnDelMgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMgActionPerformed
        // Operation for deleting manager account
        try {
            defaulttbl_2_delete = (DefaultTableModel)tbl_managers.getModel();
            int selectIndex = tbl_managers.getSelectedRow();

            int id = Integer.parseInt(defaulttbl_2_delete.getValueAt(selectIndex, 0).toString());

            // confirmation message
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete Account of this Manager", "Warnimg", JOptionPane.YES_NO_OPTION);

            if(dialogResult == JOptionPane.YES_OPTION){
                try {
                    Connection conn = DBConnection.setConnection();
                    sqlQueryCheck = conn.prepareStatement("delete from tbl_managers where id=?");
                    sqlQueryCheck.setInt(1, id);
                    sqlQueryCheck.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Manager Account has been Deleted Successfully");

                    managers_table();

                    // refreshing the current page
                    new Page3_Manager().setVisible(true);
                    this.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(Page3_Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No Account has been selected!", "Warnimg", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDelMgActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        btnViewMg.setVisible(false);
        btnDelMg.setVisible(false);
        btnGoBack.setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void tbl_managersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_managersMouseClicked
        btnViewMg.setVisible(true);
        btnDelMg.setVisible(true);

        defaulttbl_3_view = (DefaultTableModel)tbl_managers.getModel();
        int selectIndex = tbl_managers.getSelectedRow();

        int id = Integer.parseInt(defaulttbl_3_view.getValueAt(selectIndex, 0).toString());

        try {
            Connection conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_managers where id=?");
            sqlQueryCheck.setInt(1, id);
            res = sqlQueryCheck.executeQuery();

            while(res.next()) {
                AccessManager_Credentials.serial_no    = res.getString("serial_no");
                AccessManager_Credentials.id_no        = res.getString("id_no");
                AccessManager_Credentials.date_ofbirth = res.getString("date_ofbirth");
                AccessManager_Credentials.fullname     = res.getString("fullname");
                AccessManager_Credentials.gender       = res.getString("gender");
                AccessManager_Credentials.email        = res.getString("email");
                AccessManager_Credentials.phone        = res.getString("phone");
            }
        } catch (Exception ex) {
            Logger.getLogger(Page3_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        // displaying specific user info
        mgSerial.setText(AccessManager_Credentials.serial_no);
        mgIdNo.setText(AccessManager_Credentials.id_no);
        mgDob.setText(AccessManager_Credentials.date_ofbirth);
        mgFname.setText(AccessManager_Credentials.fullname);
        mgGender.setText(AccessManager_Credentials.gender);
        mgEmail.setText(AccessManager_Credentials.email);
        mgPhone.setText("0"+AccessManager_Credentials.phone);
    }//GEN-LAST:event_tbl_managersMouseClicked

    private void txtFullnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFullnameFocusGained
        if(txtFullname.getText().trim().toLowerCase().equals("fullname")){
            txtFullname.setText("");
            txtFullname.setForeground(Color.black);
            fnameLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtFullnameFocusGained

    private void txtFullnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFullnameFocusLost
        if(txtFullname.getText().trim().equals("") || txtFullname.getText().trim().equals("fullname")){
            txtFullname.setText("fullname");
            txtFullname.setForeground(Color.gray);
            fnameLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtFullnameFocusLost

    private void txtFullnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullnameKeyReleased
        String PATTERN = "^[a-z A-Z]{0,30}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtFullname.getText());

        if(!match.matches()) {
            errorFname.setText("Invalid fullname!");
        } else {
            errorFname.setText(null);
        }
    }//GEN-LAST:event_txtFullnameKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clear_form();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // operation of createing a new account
        String status   = "Offline";
        String operator = "Manager";
        String serial   = txtSerialNo.getText();
        String id_no    = txtIdNo.getText();
        String fullname = txtFullname.getText();
        String email    = txtEmail.getText();
        String phone    = txtPhone.getText();

        String gender   = "Male";
        if(btnFemale.isSelected()) { gender  = "Female"; }

        dateofbirth     = new SimpleDateFormat("YYYY-MM-dd");
        String dob      = dateofbirth.format(txtDob.getDate());

        String password = txtPassword.getText();

        // checking if any field is empty before submitting the form
        if(serial.trim().equals("") || serial.trim().equals("serial no.(mg1234567890)")){
            JOptionPane.showMessageDialog(null, "Serial Number is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(id_no.trim().equals("") || id_no.trim().equals("123456789")){
            JOptionPane.showMessageDialog(null, "Id Number is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(fullname.trim().equals("") || fullname.trim().equals("full name")){
            JOptionPane.showMessageDialog(null, "Fullname is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(email.trim().equals("") || email.trim().equals("someone@newmail.com")){
            JOptionPane.showMessageDialog(null, "Email Address is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(phone.trim().equals("") || phone.trim().equals("0700 000 000")){
            JOptionPane.showMessageDialog(null, "Phone Number is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(password.trim().equals("") || password.trim().equals("yourpassword")){
            JOptionPane.showMessageDialog(null, "Password is required!", "Please Fill in", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            try {
                conn = DBConnection.setConnection();
                sqlQueryCheck = conn.prepareStatement("select * from tbl_managers where serial_no=? or id_no=? or email=? or phone=?");
                sqlQueryCheck.setString(1, serial);
                sqlQueryCheck.setString(2, id_no);
                sqlQueryCheck.setString(3, email);
                sqlQueryCheck.setString(4, phone);
                res = sqlQueryCheck.executeQuery();

                if(res.isBeforeFirst()) {
                    // if the credential already exist display error message
                    JOptionPane.showMessageDialog(this, "These Cridentials have been used by another manager", "Please use new Cridentials", JOptionPane.ERROR_MESSAGE);

                    // clearing neccessary fields to allow the admin to re-enter new Cridentials
                    txtSerialNo.setText("");
                    errorReg.setText(null);
                    if(txtSerialNo.getText().trim().equals("")){
                        txtSerialNo.setText("serial no.(mg1234567890)");
                        txtSerialNo.setForeground(Color.gray);
                        serialLine.setBackground(Color.black);
                    }

                    txtIdNo.setText("");
                    errorId.setText(null);
                    if(txtIdNo.getText().trim().equals("")){
                        txtIdNo.setText("id no. (123456789)");
                        txtIdNo.setForeground(Color.gray);
                        idnoLine.setBackground(Color.black);
                    }

                    txtEmail.setText("");
                    errorEmail.setText(null);
                    if(txtEmail.getText().trim().equals("")){
                        txtEmail.setText("someone@newmail.com");
                        txtEmail.setForeground(Color.gray);
                        emailLine.setBackground(Color.black);
                    }

                    txtPhone.setText("");
                    errorPhone.setText(null);
                    if(txtPhone.getText().trim().equals("")){
                        txtPhone.setText("07xxxxxxxx");
                        txtPhone.setForeground(Color.gray);
                        phoneLine.setBackground(Color.black);
                    }

                    txtSerialNo.requestFocus();
                    return;
                }else {
                    sqlQueryInsert = conn.prepareStatement("insert into tbl_managers (status,operator_id,serial_no,id_no,fullname,email,phone,gender,date_ofbirth,password) values (?,?,?,?,?,?,?,?,?,?) ");
                    sqlQueryInsert.setString(1, status);
                    sqlQueryInsert.setString(2, operator);
                    sqlQueryInsert.setString(3, serial);
                    sqlQueryInsert.setString(4, id_no);
                    sqlQueryInsert.setString(5, fullname);
                    sqlQueryInsert.setString(6, email);
                    sqlQueryInsert.setString(7, phone);
                    sqlQueryInsert.setString(8, gender);
                    sqlQueryInsert.setString(9, dob);
                    sqlQueryInsert.setString(10, password);

                    //if the record is inserted successfully the state of executeUpdate() will be 1
                    if (sqlQueryInsert.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "A New Manager Account has been created successfully.");

                        // clearing the form after successfully adding the new record in the database
                        clear_form();

                        // refresh the page
                        new Page3_Manager().setVisible(true);
                        this.dispose();

                        return;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Page3_Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if(txtPassword.getText().trim().toLowerCase().equals("yourpassword")){
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
            passwordLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if(txtPassword.getText().trim().equals("") || txtPassword.getText().trim().equals("yourpassword")){
            txtPassword.setText("yourpassword");
            txtPassword.setForeground(Color.gray);
            passwordLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        String PATTERN = "^[a-zA-Z0-9_!@#$%^&*-?]{10,30}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtPassword.getText());

        if(!match.matches()) {
            errorPassword.setText("Invalid Password/use 10 or more characters!");
        } else {
            errorPassword.setText(null);
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtSerialNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerialNoFocusGained
        if(txtSerialNo.getText().trim().toLowerCase().equals("serial no.(mg1234567890)")){
            txtSerialNo.setText("");
            txtSerialNo.setForeground(Color.black);
            serialLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtSerialNoFocusGained

    private void txtSerialNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerialNoFocusLost
        if(txtSerialNo.getText().trim().equals("") || txtSerialNo.getText().trim().equals("serial no.(mg1234567890)")){
            txtSerialNo.setText("serial no.(mg1234567890)");
            txtSerialNo.setForeground(Color.gray);
            serialLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtSerialNoFocusLost

    private void txtSerialNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerialNoKeyReleased
        String PATTERN = "^[a-z A-Z 0-9/]{0,10}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtSerialNo.getText());

        if(!match.matches()) {
            errorReg.setText("Invalid Reg No!");
        } else {
            errorReg.setText(null);
        }
    }//GEN-LAST:event_txtSerialNoKeyReleased

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        if(txtPhone.getText().trim().toLowerCase().equals("07xxxxxxxx")){
            txtPhone.setText("");
            txtPhone.setForeground(Color.black);
            phoneLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        if(txtPhone.getText().trim().equals("") || txtPhone.getText().trim().equals("07xxxxxxxx")){
            txtPhone.setText("07xxxxxxxx");
            txtPhone.setForeground(Color.gray);
            phoneLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        String PATTERN = "^[0-9]{0,10}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtPhone.getText());

        if(!match.matches()) {
            errorPhone.setText("Invalid phonenumber!");
        } else {
            errorPhone.setText(null);
        }
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtIdNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdNoFocusGained
        if(txtIdNo.getText().trim().toLowerCase().equals("id no. (123456789)")){
            txtIdNo.setText("");
            txtIdNo.setForeground(Color.black);
            idnoLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtIdNoFocusGained

    private void txtIdNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdNoFocusLost
        if(txtIdNo.getText().trim().equals("") || txtIdNo.getText().trim().equals("id no. (123456789)")){
            txtIdNo.setText("id no. (123456789)");
            txtIdNo.setForeground(Color.gray);
            idnoLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtIdNoFocusLost

    private void txtIdNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdNoKeyReleased
        String PATTERN = "^[0-9]{0,15}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtIdNo.getText());

        if(!match.matches()) {
            errorId.setText("Invalid ID Number!");
        } else {
            errorId.setText(null);
        }
    }//GEN-LAST:event_txtIdNoKeyReleased

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if(txtEmail.getText().trim().toLowerCase().equals("someone@newmail.com")){
            txtEmail.setText("");
            txtEmail.setForeground(Color.black);
            emailLine.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if(txtEmail.getText().trim().equals("") || txtEmail.getText().trim().equals("someone@newmail.com")){
            txtEmail.setText("someone@newmail.com");
            txtEmail.setForeground(Color.gray);
            emailLine.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // validating email field to ensure (@) and (.) symbol are not ommitted
        String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{1,10}[.][a-zA-Z0-9]{2,5}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtEmail.getText());

        if(!match.matches()) {
            errorEmail.setText("Invalid email address!");
        } else {
            errorEmail.setText(null);
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void GoToLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoToLogoutMouseClicked
        // operation for login out
        String SerialNo = topBarRegNo.getText();

        try {
            conn = DBConnection.setConnection();
            sqlQueryLogout = conn.prepareStatement("update tbl_admin SET status='Offline' WHERE serial_no=? ");
            sqlQueryLogout.setString(1, SerialNo);

            //if the logout is successfully the state of executeUpdate() will be 1
            if (sqlQueryLogout.executeUpdate() != 0) {
                // redirect to login
                Page1_AdminLogin login = new Page1_AdminLogin();

                // logout function
                AdminPageLogout.logMeOut(this, login);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page2_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GoToLogoutMouseClicked

    private void goToDashbordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToDashbordMouseClicked
        // Go to dashboard
        Page2_Dashboard dash = new Page2_Dashboard();
        this.dispose();
        dash.setVisible(true);
    }//GEN-LAST:event_goToDashbordMouseClicked

    private void goToManagersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToManagersMouseClicked
        // Go to manager
        Page3_Manager manager = new Page3_Manager();
        this.dispose();
        manager.setVisible(true);
    }//GEN-LAST:event_goToManagersMouseClicked

    private void goToSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToSettingsMouseClicked
        // Go to settings
        Page7_Settings settings = new Page7_Settings();
        this.dispose();
        settings.setVisible(true);
    }//GEN-LAST:event_goToSettingsMouseClicked

    private void goToRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToRoomsMouseClicked
        // Go to rooms
        Page4_Rooms rooms = new Page4_Rooms();
        this.dispose();
        rooms.setVisible(true);
    }//GEN-LAST:event_goToRoomsMouseClicked

    private void goToCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToCustomersMouseClicked
        // Go to customers
        Page5_Customer customers = new Page5_Customer();
        this.dispose();
        customers.setVisible(true);
    }//GEN-LAST:event_goToCustomersMouseClicked

    private void goToReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToReportMouseClicked
        // Go to report
        Page6_Report report = new Page6_Report();
        this.dispose();
        report.setVisible(true);
    }//GEN-LAST:event_goToReportMouseClicked

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
            java.util.logging.Logger.getLogger(Page3_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Page3_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Page3_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Page3_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Page3_Manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GoToLogout;
    private javax.swing.JButton btnAddStud;
    private javax.swing.JButton btnDelMg;
    private javax.swing.JRadioButton btnFemale;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JRadioButton btnMale;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JButton btnViewMg;
    private javax.swing.JTextField emailLine;
    private javax.swing.JLabel errorEmail;
    private javax.swing.JLabel errorFname;
    private javax.swing.JLabel errorId;
    private javax.swing.JLabel errorPassword;
    private javax.swing.JLabel errorPhone;
    private javax.swing.JLabel errorReg;
    private javax.swing.JTextField fnameLine;
    private javax.swing.JLabel goToCustomers;
    private javax.swing.JLabel goToDashbord;
    private javax.swing.JLabel goToManagers;
    private javax.swing.JLabel goToReport;
    private javax.swing.JLabel goToRooms;
    private javax.swing.JLabel goToSettings;
    private javax.swing.JTextField idnoLine;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel mgDob;
    private javax.swing.JLabel mgEmail;
    private javax.swing.JLabel mgFname;
    private javax.swing.JLabel mgGender;
    private javax.swing.JLabel mgIdNo;
    private javax.swing.JLabel mgPhone;
    private javax.swing.JLabel mgSerial;
    private javax.swing.JTextField passwordLine;
    private javax.swing.JTextField phoneLine;
    private javax.swing.JTextField serialLine;
    private javax.swing.JLabel sideBarFname;
    private javax.swing.JLabel sideBarOperator;
    private rojeru_san.complementos.RSTableMetro tbl_managers;
    private javax.swing.JLabel topBarRegNo;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtDay;
    private com.toedter.calendar.JDateChooser txtDob;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtIdNo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSerialNo;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true) {
            try {
                timeFormat = new SimpleDateFormat("hh:mm:ss a");
                time = timeFormat.format(Calendar.getInstance().getTime());
                txtTime.setText(time);

                dayFormat = new SimpleDateFormat("EEEE");
                day = dayFormat.format(Calendar.getInstance().getTime());
                txtDay.setText(day);

                dateFormat = new SimpleDateFormat("dd MMM yyyy"); // setting the time
                date = dateFormat.format(Calendar.getInstance().getTime());// getting current date
                txtDate.setText(date);// displaying the date to the user
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
