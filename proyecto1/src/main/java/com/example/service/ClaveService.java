package com.example.service;

import com.example.entity.Clave;
import com.example.dto.ClaveDTO;

public interface ClaveService extends GenericService<Clave, ClaveDTO, Long> {

	String BEAN_NAME = "clave";
}