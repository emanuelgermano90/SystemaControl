/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemacontrol.base_datos;


import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Emanuel
 */
public class consultas extends Conexion {
    
    private String marca;
    private String producto;
    private int talle;
    private String codigo;
    private int cantidad;
    private double precio;
    
    
    
    
    
    public consultas(){
        
        
    }
    
    
    public consultas(String mar){
        
        this.marca = mar;
        
    }
    
    
    
    public consultas(String marca, String producto, int talle, String codigo, int cantidad, double precio){
        
        this.marca = marca;
        this.producto = producto;
        this.talle = talle;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        
    }
    
        
    public static void AgreProducto(String marca, String producto, int talle, String codigo, int cantidad, double precio) throws SQLException {
        
        String insertar = "INSERT INTO sysger(marca, prod, talle, cod, cant, precio)" + 
                            "VALUES (" + "'" + marca + "',"
                                       + "'" + producto + "',"
                                       + "'" + talle + "',"
                                       + "'" + codigo + "',"
                                       + "'" + cantidad + "',"
                                       + "'" + precio + "');";
        
        Statement insertPro = Conexion.MySQLConnect().createStatement();
        insertPro.execute(insertar);
        
        insertPro.close();
        Conexion.MySQLConnect().close();
        
    }
    
    public static void AgreMarca(String marca) throws SQLException{
        
        String agreMarca = "INSERT INTO marcas(marca) VALUES ('" + marca + "');";
        
        Statement agreM = Conexion.MySQLConnect().createStatement();
        agreM.execute(agreMarca);
        
        agreM.close();
        Conexion.MySQLConnect().close();
        
    }
    
    public ArrayList<consultas> listaDatos() throws SQLException {
        
        //creo el array para almacenar los datos de la DB
        ArrayList<consultas> array = new ArrayList<consultas>();
        
        
        
        //creo la consulta
        String con = "SELECT * FROM marcas;";
        Statement stCon;
        
        try {
            stCon = Conexion.MySQLConnect().createStatement();
            ResultSet rs = stCon.executeQuery(con);
            
            //bucle que recorre la DB
            while (rs.next()){
                array.add( new consultas(rs.getString("marca")));
            }
            
        }catch (SQLException ex) {
            
            //exepcion de error a conexion DB
            System.out.println("Error: " + ex.getMessage());
            
        }
        
                
        return array;
    }
    
    public ObservableList<String> getMarcas() {
        
        ObservableList<String> list = FXCollections.observableArrayList();
        
        String tabla = "SELECT * FROM marcas;";
        
        try {
            
            Statement st = Conexion.MySQLConnect().createStatement();
            ResultSet rs = st.executeQuery(tabla);
            
            while(rs.next()){
                
                String car = rs.getString("marca");
                
                list.add(car);
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
        
    }
    
    
}
