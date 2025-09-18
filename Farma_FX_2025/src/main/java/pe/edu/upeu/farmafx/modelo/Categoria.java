package pe.edu.upeu.farmafx.modelo;

import lombok.Data;

@Data
public class Categoria {
    private int id;
    private String nombre;
    private boolean activo; // Usaremos 'activo' para el estado
}
