package co.edu.uceva.serviciosatelital.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="datos")
public class Datos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String ndwi_link;
    private String ndti_link;
    private String area;
    private String date_proccess;
    private String path_row_src;

}

