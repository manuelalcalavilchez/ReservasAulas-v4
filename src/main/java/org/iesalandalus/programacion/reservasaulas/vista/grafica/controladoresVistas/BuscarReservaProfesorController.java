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
public class BuscarReservaProfesorController implements Initializable {

    
    private IControladorReservasAulas controladorMVC;
    private ObservableList<Profesor> profesores;
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
    @FXML private javafx.scene.control.Button botonCancelarBuscarReservaProfesor;
                  
    @FXML private void CancelarBuscarReservaProfesor(){
    // get a handle to the stage
    Stage stage = (Stage) botonCancelarBuscarReservaProfesor.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    @FXML private ChoiceBox<Profesor> cbBuscarReserva;
    @FXML private ListView<Reserva> lvReservas;  
    
    public void setValoresProfesores() //metodo que lleva los valores del arraylist al choiseBox
    {
        ObservableList<Profesor> profesores=FXCollections.observableArrayList();               
        profesores.addAll(controladorMVC.getProfesores());        
        cbBuscarReserva.setItems(profesores);       
    }
        
     public void setProfesores(ObservableList<Profesor> profesores){
        this.profesores=profesores;
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
        
        Profesor profesorSeleccionado=(Profesor) profesores.get(posicion);
       
        
      
        try {
       
            
        ObservableList<Reserva> reservas=FXCollections.observableArrayList();               
        reservas.addAll(controladorMVC.getReservasProfesor(profesorSeleccionado));         
        lvReservas.setItems(reservas); 
            
            
        } catch(IllegalArgumentException | NullPointerException e)            
            {
             Dialogos.mostrarDialogoError("Reservas", e.getMessage());
            } 
        
    }
    
    
    
    
    
    
}
