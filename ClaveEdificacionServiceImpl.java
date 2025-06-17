package com.example.service.impl;

import com.example.dto.ClaveEdificacionDTO;
import com.example.entity.ClaveEdificacion;
import com.example.mapper.ClaveEdificacionMapper;
import com.example.repository.ClaveEdificacionRepository;
import com.example.service.ClaveEdificacionService;
import com.example.repository.GenericRepository;
import com.example.mapper.GenericMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(ClaveEdificacionService.BEAN_NAME)
@Transactional
public class ClaveEdificacionServiceImpl extends GenericServiceImpl<ClaveEdificacion, ClaveEdificacionDTO, Long>
		implements
			ClaveEdificacionService {

	@Autowired
	private ClaveEdificacionRepository repo;
	@Autowired
	private ClaveEdificacionMapper mapper;

	@Override
	protected GenericRepository<ClaveEdificacion, Long> getRepo() {
		return repo;
	}

	@Override
	protected GenericMapper<ClaveEdificacion, ClaveEdificacionDTO> getMapper() {
		return mapper;
	}

	@Override
	protected Long extractIdFromDto(ClaveEdificacionDTO dto) {
		return dto.getId();
	}
}