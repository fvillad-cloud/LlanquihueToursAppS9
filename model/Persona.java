/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase padre que representa a una persona en el sistema.
 * Implementa la interfaz Registrable para permitir el registro de personas.
 * 
 * Esta clase es la superclase de Cliente, Empleado y Proveedor, y contiene
 * los atributos comunes a todos los tipos de personas:
 * - Datos personales (nombre, edad, RUT)
 * - Información de contacto (telefono)
 * - Ubicación (direccion)
 * - Clasificación (tipo de persona)
 * 
 * El metdo registrar() esta implementado como vacio en esta clase base,
 * ya que, cada subclase debe proporcionar su propia implementacion especifica.
 * 
 * @author Francisco
 */
public class Persona implements Registrable {
    private String nombre;
    private int edad;
    private RUT rut;
    private String telefono;
    private Direccion direccion;
    private String tipoDePersona;

    /**
     * Constructor que inicializa todos los atributos de una persona.
     * 
     * @param nombre Nombre completo de la persona
     * @param edad Edad de la persona
     * @param rut Objeto RUT de la persona (debe estar validado)
     * @param telefono Numero de telefono de contacto
     * @param direccion Objeto Direccion de la persona
     * @param tipoDePersona Clasificacion de la persona ("cliente", "empleado" o "proveedor")
     */
    public Persona(String nombre, int edad, RUT rut, String telefono, Direccion direccion, String tipoDePersona) {
        this.nombre = nombre;
        this.edad = edad;
        this.rut = rut;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoDePersona = tipoDePersona;
    }

    //Get and set...
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public RUT getRut() {
        return rut;
    }

    public void setRut(RUT rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTipoDePersona() {
        return tipoDePersona;
    }

    public void setTipoDePersona(String tipoDePersona) {
        this.tipoDePersona = tipoDePersona;
    }
  
   /**
     * Representación en String de la persona con todos sus atributos.
     * Incluye un encabezado (datos de persona) y todos los datos de la persona en formato legible.
     * 
     * @return String con la informacion completa de la persona
     */
    @Override
    public String toString(){
        return  "\n=== Datos de Persona ==="+
                "\nTipo de Persona     : "+tipoDePersona+
                "\nNombre              : "+nombre+
                "\nEdad                : "+edad+
                "\n"+rut+
                "\nTelefono            : "+telefono+
                "\n"+direccion;
                
    }
    
    /**
     * Muestra un resumen de la persona con todos sus atributos.
     * Identico a toString() en esta clase base, pero las subclases
     * pueden sobrescribirlo para agregar información específica.
     * 
     * @return String con el resumen de la persona
     */
    @Override
    public String mostrarResumen(){
        return  "\n=== Datos de Persona ==="+
                "\nTipo de Persona     : "+tipoDePersona+
                "\nNombre              : "+nombre+
                "\nEdad                : "+edad+
                "\n"+rut+
                "\nTelefono            : "+telefono+
                "\n"+direccion;
    }

    /**
     * Metodo vacio... cada subclase debe realizar su propia implementacion
     * especifica de este medtodo. 
     * 
     * @param scanner
     * @param listaPersonas 
     */
    @Override
    public void registrar(Scanner scanner, ArrayList<Persona> listaPersonas){
        
    }
    
    
}
