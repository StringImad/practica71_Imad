/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import Servicios.EscrituraEmpleados;
import Servicios.LecturaEmpleados;
import Servicios.MetodosNecesarios;
import Servicios.Utils;
import clase.pojo.Empleados;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author MSI
 */
public class Prueba {

    public static void main(String[] args) {
        ArrayList<Empleados> listaTerminada = LecturaEmpleados.leerFicheroScanner("RelPerCen.csv");

        System.out.println("Total de profesores: " + listaTerminada.size());

        System.out.println("-----------Ordenando por departamento--------------");
        Collections.sort(listaTerminada, (Empleados l1, Empleados l2) -> l1.getPuesto().compareTo(l2.getPuesto()));
        imprimirLista(listaTerminada);

        Map<String, String> empleadosMap = new TreeMap();
        Map<String, String> empleadosMapMas100Dias = new TreeMap();

        for (Empleados empleados : listaTerminada) {
            if (MetodosNecesarios.calculadorMasDeCienDias(empleados) > 100) {
                empleadosMapMas100Dias.put(empleados.getNombre(), String.valueOf(MetodosNecesarios.calculadorMasDeCienDias(empleados)));

            }
        }

        for (int i = 0; i < listaTerminada.size(); i++) {
            empleadosMap.put(listaTerminada.get(i).getPuesto(), String.valueOf(MetodosNecesarios.contadorNumeroDeTrabajadoresEnCadaPuesto(listaTerminada, listaTerminada.get(i).getPuesto())));
        }
        System.out.println("Imprimiendo Map: Asigantura--------Numero profesores");
        imprimirEstructuraMap(empleadosMap);

        System.out.println("Imprimiendo Map: Nombre--------Dias trabajados");
        imprimirEstructuraMap(empleadosMapMas100Dias);

        System.out.println("Escribiendo fichero profesores por departamento....");
        EscrituraEmpleados.generarTSV(empleadosMap, "profesoresPorDepartamento.csv");

        System.out.println("Escribiendo fichero empleados mas de 100 dias....");

        EscrituraEmpleados.generarTSV(empleadosMapMas100Dias, "empleadosMasDeCienDias.csv");

        System.out.println("Esta el empleado llamado Alberto?");
        System.out.println(Utils.hayEmpleado(listaTerminada, "Alberto"));
        System.out.println("Esta el empleado llamado Mario?");
        System.out.println(Utils.hayEmpleado(listaTerminada, "Mario"));

        System.out.println("Cuantos coordinadores hay en Matemáticas P.E.S.");
        System.out.println(Utils.numeroEmpleadosCoordinadores(listaTerminada, "Matemáticas P.E.S."));

        System.out.println("Lista empleados con la letra X");

List<String> empleadosMismaLetra = Utils.empleadosMismaLetraDni(listaTerminada, "X");
        //ordenamos alfabeticamente por apellidos
     //   Collections.sort(empleadosMismaLetra, (Empleados l1, Empleados l2) -> l1.getApellidos().compareTo(l2.getApellidos()));
    //   imprimirLista((ArrayList<String>) empleadosMismaLetra);
for (String string : empleadosMismaLetra) {
            System.out.println(string);
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Lista dni empleados con fecha de toma 2010/09/01");
        List<String> listaDni = Utils.empleadosMismaFecha(listaTerminada, LocalDate.of(2010, Month.SEPTEMBER, 01));
        listaDni.forEach(string -> {
            System.out.println(string);
        });
    }

    private static void imprimirEstructuraMap(Map<String, String> empleados) {

        //Bucle que recorre la estructura map, imprimiendo la clave y el valor
        for (String key : empleados.keySet()) {
            System.out.printf("id %s -- valor %s %n", key, empleados.get(key));

        }
    }

    private static void imprimirLista(ArrayList<Empleados> lista) {
        for (Empleados empleados : lista) {
            System.out.println(empleados);
        }
    }

}
