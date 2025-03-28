package co.edu.uceva.serviciosatelital.controller;

import co.edu.uceva.serviciosatelital.model.entities.Dato;
import co.edu.uceva.serviciosatelital.model.service.IDatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    //funcion guardado, guarda las imagenes en firebase store
    @PostMapping("/saveData")
    public ResponseEntity<Dato> saveDato(
            @RequestParam("ndwi_img") MultipartFile file1,
            @RequestParam("ndti_img") MultipartFile file2,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("area") String area,
            @RequestParam("date_proccess") String date_proccess,
            @RequestParam("path_row_src") String path_row_src,
            @RequestParam("colored_img") MultipartFile file3
    ) {

        try {
            Dato dato = new Dato();
            dato.setName(name);
            dato.setDescription(description);
            dato.setArea(area);
            dato.setDate_proccess(date_proccess);
            dato.setPath_row_src(path_row_src);
            // Añadir más campos según sea necesario
            Dato savedDato = datoService.saveDato(dato, file1, file2, file3);
            return new ResponseEntity<>(savedDato, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //funcion listar que usa datoService
    @GetMapping("/allData")
    public List<Dato> list(){
        return this.datoService.list();
    }

    //funcion actualizar
    @PutMapping("/updateData")
    public ResponseEntity<Dato> updateData(
            @RequestParam("ndwi_img") MultipartFile file1,
            @RequestParam("ndti_img") MultipartFile file2,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("area") String area,
            @RequestParam("date_proccess") String date_proccess,
            @RequestParam("path_row_src") String path_row_src,
            @RequestParam("colored_img") MultipartFile file3

    ) {
        try {
            Dato dato = new Dato();
            dato.setName(name);
            dato.setDescription(description);
            dato.setArea(area);
            dato.setDate_proccess(date_proccess);
            dato.setPath_row_src(path_row_src);
            // Añadir más campos según sea necesario
            Dato savedDato = datoService.saveDato(dato, file1, file2, file3);
            return new ResponseEntity<>(savedDato, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

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


    @GetMapping("/searchDataByName/{name}")
    public List<Dato> searchDataName(@PathVariable String name){
        return this.datoService.findByName(name);
    }


}
