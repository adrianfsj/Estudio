package estuido_proyecto2;

import java.io.*;

public class CalculadoraMatrices {

    public static void main(String[] args) {
        // Rutas de los archivos de entrada y salida
        String archivoA = "matrizA.txt";
        String archivoC = "matrizC.txt";
        String archivoB = "matrizB.txt";

        // Cargar las matrices A y C desde los archivos
        int[][] matrizA = cargarMatriz(archivoA);
        int[][] matrizC = cargarMatriz(archivoC);

        // Calcular la matriz B
        int[][] matrizB = calcularMatrizB(matrizA, matrizC);

        // Guardar la matriz B en un archivo
        guardarMatriz(matrizB, archivoB);

        System.out.println("El cálculo se ha completado correctamente.");
    }

    // Método para cargar una matriz desde un archivo de texto
    private static int[][] cargarMatriz(String archivo) {
        int[][] matriz = null;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int filas = 0;
            int columnas = 0;
            while ((linea = br.readLine()) != null) {
                String[] elementos = linea.split(" ");
                if (matriz == null) {
                    filas = elementos.length;
                    matriz = new int[filas][];
                }
                matriz[columnas] = new int[filas];
                for (int i = 0; i < filas; i++) {
                    matriz[columnas][i] = Integer.parseInt(elementos[i]);
                }
                columnas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matriz;
    }

    // Método para calcular la matriz B
    private static int[][] calcularMatrizB(int[][] matrizA, int[][] matrizC) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        int[][] matrizB = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizB[i][j] = matrizC[i][j] - matrizA[i][j];
            }
        }
        return matrizB;
    }

    // Método para guardar una matriz en un archivo de texto
    private static void guardarMatriz(int[][] matriz, String archivo) {
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
}

