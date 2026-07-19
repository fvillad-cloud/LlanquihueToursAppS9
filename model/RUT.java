/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import utils.RutInvalidoException;

/**
 * Clase que representa un RUT.
 * 
 * Esta clase encapsula la logica de validacion y representacion de un RUT,
 * asegurando que cumpla con el formato estandar chileno: numeros seguidos
 * de un guion y un digito verificador.
 * 
 * El formato valido es: "XXXXXXXX-X" donde:
 * - Los numeros pueden ser de 7 a 8 dígitos
 * - El guion separa el número del digito verificador
 * - El digito verificador puede ser un número (0-9) o la letra 'k'.
 * 
 * @author Francisco
 */
public class RUT {
    // Número del RUT en formato String
    private String numero;

    /**
     *
     * Constructor que crea un objeto RUT y valida su formato.
     *
     * @param numero RUT en formato "XXXXXXXX-X" (ej: 17234567-8)
     * @throws RutInvalidoException Si el formato del RUT no es válido
     *
     */
    public RUT(String numero) throws RutInvalidoException{
        if(!numero.matches("[0-9]+-[0-9kK]")){
            throw new RutInvalidoException("Formato de RUT no valido.");
        }
        this.numero = numero;
    }
    
     public String getNumero() {
        return numero;
    }

    /**
     * Representación en String del RUT con formato legible.
     * 
     * @return String con el formato "RUT                 : XXXXXXXX-X"
     */
     
    @Override
    public String toString() {
        return "RUT                 : " + numero;
    }
}
