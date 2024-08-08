package com.telefonica.servicetelefonica.mapper;

import com.telefonica.servicetelefonica.dto.PruebaEstudianteDto;
import com.telefonica.servicetelefonica.persistencia.entity.PruebaEstudiante;
import org.springframework.stereotype.Component;

@Component
public class PruebaEstInDTOToPruebaEst implements IMapper<PruebaEstudianteDto, PruebaEstudiante>{

    @Override
    public PruebaEstudiante map(PruebaEstudianteDto in) {
        PruebaEstudiante prueba = new PruebaEstudiante();
        prueba.setNombre(in.getNombre());
        prueba.setEspecialidad(in.getEspecialidad());
        prueba.setGrado(in.getGrado());
        return prueba;
    }
}
