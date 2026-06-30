
package segundoparcialprogramacion2;

import java.util.HashMap;
import java.util.Scanner;

public class Biblioteca {
    Scanner entrada = new Scanner(System.in);
    private Repositorio<Socio> socios;
    private HashMap<String, Socio> mapaSocios;
    private Repositorio<Libro> libros;
    private HashMap<String, Libro> mapaLibros;
    
    
    public Biblioteca(){
        socios = new Repositorio<>();
        mapaSocios = new HashMap<>();
        libros = new Repositorio<>();
        mapaLibros = new HashMap<>();
    }
    
    private Socio crearSocio(){
        String nombre;
        String apellido;
        String dni;
        
        do{
            System.out.println("Ingrese el NOMBRE del socio: ");
            nombre = entrada.nextLine();
            if(nombre != null && !nombre.isBlank()){
                break;
            }
            System.out.println("Ingrese un nombre VALIDO...");
        }while(true);
        
        do{
            System.out.println("Ingrese el APELLIDO del socio: ");
            apellido = entrada.nextLine();
            if(apellido != null && !apellido.isBlank()){
                break;
            }
            System.out.println("Ingrese un APELLIDO VALIDO...");
        }
        while(true);
        
        do{
            System.out.println("Ingrese el DNI del socio: ");
            dni = entrada.nextLine();
            if(dni != null && !dni.isBlank()){
                break;
            }
            System.out.println("Ingrese un DNI VALIDO...");
        }
        while(true);
        
        Socio nuevoSocio = new Socio(nombre,apellido,dni);
        
        return nuevoSocio;
    }
    
    public boolean registrarSocio(){
        Socio socio = crearSocio();
        if(socios.agregar(socio)){
            mapaSocios.put(socio.getDni(), socio);
            System.out.println(mapaSocios);
            return true;
        }
        
        return false;
    }
    
    public void listarSocios(){
        for(Socio socio : socios.getLista()){
            System.out.println(socio);
        }
    }
    
    private Libro crearLibro(){
        String codigo;
        String titulo;
        String autor;
        int anioPublicacion;

        do{
            System.out.println("Ingrese el TITULO del libro: ");
            titulo = entrada.nextLine();
            if(titulo != null && !titulo.isBlank()){
                break;
            }
            System.out.println("Ingrese un TITULO VALIDO...");
        }while(true);
        
        do{
            System.out.println("Ingrese el CODIGO del libro: ");
            codigo = entrada.nextLine();
            if(codigo != null && !codigo.isBlank()){
                break;
            }
            System.out.println("Ingrese un CODIGO VALIDO...");
        }while(true);
        
        do{
            System.out.println("Ingrese el AUTOR del libro: ");
            autor = entrada.nextLine();
            if(autor != null && !autor.isBlank()){
                break;
            }
            System.out.println("Ingrese un AUTOR VALIDO...");
        }while(true);
        
        do{
            System.out.println("Ingrese el ANIO de publicacion: ");
            anioPublicacion = entrada.nextInt();
            entrada.nextLine();
            if((anioPublicacion >= 1500 && anioPublicacion <= 2026)){
                break;
            }
            System.out.println("Ingrese un ANIO VALIDO...");
        }while(true);
        
        Libro nuevoLibro = new Libro(codigo, titulo, autor ,anioPublicacion);
        
        return nuevoLibro;
    }
    
    public boolean registrarLibro(){
        Libro nuevoLibro = crearLibro();
        
        if(libros.agregar(nuevoLibro)){
            mapaLibros.put(nuevoLibro.getCodigo(), nuevoLibro);
            return true;
        }
        return false;
    }
    
    public void listarLibros(){
        for(Libro libro : libros.getLista()){
            if(libro.isDisponible()){
                System.out.println(libro);
            }
        }
    }
    
    
    
    public Libro buscarLibroPorISBN(String isbn){
        if(isbn != null && !isbn.isBlank()){
            Libro libroEncontrado = mapaLibros.get(isbn);
            if(libroEncontrado != null){
                return libroEncontrado;
            }
        }
        System.out.println("Libro NO ENCONTRADO");
        return null;
    }
}
