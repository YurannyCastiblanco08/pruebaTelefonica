package com.telefonica.servicetelefonica.persistencia.repository;

import com.telefonica.servicetelefonica.persistencia.entity.PruebaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PruebaEstudianteRepository extends JpaRepository<PruebaEstudiante, Long>
{

    @Modifying
    @Query(value = "UPDATE estudiante SET especialidad='' WHERE id=:id", nativeQuery = true)
    public void updatePruebaEstudiantesBy(@Param("id") Long id);
}
