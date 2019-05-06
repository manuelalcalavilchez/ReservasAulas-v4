package org.iesalandalus.programacion.reservasaulas;

import org.iesalandalus.programacion.reservasaulas.controlador.ControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas;

import org.iesalandalus.programacion.reservasaulas.vista.grafica.VistasReservasAulas;

//import org.iesalandalus.programacion.reservasaulas.vista.textual.VistaReservasAulas;
//import org.iesalandalus.programacion.reservasaulas.vista.grafica.controladoresVistas;
/*
import org.iesalandalus.programacion.reservasaulas.controlador.ControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.VistaReservasAulas;
*/
public class MainApp {

	public static void main(String[] args) {
		//IVistaReservasAulas vista = new VentanaPrincipalFXMLController();
		IVistaReservasAulas vista = new VistasReservasAulas();
                IModeloReservasAulas modelo = new ModeloReservasAulas();
		IControladorReservasAulas controlador = new ControladorReservasAulas(modelo, vista);
		controlador.comenzar();
	}
/*
         // TODO code application logic here
        System.out.println("Programa para la gestión de alarmas personales.");
        IVistaGestionAlarmas vista = new VistaGestionAlarmas(); 
	IModeloGestionAlarmas modelo = new ModeloGestionAlarmas();
	                               
	IControladorGestionAlarmas controlador = new ControladorGestionAlarmas(vista, modelo);
	controlador.comenzar();
    }*/
        
}
