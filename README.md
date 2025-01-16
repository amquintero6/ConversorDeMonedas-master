# 🪙 Conversor de Monedas

Este proyecto consiste en una aplicación de consola desarrollada en Java, diseñada para realizar conversiones de divisas en tiempo real a través de una API externa de tasas de cambio. Fue creado como parte de un curso impartido en el programa *Alura + Oracle One*, con el propósito de aprender e implementar conceptos clave de Java, integración con servicios externos y prácticas de programación de calidad.

## 🚀 **Características principales**

1. **Interfaz de Usuario en Consola** 
    La aplicación presenta un menú intuitivo que permite al usuario seleccionar las monedas de origen y destino, e ingresar el monto a convertir.
    
2. **Soporte para Múltiples Divisas** 
    El conversor soporta las siguientes conversiones:
	- **Dólar** → **Peso Argentino**
	- **Peso Argentino** → **Dólar**
	- **Dólar** → **Real Brasileño**
	- **Real Brasileño** → **Dólar**
	- **Dólar** → **Peso Mexicano**
	- **Peso Mexicano** → **Dólar**
    
3. **Integración con API Externa**:
    La aplicación consume la siguiente API externa [# ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de conversión de cambio. 
    
4. **Código modular y escalable**
- Uso de clases separadas para la lógica de conversión y manejo de opciones.
- Preparado para añadir más divisas con facilidad.

## 📥 **Instalación y configuración**
### **Requisitos previos**
- Java 17 o superior instalado (Puede descargarse desde [aquí](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)).
- **Gson Library**: Biblioteca para manejar JSON. (**ya viene dentro del repositorio**)


## 🛠️ **Tecnologías utilizadas**
- [**Java 17**](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html): Lenguaje principal del proyecto.
- [**ExchangeRate-API**](https://www.exchangerate-api.com/): Fuente de tasas de cambio actualizadas.
- [**Gson**](https://mvnrepository.com/artifact/com.google.code.gson/gson): Biblioteca para manejar datos JSON obtenidos desde la API.
