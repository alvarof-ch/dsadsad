package com.example.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.controller.ClaveEdificacionController;
import com.example.util.response.CustomPage;
import com.example.util.response.GenericResponse;
import com.example.util.response.ResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort.Direction;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.example.service.ClaveEdificacionService;
import com.example.dto.ClaveEdificacionDTO;

@RestController
@RequestMapping("/claveedificacion")
public class ClaveEdificacionControllerImpl implements ClaveEdificacionController {

	private Logger logger = LoggerFactory.getLogger(ClaveEdificacionControllerImpl.class);
	@Autowired
	private ClaveEdificacionService service;

	@GetMapping
	public ResponseEntity<GenericResponse<ClaveEdificacionDTO>> findById(Long id) {
		logger.info("call ClaveEdificacionControllerImpl :: findById()");
		ClaveEdificacionDTO dto = service.findById(id);
		return ResponseEntityUtil.createResponse(dto, "claveEdificacion found", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<GenericResponse<List<ClaveEdificacionDTO>>> findAll() {
		logger.info("call ClaveEdificacionControllerImpl :: findAll()");
		List<ClaveEdificacionDTO> dtos = service.findAll();
		return ResponseEntityUtil.createResponse(dtos, "List of claveEdificacion", HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<GenericResponse<ClaveEdificacionDTO>> save(ClaveEdificacionDTO obj) {
		logger.info("call ClaveEdificacionControllerImpl :: save()");
		ClaveEdificacionDTO dto = service.save(obj);
		return ResponseEntityUtil.createResponse(dto, "claveEdificacion save success", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<GenericResponse<ClaveEdificacionDTO>> update(Long id, ClaveEdificacionDTO obj) {
		logger.info("call ClaveEdificacionControllerImpl :: update()");
		obj.setId(id);
		ClaveEdificacionDTO dto = service.update(obj);
		return ResponseEntityUtil.createResponse(dto, "claveEdificacion update success", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		logger.info("call ClaveEdificacionControllerImpl :: delete()");
		service.delete(id);
		return ResponseEntityUtil.createEmptyResponse("claveEdificacion delete success", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<CustomPage<ClaveEdificacionDTO>> search(int page, int size, String sortField,
			Direction direction, ClaveEdificacionDTO filterDto) {
		Pageable pageable = PageRequest.of(page - 1, size);
		CustomPage<ClaveEdificacionDTO> dtos = service.findByAttributesAndPaginationAndSort(filterDto, pageable,
				sortField, direction);
		return ResponseEntityUtil.createCustomPageResponse(dtos, "Search found", HttpStatus.OK);
	}
}