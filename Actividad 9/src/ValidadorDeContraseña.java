import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//SI QUITA LO QUE ESTA COMENTADO VERA QUE CUANDO EJECUTE LA CONTRASEÑAS, SALDRA LO QUE SE NECESITA

public class ValidadorDeContraseña {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\tLas sigientes contraseñas deben estar ( separadas por COMAS )");
            System.out.println("Ingrese las contraseñas a validar: ");
            String input = scanner.nextLine();

            String[] contrasenas = input.split(",");
            ExecutorService executor = Executors.newFixedThreadPool(contrasenas.length);

            for (String contrasena : contrasenas) {
                Runnable validador = new ValidadorContrasenaRunnable(contrasena.trim());
                executor.execute(validador);
            }

            executor.shutdown();
        }
    static class ValidadorContrasenaRunnable implements Runnable {
        private static final int LONGITUD_MINIMA = 4;
        private static final int MIN_MAYUSCULAS = 1;
        private static final int MIN_MINUSCULAS = 2;
        private static final int MIN_DIGITOS = 1;
        private static final String CARACTERES_ESPECIALES = "!@ # $ % \n";

        private String contrasena;

        public ValidadorContrasenaRunnable(String contrasena) {
            this.contrasena = contrasena;
        }

        @Override
        public void run() {
            if (esContrasenaValida(contrasena)) {
                System.out.println("\tLa contraseña '* " + contrasena + " *' es Válida.");
            } else {
                System.out.println("\tLa contraseña '* " + contrasena + " *' No es válida.");
//              mostrarRequisitosFaltantes(contrasena);
            }
        }
        private boolean esContrasenaValida(String contrasena) {
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
            Pattern patronEspeciales = Pattern.compile("[" + CARACTERES_ESPECIALES + "]");
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
/*        private void mostrarRequisitosFaltantes(String contrasena) {
            if (contrasena.length() < LONGITUD_MINIMA) {
                System.out.println("La contraseña debe tener al menos " + LONGITUD_MINIMA + " caracteres.");
            }
            if (!contieneMayusculas(contrasena)) {
                System.out.println("La contraseña debe tener al menos " + MIN_MAYUSCULAS + " letra(s) mayúscula(s).");
            }
            if (!contieneMinusculas(contrasena)) {
                System.out.println("La contraseña debe tener al menos " + MIN_MINUSCULAS + " letra(s) minúscula(s).");
            }
            if (!contieneDigitos(contrasena)) {
                System.out.println("La contraseña debe tener al menos " + MIN_DIGITOS + " número(s).");
            }
            if (!contieneEspeciales(contrasena)) {
                System.out.println("La contraseña debe tener al menos 1 caracter especial de la lista: " + CARACTERES_ESPECIALES);
            }
        }       */
        private boolean contieneMayusculas(String contrasena) {
            Pattern patronMayusculas = Pattern.compile("[A-Z]");
            Matcher coincidenciasMayusculas = patronMayusculas.matcher(contrasena);
            int contadorMayusculas = 0;
            while (coincidenciasMayusculas.find()) {
                contadorMayusculas++;
            }
            return contadorMayusculas >= MIN_MAYUSCULAS;
        }
        private boolean contieneMinusculas(String contrasena) {
            Pattern patronMinusculas = Pattern.compile("[a-z]");
            Matcher coincidenciasMinusculas = patronMinusculas.matcher(contrasena);
            int contadorMinusculas = 0;
            while (coincidenciasMinusculas.find()) {
                contadorMinusculas++;
            }
            return contadorMinusculas >= MIN_MINUSCULAS;
        }
        private boolean contieneDigitos(String contrasena) {
            Pattern patronDigitos = Pattern.compile("\\d");
            Matcher coincidenciasDigitos = patronDigitos.matcher(contrasena);
            int contadorDigitos = 0;
            while (coincidenciasDigitos.find()) {
                contadorDigitos++;
            }
            return contadorDigitos >= MIN_DIGITOS;
        }
        private boolean contieneEspeciales(String contrasena) {
            Pattern patronEspeciales = Pattern.compile("[" + CARACTERES_ESPECIALES + "]");
            Matcher coincidenciasEspeciales = patronEspeciales.matcher(contrasena);
            int contadorEspeciales = 0;
            while (coincidenciasEspeciales.find()) {
                contadorEspeciales++;
            }
            return contadorEspeciales > 0;
        }
    }
}