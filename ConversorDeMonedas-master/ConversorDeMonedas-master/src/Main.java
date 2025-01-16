import com.conversor.Opciones;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var opciones = new Opciones();

        while (true) {
            opciones.mostrarMenu();
            opciones.obtenerSeleccionValida(scanner);
            opciones.comenzarConversion();

            System.out.println("Seguir utilizando el programa?: Si[1], No[0]");
            int utilizar = scanner.nextInt();

            if (utilizar != 1){
            break;
            } else {
                opciones.setSeleccion(0);
            }
        }

    }

}