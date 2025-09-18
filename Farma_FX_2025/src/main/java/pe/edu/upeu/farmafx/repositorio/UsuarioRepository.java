package pe.edu.upeu.farmafx.repositorio;

import pe.edu.upeu.farmafx.modelo.Usuario;
import pe.edu.upeu.farmafx.enums.Estado;
import pe.edu.upeu.farmafx.enums.RolUsuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    // Lista 'protected' para ser accesible por la clase hija (el Servicio).
    protected List<Usuario> listaUsuarios;

    public UsuarioRepository() {
        this.listaUsuarios = new ArrayList<>();
        cargarDatosIniciales();
    }

    // --- MÉTODOS DE GESTIÓN DE DATOS ---

    /**
     * Busca un usuario en la lista por su DNI.
     */
    public Usuario buscarPorDni(String dni) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Guarda un nuevo usuario en la lista.
     */
    public void guardar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    // --- DATOS PREDEFINIDOS ---

    /**
     * Crea usuarios de ejemplo al iniciar el repositorio.
     */
    private void cargarDatosIniciales() {
        // Usuario Administrador
        Usuario admin = new Usuario();
        admin.setDni("12345678");
        admin.setClave("admin1234");
        admin.setRol(RolUsuario.ADMINISTRADOR);
        admin.setEstado(Estado.ACTIVO);
        listaUsuarios.add(admin);

        // Usuario Cliente
        Usuario cliente = new Usuario();
        cliente.setDni("87654321");
        cliente.setClave("cliente5678");
        cliente.setRol(RolUsuario.CLIENTE);
        cliente.setEstado(Estado.ACTIVO);
        listaUsuarios.add(cliente);
    }
}