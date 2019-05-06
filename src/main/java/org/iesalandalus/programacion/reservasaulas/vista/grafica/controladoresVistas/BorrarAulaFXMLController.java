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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.utilidades.Dialogos;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class BorrarAulaFXMLController implements Initializable {

    
    private IControladorReservasAulas controladorMVC;
    private ObservableList<Aula> aulas;
     
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
        // setValoresAulas();
        
        
        
    }    
    
    //boton cancelar ( cierra ventana actual)
    @FXML private javafx.scene.control.Button botonCancelarBorrarAula;
                  
    @FXML private void cancelarBorrarAula(){
    // get a handle to the stage
    Stage stage = (Stage) botonCancelarBorrarAula.getScene().getWindow();
    // do what you have to do
    stage.close();
}
         



    
    
    @FXML private ChoiceBox<Aula> cbBorrarAula;
      
    public void setValoresAulas() //metodo que lleva los valores del arraylist al choiseBox
    {
        ObservableList<Aula> aulas=FXCollections.observableArrayList();
               
        aulas.addAll(controladorMVC.getAulas());
        
        cbBorrarAula.setItems(aulas);
       
        
    }
        
     public void setAulas(ObservableList<Aula> aulas){
        this.aulas=aulas;
    }
        
  
    @FXML private void aceptar(javafx.event.ActionEvent event) throws OperationNotSupportedException
    {
        //boolean error=false;
        Stage escenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        int posicion= cbBorrarAula.getSelectionModel().getSelectedIndex();
        
        Aula aulaSeleccionada=(Aula) aulas.get(posicion);
       
        
        
        controladorMVC.borrarAula(aulaSeleccionada);//borro en modelo
        aulas.remove(aulaSeleccionada);//borro en observable
        Dialogos.mostrarDialogoInformacion("Borrar Aula", "Aula borrada correctamente");
         
         
        
         escenario.close();
    }
          
               
           
} 
        
    
        
    
 
    

