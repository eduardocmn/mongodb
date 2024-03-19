package com.service.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {
	
	private String id;
	private String nome;
	private int idade;
	private String profissao;
	private Endereco endereco;

}
