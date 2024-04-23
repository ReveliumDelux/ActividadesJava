package RegistroDeUsuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contrseña {
    private static final String CONTRASENA = "^[A-Z0-9]+$";

    public static boolean validarContrasena(String contrasena) {
        Pattern patron = Pattern.compile(CONTRASENA);
        Matcher matcher = patron.matcher(contrasena);
        return matcher.matches();
    }
}