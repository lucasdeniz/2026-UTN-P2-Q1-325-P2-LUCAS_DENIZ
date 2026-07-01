
package segundoparcialprogramacion2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Biblioteca implements Exportable{
    Scanner entrada = new Scanner(System.in);
    private Repositorio<Socio> socios;
    private HashMap<String, Socio> mapaSocios;
    private Repositorio<Libro> libros;
    private HashMap<String, Libro> mapaLibros;
    private Repositorio<Prestamo> prestamos;
    private HashMap<Libro, Prestamo> mapaPrestamos;
    
    
    public Biblioteca(){
        socios = new Repositorio<>();
        mapaSocios = new HashMap<>();
        libros = new Repositorio<>();
        mapaLibros = new HashMap<>();
        prestamos = new Repositorio<>();
        mapaPrestamos = new HashMap<>();
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
    
    private int calcularLibrosDisponibles(){
        int contador = 0;
        for(Libro libro : libros.getLista()){
            if(libro.isDisponible()){
                contador++;
            }
        }
        return contador;
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
    
    private Socio buscarPorDNI(String dni){
        Socio socioEncontrado = mapaSocios.get(dni);
        
        return socioEncontrado;
    }
    
    public boolean registrarPrestamo(){
        String dni;
        String isbn;
        do{
            System.out.println("Ingrese el DNI del socio: ");
            dni = entrada.nextLine().trim();
            if(dni != null && !dni.isBlank()){
                break;
            }
        }while(true);
        
        
        
        Socio socio = buscarPorDNI(dni);
        if(socio != null){
            do{
                System.out.println("Ingrese el codigo del libro: ");
                isbn = entrada.nextLine().trim();
            }
            while(isbn.isBlank());
            
            Libro libro = buscarLibroPorISBN(isbn);
            if(libro != null){            
                
                if(libro.isDisponible()){
                    Prestamo prestamo = new Prestamo(libro,socio);
                    if(prestamos.agregar(prestamo)){
                        libro.setDisponible(false);
                        libro.sumaCantidad();
                        mapaPrestamos.put(libro, prestamo);
                        return true;
                    }
                }
                else{
                    System.out.println("\nEl libro no esta disponible\n");
                    return false;
                }
            }
            else{
                System.out.println("CODIGO INEXISTENTE");
            }
        }
        else{
            System.out.println("NO SE ENCONTRO EL DNI");
        }
        return false;
    }
    
    
    public void listarPrestamos(){
        System.out.println("\n======= PRESTAMOS =======");
        for(Prestamo p : prestamos.getLista()){
            if(p.isActivo()){
                System.out.println(p);
            }
        }
        System.out.println("\n");
    }
    
    private int calcularPrestamosActivos(){
        int contador = 0;
        for(Prestamo p : prestamos.getLista()){
            if(p.isActivo()){
                contador++;
            }
        }
        return contador;
    }
    
    
    
    public void guardarDatos(){
        libros.guardarDatos("libros.dat");
        socios.guardarDatos("socios.dat");
        prestamos.guardarDatos("prestamos.dat");
    }
    
    public boolean cargarDatos(){
        boolean existeLibros = libros.cargarDatos("libros.dat");
        boolean existeSocios = socios.cargarDatos("socios.dat");
        boolean existePrestamos = prestamos.cargarDatos("prestamos.dat");
        
        //reconstruyo los indices
        mapaLibros = new HashMap<>();
        for(Libro libro : libros.getLista()){
            mapaLibros.put(libro.getCodigo(), libro);
        }
        
        mapaSocios = new HashMap<>();
        for(Socio socio : socios.getLista()){
            mapaSocios.put(socio.getDni(), socio);
        }
        
        mapaPrestamos = new HashMap<>();
        for(Prestamo prestamo : prestamos.getLista()){
            mapaPrestamos.put(prestamo.getLibro(), prestamo);
        }
        
        if(existeLibros && existePrestamos && existeSocios){
            System.out.println("SE CARGARON LISTAS E INDICES.");
            return true;
        }
        System.out.println("HUBO UN ERROR EN LA CARGA");
        return false;
    }
    
    public boolean registrarDevolucion(){
        String dni;
        String isbn;
        
        do{
            System.out.println("Ingrese el DNI del socio: ");
            dni = entrada.nextLine().trim();
        }while(dni.isBlank());
        
        Socio socio = buscarPorDNI(dni);
                
        do{
            System.out.println("Ingrese el codigo del libro: ");
            isbn = entrada.nextLine().trim();
        }while(isbn.isBlank());
        
        Libro libro = buscarLibroPorISBN(isbn);
        
        if(socio != null){
            if(libro != null){
                
                Prestamo prestamo = mapaPrestamos.remove(libro);
                
                if(prestamo != null){
                    prestamos.eliminar(prestamo);
                    libro.setDisponible(true);
                    mapaPrestamos.remove(libro);
                    System.out.println("Se elimino el Prestamo");
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    
    /*
    Fecha y hora de generación.- OK
    Cantidad total de socios registrados.- OK 
    Cantidad total de libros registrados.-  OK
    Cantidad de préstamos activos.- OK
    Cantidad de libros disponibles.- OK
    Libro más solicitado o prestado.- 
    Cualquier otro indicador que el estudiante considere relevante.
    */
    
    private String armarArchivo(){
        StringBuilder sb = new StringBuilder();
        LocalDateTime fechaExpedicion = LocalDateTime.now();
        Collections.sort(libros.getLista());
        Libro libroSoli = libros.getLista().get(0);
        
        sb.append("Fecha Generacion: ").append(fechaExpedicion).append("\n");
        sb.append("Total socios registrados: ").append(socios.getLista().size()).append("\n");
        sb.append("Total libros registrados: ").append(libros.getLista().size()).append("\n");
        sb.append("Cantidad prestamos activos: ").append(calcularPrestamosActivos()).append("\n");
        sb.append("Libros disponibles : ").append(calcularLibrosDisponibles()).append("\n");
        sb.append("Libro mas solicitado: ").append(libroSoli.toString()).append("\n");
        
        return sb.toString();
    }
    
    @Override
    public boolean exportar() {
        try(FileWriter escritor = new FileWriter("informe.txt")){
            escritor.write("=== REPORTE INSTITUCIONAL ===\n");
            
            escritor.write(armarArchivo());
            /*
            for(Prestamo p : prestamos.getLista()){
                escritor.write(p.toString());
                escritor.write("\n");
            }
            */
            return true;
        }
        catch(IOException e){
            System.out.println("ERROR AL EXPORTAR: " + e.getMessage());
            return false;
        }
    }
    
}
