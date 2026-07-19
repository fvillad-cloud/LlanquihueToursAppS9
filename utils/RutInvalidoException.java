/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * Excepcion personalizada que se lanza cuando un RUT no cumple con el formato valido.
 * 
 * Esta excepcion extiende Exception, por lo que es una excepcion verificada (checked).
 * Se utiliza principalmente en la clase RUT para indicar que el formato del RUT
 * proporcionado no es valido.
 * 
 * El uso de esta excepcion permite un manejo específico de errores relacionados
 * con RUT.
 * 
 * @author Francisco
 */


public class RutInvalidoException extends Exception {

    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}

