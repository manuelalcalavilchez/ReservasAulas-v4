/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista.grafica.controladoresVistas;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorHora;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.PermanenciaPorTramo;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Tramo;
import org.iesalandalus.programacion.utilidades.Dialogos;

/**
 * FXML Controller class
 *
 * @author Manuel
 */
public class AnadirReservaFXMLController implements Initializable {

private ObservableList<Reserva> reservas;    
private ObservableList<Profesor> profesores;    
private ObservableList<Aula> aulas;    
private ObservableList<Tramo> tramos;    

private IControladorReservasAulas controladorMVC;
private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");    
     
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
    private TextField tfHora;
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
      @FXML
    private ChoiceBox cbExtras;
    
     
     @FXML
    private ChoiceBox cbAula;
     @FXML
    private ChoiceBox cbProfesor;
 
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        agrupaRbTipoReserva();
        inicializaCalendario();
        
        
    }    
    
    @FXML private void cancelar(ActionEvent event)
    {
        Stage escenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        if (Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás seguro de que deseas salir?", escenario)) 
        {
            escenario.close();
	
        }
    }
      //boton cancelar ( cierra ventana actual)
    @FXML private javafx.scene.control.Button botonCancelarAnadirReserva;
                  
    @FXML private void cancelarAnadirReserva(){
    // get a handle to the stage
    Stage stage = (Stage) botonCancelarAnadirReserva.getScene().getWindow();
    // do what you have to do
    stage.close();
}


     
     
         
    //agrupo los radioButton en un Tooglegrupo
    
 private void agrupaRbTipoReserva()
    {
   tgTipoReserva=new ToggleGroup();
   rbHora.setToggleGroup(tgTipoReserva);
   rbTramo.setToggleGroup(tgTipoReserva);
   rbHora.setSelected(false);     
   rbTramo.setSelected(false);
   tgTipoReserva.selectedToggleProperty().addListener((observable, oldValue, newValue) -> muestraOpcion());
    }       
   

    
    
    //Método que en función de la opción elegida del tipo de alarma, muestra o no la fecha
    private void muestraOpcion()
    {
        RadioButton seleccionado = (RadioButton)tgTipoReserva.getSelectedToggle();
        
        if (seleccionado == rbTramo)
        {
            labelDia.setVisible(false);
            tfHora.setVisible(false);
            fecha.setVisible(false);
            labelDiaHora.setVisible(false);
        }
        else
        {
            labelDia.setVisible(true);
            tfHora.setVisible(true);
            fecha.setVisible(true);
            labelDiaHora.setVisible(true); 
        }

         if (seleccionado == rbHora)
         {
            labelDiaTramo.setVisible(false);
            labelTramo.setVisible(false);
            fechaTramo.setVisible(false);
           // selecTramo.setVisible(false);
            cbExtras.setVisible(false);
          }
        else
        {
            labelDiaTramo.setVisible(true);
            labelTramo.setVisible(true);
            fechaTramo.setVisible(true);
            //selecTramo.setVisible(true);       
           cbExtras.setVisible(true); 
           cbExtras.setItems(FXCollections.observableArrayList("Mañana", "Tarde"));
         }
}
    
    //calendario
     private void inicializaCalendario()
    {

long diasRestantesMes = DAYS.between(LocalDate.now(), LocalDate.now().plusMonths(1).withDayOfMonth(1));

        final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                LocalDate.now().plusDays(diasRestantesMes))

                                    ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: orange;");
                            }   
                    }
                };
            }
        };
        fecha.setDayCellFactory(dayCellFactory);
        fechaTramo.setDayCellFactory(dayCellFactory);
    }
    
    
    
     public void setReservas(ObservableList<Reserva> reservas){
        this.reservas=reservas;
    }
    
    
     
    
      @FXML private void aceptar(javafx.event.ActionEvent event)
    {
         Stage escenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        boolean error=false;
        Reserva reserva=null;
        LocalTime lt=null;
    
        if (!error)
        {
            try
            {
                RadioButton seleccionado = (RadioButton)tgTipoReserva.getSelectedToggle();
                Profesor profesor=(Profesor) cbProfesor.getValue();
                Aula aula = (Aula) cbAula.getValue();
                Permanencia permanencia; 
                if (seleccionado == rbHora)
                {                                   
                 
                      try 
                            {
                              lt=LocalTime.parse(tfHora.getText(), FORMATO_HORA);		
                             } 
                        catch (DateTimeParseException e) 
                               {
                                    Dialogos.mostrarDialogoError("Nueva Reserva", "El formato de la hora no es correcto. Debe ser hh:mm");			
                                    error=true;
                                }
                   
                    permanencia = new PermanenciaPorHora(fecha.getValue(), lt);
                    reserva = new Reserva(profesor, aula, permanencia);
                }                            
                //else
                 if (seleccionado == rbTramo)    
                {                                                                       
                  
                    // como no se traerme el enum al ChoiceBox, creo un constructor con un tramo String y doy valores
                    //al ChoiceBox cbExtras
                    //   permanencia = new PermanenciaPorTramo(fechaTramo.getValue(), (Tramo) selecTramo.getValue());
                    String franja = (String) cbExtras.getValue();
                   //permanencia = new PermanenciaPorTramo(fechaTramo.getValue(), (Tramo) cbExtras.getValue());
                   permanencia = new PermanenciaPorTramo(fechaTramo.getValue(), franja);
                   reserva = new Reserva(profesor, aula, permanencia);
                }   
            }     
             catch(IllegalArgumentException | NullPointerException e)            
            {
                Dialogos.mostrarDialogoError("Alarma", e.getMessage());
                 error=true;
            }        
            
         
             try {
             controladorMVC.realizarReserva(reserva);//añado en modelo
             reservas.add(reserva);//añado en observable
             Dialogos.mostrarDialogoInformacion("Nueva Reserva", "Reserva creada correctamente");
         } catch(OperationNotSupportedException | IllegalArgumentException | NullPointerException e)            
            {
             Dialogos.mostrarDialogoError("Reserva", e.getMessage());
             
            }            
          escenario.close();
            
            
            }
        
    }          
            
     
       public void setValoresAulas() //metodo que lleva los valores del arraylist al choiseBox
    {
        ObservableList<Aula> aulas=FXCollections.observableArrayList();
               
        aulas.addAll(controladorMVC.getAulas());
        
        cbAula.setItems(aulas);
       
        
    }
        
     public void setAulas(ObservableList<Aula> aulas){
        this.aulas=aulas;
    }

    
      public void setValoresProfesores() //metodo que lleva los valores del arraylist al choiseBox
    {
        ObservableList<Profesor> profesores=FXCollections.observableArrayList();
       
        
        profesores.addAll(controladorMVC.getProfesores());
        
        cbProfesor.setItems(profesores);
               
    }
      public void setProfesores(ObservableList<Profesor> profesores){
        this.profesores=profesores;
    }
    
}