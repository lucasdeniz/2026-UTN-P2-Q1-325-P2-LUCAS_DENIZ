
package segundoparcialprogramacion2;

import java.util.ArrayList;


public class Repositorio<T> {
    private ArrayList<T> lista;
    
    
    public Repositorio(){
        lista = new ArrayList<>();
    }
    
    public boolean agregar(T objeto){
        if(lista.contains(objeto)){
            return false;
        }
        lista.add(objeto);
        return true;
    }
    
    public void listar(){
        for(T objeto : lista){
            System.out.println(objeto);
        }
    }
    
    public T buscar(T objeto){
        for(T elemento : lista){
            if(elemento.equals(objeto)){
                return elemento;
            }
        }
        return null;
    }
    
    public boolean eliminar(T objeto){
        return lista.remove(objeto);
    }

    public ArrayList<T> getLista() {
        return lista;
    }
    
    
    
}
