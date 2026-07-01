
package segundoparcialprogramacion2;

import java.io.Serializable;

public class Libro implements Serializable, Comparable<Libro>{
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    private int contadorPrestados;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
        this.contadorPrestados = 0;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public int getCantidadPrestados() {
        return contadorPrestados;
    }

    public void sumaCantidad() {
        contadorPrestados++;
    }
    
    

    public boolean isDisponible() {
        return disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Libro libro = (Libro) o;
        
        return this.getCodigo().equals(libro.getCodigo());
    }
    
    @Override
    public int compareTo(Libro l) {
        return l.getCantidadPrestados() - this.contadorPrestados;
    }

    @Override
    public String toString() {
        return "TITULO: " + titulo + ", Autor: " + autor + ", ISBN: " + codigo + ", ANIO: " + anioPublicacion + ", DISPONIBLE: " + disponible;
    }
}
