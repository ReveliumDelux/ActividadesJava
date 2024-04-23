package RegistroDeUsuario;

import java.util.Scanner;


public class RegistroCompleto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Registro de Usuarios ---");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        if (Nombres.validarNombre(nombre)) {
            System.out.println("\tNombre válido.");
        } else {
            System.out.println("\tNombre inválido.");
        }
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        if (CorreoElectronico.validarCorreoElectronico(correo)) {
            System.out.println("\tCorreo electrónico válido.");
        } else {
            System.out.println("\tCorreo electrónico inválido.");
        }
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();
        if (Contrseña.validarContrasena(contrasena)) {
            System.out.println("\tContraseña válida.");
        } else {
            System.out.println("\tContraseña inválida.");
        }

        scanner.close();
    }
}
