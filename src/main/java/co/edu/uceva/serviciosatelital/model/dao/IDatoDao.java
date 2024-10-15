package co.edu.uceva.serviciosatelital.model.dao;

import co.edu.uceva.serviciosatelital.model.entities.Dato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDatoDao extends CrudRepository<Dato, Long> {

}
