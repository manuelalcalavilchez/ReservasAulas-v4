/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista.grafica.controladoresVistas;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.utilidades.Dialogos;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class AnadirAulaFXMLController implements Initializable {

     private IControladorReservasAulas controladorMVC;
    
     
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
    @FXML private javafx.scene.control.Button botonCancelarAnadirAula;
                  
    @FXML private void cancelarAnadirAula(){
    // get a handle to the stage
    Stage stage = (Stage) botonCancelarAnadirAula.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    
    
    //Añadir AULA
    
     private ObservableList<Aula> aulas;
     
        
    @FXML
    private TextField tfNombreAula;
     
    @FXML
    private TextField tfPuestosAula;
    
    
    public void setAulas(ObservableList<Aula> aulas){
        this.aulas=aulas;
    }
    
    @FXML private void aceptar(javafx.event.ActionEvent event) throws OperationNotSupportedException
    {
        boolean error=false;
        Stage escenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        Aula aula= null;
        //para pasar el texfield con el numero de puestos a tipo INT
        
        
        int puestos=0;
        if (!tfPuestosAula.getText().equals("")){
        
            try{
        puestos = Integer.parseInt(tfPuestosAula.getText());
        }catch (NumberFormatException e){
             Dialogos.mostrarDialogoError("Aula", "Debe ser formato numerico");
            }
        }    
            if (tfPuestosAula.getText() == null || tfPuestosAula.getText().equals(""))
                { 
              Dialogos.mostrarDialogoError("Nueva Aula", "Bebe introducir un numero de puestos para el aula");
            error=true;
                    };
        
        
        if (tfNombreAula.getText() == null || tfNombreAula.getText().equals("")) 
                { 
              Dialogos.mostrarDialogoError("Nueva Aula", "Bebe introducir un nombre para el aula");
            error=true;
                    };
        
        
        
        if (!error)
        {
        
        
        aula = new Aula(tfNombreAula.getText(),puestos);
        
        try {
             controladorMVC.insertarAula(aula);//añado en modelo
             aulas.add(aula);//añado en observable
            
         } catch(OperationNotSupportedException | IllegalArgumentException | NullPointerException e)            
            {
             Dialogos.mostrarDialogoError("Aula", e.getMessage());
            }            
         escenario.close();
        
         
    }
          
               
           
    } 
}
