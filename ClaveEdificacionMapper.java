package com.example.mapper;

import com.example.dto.ClaveEdificacionDTO;
import com.example.entity.ClaveEdificacion;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClaveEdificacionMapper extends GenericMapper<ClaveEdificacion, ClaveEdificacionDTO> {

	@Mappings({
			@Mapping(target = "createdAt", expression = "java(parseToStringWithFormat(claveEdificacion.getCreatedAt()))"),
			@Mapping(target = "updatedAt", expression = "java(parseToStringWithFormat(claveEdificacion.getUpdatedAt()))"),
			@Mapping(source = "campo.id", target = "campoId")})
	ClaveEdificacionDTO toDto(ClaveEdificacion claveEdificacion);

	@Mappings({
			@Mapping(target = "createdAt", expression = "java(parseToLocalDateTime(claveEdificacion.getCreatedAt()))"),
			@Mapping(target = "updatedAt", expression = "java(parseToLocalDateTime(claveEdificacion.getUpdatedAt()))"),
			@Mapping(source = "campoId", target = "campo.id")})
	ClaveEdificacion toEntity(ClaveEdificacionDTO claveEdificacion);
}