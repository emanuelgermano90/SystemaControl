/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemacontrol.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javax.swing.JOptionPane;

import systemacontrol.base_datos.consultas;

/**
 *
 * @author Emanuel
 */
public class FrmPrincipalController implements Initializable {

    //comienza buscar producto
    @FXML
    private TextField txtMarca;
    @FXML
    private ComboBox<String> cbMarca;
    @FXML
    private TextField txtCod;
    @FXML
    private TextField txtProd;
    @FXML
    private TextField txtTalle;
    @FXML
    private TextField txtCant;
    @FXML
    private TextField txtPrecio;
    //finaliza buscar producto
    //comienza tabla producto
    @FXML
    private TableView<?> tblProductos;
    @FXML
    private TableColumn<?, ?> tblProdID;
    @FXML
    private TableColumn<?, ?> tblProdMarca;
    @FXML
    private TableColumn<?, ?> tblProdProd;
    @FXML
    private TableColumn<?, ?> tblProdTalle;
    @FXML
    private TableColumn<?, ?> tblProdCod;
    @FXML
    private TableColumn<?, ?> tblProdCant;
    @FXML
    private TableColumn<?, ?> tblProdPre;
    //finaliza tabla producto

    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        try{
            
            MarcasDes();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "error: " + e.getMessage());
        }
        
    }    

    

    @FXML
    private void btnAgrePro(ActionEvent event) throws SQLException {
        
        String MarcaSelec = cbMarca.getValue();
        Double pre = Double.parseDouble(txtPrecio.getText());
        Integer talle = Integer.parseInt(txtTalle.getText());
        Integer cantidad = Integer.parseInt(txtCant.getText());
        
        consultas.AgreProducto(MarcaSelec, txtProd.getText(), talle, txtCod.getText(), cantidad, pre);
        
        limpiarCamposProd();
        
        JOptionPane.showMessageDialog(null, "Se agrego: " + txtProd.getText() + " " + txtTalle.getText());
        
    }

    @FXML
    private void btnAgreMarca(ActionEvent event) throws SQLException {
        
        consultas.AgreMarca(txtMarca.getText());
        
        JOptionPane.showMessageDialog(null, "se agrego la marca: " + txtMarca.getText());
        
        MarcasDes(); //ver como actualizar el combobox de marcas
        
    }
    
    public void MarcasDes() throws SQLException{
        
        consultas c = new consultas();
        ObservableList<String> obsMarcas = c.getMarcas();
        this.cbMarca.setItems(obsMarcas);
        
        
    }
    
    private void limpiarCamposProd(){
            
        this.cbMarca.setValue("");
        this.txtCant.setText("");
        this.txtCod.setText("");
        this.txtMarca.setText("");
        this.txtPrecio.setText("");
        this.txtProd.setText("");
        this.txtTalle.setText("");
        
    }
    
}
