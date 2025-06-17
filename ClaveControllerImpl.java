package com.example.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.controller.ClaveController;
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
import com.example.service.ClaveService;
import com.example.dto.ClaveDTO;

@RestController
@RequestMapping("/clave")
public class ClaveControllerImpl implements ClaveController {

	private Logger logger = LoggerFactory.getLogger(ClaveControllerImpl.class);
	@Autowired
	private ClaveService service;

	@GetMapping
	public ResponseEntity<GenericResponse<ClaveDTO>> findById(Long id) {
		logger.info("call ClaveControllerImpl :: findById()");
		ClaveDTO dto = service.findById(id);
		return ResponseEntityUtil.createResponse(dto, "Clave found", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<GenericResponse<List<ClaveDTO>>> findAll() {
		logger.info("call ClaveControllerImpl :: findAll()");
		List<ClaveDTO> dtos = service.findAll();
		return ResponseEntityUtil.createResponse(dtos, "List of Clave", HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<GenericResponse<ClaveDTO>> save(ClaveDTO obj) {
		logger.info("call ClaveControllerImpl :: save()");
		ClaveDTO dto = service.save(obj);
		return ResponseEntityUtil.createResponse(dto, "Clave save success", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<GenericResponse<ClaveDTO>> update(Long id, ClaveDTO obj) {
		logger.info("call ClaveControllerImpl :: update()");
		obj.setId(id);
		ClaveDTO dto = service.update(obj);
		return ResponseEntityUtil.createResponse(dto, "Clave update success", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		logger.info("call ClaveControllerImpl :: delete()");
		service.delete(id);
		return ResponseEntityUtil.createEmptyResponse("Clave delete success", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<CustomPage<ClaveDTO>> search(int page, int size, String sortField, Direction direction,
			ClaveDTO filterDto) {
		Pageable pageable = PageRequest.of(page - 1, size);
		CustomPage<ClaveDTO> dtos = service.findByAttributesAndPaginationAndSort(filterDto, pageable, sortField,
				direction);
		return ResponseEntityUtil.createCustomPageResponse(dtos, "Search found", HttpStatus.OK);
	}
}