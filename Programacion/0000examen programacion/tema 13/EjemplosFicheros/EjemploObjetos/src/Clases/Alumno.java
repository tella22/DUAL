package Clases;

import java.io.Serializable;

public class Alumno implements Serializable{
    private String nombre;
    private int nota;
    
    public Alumno(String nombre, int nota){
        this.nombre=nombre;
        this.nota=nota;
    }
    
    public String toString(){
        return "Nombre: "+nombre+", nota: "+nota;
    }
    
}
