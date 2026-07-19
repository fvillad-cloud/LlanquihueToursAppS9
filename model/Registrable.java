/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import model.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interfaz que define el contrato para las clases que pueden ser registradas
 * y visualizadas en el sistema de gestion de personas.
 * 
 * Esta interfaz establece dos metodos fundamentales que deben implementar
 * todas las clases que representan entidades registrables:
 * 
 * 1. mostrarResumen(): Para visualizar la informacion.
 * 2. registrar(): Para agregar una nueva entidad al sistema.
 *
 * 
 * @author Francisco
 */

public interface Registrable {
    /**
     * Muestra un resumen de la informacion de la entidad.
     * 
     * Este metodo debe proporcionar una representacion de todos los
     * atributos importantes del objeto.
     * 
     * @return String con el resumen formateado de la entidad
     */
    public String mostrarResumen();
    
    /**
     * Registra una nueva entidad en el sistema mediante entrada interactiva.
     * 
     * Este metodo solicita al usuario todos los datos necesarios para crear
     * una nueva entidad del tipo correspondiente. Incluye validaciones.
     * 
     * El método debe:
     * 1. Solicitar datos por consola usando el Scanner proporcionado
     * 2. Validar cada entrada
     * 3. Crear la entidad correspondiente
     * 4. Agregarla a la lista de personas
     * 5. Confirmar la operación al usuario
     * 
     * @param scanner Objeto Scanner para leer la entrada del usuario
     * @param listaPersonas Lista donde se agregará la nueva entidad
     */
    public void registrar(Scanner scanner, ArrayList<Persona> listaPersonas);
}
