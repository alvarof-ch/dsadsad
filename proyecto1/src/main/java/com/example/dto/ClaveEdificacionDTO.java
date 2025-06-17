package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClaveEdificacionDTO extends AuditableDTO<Long> {

	private String codigo;
	private Long campoId;
}