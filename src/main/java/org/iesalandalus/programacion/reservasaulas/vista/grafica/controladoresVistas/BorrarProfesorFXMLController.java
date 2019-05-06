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
import javafx.stage.Stage;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.utilidades.Dialogos;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class BorrarProfesorFXMLController implements Initializable {

    
    private IControladorReservasAulas controladorMVC;
    private ObservableList<Profesor> profesores;
    
     
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
    @FXML private javafx.scene.control.Button botonCancelarBorrarProfesor;
                  
    @FXML private void cancelarBorrarProfesor(){
    // get a handle to the stage
    Stage stage = (Stage) botonCancelarBorrarProfesor.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    
     @FXML private ChoiceBox<Profesor> cbProfesor;
     
      public void setValoresProfesores() //metodo que lleva los valores del arraylist al choiseBox
    {
        ObservableList<Profesor> profesores=FXCollections.observableArrayList();
       
        
        profesores.addAll(controladorMVC.getProfesores());
        
        cbProfesor.setItems(profesores);
               
    }
      public void setProfesores(ObservableList<Profesor> profesores){
        this.profesores=profesores;
    }
    
      
       @FXML private void aceptar(javafx.event.ActionEvent event) throws OperationNotSupportedException
    {
        
        Stage escenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        int posicion= cbProfesor.getSelectionModel().getSelectedIndex();
        
        Profesor profesorSeleccionado=(Profesor) profesores.get(posicion);
       
        
        
        controladorMVC.borrarProfesor(profesorSeleccionado);//borro en modelo
        profesores.remove(profesorSeleccionado);//borro en observable
        Dialogos.mostrarDialogoInformacion("Borrar Profesor", "Profesor borrado correctamente");
         
         
        
         escenario.close();
    }
    
}
