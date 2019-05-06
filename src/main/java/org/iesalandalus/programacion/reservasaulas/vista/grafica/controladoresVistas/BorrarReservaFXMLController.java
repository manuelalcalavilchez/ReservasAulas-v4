/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista.grafica.controladoresVistas;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.utilidades.Dialogos;



/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class BorrarReservaFXMLController implements Initializable {

private ObservableList<Reserva> reservas;
private IControladorReservasAulas controladorMVC;
    
     
      public void setControladorMVC(IControladorReservasAulas controlador) 
    {   
        controladorMVC = controlador;        
    }        
         //para agrupar los radiobutton y que hagan visibles o invisibles los gridpane
    //declaro los elementos con los que cuento
    private ToggleGroup tgTipoReserva;
    
    
    @FXML
    private RadioButton rbHora;
     @FXML
    private RadioButton rbTramo;
     @FXML
    private DatePicker fecha;
     @FXML
    private TextField Hora;
     @FXML
    private Label labelDia;
     @FXML
    private Label labelDiaHora;
     @FXML
    private Label labelDiaTramo;
     @FXML
    private Label labelTramo;
     @FXML
    private DatePicker fechaTramo;
     @FXML
    private ChoiceBox selecTramo;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
         
    }    
    
   //boton cancelar ( cierra ventana actual)
    @FXML private javafx.scene.control.Button botonCancelarBorrarReserva;
                  
    @FXML private void cancelarBorrarReserva(){
    // get a handle to the stage
    Stage stage = (Stage) botonCancelarBorrarReserva.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    

    
    
    @FXML private ChoiceBox<Reserva> cbBorrarReserva;
      
    public void setValoresReservas() //metodo que lleva los valores del arraylist al choiseBox
    {
        ObservableList<Reserva> reservas=FXCollections.observableArrayList();
               
       reservas.addAll(controladorMVC.getReservas());
        
        cbBorrarReserva.setItems(reservas);
     
    }
    
        public void setReservas(ObservableList<Reserva> reservas){
        this.reservas=reservas;
    }

 @FXML private void aceptar(javafx.event.ActionEvent event) throws OperationNotSupportedException
    {
        //boolean error=false;
        Stage escenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        int posicion= cbBorrarReserva.getSelectionModel().getSelectedIndex();
        
        
        try{
        Reserva reservaSeleccionada=(Reserva) reservas.get(posicion);
         controladorMVC.anularReserva(reservaSeleccionada);//borro en modelo
        reservas.remove(reservaSeleccionada);//borro en observable
        Dialogos.mostrarDialogoInformacion("Borrar Reserva", "Reserva borrada correctamente");
        }
        
         catch (NullPointerException e)
        {
        Dialogos.mostrarDialogoError("Reservas", e.getMessage());
        }
         escenario.close();
    }



}