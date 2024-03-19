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
public class EnderecoDTO {

	@ApiModelProperty(value = "Nome da rua")
	private String rua;
	
	@ApiModelProperty(value = "Numero da rua")
	private int numero;
	
}
