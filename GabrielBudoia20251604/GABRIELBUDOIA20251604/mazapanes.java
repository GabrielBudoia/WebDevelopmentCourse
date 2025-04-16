package GABRIELBUDOIA20251604;

import java.util.Random;
import java.util.Scanner;

public class mazapanes {
    public static void main(String[] args) {

        int intentos = 0;
        Scanner entrada = new Scanner(System.in);
        String[][] tableroVisible = new String[4][4];
        int[][] tablero = new int[4][4];
        int i = 0;
        int j = 0;
        int mazapanesColocados = 0;
        Random Aleatorio = new Random();
        int aciertos = 0;

        // Inicializar el tablero visible
        for (i = 0; i < tableroVisible.length; i++) {
            for (j = 0; j < tableroVisible[i].length; j++) {
                tableroVisible[i][j] = " - ";
            }
        }

        // Introducao para o usuario
        System.out.println("Hola Usuario aqui tendras que encontrar unos mazapanes en el tablero.");
        System.out.println("El tablero es de 4x4 y tendras 8 intentos.");
        System.out.println("Presiona enter para continuar.");
        entrada.nextLine();
        do {
            // esconder mazapanes
            while (mazapanesColocados < 3) {
                int fila = Aleatorio.nextInt(4);
                int columna = Aleatorio.nextInt(4);
                if (tablero[fila][columna] == 0) {
                    tablero[fila][columna] = 1;
                    mazapanesColocados++;
                }
            }
            // inicializar o tabulero visivel
            System.out.println("El tablero es el siguiente: ");
            System.out.println();
            for (i = 0; i < tableroVisible.length; i++) {
                for (j = 0; j < tableroVisible[i].length; j++) {
                    System.out.print(tableroVisible[i][j] + " ");

                }
                System.out.println();
            }

            // pedir coordenadas al usuario
            System.out.println("Ahora dime la fila donde crees que hay un mazapan. Debe ser un número entre 1 y 4.");
            int filaUsuario = entrada.nextInt() - 1;
            System.out.println("Ahora dime la columna donde crees que hay un mazapan. Debe ser un número entre 1 y 4.");
            int columnaUsuario = entrada.nextInt() - 1;

            // comprobar coordenadas
            if (filaUsuario < 0 || filaUsuario > 3 || columnaUsuario < 0 || columnaUsuario > 3) {
                System.out.println("¡Entrada inválida! Intenta de nuevo.");
                continue;
            }

            // comprobar si el usuario ha acertado
            if (tablero[filaUsuario][columnaUsuario] == 1) {
                System.out.println("Has encontrado un mazapan!");
                tableroVisible[filaUsuario][columnaUsuario] = "X";
                aciertos++;
                intentos++;
            } else {
                System.out.println("No has encontrado un mazapan.");
                tableroVisible[filaUsuario][columnaUsuario] = "~";
                intentos++;
            }
        } while (intentos < 8 && aciertos < 3);
        // comprobar si el usuario ha ganado o perdido
        if (aciertos == 3) {
            System.out.println("Has ganado!");
        } else {
            System.out.println("No fue de esta vez, buenas fiestas!!");
        }
        entrada.close();
    }

}
