package com.example.mapper;

import com.example.dto.ClaveDTO;
import com.example.entity.Clave;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClaveMapper extends GenericMapper<Clave, ClaveDTO> {

	@Mappings({@Mapping(target = "createdAt", expression = "java(parseToStringWithFormat(clave.getCreatedAt()))"),
			@Mapping(target = "updatedAt", expression = "java(parseToStringWithFormat(clave.getUpdatedAt()))")})
	ClaveDTO toDto(Clave clave);

	@Mappings({@Mapping(target = "createdAt", expression = "java(parseToLocalDateTime(clave.getCreatedAt()))"),
			@Mapping(target = "updatedAt", expression = "java(parseToLocalDateTime(clave.getUpdatedAt()))")})
	Clave toEntity(ClaveDTO clave);
}