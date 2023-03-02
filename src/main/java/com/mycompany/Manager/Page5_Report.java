/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Manager;

import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.mycompany.Database.DBConnection;
import com.mycompany.Database.ManagerCredentials;
import com.mycompany.Database.ManagerPageLogout;
import java.awt.Color;
import java.io.FileNotFoundException;
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
public class Page5_Report extends javax.swing.JFrame implements Runnable {
    SimpleDateFormat timeFormat;// setting variable for time Format
    SimpleDateFormat dayFormat;// setting variable for day Format
    SimpleDateFormat dateFormat;// setting variable for date Format
    String time; // setting variable for current time
    String day; // setting variable for day
    String date; // setting variable for date
    
    /**
     * Creates new form Page2_Dashboard
     */
    public Page5_Report() {
        initComponents();
        rooms_table();
        customer_table();

        // center the form
        this.setLocationRelativeTo(this);
        
        Thread t = new Thread(this);
        t.start();
        
        roomReport.setVisible(true);
        clientsReport.setVisible(false);
        
        // displaying users info
        sideBarFname.setText(ManagerCredentials.fullname);
        sideBarOperator.setText(ManagerCredentials.operator_id); 
        topBarRegNo.setText(ManagerCredentials.serial_no);
    }
    
    // universal variables
    SimpleDateFormat dateofbirth; 
    
    DefaultTableModel defaulttbl_1_roomtbl;
    DefaultTableModel defaulttbl_2_clienttbl;
    
    PreparedStatement sqlQueryCheck;
    PreparedStatement sqlQueryInsert;
    PreparedStatement sqlQueryLogout;
    ResultSet res;
    Connection conn;
    
    private void rooms_table() {
        try {
            conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_rooms");
            res = sqlQueryCheck.executeQuery();
            
            while(res.next()) {
                String rmId     = res.getString("id");
                String rmNumber = res.getString("room_no");
                String rmType   = res.getString("room_type");
                String rmBed    = res.getString("bed");
                String rmPrice  = res.getString("price");
                String rmStatus = res.getString("status");
                
                Object[] obj = {rmId, rmNumber, rmType, rmBed, rmPrice, rmStatus};
                
                defaulttbl_1_roomtbl = (DefaultTableModel)tbl_rooms.getModel();
                defaulttbl_1_roomtbl.addRow(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page5_Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void customer_table() {
        try {
            conn = DBConnection.setConnection();
            sqlQueryCheck = conn.prepareStatement("select * from tbl_customers_records");
            res = sqlQueryCheck.executeQuery();
            
            while(res.next()) {
                String recId       = res.getString("id");
                String recName     = res.getString("fullName");
                String recNation   = res.getString("nationality");
                String recGender   = res.getString("gender");
                String recPhone    = "0"+res.getString("phone");
                String recRoom     = res.getString("roomNo");
                String recPrice    = res.getString("price");
                String recDuration = res.getString("duration");
                String recCost     = res.getString("stayingCost");
                
                Object[] obj = {recId, recName, recNation, recGender, recPhone, recRoom, recPrice, recDuration, recCost};
                
                defaulttbl_2_clienttbl = (DefaultTableModel)tbl_client.getModel();
                defaulttbl_2_clienttbl.addRow(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page5_Report.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        topBarRegNo = new javax.swing.JLabel();
        txtDay = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_rooms = new rojeru_san.complementos.RSTableMetro();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_client = new rojeru_san.complementos.RSTableMetro();
        jPanel25 = new javax.swing.JPanel();
        btnShowAll = new javax.swing.JButton();
        btnViewMg = new javax.swing.JButton();
        roomReport = new javax.swing.JButton();
        clientsReport = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
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
        jLabel17.setText("Generate Report");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 190, 30));

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_rooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Room No", "Type", "Bed", "Price", "Status"
            }
        ));
        tbl_rooms.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_rooms.setColorBordeHead(new java.awt.Color(0, 112, 192));
        tbl_rooms.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_rooms.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_rooms.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_rooms.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_rooms.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_rooms.setFuenteHead(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_rooms.setGrosorBordeFilas(0);
        tbl_rooms.setGrosorBordeHead(0);
        tbl_rooms.setMultipleSeleccion(false);
        tbl_rooms.setRowHeight(25);
        tbl_rooms.setShowHorizontalLines(false);
        tbl_rooms.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tbl_rooms);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_client.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Name", "Nationality", "Gender", "Phone", "Room", "Price", "Duration", "Cost"
            }
        ));
        tbl_client.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tbl_client.setColorBordeHead(new java.awt.Color(0, 112, 192));
        tbl_client.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_client.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_client.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_client.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_client.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_client.setFuenteHead(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbl_client.setGrosorBordeFilas(0);
        tbl_client.setGrosorBordeHead(0);
        tbl_client.setMultipleSeleccion(false);
        tbl_client.setRowHeight(25);
        tbl_client.setShowHorizontalLines(false);
        tbl_client.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tbl_client);
        if (tbl_client.getColumnModel().getColumnCount() > 0) {
            tbl_client.getColumnModel().getColumn(5).setHeaderValue("Room");
            tbl_client.getColumnModel().getColumn(6).setHeaderValue("Price");
            tbl_client.getColumnModel().getColumn(7).setHeaderValue("Duration");
            tbl_client.getColumnModel().getColumn(8).setHeaderValue("Cost");
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel11.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 590, 420));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 145, 590, 390));

        jPanel25.setOpaque(false);
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnShowAll.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnShowAll.setText("Rooms");
        btnShowAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });
        jPanel25.add(btnShowAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        btnViewMg.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnViewMg.setText("Clients");
        btnViewMg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewMg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMgActionPerformed(evt);
            }
        });
        jPanel25.add(btnViewMg, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 90, 30));

        roomReport.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        roomReport.setText("Generate Report");
        roomReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomReportActionPerformed(evt);
            }
        });
        jPanel25.add(roomReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 120, 30));

        clientsReport.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        clientsReport.setText("Generate Report");
        clientsReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clientsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsReportActionPerformed(evt);
            }
        });
        jPanel25.add(clientsReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 120, 30));

        jPanel1.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 105, 590, 32));

        jPanel12.setBackground(java.awt.SystemColor.textHighlight);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Greens");
        jPanel13.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 0, 70, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Milimani");
        jPanel13.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, -1, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 17, 170, -1));

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

        jPanel12.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 60));

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

        jPanel12.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 150, 30));

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

        jPanel12.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 30));

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

        jPanel12.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 150, 30));

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

        jPanel12.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 150, 30));

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

        jPanel12.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 30));

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

        jPanel12.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 150, 30));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 550));

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
        
        roomReport.setVisible(true);
        clientsReport.setVisible(false);
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnViewMgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMgActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        
        roomReport.setVisible(false);
        clientsReport.setVisible(true);
    }//GEN-LAST:event_btnViewMgActionPerformed

    /**
     * customized function
     */ 
    
    // tbl stylling
    static Cell tblCellHerder(String textValue){
        return new Cell().add(textValue)
                .setBorder(Border.NO_BORDER)
                .setFontSize(11f)
                .setBold()
                .setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(new DeviceRgb(255, 255, 255));
    }

    // tbl stylling
    static Cell tblCellValue(String textValue){
        return new Cell().add(textValue).setBorder(Border.NO_BORDER).setFontSize(9f);
    }
    
    
    private void roomReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomReportActionPerformed
        // generate report for Rooms
        try {
            String path             = "room_report.pdf";
            PdfWriter pdfWriter     = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document       = new Document(pdfDocument);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            
            // setting variables
            float col            = 280f;
            float columnWidth[]  = {col, col};
            float columnWidth2[] = {col, col, col, col, col, col};
            float colWidth[]     = {380, 110, 70};
            
            //============== Report Header ===============
            Table tbl1 = new Table(columnWidth);
            tbl1.setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(new DeviceRgb(255, 255, 255));
            tbl1.addCell(new Cell().add("REPORT")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setPaddingTop(25f)
                    .setPaddingLeft(25f)
                    .setPaddingBottom(25f)
                    .setFontSize(17f)
                    .setBold()
                    .setBorder(Border.NO_BORDER)
            );
            
            tbl1.addCell(new Cell().add("Milimani Greens System\n Room Report\n 123654789")
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)                    
                    .setPaddingTop(25f)
                    .setPaddingBottom(25f)
                    .setPaddingRight(20f)
                    .setFontSize(12f)
                    .setBorder(Border.NO_BORDER)
            );
            
            //============== Report Body ===============
            Table tbl = new Table(columnWidth2);
            
            // adding header
            tbl.addCell(tblCellHerder("#"));
            tbl.addCell(tblCellHerder("Room No"));
            tbl.addCell(tblCellHerder("Type"));
            tbl.addCell(tblCellHerder("Bed"));
            tbl.addCell(tblCellHerder("Price"));
            tbl.addCell(tblCellHerder("Status"));
            
            for (int i = 0; i < tbl_rooms.getRowCount(); i++) {
                String No       = tbl_rooms.getValueAt(i, 0).toString();
                String RoomNo   = tbl_rooms.getValueAt(i, 1).toString();
                String RoomType = tbl_rooms.getValueAt(i, 2).toString();
                String Bed      = tbl_rooms.getValueAt(i, 3).toString();
                String Price    = tbl_rooms.getValueAt(i, 4).toString();
                String Status   = tbl_rooms.getValueAt(i, 5).toString();
                
                tbl.addCell(tblCellValue(No));
                tbl.addCell(tblCellValue(RoomNo));
                tbl.addCell(tblCellValue(RoomType));
                tbl.addCell(tblCellValue(Bed));
                tbl.addCell(tblCellValue(Price));
                tbl.addCell(tblCellValue(Status));
            }
            
            //============== Details Section ===============
            Table infoTbl = new Table(colWidth);
            
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            time = timeFormat.format(Calendar.getInstance().getTime());

            dateFormat = new SimpleDateFormat("dd MMM yyyy"); 
            date = dateFormat.format(Calendar.getInstance().getTime());
            
            infoTbl.addCell(new Cell().add("Milimani Greens Hotel").setFontSize(12f).setBold().setBorder(Border.NO_BORDER));
            
            infoTbl.addCell(new Cell().add("DATE").setFontSize(9f).setBold().setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
            infoTbl.addCell(new Cell().add(date).setFontSize(9f).setTextAlignment(TextAlignment.RIGHT).setPaddingRight(5f).setBorder(Border.NO_BORDER));
            
            infoTbl.addCell(new Cell().add("A hotel room is a substitute for the home. ").setFontSize(9f).setBorder(Border.NO_BORDER));
            
            infoTbl.addCell(new Cell().add("TIME").setFontSize(9f).setBold().setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));            
            infoTbl.addCell(new Cell().add(time).setFontSize(9f).setTextAlignment(TextAlignment.RIGHT).setPaddingRight(5f).setBorder(Border.NO_BORDER));
            
            
            document.add(tbl1);
            document.add(new Paragraph("\n"));
            document.add(tbl);
            document.add(new Paragraph("\n"));
            document.add(infoTbl);
            document.close();
            
            JOptionPane.showMessageDialog(null, "Room Report has been Generated Successfully");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Page5_Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_roomReportActionPerformed

    private void clientsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsReportActionPerformed
        // generate report for Clients        
        try {
            String path             = "clients_report.pdf";
            PdfWriter pdfWriter     = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document       = new Document(pdfDocument);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            
            // setting variables
            float col            = 280f;
            float columnWidth[]  = {col, col};
            float columnWidth2[] = {col, col, col, col, col, col, col, col, col};
            float colWidth[]     = {380, 110, 70};
            
            //============== Report Header ===============
            Table tbl1 = new Table(columnWidth);
            tbl1.setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(new DeviceRgb(255, 255, 255));
            tbl1.addCell(new Cell().add("REPORT")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setPaddingTop(25f)
                    .setPaddingLeft(25f)
                    .setPaddingBottom(25f)
                    .setFontSize(17f)
                    .setBold()
                    .setBorder(Border.NO_BORDER)
            );
            
            tbl1.addCell(new Cell().add("Milimani Greens System\n Room Report\n 123654789")
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)                    
                    .setPaddingTop(25f)
                    .setPaddingBottom(25f)
                    .setPaddingRight(20f)
                    .setFontSize(12f)
                    .setBorder(Border.NO_BORDER)
            );
            
            //============== Report Body ===============
            Table tbl = new Table(columnWidth2);
            
            // adding header
            tbl.addCell(tblCellHerder("#"));
            tbl.addCell(tblCellHerder("Clients"));
            tbl.addCell(tblCellHerder("Nationality"));
            tbl.addCell(tblCellHerder("Gender"));
            tbl.addCell(tblCellHerder("Phone"));
            tbl.addCell(tblCellHerder("Room"));
            tbl.addCell(tblCellHerder("Price"));
            tbl.addCell(tblCellHerder("Duration"));
            tbl.addCell(tblCellHerder("Cost"));
            
            for (int i = 0; i < tbl_client.getRowCount(); i++) {
                String Id       = tbl_client.getValueAt(i, 0).toString();
                String fullName = tbl_client.getValueAt(i, 1).toString();
                String Nation   = tbl_client.getValueAt(i, 2).toString();
                String Gender   = tbl_client.getValueAt(i, 3).toString();
                String Phone    = tbl_client.getValueAt(i, 4).toString();
                String RoomNo   = tbl_client.getValueAt(i, 5).toString();
                String Price    = tbl_client.getValueAt(i, 6).toString();
                String Duration = tbl_client.getValueAt(i, 7).toString();
                String Cost     = tbl_client.getValueAt(i, 8).toString();
                
                tbl.addCell(tblCellValue(Id));
                tbl.addCell(tblCellValue(fullName));
                tbl.addCell(tblCellValue(Nation));
                tbl.addCell(tblCellValue(Gender));
                tbl.addCell(tblCellValue(Phone));
                tbl.addCell(tblCellValue(RoomNo));
                tbl.addCell(tblCellValue(Price));
                tbl.addCell(tblCellValue(Duration));
                tbl.addCell(tblCellValue(Cost));
            }
            
            //============== Details Section ===============
            Table infoTbl = new Table(colWidth);
            
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            time = timeFormat.format(Calendar.getInstance().getTime());

            dateFormat = new SimpleDateFormat("dd MMM yyyy"); 
            date = dateFormat.format(Calendar.getInstance().getTime());
            
            infoTbl.addCell(new Cell().add("Milimani Greens Hotel").setFontSize(12f).setBold().setBorder(Border.NO_BORDER));
            
            infoTbl.addCell(new Cell().add("DATE").setFontSize(9f).setBold().setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
            infoTbl.addCell(new Cell().add(date).setFontSize(9f).setTextAlignment(TextAlignment.RIGHT).setPaddingRight(5f).setBorder(Border.NO_BORDER));
            
            infoTbl.addCell(new Cell().add("A hotel room is a substitute for the home. ").setFontSize(9f).setBorder(Border.NO_BORDER));
            
            infoTbl.addCell(new Cell().add("TIME").setFontSize(9f).setBold().setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));            
            infoTbl.addCell(new Cell().add(time).setFontSize(9f).setTextAlignment(TextAlignment.RIGHT).setPaddingRight(5f).setBorder(Border.NO_BORDER));
            
            
            document.add(tbl1);
            document.add(new Paragraph("\n"));
            document.add(tbl);
            document.add(new Paragraph("\n"));
            document.add(infoTbl);
            document.close();
            
            JOptionPane.showMessageDialog(null, "Clients Report has been Generated Successfully");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Page5_Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_clientsReportActionPerformed

    private void GoToLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoToLogoutMouseClicked
        // operation for login out
        String SerialNo = topBarRegNo.getText();

        try {
            conn = DBConnection.setConnection();
            sqlQueryLogout = conn.prepareStatement("update tbl_managers SET status='Offline' WHERE serial_no=? ");
            sqlQueryLogout.setString(1, SerialNo);

            //if the logout is successfully the state of executeUpdate() will be 1
            if (sqlQueryLogout.executeUpdate() != 0) {
                // redirect to login
                Page1_ManagerLogin login = new Page1_ManagerLogin();

                // logout function
                ManagerPageLogout.logMeOut(this, login);
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

    private void goToSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToSettingsMouseClicked
        // Go to settings
        Page6_Settings settings = new Page6_Settings();
        this.dispose();
        settings.setVisible(true);
    }//GEN-LAST:event_goToSettingsMouseClicked

    private void goToRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToRoomsMouseClicked
        // Go to rooms
        Page3_Rooms rooms = new Page3_Rooms();
        this.dispose();
        rooms.setVisible(true);
    }//GEN-LAST:event_goToRoomsMouseClicked

    private void goToCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToCustomersMouseClicked
        // Go to customers
        Page4_Customer customers = new Page4_Customer();
        this.dispose();
        customers.setVisible(true);
    }//GEN-LAST:event_goToCustomersMouseClicked

    private void goToReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToReportMouseClicked
        // Go to report
        Page5_Report report = new Page5_Report();
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
            java.util.logging.Logger.getLogger(Page5_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Page5_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Page5_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Page5_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Page5_Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GoToLogout;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JButton btnViewMg;
    private javax.swing.JButton clientsReport;
    private javax.swing.JLabel goToCustomers;
    private javax.swing.JLabel goToDashbord;
    private javax.swing.JLabel goToReport;
    private javax.swing.JLabel goToRooms;
    private javax.swing.JLabel goToSettings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton roomReport;
    private javax.swing.JLabel sideBarFname;
    private javax.swing.JLabel sideBarOperator;
    private rojeru_san.complementos.RSTableMetro tbl_client;
    private rojeru_san.complementos.RSTableMetro tbl_rooms;
    private javax.swing.JLabel topBarRegNo;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtDay;
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
