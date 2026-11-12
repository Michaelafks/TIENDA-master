package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;
import arreglos.tienda.utilitario.Validacion;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;

        tienda.cargarDatos();

        do {
            menu();

            opc = Validacion.leerEnteroEntre(
                    "Ingrese una opcion: ", 1, 7);

            switch (opc) {
                case 1: {
                    ingresarJuegos();
                } break;

                case 2: {
                    imprimirInformacion();
                } break;

                case 3: {

                } break;

                case 4: {

                } break;

                case 5: {
                    vender();
                } break;

                case 6: {

                } break;

                case 7: {
                    System.out.println("Gracias por utilizar AppStore Udla");
                } break;
            }

        } while (opc != 7);
    }

    public static void menu() {
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego mas vendido");
        System.out.println("7. Salir");
    }

    public static void ingresarJuegos() {

        System.out.println("*******Ingreso de datos*******");

        String nombre = Validacion.leerString(
                "Ingrese el nombre:");

        String categoria = Validacion.leerString(
                "Ingrese la categoria:");

        int tamanio = Validacion.leerEnteroPositivo(
                "Ingrese el tamanio:");

        double precio = Validacion.leerDoublePositivo(
                "Ingrese el precio:");

        int licenciasDisponibles = Validacion.leerEnteroPositivo(
                "Ingrese el stock inicial:");

        Juego nuevo = new Juego(nombre, categoria, tamanio,
                precio, licenciasDisponibles);

        boolean agregado = tienda.adicionarJuego(nuevo);

        if (agregado) {
            System.out.println("El juego se ha agregado con exito");
        } else {
            System.out.println("No fue posible agregar el juego");
        }
    }

    public static String leerPrecio() {
        return new java.util.Scanner(System.in).nextLine();
    }

    public static void imprimirInformacion() {

        Juego juegos[] = tienda.getJuegos();

        if (tienda.getIndice() == -1) {
            System.out.println("No existen juegos aun");
        } else {
            for (int i = 0; i <= tienda.getIndice(); i++) {
                System.out.println(juegos[i]);
            }
        }
    }

    public static void vender() {

        String nombre;
        int cantidad;

        nombre = Validacion.leerString(
                "Ingrese el nombre del juego (no nulo ni en blanco)");

        cantidad = Validacion.leerEnteroPositivo(
                "Ingrese la cantidad:");

        double valorPago = tienda.vender(nombre, cantidad);

        if (valorPago != 0) {

            JOptionPane.showMessageDialog(null,
                    "Juego: " + nombre +
                            "\nCantidad: " + cantidad +
                            "\nValor a cancelar: " + valorPago);

        } else {

            JOptionPane.showMessageDialog(null,
                    "No fue posible vender el juego " + nombre);
        }
    }
}
