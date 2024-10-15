package co.edu.uceva.serviciosatelital.model.service;

import co.edu.uceva.serviciosatelital.model.dao.IDatoDao;
import co.edu.uceva.serviciosatelital.model.entities.Dato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class DatoServiceImpl implements IDatoService{

    IDatoDao datoDao;

    @Autowired
    public DatoServiceImpl(IDatoDao datoDao) {
        this.datoDao = datoDao;

    }
    @Override
    public List<Dato> list() {return (List<Dato>) datoDao.findAll(); }

    @Override
    public Dato saveData(Dato asignatura) {
        return datoDao.save(asignatura);
    }


    @Override
    public Dato updateData(Dato asignatura) {
        return datoDao.save(asignatura);
    }

    @Override
    public void deleteData(Dato dato) {
        datoDao.delete(dato);
    }

    @Override
    public Dato findById(Long id) {
        return datoDao.findById(id).orElseThrow(() -> new DatoServiceImpl.ResourceNotFoundException("info no encontrada con id " + id));
    }



        @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
