package pe.edu.upeu.farmafx.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.farmafx.modelo.Usuario;
import pe.edu.upeu.farmafx.repositorio.UsuarioRepository;
import pe.edu.upeu.farmafx.utils.ValidacionesUtils;
import pe.edu.upeu.farmafx.enums.Estado;

import java.util.List; // Necesario para usar List

@Service
public class UsuarioServicioImp extends UsuarioRepository implements UsuarioServicioI {

    // --- MÉTODOS QUE YA TENÍAS ---

    @Override
    public String registrarUsuario(Usuario usuario) {
        if (!ValidacionesUtils.validarDni(usuario.getDni())) {
            return "Error: El DNI debe tener 8 dígitos numéricos.";
        }
        if (!ValidacionesUtils.validarClave(usuario.getClave())) {
            return "Error: La clave debe tener más de 8 caracteres, incluyendo letras y números.";
        }
        if (this.buscarPorDni(usuario.getDni()) != null) {
            return "Error: El DNI ya se encuentra registrado.";
        }
        usuario.setEstado(Estado.ACTIVO);
        this.guardarUsuario(usuario); // Reutilizamos el nuevo método unificado
        return "Registro exitoso.";
    }

    @Override
    public Usuario autenticarUsuario(String dni, String clave) {
        Usuario usuario = this.buscarPorDni(dni);
        if (usuario != null && usuario.getClave().equals(clave) && usuario.getEstado() == Estado.ACTIVO) {
            return usuario;
        }
        return null;
    }

    // --- NUEVOS MÉTODOS IMPLEMENTADOS ---

    /**
     * Devuelve la lista completa de usuarios. Necesario para llenar la TableView.
     */
    @Override
    public List<Usuario> listarTodosLosUsuarios() {
        return this.listaUsuarios; // Devuelve la lista heredada del Repositorio
    }

    /**
     * Unifica la lógica de creación y actualización.
     * Si el usuario no existe, lo añade a la lista.
     * Si ya existe, los cambios se reflejan al modificar el objeto.
     */
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        if(buscarPorDni(usuario.getDni()) == null) {
            this.guardar(usuario); // El método 'guardar' del Repositorio añade a la lista
        }
        return usuario;
    }

    /**
     * Elimina un usuario de la lista basándose en su DNI.
     */
    @Override
    public void eliminarUsuarioPorDni(String dni) {
        // removeIf recorre la lista y elimina el elemento que cumple la condición
        this.listaUsuarios.removeIf(user -> user.getDni().equals(dni));
    }
}