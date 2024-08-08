package com.telefonica.servicetelefonica.servicio;

import com.telefonica.servicetelefonica.dto.PruebaEstudianteDto;
import com.telefonica.servicetelefonica.exception.Exceptions;
import com.telefonica.servicetelefonica.mapper.PruebaEstInDTOToPruebaEst;
import com.telefonica.servicetelefonica.persistencia.entity.PruebaEstudiante;
import com.telefonica.servicetelefonica.persistencia.repository.PruebaEstudianteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PruebaEstudianteService {

    private final PruebaEstudianteRepository repository;
    private final PruebaEstInDTOToPruebaEst mapper;

    public PruebaEstudianteService(PruebaEstudianteRepository repository, PruebaEstInDTOToPruebaEst mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PruebaEstudiante create(PruebaEstudianteDto pruebaEstudianteDto) {
        PruebaEstudiante prueba = mapper.map(pruebaEstudianteDto);
        return this.repository.save(prueba);
    }

    public List<PruebaEstudiante> findAll() {
        return this.repository.findAll();
    }

   @Transactional
    public void updateEstudiante(Long id) {
        Optional<PruebaEstudiante> updateEst = this.repository.findById(id);
        if (updateEst.isEmpty()) {
            throw new Exceptions("Estudiante no encontrado", HttpStatus.NOT_FOUND);
        }

        this.repository.updatePruebaEstudiantesBy(id);
    }

    public void deleteById(Long id) {
        Optional<PruebaEstudiante> optionalDelete = this.repository.findById(id);
        if (optionalDelete.isEmpty()) {
            throw new Exceptions("Estudiante no encontrado", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }

}
