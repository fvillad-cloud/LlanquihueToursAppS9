/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;


import data.GestorDeDatos;
import utils.PersonaService;
import model.Registrable;
import model.Empleado;
import model.Proveedor;
import model.Persona;
import model.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal que contiene el punto de entrada de la aplicación.
 * Implementa un menu interactivo para gestionar personas (clientes, empleados y proveedores).
 * Permite listar, buscar por tipo y agregar nuevas personas al sistema (en memoria temporal)
 * @author Francisco
 */
public class Main {
     public static void main(String[] args) {
         
         //Inicia Scanner y gestor de datos.
         Scanner scan = new Scanner(System.in);
         GestorDeDatos gestor = new GestorDeDatos();
         
         //Rutas de archivos
         String rutaPersona ="Datos personas.txt";
         String rutaDireccion = "Direcciones.txt";
         
         //Cara de datos iniciales en lista de Personas.
         ArrayList<Persona> listaPersonas = gestor.leerPersonas(rutaPersona, rutaDireccion);
         
         //Verifica que listaPersonas tenga informacion
         if (listaPersonas.isEmpty()) {
            System.out.println("No se pudieron cargar datos de personas, revise los archivos!.");
            scan.close();
            return;
        }
         
         //inicializa el servicio de personas.
         PersonaService servicio = new PersonaService(listaPersonas);
         
         int opcion=0;
         
         //Inicio del bucle que despliega el menu prncipal.
         do{
            System.out.println("\n***Gestion de Personas ***");
            System.out.println("1. Listar a todas las personas.");
            System.out.println("2. Buscar persona por clasificacion (cliente, empleado o proveedor).");
            System.out.println("3. Agregar Persona.");
            System.out.println("4. Salir.");
            System.out.print("Seleccione una opcion: ");
            
              //Lectura y procesamiento de la opcion seleccionada por el usuario
             try {
                 opcion = Integer.parseInt(scan.nextLine());
                 switch (opcion) {
                     case 1: //Arroja lista con todas las personas 
                         System.out.println("\n=== Listado de Personas ===");
                         servicio.listarPersonas();
                         break;
                     case 2: //Busqueda por tipo de persona cliente, proveedor o empleado.
                         String clasificacion ="";
                         boolean entradaValida = false;
                         
                         //bucle para validar la entrada de tipo de persona
                         
                         while(!entradaValida){
                             System.out.print("Ingrese el tipo de persona (cliente, empleado o proveedor): ");
                             clasificacion=scan.nextLine().trim().toLowerCase();
                             
                             if (clasificacion.isEmpty()){
                                 System.out.println("Error, no puede ingresar un valor vacio.");
                             }else if(!clasificacion.equals("cliente") && !clasificacion.equals("empleado") && !clasificacion.equals("proveedor")){
                                 System.out.println("Error!!,tipo de persona no valido. Debe ser 'cliente', 'empleado' o 'proveedor'.");
                             }else{
                                 entradaValida=true;
                             }
                         }
                         
                         //Filtrado y visualizacion de personas por tipo.
                         ArrayList<Persona> personasFiltradas = servicio.filtrarPorTipo(listaPersonas, clasificacion);
                         
                         
                         System.out.println("=== Listado de "+clasificacion.toUpperCase()+"S ===");
                         for (Persona p: personasFiltradas){
                             System.out.println(p.mostrarResumen());
                         }
                         System.out.println("================================================================================");
                         break;
                         
                      case 3:
                         //Agregar nueva persona... la persona que se agrega se añade a la memoria transitoria y no al archivo txt...
                        System.out.println("\n=== AGREGAR NUEVA PERSONA ===");
                        String tipoPersona = "";
                        boolean tipoValido = false;
                        
                        //validacion del tipo de persona a agregar
                        while (!tipoValido) {
                            System.out.print("Seleccione el tipo de persona (cliente, empleado o proveedor): ");
                            tipoPersona = scan.nextLine().trim().toLowerCase();
                            
                            if (tipoPersona.isEmpty()) {
                                System.out.println("Error, no puede ingresar un valor vacio.");
                            } else if (!tipoPersona.equals("cliente") && !tipoPersona.equals("empleado") && !tipoPersona.equals("proveedor")) {
                                System.out.println("Error, tipo no valido.");
                            } else {
                                tipoValido = true;
                            }
                        }
                        
                        // Crear una instancia temporal para usar el metodo registrar
                        Registrable registrable = null;
                        switch (tipoPersona) {
                            case "cliente":
                                registrable = new Cliente(false, 0, "", 0, null, "", null,"cliente");
                                break;
                            case "empleado":
                                registrable = new Empleado("", false, "", 0, null, "", null,"empleado");
                                break;
                            case "proveedor":
                                registrable = new Proveedor("", false, "", 0, null, "", null,"proveedor");
                                break;
                        }
                        
                        //Registro de la nueva persona
                        if (registrable != null) {
                            // El metodo registrar recibe el Scanner y la lista
                            registrable.registrar(scan, listaPersonas);
                            
                            // Actualizar el servicio con la lista actualizada
                            servicio = new PersonaService(listaPersonas);
                        }
                        break;
                     
                      case 4: //Salir del programa
                          System.out.println("Saliendo del sistema...");
                          break;
                     default:
                         System.out.println("Opcion Invalida. Por favor, seleccione 1, 2, 3 o 4.");;
                 }
             } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
             }catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
             
         }while(opcion!=4);
         
         scan.close();
         
     }
}
