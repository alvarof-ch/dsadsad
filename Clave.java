package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;

@Entity
@Table(name = "CLAVE")
@Getter
@Setter
public class Clave extends AuditableEntity {

	@Column(name = "CODIGO", unique = true)
	private String codigo;
	@Column(name = "ID_DESCRIPCION")
	private String descripcion;
}