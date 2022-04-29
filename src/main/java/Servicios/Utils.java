/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import clase.pojo.Empleados;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author MSI
 */
public class Utils {
//Metodo publico de clase que recibe una lista de empleados y un nombre y nos indica si hay algún empleado con ese nombre.
//Devuelve true en caso de que haya un empleado con ese nombre

    public static boolean hayEmpleado(ArrayList<Empleados> lista, String nombre) {
        //  ArrayList<Empleados> listaNueva = lista;
//        for (Empleados empleados : listaNueva) {
//            //Con el .trim conseguimos eleminar los esacios antes y dspues de la cadena, así
//            //evitamos que nos afecte a los nombbres compuestos
//            if (empleados.getNombre().trim().equalsIgnoreCase(nombre)) {
//                return true;
//            }
//        }
//        return false;     
        List<Empleados> listaNueva = lista;
        Boolean existeEmpleado = listaNueva.stream()
                .anyMatch(v -> v.getNombre().equalsIgnoreCase(nombre));
        return existeEmpleado;
    }
//Metodo publico de clase que recibe  una lista de empleados y un nombre de departamento
// y nos devuelve el número de empleados Coordinadores de ese departamento.

    public static long numeroEmpleadosCoordinadores(ArrayList<Empleados> lista, String nombreDepartamento) {
//        ArrayList<Empleados> listaNueva = lista;
//        int contador = 0;
//        for (Empleados empleados : listaNueva) {
//            //Con el .trim conseguimos eleminar los espacios antes y dspues de la cadena
//            if (empleados.getPuesto().trim().equalsIgnoreCase(nombreDepartamento)) {
//                if (empleados.isCoordinador()) {
//                    contador++;
//                }
//            }
//        }
//        return contador;
        List<Empleados> saberCantidad = lista;
        long count = saberCantidad.stream()
                .filter(v -> v.getPuesto().equalsIgnoreCase(nombreDepartamento) && v.isCoordinador())
                //Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles.
                .count();
        return count;
    }
//Metodo publico de clase que recibe una lista de empleados y una letra del NIF (char)
    // nos devuelve una nueva lista ordenada alfabéticamente SOLO con los apellidos de los empleados cuyo NIF contiene letraDni.

    public static List<String> empleadosMismaLetraDni(ArrayList<Empleados> lista, String letraDni) {
//        ArrayList<Empleados> listaNueva = lista;
        //List<String> listaMismaLetraS = new ArrayList<>();
//        for (Empleados empleados : listaNueva) {
//            if (empleados.getDni().trim().substring(8, 9).equalsIgnoreCase(letraDni)) {
//                listaMismaLetra.add(empleados);
//            }
//        }
//        return listaMismaLetra;
        List<Empleados> listaMismaLetra = lista;
        List<String> listaMismaLetras = listaMismaLetra.stream()
                .filter(v -> v.getDni().contains(letraDni))
                .map(p -> p.getApellidos())
                .sorted()
                .collect(Collectors.toList());

        return listaMismaLetras;

    }

    //Metodo publico de clase que recibe una lista de empleados  y una fecha, 
    //devuelve una nueva lista con los NIF (ordenados de forma inversa) de todos los empleados cuya toma de posesión coincida con esa fecha.
    public static List<String> empleadosMismaFecha(ArrayList<Empleados> lista, LocalDate fecha) {
//        ArrayList<Empleados> listaNueva = lista;
//        ArrayList<String> listaNifOrdenadosInversa = new ArrayList<>();
//        for (Empleados empleados : listaNueva) {
//            if (empleados.getFechaDeToma().equals(fecha)) {
//                listaNifOrdenadosInversa.add(empleados.getDni());
//            }
//        }
//        //con el reverse utilizamos el orden invertido
//        Collections.reverse(listaNifOrdenadosInversa);
//        return listaNifOrdenadosInversa;
//        

        List<Empleados> listaNifOrdenadosInversa = lista;
        List<String> listaOr = listaNifOrdenadosInversa.stream()
                .filter(v -> v.getFechaDeToma().equals(fecha))
                .map(p -> p.getDni())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return listaOr;
    }
}
