package pe.edu.upeu.farmafx.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.farmafx.modelo.Usuario;
import pe.edu.upeu.farmafx.repositorio.UsuarioRepository;
import pe.edu.upeu.farmafx.utils.ValidacionesUtils;
import pe.edu.upeu.farmafx.enums.Estado;

@Service
public class UsuarioServicioImp extends UsuarioRepository implements UsuarioServicioI {

    @Override
    public String registrarUsuario(Usuario usuario) {
        // Paso 1: Usar la clase de utilidades para validar los datos.
        if (!ValidacionesUtils.validarDni(usuario.getDni())) {
            return "Error: El DNI debe tener 8 dígitos numéricos.";
        }
        if (!ValidacionesUtils.validarClave(usuario.getClave())) {
            return "Error: La clave debe tener más de 8 caracteres, incluyendo letras y números.";
        }

        // Paso 2: Usar el método 'buscarPorDni' que HEREDAMOS del repositorio.
        if (this.buscarPorDni(usuario.getDni()) != null) {
            return "Error: El DNI ya se encuentra registrado.";
        }

        // Paso 3: Si todo es correcto, guardamos el usuario.
        usuario.setEstado(Estado.ACTIVO);
        // Usamos el método 'guardar' que también HEREDAMOS.
        this.guardar(usuario);
        return "Registro exitoso.";
    }

    @Override
    public Usuario autenticarUsuario(String dni, String clave) {
        // Usamos el método heredado 'buscarPorDni'.
        Usuario usuario = this.buscarPorDni(dni);

        // Verificamos que el usuario exista, la clave sea correcta y esté activo.
        if (usuario != null && usuario.getClave().equals(clave) && usuario.getEstado() == Estado.ACTIVO) {
            return usuario;
        }

        return null; // Si algo falla, retornamos null.
    }
}