
package systemacontrol.base_datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel
 */
public class Conexion {
    
    public static Connection MySQLConnect() {
        
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost:3306/syscontrol";
            String usuario = "root";
            String pass = "";
            
            conexion = DriverManager.getConnection(servidor, usuario, pass);
            
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en el Driver de la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            JOptionPane.showMessageDialog(null, "Conexión Exitosa");
            return conexion;
        }
        
    }
    
    
    
}
