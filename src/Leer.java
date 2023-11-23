import java.io.*;

public class Leer {

    public static void main(String[] args) {
        // Nombre del archivo .dat
        String nombreArchivo = "usuarios.dat";

        // Intentar leer objetos desde el archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            // Leemos objetos hasta que se alcance el final del archivo
            while (true) {
                try {
                    // Intentamos leer un objeto desde el archivo
                    Object objetoLeido = ois.readObject();

                    // Hacer algo con el objeto leído (en este ejemplo, simplemente imprimirlo)
                    System.out.println(objetoLeido);
                } catch (EOFException e) {
                    // Se lanza cuando se alcanza el final del archivo
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo: " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
