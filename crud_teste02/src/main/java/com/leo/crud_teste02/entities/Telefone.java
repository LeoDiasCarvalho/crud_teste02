package com.leo.crud_teste02.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Telefone {
	
	@Id
	@Column(name = "id_telefone")
	@NotNull
	private Long id_telefone;
	
	@Column(name = "tel_principal")
	@Size(min = 9, max = 11, message = "Telefone invalido")
	@NotBlank(message = "Telefone principal não pode ser vazio")
	private String tel_principal;
	
	@Column(name = "tel_recado")
	@Size(min = 9, max = 11, message = "Telefone invalido")
	private String tel_recado;

}
