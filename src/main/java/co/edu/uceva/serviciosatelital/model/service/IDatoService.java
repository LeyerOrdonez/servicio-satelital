package co.edu.uceva.serviciosatelital.model.service;

import co.edu.uceva.serviciosatelital.model.entities.Dato;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IDatoService {

    List<Dato> list();

    Dato updateData(Dato dato);

    void deleteData(Dato dato) ;

    Dato findById(Long id);

    Dato saveDato(Dato dato, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;

    List<Dato> findByName(String nombre);




}
