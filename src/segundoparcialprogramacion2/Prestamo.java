
package segundoparcialprogramacion2;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Prestamo implements Serializable{
     private static int contadorId = 1;
    private String idPrestamo;
    private Libro libro;
    private Socio socio;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
    private boolean activo;
    
    public Prestamo(Libro libro, Socio socio) {
        this.libro = libro;
        this.socio = socio;
        this.activo = true;
        this.idPrestamo = String.valueOf(contadorId++);
        
        this.fechaPrestamo = LocalDateTime.now();//el prestamo se genera con la fecha y hora del sistema
        this.fechaDevolucion = LocalDateTime.now().plusDays(10);//se genera con la fecha y hora actual + 10 dias
    }

    public Libro getLibro() {
        return libro;
    }

    public Socio getSocio() {
        return socio;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }
    
    public String estadoString() {
        if(isActivo()){
            return "ACTIVO";
        }
        return "DEVUELTO";
    }
    
    

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Prestamo prestamo = (Prestamo) o;
        
        return this.getIdPrestamo().equals(prestamo.getIdPrestamo());
    }
    
    
    
    @Override
    public String toString() {
        String separador = "********************************";
        return separador + "\n" + "ID: " + idPrestamo + "\nSOCIO: " + socio.toString() + "\nLIBRO: " + libro.getTitulo() + "\nFECHA PRESTAMO: " + fechaPrestamo + "\nESTADO: " + estadoString() + "\n" +separador;
    }
}
