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
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Crestfall
 */
public enum pms_global {
    INSTANCE;

    // Workaround for pms_main
    static String admin = "admin";

    // DATA STRINGS
    static String pms_url = "jdbc:mysql://localhost:3306/payslipmanagementsystem?user=root";
    private String pms_session_email;
    private String pms_session_rights;
    private String pms_session_name;
    private String pms_session_phone;
    private String pms_session_role;
    private String pms_session_level;

    // LOG CODES
    static String log_user_login = "USER_LOGIN";
    static String log_user_logout = "USER_LOGIN";
    static String log_user_add = "USER_ADD";
    static String log_user_delete = "USER_DELETE";
    static String log_user_reset = "USER_RESET";
    static String log_user_changepw = "USER_CHANGEPASSWORD";
    static String log_user_message = "USER_MESSAGE";
    static String log_user_edit = "USER_EDIT";
    static String log_user_payslip_add = "USER_PAYSLIP_ADD";
    static String log_user_payslip_delete = "USER_PAYSLIP_DELETE";
    static String log_clear = "LOG_CLEAR";

    public void set_email(String n) {
        this.pms_session_name = n;
    }

    public String get_email() {
        return pms_session_email;
    }

    public void set_rights(String n) {
        this.pms_session_rights = n;
    }

    public String get_rights() {
        return pms_session_rights;
    }

    public void set_name(String n) {
        this.pms_session_name = n;
    }

    public String get_name() {
        return pms_session_name;
    }

    public void set_phone(String n) {
        this.pms_session_phone = n;
    }

    public String get_phone() {
        return pms_session_phone;
    }

    public void set_role(String n) {
        this.pms_session_role = n;
    }

    public String get_role() {
        return pms_session_role;
    }

    public void set_level(String n) {
        this.pms_session_level = n;
    }

    public String get_level() {
        return pms_session_level;
    }

    public void clear_data() {
        this.pms_session_email = null;
        this.pms_session_rights = null;
        this.pms_session_name = null;
        this.pms_session_phone = null;
        this.pms_session_role = null;
        this.pms_session_level = null;
    }

    public void logout() {
        pms_global global = pms_global.INSTANCE;
        global.log(global.log_user_logout, null);
        global.set_data(null);
        new pms_menu_login().setVisible(true);
    }

    public void set_data(String n) {
        if (n == null) {
            this.clear_data();
        } else {
            this.pms_session_email = n;
            try {

                // CONNECTION STUFF
                Connection conn = DriverManager.getConnection(this.pms_url);
                Statement st = conn.prepareStatement(this.pms_url);
                ResultSet rs = st.executeQuery("SELECT * from pms_user WHERE email='" + n + "'");
                rs.first();

                // LETS GET SOME SHIT
                this.set_rights(rs.getString("rights"));
                this.set_name(rs.getString("name"));
                this.set_phone(rs.getString("phone"));
                this.set_role(rs.getString("role"));
                this.set_level(rs.getString("level"));

                System.out.println("THIS SESSION BELONGS TO [" + n + "]");
                conn.close();
            } catch (Exception e) {
                System.out.println("WHAAAATTT YOU GOTTA BE KIDDING MEEE EVEN THE SESSION SYSTEM IS BROKEN");
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void log(String a, String b) {
        pms_global global = pms_global.INSTANCE;
        String url = global.pms_url;
        try {
            // Connection
            Connection conn = DriverManager.getConnection(url);
            // Date
            Date date = new java.util.Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            // Logging
            PreparedStatement prepstate_log = conn.prepareStatement(" insert into pms_log (email, timestamp, activity, description)" + " values (?, ?, ?, ?)");
            prepstate_log.setString(1, global.get_email());
            prepstate_log.setString(2, ts.toString());
            prepstate_log.setString(3, a);
            prepstate_log.setString(4, b);
            prepstate_log.execute();
            System.out.println("Log: " + global.get_email() + ", " + ts.toString() + ", " + a + ", " + b + ".");
        } catch (Exception e) {
            System.out.println("Log error.");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
