/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author MSI
 */
public class EscrituraEmpleados {

    public static void generarTSV(Map<String, String> empleadosMap, String ruta) {
        System.out.println("Tam del map: " + empleadosMap.size());
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            for (String key : empleadosMap.keySet()) {
                //flujo.write sirve para escribir en el fichero
                flujo.write(key + "\t" + empleadosMap.get(key));
                //flujo.newLine sirve para pasar a la siguiente linea
                flujo.newLine();
            }
//            for (Map.Entry<String, String> pair : empleadosMap.entrySet()) {
//              
//                //flujo.write sirve para escribir en el fichero
//                flujo.write(pair.getKey() + "\t" + pair.getValue());
//                //flujo.newLine sirve para pasar a la siguiente linea
//                flujo.newLine();
//            }
            //flujo.flush sirve para liberar el buffer
            flujo.flush();

        } catch (IOException e) {
            System.out.println("No se ha podido introducir");

        }
    }

}
