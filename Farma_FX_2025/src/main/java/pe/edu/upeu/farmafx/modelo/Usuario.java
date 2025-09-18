package pe.edu.upeu.farmafx.modelo;

import lombok.Data;
import pe.edu.upeu.farmafx.enums.Estado;
import pe.edu.upeu.farmafx.enums.RolUsuario;

@Data // Anotación de Lombok: crea getters, setters, toString(), etc. automáticamente.
public class Usuario {

    private String dni;
    private String clave;
    private Estado estado;
    private RolUsuario rol;

}