package com.telefonica.servicetelefonica.controller;

import com.telefonica.servicetelefonica.dto.PruebaEstudianteDto;
import com.telefonica.servicetelefonica.persistencia.entity.PruebaEstudiante;
import com.telefonica.servicetelefonica.servicio.PruebaEstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pruebaEstudiantes")
public class ServicioController {

    private final PruebaEstudianteService pruebaService;

    public ServicioController (PruebaEstudianteService pruebaService) {
        this.pruebaService = pruebaService;
    }

    @PostMapping
    public PruebaEstudiante create(@RequestBody PruebaEstudianteDto pruebaEstudianteDto) {
       return this.pruebaService.create(pruebaEstudianteDto);
    }

    @GetMapping
    public List<PruebaEstudiante> findAll(){
        return this.pruebaService.findAll();
    }

    @PatchMapping("/estudiantes/{id}")
    public ResponseEntity<Void> updatePruebaEstudiantes(@PathVariable("id") Long id) {
        this.pruebaService.updateEstudiante(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.pruebaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
