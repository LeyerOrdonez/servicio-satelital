package co.edu.uceva.servicioasignatura.controller;

import co.edu.uceva.servicioasignatura.model.entities.Asignatura;
import co.edu.uceva.servicioasignatura.model.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/asignatura-service")
public class AsignaturaRestController {
    private IAsignaturaService asignaturaService;

    @Autowired
    public AsignaturaRestController(IAsignaturaService asignaturaService){
        this.asignaturaService = asignaturaService;
    }


    //funcion listar que usa AsignaturaService
    @GetMapping("/asignaturas")
    public List<Asignatura> listar(){
        return this.asignaturaService.findAll();
    }


    
    //funcion actualizar hecha por camilo mena
    @PutMapping("/asignaturasActualizar")
    public Asignatura actualizarAsignatura(@RequestBody Asignatura asignatura) {
        return this.asignaturaService.save(asignatura);
    }

    // Funcion borrar

    @DeleteMapping("/asignaturasBorrar")
    public Asignatura borrarAsignatura(@RequestBody Asignatura asignatura) {
        return this.asignaturaService.delete(asignatura);
    }



}
