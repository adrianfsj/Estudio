package estuido_proyecto2;

import java.io.*;

public class Persona implements Serializable {
    private String nombre;
    private int anioNacimiento;
    
    public Persona(String nombre, int anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getAnioNacimiento() {
        return anioNacimiento;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }
    
    public String toString() {
        return "Persona [nombre=" + nombre + ", anioNacimiento=" + anioNacimiento + "]";
    }
}

