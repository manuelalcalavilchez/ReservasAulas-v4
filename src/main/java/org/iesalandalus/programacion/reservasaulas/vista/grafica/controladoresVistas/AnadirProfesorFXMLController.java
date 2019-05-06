/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista.grafica.controladoresVistas;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
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
public class AnadirProfesorFXMLController implements Initializable {

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
    
    
    
    //Añadir un profesor
    
    @FXML
    private TextField tfNombre;
     
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfEmail;
       
    public void setProfesor(ObservableList<Profesor> profesor){
        this.profesores=profesor;
    }
    
    @FXML private void aceptar(javafx.event.ActionEvent event) throws OperationNotSupportedException
    {
        Stage escenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        Profesor profesor= null;
               

        
         if (tfTelefono.getText().equals("")){
             try{
         profesor = new Profesor(tfNombre.getText(), tfEmail.getText());
         controladorMVC.insertarProfesor(profesor);
         profesores.add(profesor);
         Dialogos.mostrarDialogoInformacion("Nuevo Profesor", "Profesor creado correctamente");
         }
             catch (IllegalArgumentException e){
                  Dialogos.mostrarDialogoError("Profesor", e.getMessage());
             }
         }
         else {
             
        //para pasar el texfield con el numero de telefono a tipo INT
        
        int telefono =0;
        if(!tfTelefono.getText().equals("")) {
            try{
            telefono = Integer.parseInt(tfTelefono.getText());
        }catch (NumberFormatException e){
             Dialogos.mostrarDialogoError("Aula", "Debe ser formato numerico");
            }
        }
        
        try {
        profesor = new Profesor(tfNombre.getText(), tfEmail.getText(), tfTelefono.getText());
         
        
             controladorMVC.insertarProfesor(profesor);
             profesores.add(profesor);
             Dialogos.mostrarDialogoInformacion("Nuevo Profesor", "Profesor creado correctamente");
         } catch( IllegalArgumentException e)            
            {
                Dialogos.mostrarDialogoError("Profesor", e.getMessage());
            }            
         
        }
         escenario.close();
    }

}
