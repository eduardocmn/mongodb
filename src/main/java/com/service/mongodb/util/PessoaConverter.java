package com.service.mongodb.util;

import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.util.StringUtils;

import com.mongodb.DBObject;
import com.service.mongodb.dto.PessoaDTO;
import com.service.mongodb.entity.Pessoa;

public class PessoaConverter {

	public static Map<String, Object> converterToMap(Pessoa pessoa) {
		
        Map<String, Object> mapPessoa = new HashMap<String, Object>();
        
        if(StringUtils.hasText(pessoa.getNome())) {
        	mapPessoa.put("nome", pessoa.getNome());
        }
        
        if(pessoa.getIdade() > 0) {
        	mapPessoa.put("idade", pessoa.getIdade());
        }
        
        if(StringUtils.hasText(pessoa.getProfissao())) {
        	mapPessoa.put("profissao", pessoa.getProfissao());
        }
        
        if(pessoa.getEndereco() != null) {
        	
        	Map<String, Object> mapEndereco = EnderecoConverter.converterToMap(pessoa.getEndereco());
        	if(mapEndereco != null) {
        		mapPessoa.put("endereco", mapEndereco);
        	}       	
        	
        }
        
        return mapPessoa;
    }
	
	public static Pessoa converterToPerson(DBObject dbo) {
		
		return Pessoa.builder().
			id(dbo.get("_id").toString()).
			nome((String) dbo.get("nome")).
			idade((Integer) dbo.get("idade")).
			profissao((String) dbo.get("profissao")).
			endereco(EnderecoConverter.converterToEndereco((HashMap<String, Object>) dbo.get("endereco"))).
			build();		
	}
	
	public static Pessoa converterDTOToPerson(PessoaDTO pessoaDTO) {
		
		return Pessoa.builder().
			nome(pessoaDTO.getNome()).
			idade(pessoaDTO.getIdade()).
			profissao(pessoaDTO.getProfissao()).
			endereco(pessoaDTO.getEndereco() != null ? EnderecoConverter.converterDTOToEndereco(pessoaDTO.getEndereco()) : null).
			build();
	}
	
	public static PessoaDTO converterPersonToDTO(Pessoa pessoa) {
		
		return PessoaDTO.builder().
			id(pessoa.getId()).
			nome(pessoa.getNome()).
			idade(pessoa.getIdade()).
			profissao(pessoa.getProfissao()).
			endereco(EnderecoConverter.converterEnderecoToDTO(pessoa.getEndereco())).
			build();
	}
	
	
	
}
