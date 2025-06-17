package com.example.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Sort.Direction;
import com.example.util.response.CustomPage;
import com.example.util.response.GenericResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.example.dto.ClaveDTO;

@SecurityRequirement(name = "JWT")
public interface ClaveController {

	@Operation(summary = "Buscar por Id")
	ResponseEntity<GenericResponse<ClaveDTO>> findById(Long id);

	@Operation(summary = "Listar")
	ResponseEntity<GenericResponse<List<ClaveDTO>>> findAll();

	@Operation(summary = "Guardar")
	ResponseEntity<GenericResponse<ClaveDTO>> save(ClaveDTO obj);

	@Operation(summary = "Actualizar")
	ResponseEntity<GenericResponse<ClaveDTO>> update(Long id, ClaveDTO obj);

	@Operation(summary = "Eliminar")
	ResponseEntity<Void> delete(Long id);

	@Operation(summary = "Buscar por campos")
	ResponseEntity<CustomPage<ClaveDTO>> search(int page, int size, String sortField, Direction direction,
			ClaveDTO filterDto);
}