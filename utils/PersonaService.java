/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import model.Empleado;
import model.Proveedor;
import model.Persona;
import model.Cliente;
import java.util.ArrayList;

/**
 * Clase de servicio que proporciona operaciones de negocio sobre una lista de personas.
 * 
 * Esta clase actua como una capa de servicio entre la interfaz de usuario (Main)
 * y el modelo de datos (Persona y sus subclases). Encapsula la logica de:
 * - Listado de todas las personas
 * - Filtrado por tipo (cliente, empleado, proveedor)
 * 
 * Utiliza el principio de polimorfismo para trabajar con cualquier tipo de Persona,
 * y realiza comprobaciones de tipo mediante el operador instanceof.
 * 
 * @author Francisco
 */
public class PersonaService {
    private ArrayList<Persona> personas;

    public PersonaService(ArrayList<Persona> personas) {
        this.personas = personas;
    }
   
    /**
     * Lista todas las personas almacenadas en el servicio.
     * 
     * Si la lista esta vacia, se muestra un mensaje.
     * En caso contrario, imprime en consola la representación completa
     * de cada persona (usando su método toString()).
     * 
     * El formato de salida depende de la implementación de toString()
     * en cada subclase.
     */
    public void listarPersonas(){
        if (personas.isEmpty()){
            System.out.println("No hay datos de personas para mostrar.");
        }else{
            for (Persona persona:personas){
                System.out.println(persona);
            }
        }
    }
    
   /**
     * Filtra una lista de personas segun su tipo (cliente, empleado o proveedor).
     * 
     * Este metodo recorre la lista original y verifica el tipo de cada objeto
     * usando el operador instanceof. Solo agrega a la lista filtrada aquellos
     * objetos que coinciden con el tipo solicitado.
     *
     * 
     * @param personas Lista de personas a filtrar.
     * @param tipo Tipo de persona a filtrar: "cliente", "empleado" o "proveedor"
     * @return ArrayList con las personas que coinciden con el tipo especificado.
     *         Si el tipo no es valido, retorna una lista vacia y muestra un mensaje.
     */
    
   public ArrayList<Persona> filtrarPorTipo(ArrayList<Persona> personas, String tipo){
       ArrayList<Persona> filtradas = new ArrayList<>();
       String tipoFormateado = tipo.trim().toLowerCase();
       
       for(Persona p:personas){
           boolean coincide = false;
           
           switch (tipoFormateado) {
               case "cliente":
                   if(p instanceof Cliente){
                       coincide = true;
                   }
                   break;
                
               case "proveedor":
                   if(p instanceof Proveedor){
                       coincide = true;
                   }
                   break;
               case "empleado":
                   if(p instanceof Empleado){
                       coincide = true;
                   }
                   break;
               default:
                   System.out.println("Tipo de persona no valido: "+tipoFormateado);
           }
           if(coincide){
               filtradas.add(p);
           }
       }
       return filtradas;
   }
}
