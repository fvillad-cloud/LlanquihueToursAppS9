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
 * Clase que representa a un Proveedor en el sistema.
 * Extiende la clase Persona e implementa la interfaz Registrable.
 * 
 * Un proveedor tiene atributos específicos como:
 * - Tipo de servicio que ofrece (gastronomico, turistico, transporte, etc.)
 * - Estado de vigencia (activo o inactivo)
 * 
 * @author Francisco
 */
public class Proveedor extends Persona {
    private String tipoServicio;
    private boolean vigente;

    /**
     * Constructor completo para crear un objeto Proveedor con todos sus atributos.
     * 
     * @param tipoServicio Tipo de servicio que ofrece el proveedor
     * @param vigente Estado de vigencia (true = activo, false = inactivo)
     * @param nombre Nombre completo del proveedor
     * @param edad Edad del proveedor
     * @param rut Objeto RUT del proveedor (validado)
     * @param telefono Numero de telefono del proveedor
     * @param direccion Objeto Direccion del proveedor
     * @param tipoDePersona Tipo de persona (siempre sera "proveedor")
     */
    
    public Proveedor(String tipoServicio, boolean vigente, String nombre, int edad, RUT rut, String telefono, Direccion direccion, String tipoDePersona) {
        super(nombre, edad, rut, telefono, direccion, "proveedor");
        this.tipoServicio = tipoServicio;
        this.vigente = vigente;
    }

    //get and set
    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
    
    /**
     * Representación en String del proveedor con todos sus atributos.
     * Incluye los datos heredados de Persona y los especificos de Proveedor.
     * 
     * @return String con la informacion completa del proveedor
     */
    
    @Override
    public String toString(){
    return super.toString() +
           "\nTipo de Servicio    : " + tipoServicio +
           "\nVigente             : " + (vigente ? "Si" : "No");
    }
    
    /**
     * Muestra un resumen del proveedor con todos sus atributos.
     * Similar a toString() pero con formato especifico para listados.
     * 
     * @return String con el resumen del proveedor
     */
    
     @Override
    public String mostrarResumen(){
    return super.toString() +
           "\nTipo de Servicio    : " + tipoServicio +
           "\nVigente             : " + (vigente ? "Si" : "No");
    }
    
    /**
     * Registra un nuevo proveedor en el sistema mediante entrada interactiva.
     * Implementa el metodo de la interfaz Registrable.
     * 
     * Este metodo solicita al usuario todos los datos necesarios para crear un proveedor:
     * - Datos de dirección (calle, numero, ciudad, region)
     * - Datos personales (nombre, edad, RUT, telefono)
     * - Datos específicos de proveedor (tipo de servicio, vigencia)
     * 
     * Incluye validaciones para cada campo, proporcionando valores por defecto
     * cuando la entrada es invalida o vacia.
     * 
     * @param scanner Objeto Scanner para leer la entrada del usuario
     * @param listaPersonas Lista donde se agregara el nuevo proveedor
     */
    
    @Override
    public void registrar(Scanner scanner, ArrayList<Persona> listaPersonas){
        
        System.out.println("\n=== REGISTRO DE NUEVO PROVEEDOR (MEMORIA) ===");
        
        // Datos de dirección
        //Calle
        System.out.println("--- Datos de Direccion ---");
        System.out.print("Calle: ");
        String calle = scanner.nextLine().trim();
        if (calle.isEmpty()) {
            System.out.println("La calle no puede estar vacia.");
            calle = "Calle por defecto";
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
        System.out.println("--- Datos del Proveedor ---");
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
                // Esto no debería ocurrir
            }
        }
        
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine().trim();
        if (telefono.isEmpty()) {
            System.out.println("Telefono vacio.");
            telefono = "999999999";
        }
        
        System.out.print("Tipo de servicio: ");
        String tipoServicio = scanner.nextLine().trim();
        if (tipoServicio.isEmpty()) {
            System.out.println("El tipo de servicio no puede estar vacio.");
            tipoServicio = "Servicio por defecto";
        }
        
        System.out.print("Vigente? (true/false): ");
        boolean vigente = false;
        try {
            String vigInput = scanner.nextLine().trim().toLowerCase();
            if (vigInput.isEmpty()) {
                System.out.println("Campo vacio.");
            } else if (vigInput.equals("true") || vigInput.equals("false")) {
                vigente = Boolean.parseBoolean(vigInput);
            } else {
                System.out.println("Valor invalido.");
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada.");
        }
        
        // Crear y agregar el proveedor
        Proveedor proveedor = new Proveedor(tipoServicio, vigente, nombre, edad, rut, telefono, direccion, "proveedor");
        listaPersonas.add(proveedor);
        
        System.out.println("\nProveedor agregado exitosamente a la lista en memoria!");
    }
    
    
}
