/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundoparcialprogramacion2;

public class Socio extends Persona{
    private static int contadorId = 1;
    private String idSocio;

    public Socio(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
        idSocio = String.valueOf(contadorId++);
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "ID SOCIO: " + idSocio + " - " + super.toString();
    }
    
    
}
