package estuido_proyecto2;

import java.io.*;

public class clase_prueba {
    public static void main(String[] args) {
        Persona persona1 = new Persona("John Doe", 1990);
        Persona persona2 = new Persona("Jane Smith", 1985);
        
        // Escribir objetos en un archivo
        escribirObjeto(persona1, "personas.dat");
        escribirObjeto(persona2, "personas.dat");
        
        // Leer objetos desde el archivo
        Persona persona3 = (Persona) leerObjeto("personas.dat");
        Persona persona4 = (Persona) leerObjeto("personas.dat");
        
        // Imprimir los objetos leídos
        System.out.println(persona3);
        System.out.println(persona4);
    }
    
    public static void escribirObjeto(Object objeto, String archivo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, true);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(objeto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Object leerObjeto(String archivo) {
        Object objeto = null;
        try (FileInputStream fileInputStream = new FileInputStream(archivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            objeto = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objeto;
    }
}