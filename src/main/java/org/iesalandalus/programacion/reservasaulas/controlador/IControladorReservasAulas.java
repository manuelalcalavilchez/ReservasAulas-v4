/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.controlador;

import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

/**
 *
 * @author Manuel
 */
public interface IControladorReservasAulas {

    void anularReserva(Reserva anular) throws OperationNotSupportedException;

    void borrarAula(Aula borrar) throws OperationNotSupportedException;

    void borrarProfesor(Profesor borrar) throws OperationNotSupportedException;

    Aula buscarAula(Aula buscar);

    Profesor buscarProfesor(Profesor buscar);

    //Reserva buscarReserva(Reserva buscar);

    void comenzar();

    void salir();
    
    boolean consultarDisponibilidad(Aula aula, Permanencia permanencia);

    //List<Aula> getAulas();

    //int getNumAulas();

    //int getNumProfesores();

   // int getNumReservas();

   // List<Profesor> getProfesores();

   // List<Reserva> getReservas();

    List<Reserva> getReservasAula(Aula aula);

    List<Reserva> getReservasPermanencia(Permanencia permanencia);

    List<Reserva> getReservasProfesor(Profesor profesor);

    void insertarAula(Aula insertar) throws OperationNotSupportedException;

    void insertarProfesor(Profesor insertar) throws OperationNotSupportedException;

    void realizarReserva(Reserva realizar) throws OperationNotSupportedException;

    List<String> representarAulas();
    List<Aula> getAulas();
    List<String> representarProfesores();
    List<Profesor> getProfesores();
    List<String> representarReservas();
    List<Reserva> getReservas();
}
