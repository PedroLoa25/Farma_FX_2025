package pe.edu.upeu.farmafx.utils;

public class ValidacionesUtils {

    /**
     * Valida si un DNI tiene 8 dígitos numéricos.
     */
    public static boolean validarDni(String dni) {
        // Verifica que no sea nulo y que contenga exactamente 8 dígitos.
        return dni != null && dni.matches("\\d{8}");
    }

    /**
     * Valida si una clave tiene más de 8 caracteres y contiene letras y números.
     */
    public static boolean validarClave(String clave) {
        if (clave == null || clave.length() <= 8) {
            return false;
        }
        boolean tieneLetra = false;
        boolean tieneNumero = false;
        for (char c : clave.toCharArray()) {
            if (Character.isLetter(c)) {
                tieneLetra = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            }
            if (tieneLetra && tieneNumero) {
                return true; // Si ya encontramos ambos, es válida.
            }
        }
        return false; // Si termina el bucle y falta uno, no es válida.
    }
}