package com.universidad.seguridad.service;

import com.universidad.seguridad.model.Tarea;
import com.universidad.seguridad.repository.TareaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TareaService {
    private final TareaRepository repo;

    public TareaService(TareaRepository repo) { this.repo = repo; }

    // ADMIN ve todas; USER solo las suyas (se filtra en el controlador
    // por el id del usuario autenticado, ver Paso 6)
    @PreAuthorize("hasRole('ADMIN') or #usuarioId == authentication.principal.id")
    public List<Tarea> listarDe(Long usuarioId) {
        return repo.findByPropietarioId(usuarioId);
    }

    public List<Tarea> buscar(String texto) {
        return repo.buscarPorTitulo(texto); // @Query parametrizado — seguro
    }
}
