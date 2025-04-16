package Gestion_De_Notas;

import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {

        // Notas de Programacion y Entornos de Desarrollo
        double[][] notasProgramacion = { { 8.0, 6.2, 7.8, 8.6, 9.0 },
                { 9.4, 6.1, 9.8, 4.7 },
                { 5.4, 8.9, 8.7, 6.4 } };
        double[][] notasEntornos = { { 4.0, 5.2, 4.8, 8.6 },
                { 5.4, 6.1, 2.8, 3.7 },
                { 1.4, 1.9, 8.7, 6.4 } };

        Scanner scanner = new Scanner(System.in);

        final String LETRA_ROJA = "\u001B[31m";
        final String RESET = "\u001B[0m";

        int opcionPrincipal;
        int opcionSecundaria;

        do {
            System.out.println("--- Menu Principal ---");
            System.out.println("1. Notas de Programacion");
            System.out.println("2. Notas de Entornos de Desarrollo");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    do {
                        System.out.println("--- PROGRAMACION ---");
                        System.out.println("1. Mostrar Notas");
                        System.out.println("2. Cambiar Nota");
                        System.out.println("3. Mostrar Nota Final");
                        System.out.println("4. Volver al Menu Principal");
                        System.out.println("Elige una opción: ");
                        opcionSecundaria = scanner.nextInt();
                        switch (opcionSecundaria) {
                            case 1:
                                System.out.println("--- NOTAS DE PROGRAMACION ---");
                                System.out.printf("%-20s %-20s %-20s %n", "Andres Mateo", "Mar Beamund", "Luis Miguel");
                                for (int columna = 0; columna < notasProgramacion[0].length; columna++) {
                                    for (int fila = 0; fila < notasProgramacion.length; fila++) {
                                        if (notasProgramacion[fila][columna] < 5.0) {
                                            System.out.printf(LETRA_ROJA + "%-20.2f " + RESET,
                                                    notasProgramacion[fila][columna]);
                                        } else {
                                            System.out.printf("%-20.2f ", notasProgramacion[fila][columna]);
                                        }
                                    }
                                    System.out.println();
                                }
                                break;
                            case 2:
                                System.out.println(
                                        "Indica el estudiante de que vas a cambiar la nota: \n1. Andres Mateo\n2. Mar Beamund\n3. Luis Miguel\n4. Volver al menu de Programacion");
                                int indiceEstudiante = scanner.nextInt() - 1;

                                if (indiceEstudiante < 0 || indiceEstudiante > notasProgramacion.length) {
                                    System.out.println("Opción no válida. Intenta de nuevo.\n");
                                    break;
                                } else {
                                    System.out.println(
                                            "Ahora introduce el indice del examen cuya nota quieas modificar(entre el 0 y el "
                                                    + notasProgramacion[indiceEstudiante].length + " ): ");
                                    int indiceNota = scanner.nextInt() - 1;
                                    if (indiceNota < 0 || indiceNota > notasProgramacion[indiceEstudiante].length) {
                                        System.out.println("Opción no válida. Intenta de nuevo.\n");
                                    } else {
                                        System.out.println("Introduce la nueva nota: ");
                                        double nuevaNota = scanner.nextDouble();
                                        if (nuevaNota < 0 || nuevaNota > 10) {
                                            System.out.println("Opción no válida. Intenta de nuevo.\n");
                                        } else {
                                            notasProgramacion[indiceEstudiante][indiceNota] = nuevaNota;
                                            System.out.println("Nota cambiada correctamente.\n");
                                        }
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("--- NOTA FINAL ---");
                                for (int i = 0; i < notasProgramacion.length; i++) {
                                    int numeroEntregas = notasProgramacion[i].length - 1;
                                    double sumaEntregas = 0.0;
                                    for (int j = 0; j < numeroEntregas; j++) {
                                        sumaEntregas += notasProgramacion[i][j];
                                    }
                                    double mediaEntregas = sumaEntregas / numeroEntregas;
                                    double notaExamen = notasProgramacion[i][numeroEntregas];
                                    System.out.println("Notal final del estudiante del numero" + (i + 1) + " es: "
                                            + (mediaEntregas * 0.4 + notaExamen * 0.6));
                                }
                                break;

                            case 4:
                                System.out.println("volvendo al menu principal...\n");
                                break;

                            default:
                                System.out.println("Opción no válida. Intenta de nuevo.\n");
                                break;
                        }

                    } while (opcionSecundaria != 4);
                    break;

                case 2:
                    do {
                        System.out.println("--- Entornos De Programacion ---");
                        System.out.println("1. Mostrar Notas");
                        System.out.println("2. Cambiar Nota");
                        System.out.println("3. Mostrar Nota Final");
                        System.out.println("4. Volver al Menu Principal");
                        System.out.println("Elige una opción: ");
                        opcionSecundaria = scanner.nextInt();
                        switch (opcionSecundaria) {
                            case 1:
                                System.out.println("--- NOTAS DE PROGRAMACION ---");
                                System.out.printf("%-20s %-20s %-20s %n", "Andres Mateo", "Mar Beamund", "Luis Miguel");
                                for (int columna = 0; columna < notasEntornos[0].length; columna++) {
                                    for (int fila = 0; fila < notasEntornos.length; fila++) {
                                        if (notasEntornos[fila][columna] < 5.0) {
                                            System.out.printf(LETRA_ROJA + "%-20.2f " + RESET,
                                                    notasEntornos[fila][columna]);
                                        } else {
                                            System.out.printf("%-20.2f ", notasEntornos[fila][columna]);
                                        }
                                    }
                                    System.out.println();
                                }
                                break;
                            case 2:
                                System.out.println(
                                        "Indica el estudiante de que vas a cambiar la nota: \n1. Andres Mateo\n2. Mar Beamund\n3. Luis Miguel\n4. Volver al menu de Programacion");
                                int indiceEstudiante = scanner.nextInt() - 1;

                                if (indiceEstudiante < 0 || indiceEstudiante > notasEntornos.length) {
                                    System.out.println("Opción no válida. Intenta de nuevo.\n");
                                    break;
                                } else {
                                    System.out.println(
                                            "Ahora introduce el indice del examen cuya nota quieas modificar(entre el 0 y el "
                                                    + notasEntornos[indiceEstudiante].length + " ): ");
                                    int indiceNota = scanner.nextInt() - 1;
                                    if (indiceNota < 0 || indiceNota > notasEntornos[indiceEstudiante].length) {
                                        System.out.println("Opción no válida. Intenta de nuevo.\n");
                                    } else {
                                        System.out.println("Introduce la nueva nota: ");
                                        double nuevaNota = scanner.nextDouble();
                                        if (nuevaNota < 0 || nuevaNota > 10) {
                                            System.out.println("Opción no válida. Intenta de nuevo.\n");
                                        } else {
                                            notasEntornos[indiceEstudiante][indiceNota] = nuevaNota;
                                            System.out.println("Nota cambiada correctamente.\n");
                                        }
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("--- NOTA FINAL ---");
                                for (int i = 0; i < notasEntornos.length; i++) {
                                    int numeroEntregas = notasEntornos[i].length - 1;
                                    double sumaEntregas = 0.0;
                                    for (int j = 0; j < numeroEntregas; j++) {
                                        sumaEntregas += notasEntornos[i][j];
                                    }
                                    double mediaEntregas = sumaEntregas / numeroEntregas;
                                    double notaExamen = notasEntornos[i][numeroEntregas];
                                    System.out.println("Notal final del estudiante del numero" + (i + 1) + " es: "
                                            + (mediaEntregas * 0.4 + notaExamen * 0.6));
                                }
                                break;

                            case 4:
                                System.out.println("volvendo al menu principal...\n");
                                break;

                            default:
                                System.out.println("Opción no válida. Intenta de nuevo.\n");
                                break;
                        }

                    } while (opcionSecundaria != 4);

                case 3:

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.\n");
                    break;
            }
        } while (opcionPrincipal != 3);
        System.out.println("Saliendo del programa...");
        scanner.close();

    }

}
