/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase.pojo;

import java.time.LocalDate;

/**
 *
 * @author imad
 */
public class Empleados {
//Declaracion de atributos privados 
    private String nombre,apellidos, dni, puesto;
    private LocalDate fechaDeToma, fechaDeCese;
    private String telefono;
    private boolean evaluador, coordinador;
//constructor por defecto
    public Empleados() {
    }
//Metodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LocalDate getFechaDeToma() {
        return fechaDeToma;
    }

    public void setFechaDeToma(LocalDate fechaDeToma) {
        this.fechaDeToma = fechaDeToma;
    }

    public LocalDate getFechaDeCese() {
        return fechaDeCese;
    }

    public void setFechaDeCese(LocalDate fechaDeCese) {
        this.fechaDeCese = fechaDeCese;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEvaluador() {
        return evaluador;
    }

    public void setEvaluador(boolean evaluador) {
        this.evaluador = evaluador;
    }

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }
//toString separado por punto y coma
    @Override
    public String toString() {
        return  nombre+";" + apellidos+";" + dni + ";" + puesto + ";" + fechaDeToma + ";" + fechaDeCese + ";" + telefono + ";" + evaluador + ";" + coordinador;
    }


    
    
}
