package com.telefonica.servicetelefonica.mapper;

public interface IMapper <datoEntrada, datoSalida>{
    public datoSalida map(datoEntrada in);
}
