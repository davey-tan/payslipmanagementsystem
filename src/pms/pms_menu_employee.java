/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Crestfall
 */
public class pms_menu_employee extends javax.swing.JFrame {

    pms_global global = pms_global.INSTANCE;
    String url = global.pms_url;

    /**
     * Creates new form pms_menu_manager
     */
    public pms_menu_employee() {
        initComponents();
        
        pms_menu_employee_tab_yourpayslips_refresh();
        pms_menu_employee_tab_messages_refresh();
        
        pms_menu_employee_tab_messages_table_inbox.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                final int column = 0;
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row!=-1) {
                    System.out.println("Selected row: " + row);
                    String msgid = table.getValueAt(row, column).toString();
                    System.out.println("msgid:" + msgid);
                    pms_menu_message message = new pms_menu_message();
                    message.pms_menu_message_init(msgid);
                    message.setVisible(true);
                }
            }
        });

        pms_menu_employee_tab_messages_table_outbox.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                final int column = 0;
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1 && row!=-1) {
                    System.out.println("Selected row: " + row);
                    String msgid = table.getValueAt(row, column).toString();
                    System.out.println("msgid:" + msgid);
                    pms_menu_message message = new pms_menu_message();
                    message.pms_menu_message_init(msgid);
                    message.setVisible(true);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        JTabbedPane1 = new javax.swing.JTabbedPane();
        pms_menu_employee_tab_home = new javax.swing.JPanel();
        pms_menu_employee_label_name1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pms_menu_employee_label_email = new javax.swing.JLabel();
        pms_menu_employee_label_rights = new javax.swing.JLabel();
        pms_menu_employee_label_name2 = new javax.swing.JLabel();
        pms_menu_employee_label_phone = new javax.swing.JLabel();
        pms_menu_employee_label_role = new javax.swing.JLabel();
        pms_menu_employee_label_level = new javax.swing.JLabel();
        pms_menu_employee_button_changepw = new javax.swing.JButton();
        pms_menu_logout = new javax.swing.JButton();
        pms_menu_employee_tab_messages = new javax.swing.JPanel();
        pms_menu_employee_tab_messages_button_refresh = new javax.swing.JButton();
        pms_menu_employee_tab_messages_button_new = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pms_menu_employee_tab_messages_table_inbox = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pms_menu_employee_tab_messages_table_outbox = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        pms_menu_employee_tab_yourpayslips = new javax.swing.JPanel();
        pms_menu_admin_tab_employees_scroll3 = new javax.swing.JScrollPane();
        pms_menu_employee_tab_yourpayslips_table = new javax.swing.JTable();
        pms_menu_employee_tab_yourpayslips_refresh = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel2.setText("Employee Menu");

        pms_menu_employee_label_name1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        pms_menu_employee_label_name1.setText(global.get_name() + "!");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel3.setText("Welcome,");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Rights:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Name:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("Phone:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("Role:");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setText("Level:");

        pms_menu_employee_label_email.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pms_menu_employee_label_email.setText(global.get_email());
        repaint();
        revalidate();

        pms_menu_employee_label_rights.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pms_menu_employee_label_rights.setText(global.get_rights());

        pms_menu_employee_label_name2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pms_menu_employee_label_name2.setText(global.get_name());

        pms_menu_employee_label_phone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pms_menu_employee_label_phone.setText(global.get_phone());

        pms_menu_employee_label_role.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pms_menu_employee_label_role.setText(global.get_role());

        pms_menu_employee_label_level.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pms_menu_employee_label_level.setText(global.get_level());

        pms_menu_employee_button_changepw.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pms_menu_employee_button_changepw.setText("Change Password");
        pms_menu_employee_button_changepw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pms_menu_employee_button_changepwActionPerformed(evt);
            }
        });

        pms_menu_logout.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pms_menu_logout.setText("Logout");
        pms_menu_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pms_menu_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pms_menu_employee_tab_homeLayout = new javax.swing.GroupLayout(pms_menu_employee_tab_home);
        pms_menu_employee_tab_home.setLayout(pms_menu_employee_tab_homeLayout);
        pms_menu_employee_tab_homeLayout.setHorizontalGroup(
            pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pms_menu_employee_tab_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pms_menu_employee_tab_homeLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pms_menu_employee_label_name1))
                    .addGroup(pms_menu_employee_tab_homeLayout.createSequentialGroup()
                        .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(pms_menu_employee_tab_homeLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(jLabel1))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel5)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pms_menu_employee_label_email)
                            .addComponent(pms_menu_employee_label_name2)
                            .addComponent(pms_menu_employee_label_rights)
                            .addComponent(pms_menu_employee_label_phone)
                            .addComponent(pms_menu_employee_label_role)
                            .addComponent(pms_menu_employee_label_level))))
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pms_menu_employee_tab_homeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pms_menu_logout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pms_menu_employee_button_changepw)
                .addGap(60, 60, 60))
        );
        pms_menu_employee_tab_homeLayout.setVerticalGroup(
            pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pms_menu_employee_tab_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pms_menu_employee_label_name1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pms_menu_employee_label_email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pms_menu_employee_label_rights))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pms_menu_employee_label_name2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pms_menu_employee_label_phone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pms_menu_employee_label_role))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(pms_menu_employee_label_level))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pms_menu_employee_tab_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pms_menu_employee_button_changepw, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(pms_menu_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        JTabbedPane1.addTab("Home", pms_menu_employee_tab_home);

        pms_menu_employee_tab_messages_button_refresh.setText("Refresh");
        pms_menu_employee_tab_messages_button_refresh.setToolTipText("");
        pms_menu_employee_tab_messages_button_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pms_menu_employee_tab_messages_button_refreshActionPerformed(evt);
            }
        });

        pms_menu_employee_tab_messages_button_new.setText("New");
        pms_menu_employee_tab_messages_button_new.setToolTipText("");
        pms_menu_employee_tab_messages_button_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pms_menu_employee_tab_messages_button_newActionPerformed(evt);
            }
        });

        pms_menu_employee_tab_messages_table_inbox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sender", "Subject", "Timestamp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(pms_menu_employee_tab_messages_table_inbox);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Inbox", jPanel1);

        pms_menu_employee_tab_messages_table_outbox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Receiver", "Subject", "Timestamp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(pms_menu_employee_tab_messages_table_outbox);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Outbox", jPanel2);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Double-click to view a message.");

        javax.swing.GroupLayout pms_menu_employee_tab_messagesLayout = new javax.swing.GroupLayout(pms_menu_employee_tab_messages);
        pms_menu_employee_tab_messages.setLayout(pms_menu_employee_tab_messagesLayout);
        pms_menu_employee_tab_messagesLayout.setHorizontalGroup(
            pms_menu_employee_tab_messagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pms_menu_employee_tab_messagesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pms_menu_employee_tab_messagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addGroup(pms_menu_employee_tab_messagesLayout.createSequentialGroup()
                        .addComponent(pms_menu_employee_tab_messages_button_new)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pms_menu_employee_tab_messages_button_refresh)))
                .addContainerGap())
        );
        pms_menu_employee_tab_messagesLayout.setVerticalGroup(
            pms_menu_employee_tab_messagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pms_menu_employee_tab_messagesLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pms_menu_employee_tab_messagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pms_menu_employee_tab_messages_button_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pms_menu_employee_tab_messages_button_new, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        JTabbedPane1.addTab("Messages", pms_menu_employee_tab_messages);

        pms_menu_employee_tab_yourpayslips_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Email", "Timestamp", "Workdays", "Leaves", "Basic Salary", "Salary per Day", "Salary Deduction", "Net Salary", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pms_menu_employee_tab_yourpayslips_table.getTableHeader().setReorderingAllowed(false);
        pms_menu_admin_tab_employees_scroll3.setViewportView(pms_menu_employee_tab_yourpayslips_table);

        pms_menu_employee_tab_yourpayslips_refresh.setText("Refresh");
        pms_menu_employee_tab_yourpayslips_refresh.setToolTipText("");
        pms_menu_employee_tab_yourpayslips_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pms_menu_employee_tab_yourpayslips_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pms_menu_employee_tab_yourpayslipsLayout = new javax.swing.GroupLayout(pms_menu_employee_tab_yourpayslips);
        pms_menu_employee_tab_yourpayslips.setLayout(pms_menu_employee_tab_yourpayslipsLayout);
        pms_menu_employee_tab_yourpayslipsLayout.setHorizontalGroup(
            pms_menu_employee_tab_yourpayslipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pms_menu_employee_tab_yourpayslipsLayout.createSequentialGroup()
                .addContainerGap(459, Short.MAX_VALUE)
                .addComponent(pms_menu_employee_tab_yourpayslips_refresh)
                .addContainerGap())
            .addGroup(pms_menu_employee_tab_yourpayslipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pms_menu_employee_tab_yourpayslipsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pms_menu_admin_tab_employees_scroll3, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pms_menu_employee_tab_yourpayslipsLayout.setVerticalGroup(
            pms_menu_employee_tab_yourpayslipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pms_menu_employee_tab_yourpayslipsLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(pms_menu_employee_tab_yourpayslips_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
            .addGroup(pms_menu_employee_tab_yourpayslipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pms_menu_employee_tab_yourpayslipsLayout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(pms_menu_admin_tab_employees_scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );

        JTabbedPane1.addTab("Your Payslips", pms_menu_employee_tab_yourpayslips);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTabbedPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pms_menu_employee_button_changepwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pms_menu_employee_button_changepwActionPerformed
        new pms_menu_changepw1().setVisible(true);
    }//GEN-LAST:event_pms_menu_employee_button_changepwActionPerformed

    private void pms_menu_employee_tab_messages_refresh() {
        DefaultTableModel model1 = (DefaultTableModel) pms_menu_employee_tab_messages_table_inbox.getModel();
        DefaultTableModel model2 = (DefaultTableModel) pms_menu_employee_tab_messages_table_outbox.getModel();
        model1.setRowCount(0);
        model2.setRowCount(0);
        try {
            // Connections
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.prepareStatement(url);
            ResultSet rs = st.executeQuery("SELECT * from pms_messages WHERE receiver LIKE '" + global.get_email() + "'");
            // Inbox
            while (rs.next()) {
                String a = rs.getString("id");
                String b = rs.getString("sender");
                String c = rs.getString("subject");
                String d = rs.getString("timestamp");
                model1.addRow(new Object[]{a, b, c, d});
            }
            rs = st.executeQuery("SELECT * from pms_messages WHERE sender LIKE '" + global.get_email() + "'");
            while (rs.next()) {
                String a = rs.getString("id");
                String b = rs.getString("receiver");
                String c = rs.getString("subject");
                String d = rs.getString("timestamp");
                model2.addRow(new Object[]{a, b, c, d});
            }
            System.out.println("Refreshed messages from database.");
        } catch (Exception e) {
            System.out.println("Message table error.");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void pms_menu_employee_tab_messages_button_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pms_menu_employee_tab_messages_button_refreshActionPerformed
        pms_menu_employee_tab_messages_refresh();
    }//GEN-LAST:event_pms_menu_employee_tab_messages_button_refreshActionPerformed

    private void pms_menu_employee_tab_messages_button_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pms_menu_employee_tab_messages_button_newActionPerformed
        new pms_menu_newmessage().setVisible(true);
    }//GEN-LAST:event_pms_menu_employee_tab_messages_button_newActionPerformed

    private void pms_menu_employee_tab_yourpayslips_refresh() {
        DefaultTableModel model = (DefaultTableModel) pms_menu_employee_tab_yourpayslips_table.getModel();
        model.setRowCount(0);
        try {
            // CONNECTION STUFF
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.prepareStatement(url);
            ResultSet rs = st.executeQuery("SELECT * from pms_payslips WHERE email like '" + global.get_email() + "'");
            // TIME TO COPY PASTE NIGGAAAAA
            while (rs.next()) {
                String a = rs.getString("id");
                String b = rs.getString("email");
                String c = rs.getString("timestamp");
                String d = rs.getString("workdays");
                String e = rs.getString("leaves");
                String f = rs.getString("salary_basic");
                String g = rs.getString("salary_perday");
                String h = rs.getString("salary_deduction");
                String i = rs.getString("salary_net");
                String j = rs.getString("description");
                model.addRow(new Object[]{a, b, c, d, e, f, g, h, i, j});
            }
        } catch (Exception e) {
            System.out.println("Employee [" + global.get_email() + "]'s payslip table refresh error.");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void pms_menu_employee_tab_yourpayslips_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pms_menu_employee_tab_yourpayslips_refreshActionPerformed
        pms_menu_employee_tab_yourpayslips_refresh();
    }//GEN-LAST:event_pms_menu_employee_tab_yourpayslips_refreshActionPerformed

    private void pms_menu_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pms_menu_logoutActionPerformed
        logout();
    }//GEN-LAST:event_pms_menu_logoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        logout();
    }//GEN-LAST:event_formWindowClosing

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Warning", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            global.logout();
            dispose();
        }
    }
    
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
            java.util.logging.Logger.getLogger(pms_menu_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pms_menu_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pms_menu_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pms_menu_employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pms_menu_employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane pms_menu_admin_tab_employees_scroll3;
    private javax.swing.JButton pms_menu_employee_button_changepw;
    private javax.swing.JLabel pms_menu_employee_label_email;
    private javax.swing.JLabel pms_menu_employee_label_level;
    private javax.swing.JLabel pms_menu_employee_label_name1;
    private javax.swing.JLabel pms_menu_employee_label_name2;
    private javax.swing.JLabel pms_menu_employee_label_phone;
    private javax.swing.JLabel pms_menu_employee_label_rights;
    private javax.swing.JLabel pms_menu_employee_label_role;
    private javax.swing.JPanel pms_menu_employee_tab_home;
    private javax.swing.JPanel pms_menu_employee_tab_messages;
    private javax.swing.JButton pms_menu_employee_tab_messages_button_new;
    private javax.swing.JButton pms_menu_employee_tab_messages_button_refresh;
    private javax.swing.JTable pms_menu_employee_tab_messages_table_inbox;
    private javax.swing.JTable pms_menu_employee_tab_messages_table_outbox;
    private javax.swing.JPanel pms_menu_employee_tab_yourpayslips;
    private javax.swing.JButton pms_menu_employee_tab_yourpayslips_refresh;
    private javax.swing.JTable pms_menu_employee_tab_yourpayslips_table;
    private javax.swing.JButton pms_menu_logout;
    // End of variables declaration//GEN-END:variables
}
