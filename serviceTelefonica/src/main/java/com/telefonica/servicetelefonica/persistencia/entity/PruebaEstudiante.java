package com.telefonica.servicetelefonica.persistencia.entity;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "estudiante")
public class PruebaEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String especialidad;
    private String grado;
}
