/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import utils.RutInvalidoException;
import model.RUT;
import model.Direccion;
import model.Empleado;
import model.Proveedor;
import model.Persona;
import model.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de la gestion y lectura de datos desde archivos de texto.
 * Proporciona metodos para leer direcciones y personas desde archivos,
 * transformando los datos en objetos.
 * 
 * @author Francisco
 */
public class GestorDeDatos {
    
    /**
     * Metodo que lee archivo txt con direcciones, lo transforma en objetos del tipo direccion y luego lo añade
     * a una lista de objetos de tipo direccion.
     * 
     * @param rutaDirecciones Ruta del archivo de texto que contiene las direcciones
     * @return ArrayList de objetos Direccion con todas las direcciones leídas del archivo.
     */
    
    public ArrayList<Direccion> leerDirecciones(String rutaDirecciones){
        ArrayList<Direccion> direcciones = new ArrayList<>();
        
        try (BufferedReader scan = new BufferedReader(new FileReader(rutaDirecciones))) {
            String linea;
            
            while((linea = scan.readLine())!=null){
                //Dividir la linea por punto y coma
                String partes[]=linea.split(";");
               
                //Verifica que la linea tenga 4 partes
                if(partes.length == 4){
                    String calle = partes[0];
                    int numero = Integer.parseInt(partes[1]);
                    String ciudad = partes[2];
                    String region = partes[3];
                    
                    Direccion direccion = new Direccion(calle, numero, ciudad, region);
                    direcciones.add(direccion);
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de direcciones: " + e.getMessage());
        }
        return direcciones;
    }
    
    /**
     * Lee un archivo de personas y crea objetos Persona con sus respectivas direcciones.
     * 
     * Este mtodo realiza las siguientes operaciones:
     * 1. Lee todas las direcciones del archivo de direcciones
     * 2. Lee cada linea del archivo de personas
     * 3. Valida el Rut de cada persona
     * 4. Asigna una direccion a cada persona (en orden de aparicion)
     * 5. Crea el objeto especifico segun el tipo (Cliente, Empleado o Proveedor)
     * 
     * @param rutaPersonas Ruta del archivo de texto que contiene los datos de las personas
     * @param rutaDirecciones Ruta del archivo de texto que contiene las direcciones
     * @return ArrayList de objetos Persona con todas las personas leídas del archivo.
     */
    
    public ArrayList<Persona> leerPersonas(String rutaPersonas, String rutaDirecciones){
        ArrayList<Persona> personas = new ArrayList<>();
        
        //Leemos todas la direcciones disponibles
        ArrayList<Direccion> direcciones = leerDirecciones(rutaDirecciones);
        
        try (BufferedReader scan = new BufferedReader(new FileReader(rutaPersonas))) {
            String linea;
            int indiceDireccion=0;
            
            while((linea = scan.readLine())!=null){
                String partes[] = linea.split(";");
                
                if(partes.length >=7){
                    String nombre = partes[0];
                    int edad = Integer.parseInt(partes[1]);
                    String numeroRut = partes[2];
                    String fono = partes[3];
                    String tipoPersona = partes[4].toLowerCase();
                    
                    //validacion del RUT
                    RUT rut = null;
                    
                    try {
                        rut = new RUT(numeroRut);
                    } catch (RutInvalidoException e) {
                        System.out.println("Error en RUT: " + e.getMessage() + " - RUT: " + numeroRut);
                        continue;
                    }
                    
                    Direccion direccion = null;
                    if(indiceDireccion < direcciones.size()){
                        direccion = direcciones.get(indiceDireccion);
                        indiceDireccion++;
                    }
                    
                    //Crea el objeto segun el tipo: cliente, proveedor o empleado.
                    Persona persona = null;
                    switch (tipoPersona) {
                        case "cliente":
                            boolean preferencial = Boolean.parseBoolean(partes[5]);
                            int puntos = Integer.parseInt(partes[6]);
                            
                            persona = new Cliente(preferencial, puntos, nombre, edad, rut, fono, direccion,"cliente");
                            
                            break;
                        case "proveedor":
                            String tipoServicio = partes[5];
                            boolean vigencia = Boolean.parseBoolean(partes[6]);
                            
                            persona = new Proveedor(tipoServicio, vigencia, nombre, edad, rut, fono, direccion,"proveedor");
                            break;
                        case "empleado":
                            String area = partes[5];
                            boolean indefinido = Boolean.parseBoolean(partes[6]);
                            
                            persona = new Empleado(area, indefinido, nombre, edad, rut, fono, direccion,"empleado");
                            break;
                        default:
                            System.out.println("Tipo de persona no valido! "+tipoPersona);
                    }
                    
                    //agrega persona creada
                    personas.add(persona);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de direcciones: " + e.getMessage());
        }
        return personas;
    }    
    
    
}
