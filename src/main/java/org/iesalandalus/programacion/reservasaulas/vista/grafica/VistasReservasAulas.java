/* ?¿donde esta?
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista.grafica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.grafica.controladoresVistas.VentanaPrincipalFXMLController;

/**
 *
 * @author Manuel
 */
public class VistasReservasAulas extends Application implements IVistaReservasAulas {

    //declaro controlador de mi modelo 
private IControladorReservasAulas controladorMVC;
private static VistasReservasAulas instancia=null;

       
 // constructor de la clase       
 public VistasReservasAulas()
        {
            //System.out.println("IUGVEntanas: Constructor llamado");
            if (instancia != null) 
            {
                controladorMVC = instancia.controladorMVC;
            } 
            else 
            {
                instancia = this;
            }
        }               



    
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader= new FXMLLoader(getClass().getResource("Vistas/VentanaPrincipal.fxml"));

        Parent root = loader.load();
        
             //System.out.println("Antes de setControlador");
                VentanaPrincipalFXMLController controlador=loader.getController();
                controlador.setControladorMVC(controladorMVC);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
   
    /*
    public static void main(String[] args) {
        launch(args);
    }
    */
    
    public IControladorReservasAulas getControladorMVC() {
		return controladorMVC;
	}       
       
       
    @Override
	public void comenzar() {            
		launch(this.getClass());
	}

    @Override
    public void setControlador(IControladorReservasAulas controlador) {        
        this.controladorMVC = controlador;       
    
    
    
}

    @Override
    public void anularReserva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarAula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarAula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarDisponibilidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarAula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarAulas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarProfesores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarReservas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarReservasAula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarReservasPermanencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarReservasProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void realizarReserva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}