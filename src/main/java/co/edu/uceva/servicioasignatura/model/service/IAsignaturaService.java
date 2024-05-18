package co.edu.uceva.servicioasignatura.model.service;

import co.edu.uceva.servicioasignatura.model.entities.Asignatura;

import java.util.List;

public interface IAsignaturaService {

    Asignatura delete(Asignatura asignatura);
    List<Asignatura> findAll();
    Asignatura save(Asignatura asignatura);
    Asignatura findById(Long id);
    Asignatura update(Asignatura asignatura);
}
