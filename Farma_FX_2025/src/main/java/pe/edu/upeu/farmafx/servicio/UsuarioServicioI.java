package pe.edu.upeu.farmafx.servicio;

import pe.edu.upeu.farmafx.modelo.Usuario;

public interface UsuarioServicioI {

    String registrarUsuario(Usuario usuario);

    Usuario autenticarUsuario(String dni, String clave);
}