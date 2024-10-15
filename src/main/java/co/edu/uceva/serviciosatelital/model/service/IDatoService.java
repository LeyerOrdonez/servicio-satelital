package co.edu.uceva.serviciosatelital.model.service;

import co.edu.uceva.serviciosatelital.model.entities.Dato;

import java.util.List;

public interface IDatoService {

    List<Dato> list();

    Dato saveData(Dato dato);

    Dato updateData(Dato dato);

    void deleteData(Dato dato) ;

    Dato findById(Long id);




}
