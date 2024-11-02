package co.edu.uceva.serviciosatelital.model.dao;

import co.edu.uceva.serviciosatelital.model.entities.Dato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface IDatoDao extends JpaRepository<Dato, Long> {

    // Búsqueda parcial, insensible a mayúsculas y minúsculas
    @Query("SELECT d FROM Dato d WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Dato> findByNombreContainingIgnoreCaseWithJPQL(String name);
}
