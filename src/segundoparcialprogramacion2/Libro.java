
package segundoparcialprogramacion2;

public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
    }
    
    public String getCodigo() {
        return codigo;
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
    public String toString() {
        return "TITULO: " + titulo + ", Autor: " + autor + ", ISBN: " + codigo + ", ANIO: " + anioPublicacion + ", DISPONIBLE: " + disponible;
    }
}
