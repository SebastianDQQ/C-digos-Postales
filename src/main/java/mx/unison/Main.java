package mx.unison;

/* Contar cuantos códigos postales corresponden a asentamientos rurales
y cantos a asentamientos rurales
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String archivo = "codigos_postales.csv";
        String lineas = "";
        String division = ",";

        int Urbano = 0;
        int Rural = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((lineas = br.readLine()) != null) {
                String[] datos = lineas.split(division);
                String Asentamiento = datos[2].trim();

                if (Asentamiento.equalsIgnoreCase("Urbano")) {
                    Urbano++;
                } else if (Asentamiento.equalsIgnoreCase("Rural")) {
                    Rural++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Número de asentamientos urbanos: " + Urbano);
        System.out.println("Número de asentamientos rurales: " + Rural);
    }
}
