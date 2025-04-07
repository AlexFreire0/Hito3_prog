package h1_T3_Prog;

import java.util.*;

public class Principal {
	//creamos el hasmap
    static HashMap<Integer, Animal> animales = new HashMap<>();
    //lamamos a menu
    public static void main(String[] args) {
        menu();
    }
    //declaramos el menu con sus opciones
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int eleccion1;

        do {
            System.out.println("\n¿Qué opcion ejecutar?");
            System.out.println("1. Dar de alta un animal para el proyecto.");
            System.out.println("2. Buscar animal por su número de chip");
            System.out.println("3. Salir\n");
            	//con scanner elegimos la opcion
            eleccion1 = scanner.nextInt();
            scanner.nextLine(); 

            switch (eleccion1) {
                case 1:
                	//en caso de crear un animal elegimos cual y le mandamos a la funcion que los crea
                    System.out.println("Elige qué animal:");
                    System.out.println("1. Perro");
                    System.out.println("2. Gato\n");
                    int eleccion2 = scanner.nextInt();
                    scanner.nextLine(); 
                    darDeAlta(eleccion2, scanner);
                    break;
                    
                case 2:
                	//en caso de buscar un animal le pedimos el numero de chip
                    System.out.print("Introduce el número de chip del animal: ");
                    int numeroChip = scanner.nextInt();
                    buscarAnimal(numeroChip);
                    break;

                case 3:
                	//en caso de querer salir simplemente salimos
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (eleccion1 != 3);	//repetimos hasta que sea 3

        scanner.close();
    }
    //funcion para dar de alta
    public static void darDeAlta(int tipo, Scanner scanner) {
        System.out.print("Introduce el número de chip: "); //pedimos numero de chip
        int chip = scanner.nextInt();
        scanner.nextLine();

        if (animales.containsKey(chip)) { // si ya existe le mandamos mensaje de que ya existe
            System.out.println("Ya existe un animal con ese número de chip.");
            return;
        }
        //pedimos datos generales de animal
        System.out.print("Introduce el nombre del animal: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Introduce la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduce la raza: ");
        String raza = scanner.nextLine();

        System.out.print("¿Está adoptado? \n1 - Si  \n2 - No : ");
        boolean adoptado;
        int elegido = scanner.nextInt();
        if (elegido == 1) {
        	adoptado = true;
        }
        else {
        	adoptado = false;
        }
        scanner.nextLine();

        Animal nuevoAnimal;	//creamos un objeto animal vacio por ahora
        //pedimos las opciones especiales de perro y gato y los introducimos en el objeto
        if (tipo == 1) { // Perro
            System.out.print("Introduce el tamaño entre pequeño, mediano o grande: ");
            String tamano = scanner.nextLine();
            nuevoAnimal = new Perro(chip, nombre, edad, raza, adoptado, tamano);
        } else if (tipo == 2) { // Gato
            System.out.print("¿Tiene test de leucemia? \n1 - Si  \n2 - No\n eLIGE: ");
            boolean testLeucemia;
            int elegido2 = scanner.nextInt();
            if (elegido2 == 1) {
            	testLeucemia = true;
            }
            else {
            	testLeucemia = false;
            }
            scanner.nextLine();
            nuevoAnimal = new Gato(chip, nombre, edad, raza, adoptado, testLeucemia);
        } else {
            System.out.println("Tipo de animal no válido."); //error si es invalido
            return;
        }

        animales.put(chip, nuevoAnimal);
        System.out.println("Animal dado de alta"); // mensaje de hecho 
        menu();	//volvemos
    }

    public static void buscarAnimal(int chip) {
        Animal animal = animales.get(chip);	//buscamos por chip el animal
        // si no encontramso lo mostramos y si si lo encontramos igual.
        if (animal != null) {
            System.out.println("\nAnimal encontrado:");
            animal.mostrar();
        } else {
            System.out.println("Animal no encontrado.");
        }
        menu(); //volvemos
    }
}
