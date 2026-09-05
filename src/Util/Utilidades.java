
package Util;

import java.util.Scanner;


public class Utilidades {

    private static Scanner scanner = new Scanner(System.in);
    
public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }
 public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
public static void pausar() {
        System.out.print("\nPresiona ENTER para continuar...");
        scanner.nextLine();
    }

    
}
