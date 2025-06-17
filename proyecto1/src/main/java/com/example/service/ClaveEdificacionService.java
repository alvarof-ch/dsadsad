package com.example.service;

import com.example.entity.ClaveEdificacion;
import com.example.dto.ClaveEdificacionDTO;

public interface ClaveEdificacionService extends GenericService<ClaveEdificacion, ClaveEdificacionDTO, Long> {

	String BEAN_NAME = "claveEdificacion";
}