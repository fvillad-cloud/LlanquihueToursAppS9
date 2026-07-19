/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import utils.RutInvalidoException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa a un Cliente en el sistema.
 * Hereda de la clase Persona e implementa la interfaz Registrable.
 * 
 * Cliente tiene 2 atributos especificos:
 *  * Si es preferencial (cliente VIP)
 *  * puntos acumulados (sistema de fidelizacion)
 * 
 * @author Francisco
 */
public class Cliente extends Persona implements Registrable{
    private boolean preferencial;
    private int puntosAcumulados;
/**
 * Constructor completo para crear un objeto Cliente con todos sus atributos.
 * 
 * @param preferencial Indica si el cliente es preferencial (true) o no (false)
 * @param puntosAcumulados Cantidad de puntos acumulados en el sistema
 * @param nombre Nombre completo del cliente
 * @param edad Edad del cliente
 * @param rut Objeto RUT del cliente (validado)
 * @param telefono Numero de telefono del cliente
 * @param direccion Objeto Direccion del cliente
 * @param tipoDePersona Tipo de persona (siempre será "cliente")
 */
    
    public Cliente(boolean preferencial, int puntosAcumulados, String nombre, int edad, RUT rut, String telefono, Direccion direccion, String tipoDePersona) {
        super(nombre, edad, rut, telefono, direccion, "cliente");
        this.preferencial = preferencial;
        this.puntosAcumulados = puntosAcumulados;
    }

    //Setter and getters.

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }
    
     /**
     * Representación en String del cliente con todos sus atributos.
     * Incluye los datos heredados de Persona y los especificos de Cliente.
     * 
     * @return String con la información completa del cliente.
     */
    @Override
    public String toString(){
    return super.toString() +
           "\nPreferencial        : " + (preferencial ? "Si" : "No") +
           "\nPuntos Acumulados   : " + puntosAcumulados;
    }
    
     /**
     * Muestra un resumen del cliente con todos sus atributos.
     * Similar a toString() pero con formato específico para listados.
     * 
     * @return String con el resumen del cliente.
     */
    @Override
    public String mostrarResumen(){
    return super.toString() +
           "\nPreferencial        : " + (preferencial ? "Si" : "No") +
           "\nPuntos Acumulados   : " + puntosAcumulados;
    }
    
    /**
     * Registra un nuevo cliente en el sistema mediante entrada interactiva.
     * Implementa el metodo de la interfaz Registrable.
     * 
     * Este metodo solicita al usuario todos los datos necesarios para crear un cliente:
     * * Datos de dirección (calle, número, ciudad, región)
     * * Datos personales (nombre, edad, RUT, teléfono)
     * * Datos específicos de cliente (preferencial, puntos)
     * 
     * Incluye validaciones para cada campo, proporcionando valores por defecto
     * cuando la entrada es invalida o vacia.
     * 
     * @param scanner Objeto Scanner para leer la entrada del usuario
     * @param listaPersonas Lista donde se agregará el nuevo cliente
     */
    @Override
    public void registrar(Scanner scanner, ArrayList<Persona> listaPersonas){
         System.out.println("\n=== REGISTRO DE NUEVO CLIENTE ===");
         
        // Datos de dirección
        //Calle
        System.out.println("--- Datos de Direccion ---");
        System.out.print("Calle: ");
        String calle = scanner.nextLine().trim();
        if (calle.isEmpty()) {
            System.out.println("La calle no puede estar vacia.");
            calle="Calle por defecto";
        }
        //Numero
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
        System.out.println("--- Datos del Cliente ---");
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
                    System.out.println("Edad fuera de rango (0-150).");
                    edad = 0;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Edad invalida.");
        }
        //Rut...
        System.out.print("RUT (formato: XXXXXXXX-X): ");
        String numeroRut= scanner.nextLine().trim();
        RUT rut = null;
        try {
            if (numeroRut.isEmpty()) {
                System.out.println("RUT vacio.");
                rut = new RUT("11111111-1");
            } else {
                rut = new RUT(numeroRut);
            }
        } catch (RutInvalidoException e) {
            System.out.println("RUT invalido: " + e.getMessage() + ".");
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
        
        //Cliente preferencial tru/false
        
        System.out.print("Es cliente preferencial? (true/false): ");
        boolean preferencial = false;
        try {
            String prefInput = scanner.nextLine().trim().toLowerCase();
            if (prefInput.isEmpty()) {
                System.out.println("Campo vacio.");
            } else if (prefInput.equals("true") || prefInput.equals("false")) {
                preferencial = Boolean.parseBoolean(prefInput);
            } else {
                System.out.println("Valor invalido.");
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada.");
        }
        
        //Puntos acumulados del cliente
        
        System.out.print("Puntos acumulados: ");
        int puntos = 0;
        try {
            String puntosInput = scanner.nextLine().trim();
            if (puntosInput.isEmpty()) {
                System.out.println("Campo vacio.");
            } else {
                puntos = Integer.parseInt(puntosInput);
                if (puntos < 0) {
                    System.out.println("Los puntos no pueden ser negativos.");
                    puntos = 0;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Puntos invalidos.");
        }
        
        // Crear y agregar el cliente
        Cliente cliente = new Cliente(preferencial, puntosAcumulados, nombre, edad, rut, telefono, direccion, "cliente");
        listaPersonas.add(cliente);
        
        System.out.println("\n Cliente agregado exitosamente a la lista!");
    }
}
