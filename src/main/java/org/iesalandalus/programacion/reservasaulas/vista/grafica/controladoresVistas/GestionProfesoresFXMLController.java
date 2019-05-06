/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista.grafica.controladoresVistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class GestionProfesoresFXMLController implements Initializable {

    
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
    
        @FXML
    private void anadirProfesor (ActionEvent event)
    {        
        try 
        {
            //Parent raiz=FXMLLoader.load(getClass().getResource("FXMLEscenaEnlazada.fxml"));
            //Obtenemos la referencia a la escena que queremos mostrar
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vistas/AnadirProfesorFXML.fxml"));                      
            Parent raiz=loader.load();
            
            //Creamos un objeto escena con la escena almacenada en el fichero fxml
            Scene enlazadoEscena=new Scene(raiz);
            
            //Creamos un nuevo escenario
            Stage escenarioNuevo=new Stage();
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Añadir profesor");
            
            //Obtenemos el controlador de la escena para llamar al método que oculta el botón volver
            AnadirProfesorFXMLController controlador=loader.getController();
            controlador.setControladorMVC(controladorMVC);
            controlador.setProfesor(profesores);
      
            
            
            
            
            
            
            //Le asignamos la escena y mostramos el escenario
            escenarioNuevo.setScene(enlazadoEscena);
            escenarioNuevo.showAndWait();   
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }                        
    }
    
    
        @FXML
    private void borrarProfesor (ActionEvent event)
    {        
        try 
        {
            //Parent raiz=FXMLLoader.load(getClass().getResource("FXMLEscenaEnlazada.fxml"));
            //Obtenemos la referencia a la escena que queremos mostrar
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vistas/BorrarProfesorFXML.fxml"));                      
            Parent raiz=loader.load();
            
            //Creamos un objeto escena con la escena almacenada en el fichero fxml
            Scene enlazadoEscena=new Scene(raiz);
            
            //Creamos un nuevo escenario
            Stage escenarioNuevo=new Stage();
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Borrar profesor");
            
            //Obtenemos el controlador de la escena para llamar al método que oculta el botón volver
            BorrarProfesorFXMLController controlador=loader.getController();
            controlador.setControladorMVC(controladorMVC);
            controlador.setProfesores(profesores);//el observablelist que se actualiza cuando se borre
            controlador.setValoresProfesores();//para cargar en el observablelist los valores
            
            
            //Le asignamos la escena y mostramos el escenario
            escenarioNuevo.setScene(enlazadoEscena);
            escenarioNuevo.showAndWait();   
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }                        
    }
    
    
     @FXML
    private void buscarReservaProfesor (ActionEvent event)
    {        
        try 
        {
            //Parent raiz=FXMLLoader.load(getClass().getResource("FXMLEscenaEnlazada.fxml"));
            //Obtenemos la referencia a la escena que queremos mostrar
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vistas/BuscarReservaProfesor.fxml"));                      
            Parent raiz=loader.load();
            
            //Creamos un objeto escena con la escena almacenada en el fichero fxml
            Scene enlazadoEscena=new Scene(raiz);
            
            //Creamos un nuevo escenario
            Stage escenarioNuevo=new Stage();
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Borrar profesor");
            
            //Obtenemos el controlador de la escena para llamar al método que oculta el botón volver
            BuscarReservaProfesorController controlador=loader.getController();
            controlador.setControladorMVC(controladorMVC);
            controlador.setProfesores(profesores);//el observablelist que se actualiza cuando se borre
            controlador.setValoresProfesores();//para cargar en el observablelist los valores
            
            //Le asignamos la escena y mostramos el escenario
            escenarioNuevo.setScene(enlazadoEscena);
            escenarioNuevo.showAndWait();   
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }                        
    }
    
    
    
      //boton cancelar ( cierra ventana actual)
    @FXML private javafx.scene.control.Button botonAtras;
                  
    @FXML private void atras(){
    // get a handle to the stage
    Stage stage = (Stage) botonAtras.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    @FXML
    private ListView<Profesor> lvProfesores;
    
        public void getProfesores()
    {
        profesores=FXCollections.observableArrayList();
        
        profesores.addAll(controladorMVC.getProfesores());
        
        lvProfesores.setItems(profesores);
        
        
    }
    
}
