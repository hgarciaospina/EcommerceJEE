package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HENRY
 */
public class DBConnect {
    public static Connection myConnection(){
        try {
            Class.forName("com.mysql.jdbc.driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Leandro2009");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
