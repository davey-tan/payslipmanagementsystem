/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Crestfall
 */
public class pms_menu_payslip_delete extends javax.swing.JFrame {

    pms_global global = pms_global.INSTANCE;
    String url = global.pms_url;

    String currentemail;

    private void set_email(String n) {
        currentemail = n;
    }

    private String get_email() {
        return currentemail;
    }

    /**
     * Creates new form pms_menu_admin_add
     */
    public void pms_menu_payslip_delete_init(String n) {
        initComponents();
        this.getRootPane().setDefaultButton(pms_menu_admin_payslip_delete_button_delete);
        this.set_email(n);
        pms_menu_admin_payslip_delete_combo_refresh();
    }

    private void pms_menu_admin_payslip_delete_combo_refresh() {
        pms_menu_admin_payslip_delete_combo.removeAllItems();
        // Get combobox value from database
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.prepareStatement(url);
            ResultSet rs = st.executeQuery("select id from pms_payslips where email = '" + this.get_email() + "'");
            while (rs.next()) {
                pms_menu_admin_payslip_delete_combo.addItem(rs.getString("id"));
            }
        } catch (Exception e) {
            System.out.println("Error in getting items from combo.");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pms_menu_admin_payslip_delete_button_delete = new javax.swing.JButton();
        pms_menu_admin_payslip_delete_combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel2.setText("Delete");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Payslip ID:");

        pms_menu_admin_payslip_delete_button_delete.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pms_menu_admin_payslip_delete_button_delete.setText("Delete");
        pms_menu_admin_payslip_delete_button_delete.setToolTipText("Submit to database.");
        pms_menu_admin_payslip_delete_button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pms_menu_admin_payslip_delete_button_deleteActionPerformed(evt);
            }
        });

        pms_menu_admin_payslip_delete_combo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pms_menu_admin_payslip_delete_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT--" }));
        pms_menu_admin_payslip_delete_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pms_menu_admin_payslip_delete_comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pms_menu_admin_payslip_delete_button_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(pms_menu_admin_payslip_delete_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pms_menu_admin_payslip_delete_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pms_menu_admin_payslip_delete_button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pms_menu_admin_payslip_delete_button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pms_menu_admin_payslip_delete_button_deleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete payslip?", "Warning", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            try {
                // Connection
                Connection conn = DriverManager.getConnection(url);
                Statement st = conn.prepareStatement(url);
                st.execute("DELETE FROM pms_payslips WHERE id = '" + pms_menu_admin_payslip_delete_combo.getSelectedItem().toString() + "'");
                global.log(global.log_user_payslip_delete, pms_menu_admin_payslip_delete_combo.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Deleted payslip!");
                dispose();
            } catch (Exception e) {
                System.out.println("Error in deleting payslip");
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }//GEN-LAST:event_pms_menu_admin_payslip_delete_button_deleteActionPerformed
    }
    private void pms_menu_admin_payslip_delete_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pms_menu_admin_payslip_delete_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pms_menu_admin_payslip_delete_comboActionPerformed

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
            java.util.logging.Logger.getLogger(pms_menu_payslip_delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pms_menu_payslip_delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pms_menu_payslip_delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pms_menu_payslip_delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new pms_menu_payslip_delete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton pms_menu_admin_payslip_delete_button_delete;
    private javax.swing.JComboBox<String> pms_menu_admin_payslip_delete_combo;
    // End of variables declaration//GEN-END:variables

}
