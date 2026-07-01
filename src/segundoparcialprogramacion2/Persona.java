/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundoparcialprogramacion2;

import java.io.Serializable;

public abstract class Persona implements Serializable{
    protected String nombre;
    protected String apellido;
    protected String dni;

    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - DNI " + dni;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        
        Persona persona = (Persona) o;
        
        return this.getDni().equals(persona.getDni());
    }
}
