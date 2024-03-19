package com.service.mongodb.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.service.mongodb.dto.EnderecoDTO;
import com.service.mongodb.entity.Endereco;

public class EnderecoConverter {

	public static Map<String, Object> converterToMap(Endereco endereco) {
		
		Map<String, Object> mapEndereco = null;
		
		if(endereco != null && (StringUtils.hasText(endereco.getRua()) || endereco.getNumero() > 0)) {
			
			mapEndereco = new HashMap<String, Object>();
			
			if(StringUtils.hasText(endereco.getRua())) {
				mapEndereco.put("rua", endereco.getRua());
			}
	        
			if(endereco.getNumero() > 0) {
				mapEndereco.put("numero", endereco.getNumero());
			}
		}
		       

        return mapEndereco;
    }
	
	public static Endereco converterToEndereco(HashMap<String, Object> hashMap) {
		
		//Endereco endereco = new Endereco();
		//endereco.setRua((String) hashMap.get("rua"));
		//endereco.setNumero((Integer) hashMap.get("numero"));
		
		return Endereco.builder().
			rua((String) hashMap.get("rua")).
			numero((Integer) hashMap.get("numero")).
			build();
		
        //return endereco;
    }
	
	public static Endereco converterDTOToEndereco(EnderecoDTO enderecoDTO) {
				
		return Endereco.builder().
			rua(enderecoDTO.getRua()).
			numero(enderecoDTO.getNumero()).
			build();		
        
    }
	
	public static EnderecoDTO converterEnderecoToDTO(Endereco endereco) {
		
		return EnderecoDTO.builder().
			rua(endereco.getRua()).
			numero(endereco.getNumero()).
			build();		
        
    }
}
