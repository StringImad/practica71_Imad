/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import clase.pojo.Empleados;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class MetodosNecesarios {

    //metodo public statico que nos devuelve el numero de trabajadores en cada puesto
    public static int contadorNumeroDeTrabajadoresEnCadaPuesto(ArrayList<Empleados> lista, String puesto) {
        ArrayList<Empleados> listaUsada = lista;
        int contador = 0;
        for (int i = 0; i < listaUsada.size(); i++) {
            if (listaUsada.get(i).getPuesto().contains(puesto)) {
                contador++;
            }
        }
        return contador;
    }

    //metodo publico estatico que calcula los dias que pasan entre dos fechas y nos devuelve si la condicion se cumple
    public static int calculadorMasDeCienDias(Empleados em) {
        LocalDate fechaToma, fechaCese;
        fechaToma = em.getFechaDeToma();
        fechaCese = em.getFechaDeCese();
        //si la fecha de cese es null calculamos a base del dia actual
        if (em.getFechaDeCese() == null) {
            fechaCese = LocalDate.now();
        }
        return (int) ChronoUnit.DAYS.between(fechaToma, fechaCese);

    }
}
