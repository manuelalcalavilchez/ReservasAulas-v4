/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista.grafica.controladoresVistas;

//import com.sun.deploy.uitoolkit.ToolkitStore;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;

/**
 *
 * @author Manuel
 */
public class VentanaPrincipalFXMLController  implements Initializable  {
    
    
     private IControladorReservasAulas controladorMVC;
    
     
      public void setControladorMVC(IControladorReservasAulas controlador) 
    {   
        controladorMVC = controlador;        
    }
    
    
    
    @FXML
    private Label label;
    
    /*
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
 @FXML
    private void gestionAulas (ActionEvent event)
    {        
        try 
        {
            //Parent raiz=FXMLLoader.load(getClass().getResource("FXMLEscenaEnlazada.fxml"));
            //Obtenemos la referencia a la escena que queremos mostrar
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vistas/GestionAulasFXML.fxml"));                      
            Parent raiz=loader.load();
            
            //Creamos un objeto escena con la escena almacenada en el fichero fxml
            Scene enlazadoEscena=new Scene(raiz);
            
            //Creamos un nuevo escenario
            Stage escenarioNuevo=new Stage();
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Gestión de aulas");
            
            //Obtenemos el controlador de la escena para llamar al método que oculta el botón volver
            GestionAulasFXMLController controlador=loader.getController();
            controlador.setControladorMVC(controladorMVC);
            controlador.getAulas();
            
            //Le asignamos la escena y mostramos el escenario
            escenarioNuevo.setScene(enlazadoEscena);
            escenarioNuevo.showAndWait();   
         
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }                        
    }
    
     @FXML
    private void gestionProfesores (ActionEvent event)
    {        
        try 
        {
            //Parent raiz=FXMLLoader.load(getClass().getResource("FXMLEscenaEnlazada.fxml"));
            //Obtenemos la referencia a la escena que queremos mostrar
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vistas/GestionProfesoresFXML.fxml"));                      
            Parent raiz=loader.load();
            
            //Creamos un objeto escena con la escena almacenada en el fichero fxml
            Scene enlazadoEscena=new Scene(raiz);
            
            //Creamos un nuevo escenario
            Stage escenarioNuevo=new Stage();
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Gestión de profesores");
            
            //Obtenemos el controlador de la escena para llamar al método que oculta el botón volver
            GestionProfesoresFXMLController controlador=loader.getController();
            controlador.setControladorMVC(controladorMVC);
            controlador.getProfesores();
            
            //Le asignamos la escena y mostramos el escenario
            escenarioNuevo.setScene(enlazadoEscena);
            escenarioNuevo.showAndWait();   
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }                        
    }
    
     @FXML
    private void gestionReservas (ActionEvent event)
    {        
        try 
        {
            //Parent raiz=FXMLLoader.load(getClass().getResource("FXMLEscenaEnlazada.fxml"));
            //Obtenemos la referencia a la escena que queremos mostrar
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../Vistas/GestionReservasFXML.fxml"));                      
            Parent raiz=loader.load();
            
            //Creamos un objeto escena con la escena almacenada en el fichero fxml
            Scene enlazadoEscena=new Scene(raiz);
            
            //Creamos un nuevo escenario
            Stage escenarioNuevo=new Stage();
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Gestión de reservas");
            
            //Obtenemos el controlador de la escena para llamar al método que oculta el botón volver
            GestionReservasFXMLController controlador=loader.getController();
            controlador.setControladorMVC(controladorMVC);
            controlador.getReservas();
            
            //Le asignamos la escena y mostramos el escenario
            escenarioNuevo.setScene(enlazadoEscena);
            escenarioNuevo.showAndWait();   
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }                        
    }
   
    
     @FXML
    private void cerrarPrograma (ActionEvent event) throws Exception
    {        
        controladorMVC.salir();//incluye el guardar los ficheros
        System.exit(0);
    }
   
    
}
