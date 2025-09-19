package pe.edu.upeu.farmafx.servicio;

import pe.edu.upeu.farmafx.modelo.Usuario;
import java.util.List;

public interface UsuarioServicioI {

    // --- Métodos que ya teníamos ---
    String registrarUsuario(Usuario usuario);
    Usuario autenticarUsuario(String dni, String clave);

    // --- NUEVOS MÉTODOS (LA PARTE QUE PROBABLEMENTE FALTABA) ---
    List<Usuario> listarTodosLosUsuarios();
    Usuario guardarUsuario(Usuario usuario);
    void eliminarUsuarioPorDni(String dni);
}