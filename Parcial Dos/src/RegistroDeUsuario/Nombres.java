package RegistroDeUsuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nombres {
    private static final String NOMBRES = "^[A-Z-a-z]+$";

    public static boolean validarNombre(String nombre) {
        Pattern patron = Pattern.compile(NOMBRES);
        Matcher matcher = patron.matcher(nombre);
        return matcher.matches();
    }
}