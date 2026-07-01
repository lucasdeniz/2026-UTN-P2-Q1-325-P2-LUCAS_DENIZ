
package segundoparcialprogramacion2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner entrada = new Scanner(System.in);
        String archivoInforme = "informe.txt";
        
        int opcion;
        String isbn;
        do{
            Menu.mostrarMenu();
            opcion = entrada.nextInt();
            entrada.nextLine();
            
            switch(opcion){
                case 1: if(biblioteca.registrarSocio()){
                            System.out.println("Socio registrado.");
                        }
                        else{
                            System.out.println("NO se pudo REGISTRAR el SOCIO");
                        }
                        break;
                case 2 :if(biblioteca.registrarLibro()){
                            System.out.println("Nuevo Libro registrado");
                        }
                        else{
                            System.out.println("NO se pudo REGISTRAR EL LIBRO");
                        }
                        break;
                case 3 : System.out.println("==== SOCIOS ===="); biblioteca.listarSocios(); break;
                case 4 : System.out.println("==== LIBROS ===="); biblioteca.listarLibros(); break;
                case 5 : System.out.println("INGRESE EL CODIGO: ");
                         isbn = entrada.nextLine();
                         System.out.println(biblioteca.buscarLibroPorISBN(isbn)) ;break;
                case 6 : if(biblioteca.registrarPrestamo()){
                                System.out.println("PRESTAMO REGISTRADO");
                            }
                         else{
                             System.out.println("NO SE REGISTRO EL PRESTAMO");
                         }
                         break;
                case 7 : if(biblioteca.registrarDevolucion()){
                            System.out.println("LIBRO DEVUELVO");
                            }
                        else{
                            System.out.println("NO SE PUDO HACER LA DEVOLUCION");
                        }
                        break;
                case 8 : biblioteca.listarPrestamos();break;
                case 9 : if(biblioteca.exportar()){
                            System.out.println("Se exporto el archivo informe.txt");
                        }
                        else{
                            System.out.println("NO se pudo EXPORTAR el informe");
                        }
                        break;
                case 10 : biblioteca.guardarDatos(); opcion = 0; break;
                case 11 : biblioteca.cargarDatos(); break;
                default : break;
                
                
            }
            
        }while(opcion != 0);
    }
}
