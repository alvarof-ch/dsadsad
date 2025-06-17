package com.example.service.impl;

import com.example.dto.ClaveDTO;
import com.example.entity.Clave;
import com.example.mapper.ClaveMapper;
import com.example.repository.ClaveRepository;
import com.example.service.ClaveService;
import com.example.repository.GenericRepository;
import com.example.mapper.GenericMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(ClaveService.BEAN_NAME)
@Transactional
public class ClaveServiceImpl extends GenericServiceImpl<Clave, ClaveDTO, Long> implements ClaveService {

	@Autowired
	private ClaveRepository repo;
	@Autowired
	private ClaveMapper mapper;

	@Override
	protected GenericRepository<Clave, Long> getRepo() {
		return repo;
	}

	@Override
	protected GenericMapper<Clave, ClaveDTO> getMapper() {
		return mapper;
	}

	@Override
	protected Long extractIdFromDto(ClaveDTO dto) {
		return dto.getId();
	}
}