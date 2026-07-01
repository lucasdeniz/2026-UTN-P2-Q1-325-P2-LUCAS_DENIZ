
package segundoparcialprogramacion2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Repositorio<T> implements Serializable{
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
    
    public void guardarDatos(String nombreArchivo) {
        try {
            FileOutputStream archivo = new FileOutputStream(nombreArchivo);
            ObjectOutputStream salida = new ObjectOutputStream(archivo);

            salida.writeObject(lista);

            salida.close();
            archivo.close();
            
            System.out.println("Archivo : " + nombreArchivo + " guardado.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean cargarDatos(String nombreArchivo){
        try{
            FileInputStream archivoEntrada = new FileInputStream(nombreArchivo);
            ObjectInputStream entrada = new ObjectInputStream(archivoEntrada);
            
            lista = (ArrayList<T>) entrada.readObject();
            
            entrada.close();
            archivoEntrada.close();
            
            System.out.println("Archivo : " + nombreArchivo + " cargado.");
            return true;
            
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
