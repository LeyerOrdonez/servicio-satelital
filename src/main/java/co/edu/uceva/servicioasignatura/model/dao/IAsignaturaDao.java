package co.edu.uceva.servicioasignatura.model.dao;

import co.edu.uceva.servicioasignatura.model.entities.Asignatura;
import org.springframework.data.repository.CrudRepository;

public interface IAsignaturaDao extends CrudRepository<Asignatura, Long> {

}
