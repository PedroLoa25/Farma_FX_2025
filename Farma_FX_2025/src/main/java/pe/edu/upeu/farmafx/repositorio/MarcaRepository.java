package pe.edu.upeu.farmafx.repositorio;

import pe.edu.upeu.farmafx.modelo.Marca;
import java.util.ArrayList;
import java.util.List;

public class MarcaRepository {

    protected List<Marca> listaMarcas = new ArrayList<>();
    private int proximoId = 1;

    public MarcaRepository() {
        guardar(new Marca() {{ setNombre("Genfar"); setActivo(true); }});
        guardar(new Marca() {{ setNombre("Bayer"); setActivo(true); }});
    }

    public List<Marca> buscarTodos() {
        return new ArrayList<>(listaMarcas);
    }

    public Marca guardar(Marca marca) {
        if (marca.getId() == 0) {
            marca.setId(proximoId++);
            listaMarcas.add(marca);
        } else {
            listaMarcas.stream()
                    .filter(m -> m.getId() == marca.getId())
                    .findFirst()
                    .ifPresent(m -> {
                        m.setNombre(marca.getNombre());
                        m.setActivo(marca.isActivo());
                    });
        }
        return marca;
    }

    public void eliminar(int id) {
        listaMarcas.removeIf(m -> m.getId() == id);
    }
}
