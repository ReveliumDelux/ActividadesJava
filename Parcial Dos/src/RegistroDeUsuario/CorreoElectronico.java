package RegistroDeUsuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorreoElectronico {
    private static final String CORREO = "^[A-Z0-9a-z.]+@";

    public static boolean validarCorreoElectronico(String correo) {
        Pattern patron = Pattern.compile(CORREO);
        Matcher matcher = patron.matcher(correo);
        return matcher.matches();
    }
}
