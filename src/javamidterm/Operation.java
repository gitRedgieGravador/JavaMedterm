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
import java.util.ArrayList;
import java.util.List;
import static javamidterm.Source.*;

/**
 *
 * @author gravadorre_sd2023
 */
public class Operation {

    public static List<String> posts = new ArrayList();

    public static void post(String username) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String content = Menu.ask("Content");
            String date = Menu.ask("Date");
            String accountQuery = "INSERT INTO `tblpost`(`Postby`, `Content`, `Dates`) VALUES ('" + username + "','" + content + "','" + date + "')";
            stmt.executeUpdate(accountQuery);
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
    }

    public static void retreive() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String accountQuery = "SELECT `Postby`, `Content`, `Dates` FROM `tblpost` WHERE 1";
            ResultSet rs = stmt.executeQuery(accountQuery);
            while (rs.next()) {
                posts.add(rs.getString("Postby"));
                posts.add(rs.getString("Content"));
                posts.add(rs.getString("Dates"));
            }
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
        }
        for (int i = 0; i < posts.size(); ++i) {
            System.out.println("Postedby: " +posts.get(i));
            System.out.println("Content: " +posts.get(i+1));
            System.out.println("Date: " +posts.get(i+2));
            i += 3;
            
        }
        posts.clear();
    }
    
    public static void update() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String Postby = Menu.ask("Postby");
            String date = Menu.ask("Date");
            
            String content = Menu.askline("New Content");
            
            String accountQuery = "UPDATE `tblpost` SET `Content`='"+content+"' WHERE Postby ='"+Postby+"' && `Dates`='"+date+"'";
            stmt.executeUpdate(accountQuery);
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
    }
    
    public static void delete() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String Postby = Menu.ask("Postby");
            String date = Menu.ask("Date");
            
            String accountQuery = "DELETE FROM `tblpost` WHERE Postby ='"+Postby+"' && `Dates`='"+date+"'";
            stmt.executeUpdate(accountQuery);
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
    }
}
