package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "CLAVE_EDIFICACION")
@Getter
@Setter
public class claveEdificacion extends AuditableEntity {

	@Column(name = "ID_CODIGO")
	private String codigo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CAMPO", referencedColumnName = "ID")
	private Clave campo;
}