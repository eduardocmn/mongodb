package com.service.mongodb.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.mongodb.dao.PessoaDAO;
import com.service.mongodb.dto.PessoaDTO;
import com.service.mongodb.entity.Pessoa;
import com.service.mongodb.util.PessoaConverter;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	public PessoaDTO findPessoa(PessoaDTO pessoaDTO) {
		
		Pessoa pessoa = PessoaConverter.converterDTOToPerson(pessoaDTO);
		
		Map<String, Object> mapPessoa = PessoaConverter.converterToMap(pessoa);
		
		Pessoa pessoafound = this.pessoaDAO.findPessoa(mapPessoa);
		
		PessoaDTO pessoaReturnDTO = PessoaConverter.converterPersonToDTO(pessoafound);
		
		return pessoaReturnDTO;
	}
	
	public void savePessoa(PessoaDTO pessoaDTO) {
		
		Pessoa pessoa = PessoaConverter.converterDTOToPerson(pessoaDTO);
		
		Map<String, Object> mapPessoa = PessoaConverter.converterToMap(pessoa);
		
		this.pessoaDAO.savePessoa(mapPessoa);
		
	}
	
	public void updatePessoa(PessoaDTO pessoaDTO) {
				
		Map<String, Object> mapPessoaEncontrada = PessoaConverter.converterToMap(Pessoa.builder().nome(pessoaDTO.getNome()).build());
		
		Pessoa pessoaOld = this.pessoaDAO.findPessoa(mapPessoaEncontrada);
		
		Pessoa pessoaNew = PessoaConverter.converterDTOToPerson(pessoaDTO);
		
		this.pessoaDAO.update(pessoaOld, pessoaNew);
		
	}
	
	public void deletePessoa(PessoaDTO pessoaDTO) {
		
		Map<String, Object> mapPessoaEncontrada = PessoaConverter.converterToMap(Pessoa.builder().nome(pessoaDTO.getNome()).build());
		
		Pessoa pessoa = this.pessoaDAO.findPessoa(mapPessoaEncontrada);
					
		this.pessoaDAO.delete(pessoa);
		
	}

}
