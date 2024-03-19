package com.service.mongodb.dto;


import io.swagger.annotations.ApiModelProperty;
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
public class PessoaDTO {

	@ApiModelProperty(value = "Codigo da pessoa")
	private String id;
	
	@ApiModelProperty(value = "Nome da pessoa")
	private String nome;
	
	@ApiModelProperty(value = "Idade da pessoa")
	private int idade;
	
	@ApiModelProperty(value = "Profissao da pessoa")
	private String profissao;
	
	@ApiModelProperty(value = "Endereco da pessoa")
	private EnderecoDTO endereco;
	
}
