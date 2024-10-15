package co.edu.uceva.serviciosatelital.controller;

import co.edu.uceva.serviciosatelital.model.entities.Dato;
import co.edu.uceva.serviciosatelital.model.service.IDatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/servicio-satelital")
public class DatoRestController {
    private IDatoService datoService;

    @Autowired
    public DatoRestController(IDatoService datoService){
        this.datoService = datoService;
    }

    //funcion listar que usa datoService
    @GetMapping("/allData")
    public List<Dato> list(){
        return this.datoService.list();
    }

    //funcion guardar
    @PostMapping("/saveData")
    public Dato createData(@RequestBody Dato dato){
        return this.datoService.saveData(dato);
    }

    //funcion actualizar
    @PutMapping("/updateData")
    public Dato updateData(@RequestBody Dato dato) {
        return this.datoService.saveData(dato);
    }

    //Funcion borrar
    @DeleteMapping("/deleteData/{id}")
    public void deleteData(@PathVariable Long id) {
        Dato dato = this.datoService.findById(id); // Encuentro un pais por su id
        this.datoService.deleteData(dato);
    }

    @GetMapping("/searchDataById/{id}")
    public Dato searchDataId(@PathVariable Long id) {
        return this.datoService.findById(id);
    }


}
