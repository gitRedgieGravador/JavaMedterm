/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamidterm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javamidterm.Source.*;

/**
 *
 * @author gravadorre_sd2023
 */
public class Account {
    public static String user = null;

    public static int registrer() {
        Connection conn = null;
        Statement stmt = null;
        String username = null, password = null, conpass;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            System.out.println("=================== Register Account ===================");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            username = Menu.ask("Username");
            boolean notpass = true;
            while (notpass) {
                password = Menu.ask("Password");
                conpass = Menu.ask("Confirm Password");
                if (password.equals(conpass)) {
                    notpass = false;
                }
            }
            String accountUpdate = "INSERT INTO `tblaccounts`(`Usernames`, `Passwords`) VALUES ('" + username + "','" + password + "')";
            stmt.executeUpdate(accountUpdate);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try

        System.out.println("=================== done! ===================");
        return getAccId(username);
    }
    public static boolean login() {
        Connection conn = null;
        Statement stmt = null;
        String logpassword = null, password = "initial", username = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            username = Menu.ask("username");
            password = Menu.ask("password");
            
            String accountQuery = "SELECT `Passwords` FROM `tblaccounts` WHERE Usernames = '" + username + "'";
            ResultSet rs = stmt.executeQuery(accountQuery);

            while (rs.next()) {
                logpassword = rs.getString("Passwords");
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try
        if (logpassword.equals(password)){
            user = username;
            return true;
        }else{
            return false;
        }
    }

    public static int getAccId(String username) {
        Connection conn = null;
        Statement stmt = null;
        int retrieve_id = 1;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountQuery = "SELECT idaccount FROM tblaccounts WHERE usernames = '" + username + "'";

            ResultSet rs = stmt.executeQuery(accountQuery);
            //System.out.println("this" + rs.getInt("IDAccount"));

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                retrieve_id = rs.getInt("IDAccount");
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                System.out.println(se2);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println(se);
            }//end finally try
        }//end try

        return retrieve_id;
    }
}
