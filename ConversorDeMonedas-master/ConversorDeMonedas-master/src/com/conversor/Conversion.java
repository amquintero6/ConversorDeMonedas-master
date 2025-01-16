package com.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversion {
    private String moneda;
    private String tasaDeCambio;
    private Double equivalencia;
    private Double cantidad;
    private Double resultado;


    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public void setTasaDeCambio(String tasaDeCambio) {
        this.tasaDeCambio = tasaDeCambio;
    }

    public void obtenerEquivalencia() {

        String url = "https://v6.exchangerate-api.com/v6/d094ab72326095660fa0ad7f/latest/" + this.moneda;

        try {
            if (this.moneda == null || this.tasaDeCambio == null) {
                throw new IllegalArgumentException("La moneda o la tasa de cambio no pueden ser nulas.");
            }

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error al conectar con la API. Código de estado: " + response.statusCode());
            }

            var json = response.body();
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            if (!jsonObject.has("conversion_rates")) {
                throw new RuntimeException("La respuesta de la API no contiene 'conversion_rates'.");
            }

            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            if (!conversionRates.has(this.tasaDeCambio)) {
                throw new RuntimeException("La tasa de cambio '" + this.tasaDeCambio + "' no está disponible en la API.");
            }

            this.equivalencia = conversionRates.get(this.tasaDeCambio).getAsDouble();

        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            throw e;

        } catch (RuntimeException e) {
            System.out.println("Error al procesar los datos de la API: " + e.getMessage());
            throw e;

        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void obtenerCantidad() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ingrese la cantidad de [" + this.moneda + "] a convertir en [" + this.tasaDeCambio + "]: ");
                this.cantidad = scanner.nextDouble();


                if (this.cantidad <= 0) {
                    System.out.println("Error: La cantidad debe ser mayor a cero.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
        }
    }


    public void obtenerConversion() {
        if (this.cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        if (this.equivalencia <= 0) {
            throw new IllegalArgumentException("La equivalencia debe ser mayor que cero.");
        }

        this.resultado = Math.round(this.cantidad * this.equivalencia * 100.0) / 100.0;
    }


    @Override
    public String toString() {
        return this.cantidad + " [" + this.moneda + "] " + "convertido a [" + this.tasaDeCambio + "]" + " es igual a: " + this.resultado + "[" + this.tasaDeCambio + "]";
    }
}
