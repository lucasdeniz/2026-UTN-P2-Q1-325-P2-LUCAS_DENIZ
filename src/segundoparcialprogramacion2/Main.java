
package segundoparcialprogramacion2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner entrada = new Scanner(System.in);
        //Socio socio = new Socio("Lucas","Deniz","37861977");
        
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
                default : break;
            }
            
        }while(opcion != 0);
    }
}
