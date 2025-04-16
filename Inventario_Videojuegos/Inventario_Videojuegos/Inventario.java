package Inventario_Videojuegos;

import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        String[][] games = {
            {"Zelda", "God Of War","Elden Ring"}, // Action-adventure
            {"Mario", "LOL", "Valorant"},         // Platformer
            {"Witcher 3", "Diablo", "WOW"},       // Action RPG
        };

        final String RESET = "\u001B[0m";
        final String FONDO_AZUL = "\u001B[44m";
        final String LETRA_BLANCA = "\u001B[37m";
        final String LETRA_ROJA = "\u001B[31m";
        final String LETRA_VERDE = "\u001B[32m";
        final String LETRA_AZUL = "\u001B[34m";

        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Inventario de Videojuegos ---");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Agregar videojuego");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Inventario de Videojuegos ---");
                    System.out.printf(FONDO_AZUL + LETRA_BLANCA + "%-15s %-15s %-15s" + RESET + "%n", "categoría 1", "categoría 2", "categoría 3");
                    for (int fila = 0; fila < games.length; fila++) {
                        for (int columna = 0; columna < games[fila].length; columna++) {
                            String color = (columna == 0) ? LETRA_ROJA : (columna == 1) ? LETRA_VERDE : LETRA_AZUL;
                            System.out.printf(color + "%-15s" + RESET, games[fila][columna]);
                            
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("Actualizar inventario de videojuegos:");
                    System.out.print("Ingrese la categoría (1-3): ");
                    int categoria = entrada.nextInt() - 1;
                    System.out.print("Ingrese el índice (1-3): ");
                    int indice = entrada.nextInt() - 1;

                    entrada.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese el nombre del videojuego: ");
                    String nuevoJuego = entrada.nextLine().toLowerCase().trim();

                    if (categoria >= 0 && categoria < games.length && indice >= 0 && indice < games[0].length) {
                        games[categoria][indice] = nuevoJuego;
                        System.out.println("Videojuego agregado correctamente.");
                    } else {
                        System.out.println("Categoría o índice fuera de rango.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }

        } while (opcion != 3);
        
        entrada.close();
    }
}
