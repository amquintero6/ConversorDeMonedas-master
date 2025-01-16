package com.conversor;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Opciones {
    private int seleccion;

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    //Declaracion de opciones iniciales
    public static List<String[]> conversionOptions = List.of(
            new String[]{"USD", "ARS"},
            new String[]{"ARS", "USD"},
            new String[]{"USD", "BRL"},
            new String[]{"BRL", "USD"},
            new String[]{"USD", "MXN"},
            new String[]{"MXN", "USD"}
    );

    public void mostrarMenu() {
        System.out.println("""
        ***********************
        Conversor de monedas:
            1) Dollar >>> Peso Argentino
            2) Peso Argentino >>> Dollar
            3) Dollar >>> Real Brasileiro
            4) Real Brasileiro >>> Dollar
            5) Dollar >>> Peso Mexicano
            6) Peso Mexicano >>> Dollar
        Elige una opción válida:
        ***********************
        """);
    }

    // Obtiene una opción válida del usuario
    public void obtenerSeleccionValida(Scanner scanner) {
        while (this.seleccion < 1 || this.seleccion > 6) {
            try {
                this.seleccion = scanner.nextInt();
                if (this.seleccion < 1 || this.seleccion > 6) {
                    System.out.println("Por favor, elija una opción entre 1 y 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
        }

    }

    public void comenzarConversion(){
        if (this.seleccion >= 1 && this.seleccion <= 6) {
            String[] monedas = conversionOptions.get(this.seleccion -1); //Se le resta 1 porque la lista comienza con el indice 0, y en el menú se comienza desde 1)

            try {
                Conversion conversion = new Conversion();
                conversion.setMoneda(monedas[0]);
                conversion.setTasaDeCambio(monedas[1]);

                conversion.obtenerEquivalencia();
                conversion.obtenerCantidad();
                conversion.obtenerConversion();
                System.out.println(conversion);
            } catch (Exception e) {
                System.out.println("Hubo un error en la conversión: " + e.getMessage());
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }
}
