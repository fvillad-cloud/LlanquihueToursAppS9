/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import utils.RutInvalidoException;
import model.Persona;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa a un Empleado en el sistema.
 * Extiende la clase Persona e implementa la interfaz Registrable.
 * 
 * Un empleado tiene atributos especificos como:
 * - Area de trabajo (departamento o area donde trabaja)
 * - Tipo de contrato (indefinido o a plazo fijo)
 * 
 * @author Francisco
 */
public class Empleado extends Persona implements Registrable{
    
    private String area;
    private boolean contratoIndefinido;

    /**
     * Constructor completo para crear un objeto Empleado con todos sus atributos.
     * 
     * @param area Area o departamento donde trabaja el empleado
     * @param contratoIndefinido true si tiene contrato indefinido, false si es a plazo fijo
     * @param nombre Nombre completo del empleado
     * @param edad Edad del empleado
     * @param rut Objeto RUT del empleado
     * @param telefono Numero de telefono del empleado
     * @param direccion Objeto Direccion del empleado
     * @param tipoDePersona Tipo de persona (siempre sera "empleado")
     */
    public Empleado(String area, boolean contratoIndefinido, String nombre, int edad, RUT rut, String telefono, Direccion direccion, String tipoDePersona) {
        super(nombre, edad, rut, telefono, direccion, "empleado");
        this.area = area;
        this.contratoIndefinido = contratoIndefinido;
    }

   //Setters and getters

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isContratoIndefinido() {
        return contratoIndefinido;
    }

    public void setContratoIndefinido(boolean contratoIndefinido) {
        this.contratoIndefinido = contratoIndefinido;
    }
    
    /**
     * Representación en String del empleado con todos sus atributos.
     * Incluye los datos heredados de Persona y los especificos de Empleado.
     * 
     * @return String con la información completa del empleado
     */
    @Override
    public String toString(){
    return super.toString() +
           "\nArea                : " + area +
           "\nContrato Indefinido : " + (contratoIndefinido ? "Si" : "No");
    }
    
    /**
     * Muestra un resumen del empleado con todos sus atributos.
     * Similar a toString() pero con formato especifico para listados.
     * 
     * @return String con el resumen del empleado
     */
    @Override
    public String mostrarResumen(){
    return super.toString() +
           "\nArea                : " + area +
           "\nContrato Indefinido : " + (contratoIndefinido ? "Si" : "No");
    }
    
   /** Registra un nuevo empleado en el sistema mediante entrada interactiva.
     * Implementa el metodo de la interfaz Registrable.
     * 
     * Este metodo solicita al usuario todos los datos necesarios para crear un empleado:
     * - Datos de dirección (calle, numero, ciudad, region)
     * - Datos personales (nombre, edad, RUT, telefono)
     * - Datos específicos de empleado (area, tipo de contrato)
     * 
     * Incluye validaciones para cada campo, proporcionando valores por defecto
     * cuando la entrada es invalida o vacia.
     * 
     * @param scanner Objeto Scanner para leer la entrada del usuario
     * @param listaPersonas Lista donde se agregara el nuevo empleado
     */
    
    @Override
    public void registrar(Scanner scanner, ArrayList<Persona> listaPersonas){
        System.out.println("\n=== REGISTRO DE NUEVO EMPLEADO ===");
        
        // Datos de dirección
        //Calle
        System.out.println("--- Datos de Direccion ---");
        System.out.print("Calle: ");
        String calle = scanner.nextLine().trim();
        if (calle.isEmpty()) {
            System.out.println("La calle no puede estar vacia.");
            calle = "Calle por defecto";
        }
        //numero
        System.out.print("Numero: ");
        int numero = 0;
        try {
            String numInput = scanner.nextLine().trim();
            if (!numInput.isEmpty()) {
                numero = Integer.parseInt(numInput);
                if (numero <= 0) {
                    System.out.println("El numero debe ser positivo.");
                    numero = 0;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Numero invalido.");
        }
        
        //Ciudad
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine().trim();
        if (ciudad.isEmpty()) {
            System.out.println("La ciudad no puede estar vacia.");
            ciudad = "Ciudad por defecto";
        }
        
        //Region
        System.out.print("Region: ");
        String region = scanner.nextLine().trim();
        if (region.isEmpty()) {
            System.out.println("La region no puede estar vacia.");
            region = "Region por defecto";
        }
        
        Direccion direccion = new Direccion(calle, numero, ciudad, region);
        
        // Datos de la persona
        //Nombre
        System.out.println("--- Datos del Empleado ---");
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            nombre = "Nombre por defecto";
        }
        //Edad
        System.out.print("Edad: ");
        int edad = 0;
        try {
            String edadInput = scanner.nextLine().trim();
            if (!edadInput.isEmpty()) {
                edad = Integer.parseInt(edadInput);
                if (edad < 0 || edad > 150) {
                    System.out.println("Edad fuera de rango (0-150)");
                    edad = 0;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Edad invalida.");
        }
        
        //RUT
        System.out.print("RUT (formato: XXXXXXXX-X): ");
        String rutStr = scanner.nextLine().trim();
        RUT rut = null;
        try {
            if (rutStr.isEmpty()) {
                System.out.println("RUT vacio.");
                rut = new RUT("11111111-1");
            } else {
                rut = new RUT(rutStr);
            }
        } catch (RutInvalidoException e) {
            System.out.println("RUT invalido: " + e.getMessage());
            try {
                rut = new RUT("11111111-1");
            } catch (RutInvalidoException ex) {
               
            }
        }
        
        //Telefono
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine().trim();
        if (telefono.isEmpty()) {
            System.out.println("Telefono vacio.");
            telefono = "999999999";
        }
        
        //Area
        System.out.print("Area de trabajo: ");
        String area = scanner.nextLine().trim();
        if (area.isEmpty()) {
            System.out.println("El area no puede estar vacia.");
            area = "Area por defecto";
        }
        
        //Contrato indefinido?
        System.out.print("Contrato indefinido? (true/false): ");
        boolean indefinido = false;
        try {
            String indInput = scanner.nextLine().trim().toLowerCase();
            if (indInput.isEmpty()) {
                System.out.println("Campo vacio.");
            } else if (indInput.equals("true") || indInput.equals("false")) {
                indefinido = Boolean.parseBoolean(indInput);
            } else {
                System.out.println("Valor invalido.");
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada.");
        }
        
        // Crear y agregar el empleado
        Empleado empleado = new Empleado(area, contratoIndefinido, nombre, edad, rut, telefono, direccion, "empleado");
        listaPersonas.add(empleado);
        
        System.out.println("\nEmpleado agregado exitosamente a la lista!");

    }
}
