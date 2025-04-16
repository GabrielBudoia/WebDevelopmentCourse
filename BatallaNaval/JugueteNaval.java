package BatallaNaval;

import java.util.Random;
import java.util.Scanner;

public class JugueteNaval {
    public static void main(String[] args) {
        // Colores para la consola
        final String ROJO = "\u001B[31m";
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";

        // Crear Tablero
        int[][] tablero = new int[5][5];
        Random aleatorio = new Random();
        int barcosColocados = 0;
        int[][] tableroVisible = new int[5][5];
        Scanner entrada = new Scanner(System.in);
        int i;
        int j;
        int intentos = 0;
        int aciertos = 0;

        // Colocar barcos aleatoriamente en el tablero
        while (barcosColocados < 3) {
            int fila = aleatorio.nextInt(5);
            int columna = aleatorio.nextInt(5);
            if (tablero[fila][columna] == 0) {
                tablero[fila][columna] = 1;
                barcosColocados++;
            }
        }

        System.out.println("Bienvenido a la batalla naval! \n" +
                "El tablero es de 5x5 y tienes que adivinar donde están los barcos. \n" +
                "Tienes 3 barcos en el tablero, si aciertas un barco, lo verás en rojo. \n" +
                "Si no aciertas, verás un ~ azul. \n" +
                "Buena suerte!");

        // Mostrar tablero visible inicial
        for (i = 0; i < tableroVisible.length; i++) {
            for (j = 0; j < tableroVisible[i].length; j++) {
                System.out.print(" - ");
            }
            System.out.println();
        }

        while (intentos < 10 && aciertos < 3) {
            System.out.println(
                    "Oye usuario, hazme el favor y dime la fila donde crees que hay un barco. Debe ser un número entre 1 y 5.");
            int filaUsuario = entrada.nextInt() - 1;
            System.out.println("Ahora dime la columna donde crees que hay un barco. Debe ser un número entre 1 y 5.");
            int columnaUsuario = entrada.nextInt() - 1;

            if (filaUsuario < 0 || filaUsuario > 4 || columnaUsuario < 0 || columnaUsuario > 4) {
                System.out.println("¡Entrada inválida! Intenta de nuevo.");
                continue;
            }

            if (tableroVisible[filaUsuario][columnaUsuario] == 1) {
                System.out.println("Ya has intentado esa posición. Prueba otra.");
                continue;
            }

            tableroVisible[filaUsuario][columnaUsuario] = 1;

            if (tablero[filaUsuario][columnaUsuario] == 1) {
                System.out.println("Tocado!");
                aciertos++;
            } else {
                System.out.println("Agua!");
            }

            // Mostrar tablero actualizado
            for (i = 0; i < tableroVisible.length; i++) {
                for (j = 0; j < tableroVisible[i].length; j++) {
                    if (tableroVisible[i][j] == 1) {
                        if (tablero[i][j] == 1) {
                            System.out.print(ROJO + "X" + RESET + " ");
                        } else {
                            System.out.print(AZUL + "~" + RESET + " ");
                        }
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }

            intentos++;
        }

        if (aciertos == 3) {
            System.out.println("¡Has ganado!");
        } else {
            System.out.println("¡Has perdido!");
            System.out.println("Posiciones correctas de los barcos:");
            for (i = 0; i < tablero.length; i++) {
                for (j = 0; j < tablero[i].length; j++) {
                    if (tablero[i][j] == 1) {
                        System.out.print(ROJO + "X" + RESET + " ");
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }
        }

        System.out.println("¡Fin del juego!");
        entrada.close();
    }
}
