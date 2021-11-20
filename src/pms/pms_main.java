/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Crestfall
 */
public class pms_main {

    pms_global global = pms_global.INSTANCE;
    
    final static String admin = "admin";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new pms_menu_login().setVisible(true);

        // Check whether account table is empty.
        // If empty, create the first account.
        // admin || password
        try {
            // Connection
            Connection conn = DriverManager.getConnection(pms_global.pms_url);
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * from pms_user");
            if (rs.next() == false) {
                // Statements
                PreparedStatement prepstate_db = conn.prepareStatement(" insert into pms_user (email, password, rights)" + " values (?, ?, ?)");
                prepstate_db.setString(1, "admin");
                prepstate_db.setString(2, (String) "password");
                prepstate_db.setString(3, (String) "admin");
                // Logging (wtf java cmon man what the fuck)
                pms_main wtf = new pms_main();
                wtf.admin_log();                
                prepstate_db.execute();
                System.out.println("pms_user is empty.");
                JOptionPane.showMessageDialog(null, "Since there's no account in the database, an admin account has been created. email: admin || password: password");
            } else {
            }
        } catch (Exception e) {
            System.out.println("Error in creating first account.");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        try {
            // Connection
            Connection conn1 = DriverManager.getConnection(pms_global.pms_url);
            Connection conn2 = DriverManager.getConnection(pms_global.pms_url);
            Connection conn3 = DriverManager.getConnection(pms_global.pms_url);
            Statement state = conn1.createStatement();
            ResultSet rs = state.executeQuery("SELECT * from pms_settings");
            if (rs.next() == false) {
                // Statements
                PreparedStatement prepstate_db1 = conn1.prepareStatement(" insert into pms_settings (settings, value)" + " values (?, ?)");
                prepstate_db1.setString(1, "salary_basic");
                prepstate_db1.setString(2, "1000");
                prepstate_db1.execute();
                
                PreparedStatement prepstate_db2 = conn2.prepareStatement(" insert into pms_settings (settings, value)" + " values (?, ?)");
                prepstate_db2.setString(1, "salary_perday");
                prepstate_db2.setString(2, "200");
                prepstate_db2.execute();
                
                PreparedStatement prepstate_db3 = conn3.prepareStatement(" insert into pms_settings (settings, value)" + " values (?, ?)");
                prepstate_db3.setString(1, "salary_deduction");
                prepstate_db3.setString(2, "200");
                prepstate_db3.execute();
                
                System.out.println("pms_settings is empty.");
                JOptionPane.showMessageDialog(null, "Default settings not detected in database. Initialized.");
            } else {
            }
        } catch (Exception e) {
            System.out.println("Error in setting default settings.");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    // ARE YOU SERIOUS JAVA
    public void admin_log() {
        global.log(global.log_user_add, pms_global.admin);
    }

}