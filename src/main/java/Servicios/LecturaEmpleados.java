/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;


import clase.pojo.Empleados;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author imad
 */
public class LecturaEmpleados {

//metodo publico y estatico que recibe el nombre de un fichero y nos devuelve una lista con los valores que ha leido del fichero
    public static ArrayList<Empleados> leerFicheroScanner(String fichero) {
        ArrayList<Empleados> listaEmpleados = new ArrayList<>();
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero CSV: " + fichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(fichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            //Omitimos la primera linea
            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un Stringç
                linea = datosFichero.nextLine();
                //remplazamos todas las comillas que haya en las lineas que se lean
                linea = linea.replace("\"", "");
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(",");
                Empleados tmp = new Empleados();
                for (String string : tokens) {

                    tmp.setNombre(tokens[1]);

                    tmp.setApellidos(tokens[0]);

                    tmp.setDni(tokens[2]);

                    tmp.setPuesto(tokens[3]);

                    LocalDate fechaTom = LocalDate.parse(tokens[4].replace("\"", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    //inicializo las fechas a null
                    LocalDate fechaCes = null;
                    //si al recibir el string no esta vacio entonces le hacemos el formateo para que no nos de fallo
                    if (!tokens[5].equals("")) {
                        fechaCes = LocalDate.parse(tokens[5], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    }
                    tmp.setFechaDeToma(fechaTom);
                    tmp.setFechaDeCese(fechaCes);
                    tmp.setTelefono(tokens[6]);
                    tmp.setEvaluador(devolverSiNo(tokens[7]));
                    tmp.setCoordinador(devolverSiNo(tokens[8]));
                }
                listaEmpleados.add(tmp);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return listaEmpleados;
    }

//Metodo privado de clase que nos devuelve true si lo que recibe es un si
    private static boolean devolverSiNo(String sN) {
        return sN.equalsIgnoreCase("sí");
    }
}
