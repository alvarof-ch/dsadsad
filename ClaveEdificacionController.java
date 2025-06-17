package com.example.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Sort.Direction;
import com.example.util.response.CustomPage;
import com.example.util.response.GenericResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.example.dto.ClaveEdificacionDTO;

@SecurityRequirement(name = "JWT")
public interface ClaveEdificacionController {

	@Operation(summary = "Buscar por Id")
	ResponseEntity<GenericResponse<ClaveEdificacionDTO>> findById(Long id);

	@Operation(summary = "Listar")
	ResponseEntity<GenericResponse<List<ClaveEdificacionDTO>>> findAll();

	@Operation(summary = "Guardar")
	ResponseEntity<GenericResponse<ClaveEdificacionDTO>> save(ClaveEdificacionDTO obj);

	@Operation(summary = "Actualizar")
	ResponseEntity<GenericResponse<ClaveEdificacionDTO>> update(Long id, ClaveEdificacionDTO obj);

	@Operation(summary = "Eliminar")
	ResponseEntity<Void> delete(Long id);

	@Operation(summary = "Buscar por campos")
	ResponseEntity<CustomPage<ClaveEdificacionDTO>> search(int page, int size, String sortField, Direction direction,
			ClaveEdificacionDTO filterDto);
}