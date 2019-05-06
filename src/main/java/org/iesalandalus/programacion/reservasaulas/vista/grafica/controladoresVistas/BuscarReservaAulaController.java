/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista.grafica.controladoresVistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.utilidades.Dialogos;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class BuscarReservaAulaController implements Initializable {

    
    private IControladorReservasAulas controladorMVC;
    private ObservableList<Aula> aulas;
    private ObservableList<Reserva> reservas;
     
      public void setControladorMVC(IControladorReservasAulas controlador) 
    {   
        controladorMVC = controlador;        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
     //boton cancelar ( cierra ventana actual)
    @FXML private javafx.scene.control.Button botonCancelarBuscarReservaAula;
                  
    @FXML private void CancelarBuscarReservaAula(){
    // get a handle to the stage
    Stage stage = (Stage) botonCancelarBuscarReservaAula.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    @FXML private ChoiceBox<Aula> cbBuscarReserva;
    @FXML private ListView<Reserva> lvReservas;  
    
    public void setValoresAulas() //metodo que lleva los valores del arraylist al choiseBox
    {
        ObservableList<Aula> aulas=FXCollections.observableArrayList();               
        aulas.addAll(controladorMVC.getAulas());        
        cbBuscarReserva.setItems(aulas);       
    }
        
     public void setAulas(ObservableList<Aula> aulas){
        this.aulas=aulas;
    }
    
     
     public void setValoresReservas() //metodo que lleva los valores del arraylist al choiseBox
    {
        ObservableList<Reserva> reservas=FXCollections.observableArrayList();               
        reservas.addAll(controladorMVC.getReservas());        
        lvReservas.setItems(reservas);       
    }
        
     public void setReservas(ObservableList<Reserva> reservas){
        this.reservas=reservas;
    }
     
     
      @FXML private void buscar(javafx.event.ActionEvent event) throws OperationNotSupportedException
    {
        //boolean error=false;
        Stage escenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        int posicion= cbBuscarReserva.getSelectionModel().getSelectedIndex();
        
        Aula aulaSeleccionada=(Aula) aulas.get(posicion);
       
        
      
        try {
            
            /*
        controladorMVC.getReservasAula(aulaSeleccionada);
       // reservas.addAll(controladorMVC.getReservasAula(aulaSeleccionada));        
        lvReservas.setItems(reservas);
        */
            
        ObservableList<Reserva> reservas=FXCollections.observableArrayList();               
        reservas.addAll(controladorMVC.getReservasAula(aulaSeleccionada));         
        lvReservas.setItems(reservas); 
            
            
        } catch(IllegalArgumentException | NullPointerException e)            
            {
             Dialogos.mostrarDialogoError("Reservas", e.getMessage());
            } 
        
    }
     
}
