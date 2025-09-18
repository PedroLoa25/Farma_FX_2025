package pe.edu.upeu.farmafx.repositorio;

import pe.edu.upeu.farmafx.modelo.Categoria;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// No necesita anotaciones porque el Servicio lo hereda
public class CategoriaRepository {

    protected List<Categoria> listaCategorias = new ArrayList<>();
    private int proximoId = 1;

    public CategoriaRepository() {
        // Precargamos datos de ejemplo
        guardar(new Categoria() {{ setNombre("Analgésicos"); setActivo(true); }});
        guardar(new Categoria() {{ setNombre("Antibióticos"); setActivo(true); }});
        guardar(new Categoria() {{ setNombre("Vitaminas"); setActivo(false); }});
    }

    public List<Categoria> buscarTodos() {
        return new ArrayList<>(listaCategorias);
    }

    public Categoria guardar(Categoria categoria) {
        if (categoria.getId() == 0) {
            // Es una nueva categoría
            categoria.setId(proximoId++);
            listaCategorias.add(categoria);
        } else {
            // Es una actualización
            listaCategorias.stream()
                    .filter(c -> c.getId() == categoria.getId())
                    .findFirst()
                    .ifPresent(c -> {
                        c.setNombre(categoria.getNombre());
                        c.setActivo(categoria.isActivo());
                    });
        }
        return categoria;
    }

    public void eliminar(int id) {
        listaCategorias.removeIf(c -> c.getId() == id);
    }
}
