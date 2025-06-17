package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClaveDTO extends AuditableDTO<Long> {

	private String codigo;
	private String descripcion;
}