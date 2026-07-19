/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Clase que representa una dirección fisica de una persona en el sistema.
 * 
 * Una direccion esta compuesta por los elementos basicos de una ubicacion:
 * - Calle 
 * - Número 
 * - Ciudad 
 * - Region 
 * 
 * Esta clase es utilizada como componente de la clase Persona y sus subclases
 * (Cliente, Empleado, Proveedor) para almacenar la informacio de ubicacion.
 * 
 * @author Francisco
 */
public class Direccion {
    private String calle;
    private int numero;
    private String ciudad;
    private String region;

     /**
     * Constructor que inicializa todos los atributos de la direccion.
     * 
     * @param calle Nombre de la calle 
     * @param numero Número de la propiedad 
     * @param ciudad Ciudad donde se ubica 
     * @param region Región donde se ubica 
     */
    public Direccion(String calle, int numero, String ciudad, String region) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.region = region;
    }

    //getter and setters
    
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    
    /**
     * Representación en String de la direccion con un formato legible.
     * 
     * @return String formateado con todos los datos de la dirección
     */
   
    
    @Override
    
    public String toString(){
        return "Direccion           : Calle "+calle+" #"+numero+", "+ciudad+", Region "+region+".";
    }
}
