
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroDeAcceso {
    public static final Map<String, Boolean> correosRegistrados = new HashMap<>();
    public static final Map<String, Usuario> usuariosRegistrados = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        registrarUsuario("Eric1@gmail.com", "Perro", "Eric", "12");
        registrarUsuario("Eric2@gmail.com", "Gato", "ERic", "123");
        registrarUsuario("Eric3@gmail.com", "Dinosaurio", "ERIc", "1234");
        registrarUsuario("Eric4@gmail.com", "Leon", "ERIC", "12345");

        System.out.print("Ingrese su Correo: ");
        String correo;
        correo = scanner.nextLine();

        if (correosRegistrados.containsKey(correo)) {
            System.out.println("¡BIENVENIDO!");
            Usuario usuario = usuariosRegistrados.get(correo);
            System.out.println("¡Bienvenido!, " + usuario.getNombre());
            boolean tipoMascotaValido = false;
            while (!tipoMascotaValido) {
                try {
                    System.out.print("Ingrese el tipo de mascota para ingresar: ");
                    String tipoMascota = scanner.nextLine();
                    if (tipoMascota.equalsIgnoreCase(usuario.getTipoMascota())) {
                        System.out.println("Acceso Exitoso. ¡Bienvenido, " + usuario.getNombre() + "!");
                        tipoMascotaValido = true;
                    } else {
                        throw new IllegalArgumentException("El tipo de mascota ingresado no es válido.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("El correo ingresado no está registrado.");

            boolean respuestaValida = false;
            while (!respuestaValida) {
                try {
                    System.out.print("¿Desea registrarse? (s/n): ");
                    String respuesta = scanner.nextLine().toLowerCase();
                    if (respuesta.equals("s")) {
                        registrarUsuario(scanner);
                        System.out.println("Usuario registrado exitosamente. Ahora puede iniciar sesión.");
                        respuestaValida = true;
                    } else if (respuesta.equals("n")) {
                        respuestaValida = true;
                    } else {
                        throw new IllegalArgumentException("Respuesta no válida. Por favor, ingrese 's' o 'n'.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        scanner.close();
    }

    public static void registrarUsuario(String correo, String tipoMascota, String nombre, String telefono) {
        Usuario nuevoUsuario = new Usuario(nombre, tipoMascota, telefono);
        usuariosRegistrados.put(correo, nuevoUsuario);
        correosRegistrados.put(correo, true);
    }

    public static void registrarUsuario(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Tipo de mascota: ");
        String tipoMascota = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine().trim();

        registrarUsuario(correo, tipoMascota, nombre, telefono);
    }

    public static class Usuario {
        private String nombre;
        private String tipoMascota;
        private String telefono;

        public Usuario(String nombre, String tipoMascota, String telefono) {
            this.nombre = nombre;
            this.tipoMascota = tipoMascota;
            this.telefono = telefono;
        }

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public String getTipoMascota() {
            return tipoMascota;

        }
    }
}