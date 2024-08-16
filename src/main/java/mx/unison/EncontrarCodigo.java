package mx.unison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EncontrarCodigo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Introduce una lista de códigos postales como argumento.");
            return;
        }

        String archivo = "codigos_postales.csv";
        String lineas;
        String division = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            for (String codigo : args) {
                boolean encontrado = false;
                br.mark(10000);

                while ((lineas = br.readLine()) != null) {
                    String[] datos = lineas.split(division);
                    String codigoPostal = datos[0].trim();
                    String asentamiento = datos[1].trim();

                    if (codigoPostal.equals(codigo)) {
                        System.out.println("Código Postal: " + codigo + " - Asentamiento: " + asentamiento);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Código Postal: " + codigo + " no se encontró.");
                }
                br.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}