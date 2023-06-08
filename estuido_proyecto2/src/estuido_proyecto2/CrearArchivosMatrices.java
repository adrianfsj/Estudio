package estuido_proyecto2;

import java.io.*;

public class CrearArchivosMatrices {

    public static void main(String[] args) {
        // Rutas de los archivos de entrada
        String archivoA = "matrizA.txt";
        String archivoC = "matrizC.txt";

        // Crear las matrices A y C en los archivos
        crearArchivoMatriz(archivoA, generarMatrizEjemploA());
        crearArchivoMatriz(archivoC, generarMatrizEjemploC());

        System.out.println("Los archivos de las matrices se han creado correctamente.");
    }

    // Método para crear un archivo de texto con una matriz
    private static void crearArchivoMatriz(String archivo, int[][] matriz) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            int filas = matriz.length;
            int columnas = matriz[0].length;
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    bw.write(matriz[i][j] + " ");
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para generar una matriz de ejemplo A
    private static int[][] generarMatrizEjemploA() {
        int[][] matriz = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        return matriz;
    }

    // Método para generar una matriz de ejemplo C
    private static int[][] generarMatrizEjemploC() {
        int[][] matriz = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 2, 1}
        };
        return matriz;
    }
}
