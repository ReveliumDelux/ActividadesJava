import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public class AlmacenamientoDeValidador {
    private static final String LOG_FILE = "registro_contraseñas.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tAL ESCRIBIR SU PROXIMA CONTRASEÑAS, DEBE ESTAR SEPARADAS POR *COMAS `,` *");
        System.out.println("Ingrese las contraseñas a validar: ");
        String input = scanner.nextLine();

        String[] contrasenas = input.split(",");
        ExecutorService executor = Executors.newFixedThreadPool(contrasenas.length);

//  Utilizare BufferedWriter para guardar el registro

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE))) {
            for (String contrasena : contrasenas) {
                Runnable validador = () -> validarContraseña(contrasena.trim(), writer);
                executor.execute(validador);
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
            }

            System.out.println("Todas las contraseñas se han guardado en '" + LOG_FILE + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void validarContraseña(String contrasena, BufferedWriter writer) {
        try {
            boolean esValida = esContrasenaValida(contrasena);
            String resultado = esValida ? "Valida" : "No Valida";

            String mensaje = "La contraseña '* " + contrasena + " *' es " + resultado + ".\n";
            System.out.println(mensaje);

            writer.write(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean esContrasenaValida(String contrasena) {
        final int LONGITUD_MINIMA = 4;
        final int MIN_MAYUSCULAS = 1;
        final int MIN_MINUSCULAS = 2;
        final int MIN_DIGITOS = 1;
        final String CARACTERES_ESPECIALES = "!@ # $ % \n";

        if (contrasena.length() < LONGITUD_MINIMA) {
            return false;
        }

        Pattern patronMayusculas = Pattern.compile("[A-Z]");
        Matcher coincidenciasMayusculas = patronMayusculas.matcher(contrasena);
        int contadorMayusculas = 0;
        while (coincidenciasMayusculas.find()) {
            contadorMayusculas++;
        }

        Pattern patronMinusculas = Pattern.compile("[a-z]");
        Matcher coincidenciasMinusculas = patronMinusculas.matcher(contrasena);
        int contadorMinusculas = 0;
        while (coincidenciasMinusculas.find()) {
            contadorMinusculas++;
        }

        Pattern patronDigitos = Pattern.compile("\\d");
        Matcher coincidenciasDigitos = patronDigitos.matcher(contrasena);
        int contadorDigitos = 0;
        while (coincidenciasDigitos.find()) {
            contadorDigitos++;
        }

        Pattern patronEspeciales = Pattern.compile("[" + Pattern.quote(CARACTERES_ESPECIALES) + "]");
        Matcher coincidenciasEspeciales = patronEspeciales.matcher(contrasena);
        int contadorEspeciales = 0;
        while (coincidenciasEspeciales.find()) {
            contadorEspeciales++;
        }

        return contadorMayusculas >= MIN_MAYUSCULAS &&
                contadorMinusculas >= MIN_MINUSCULAS &&
                contadorDigitos >= MIN_DIGITOS &&
                contadorEspeciales > 0;
    }
}