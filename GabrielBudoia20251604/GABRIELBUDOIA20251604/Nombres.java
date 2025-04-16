package GABRIELBUDOIA20251604;

import java.util.Scanner;

public class Nombres {
    public static void main(String[] args) {
        String ROJO = "\u001B[31m";
        String AZUL = "\u001B[34m";
        String RESET = "\u001B[0m";
        boolean minusculo = false;
        do {
            System.out.println("Hola Usuario Dame Un Nombre: ");
            Scanner entrada = new Scanner(System.in);
            String nombre = entrada.nextLine();
            if (nombre.equals(nombre.toLowerCase())) {
                System.out.println("El nombre esta em minusculas");
            } else if (nombre.equals(nombre.toUpperCase())) {
                System.out.println("El nombre esta en mayusculas");
            } else {
                System.out.println("El nombre tiene mayusculas y minusculas");
            }
            if (nombre.equals(nombre.trim())) {
                System.out.println("El nombre no tiene espacios al principio ni al final");
            } else {
                System.out.println("El nombre tiene espacios al principio o al final");
            }
            if (nombre.equals(nombre.toLowerCase()) && nombre.equals(nombre.trim())) {
                int longitud = nombre.length();
                System.out.println("El nombre tiene " + AZUL + longitud + " caracteres." + RESET);
                minusculo = true;
            } else {
                System.out.println(ROJO + "El nombre no es correcto, vuelve a intentarlo." + RESET);

            }

        } while (minusculo != true);
        System.out.println("Muy bien aceptamos tu nombre.");
    }
}
