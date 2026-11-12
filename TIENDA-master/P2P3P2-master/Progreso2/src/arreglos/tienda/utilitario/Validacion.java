package arreglos.tienda.utilitario;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje) {
        String dato;
        do {
            System.out.println(mensaje);
            dato = sc.nextLine();
        } while (dato == null || dato.trim().isEmpty());

        return dato;
    }

    public static int leerEnteroPositivo(String mensaje) {
        int dato;

        do {
            System.out.println(mensaje);
            dato = sc.nextInt();
            sc.nextLine();

            if (dato <= 0) {
                System.out.println("Ingrese un número positivo");
            }

        } while (dato <= 0);

        return dato;
    }

    public static double leerDoublePositivo(String mensaje) {
        double dato;

        do {
            System.out.println(mensaje);
            dato = sc.nextDouble();
            sc.nextLine();

            if (dato <= 0) {
                System.out.println("Ingrese un número positivo");
            }

        } while (dato <= 0);

        return dato;
    }

    public static int leerEnteroMayorQue(String mensaje, int limite) {
        int dato;

        do {
            System.out.println(mensaje);
            dato = sc.nextInt();
            sc.nextLine();

            if (dato <= limite) {
                System.out.println("Ingrese un número mayor que " + limite);
            }

        } while (dato <= limite);

        return dato;
    }

    public static int leerEnteroMenorQue(String mensaje, int limite) {
        int dato;

        do {
            System.out.println(mensaje);
            dato = sc.nextInt();
            sc.nextLine();

            if (dato >= limite) {
                System.out.println("Ingrese un número menor que " + limite);
            }

        } while (dato >= limite);

        return dato;
    }

    public static int leerEnteroEntre(String mensaje, int minimo, int maximo) {
        int dato;

        do {
            System.out.println(mensaje);
            dato = sc.nextInt();
            sc.nextLine();

            if (dato < minimo || dato > maximo) {
                System.out.println("Ingrese un número entre " + minimo + " y " + maximo);
            }

        } while (dato < minimo || dato > maximo);

        return dato;
    }
}
