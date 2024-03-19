package com.service.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.service.mongodb.dto.PessoaDTO;
import com.service.mongodb.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class MongoController {

	@Autowired
	private PessoaService pessoaService;
	
	@ApiOperation(value = "Endpoint hello")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Ok"),
		    @ApiResponse(code = 404, message = "Não encontrada"),
		})
	@GetMapping(path = "/hello")
	public ResponseEntity<String> consultarPessoa() {
				
		try {
		
			return ResponseEntity.status(HttpStatus.OK).body("Hello");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@ApiOperation(value = "Retorna uma pessoa")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Pessoa encontrada"),
		    @ApiResponse(code = 404, message = "Pessoa não encontrada"),
		})
	@GetMapping(path = "/findOne", consumes = "application/json", produces= "application/json")
	public ResponseEntity<PessoaDTO> consultarPessoa(@RequestBody PessoaDTO pessoaDTO) {
				
		try {
		
			PessoaDTO pessoaFoundDTO = pessoaService.findPessoa(pessoaDTO);
			
			return ResponseEntity.status(HttpStatus.OK).body(pessoaFoundDTO);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@ApiOperation(value = "Cadastrar uma pessoa")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Pessoa cadastrada com sucesso"),
		    @ApiResponse(code = 400, message = "Erro ao cadastrar pessoa"),
		})
	@PostMapping(path = "/save", consumes = "application/json", produces= "application/json")
	public ResponseEntity<String> savePessoa(@RequestBody PessoaDTO pessoaDTO) {
				
		try {
		
			pessoaService.savePessoa(pessoaDTO);
			
			return ResponseEntity.status(HttpStatus.CREATED).build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation(value = "Alterar uma pessoa")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Pessoa alterada com sucesso"),
		    @ApiResponse(code = 400, message = "Erro ao alterar uma pessoa"),
		})
	@PutMapping(path = "/update", consumes = "application/json", produces= "application/json")
	public ResponseEntity<String> updatePessoa(@RequestBody PessoaDTO pessoaDTO) {
				
		try {
		
			pessoaService.updatePessoa(pessoaDTO);
			
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation(value = "Deletar uma pessoa")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Pessoa deletada com sucesso"),
		    @ApiResponse(code = 400, message = "Erro ao alterar uma pessoa"),
		})
	@DeleteMapping(path = "/delete", consumes = "application/json", produces= "application/json")
	public ResponseEntity<String> deletePessoa(@RequestBody PessoaDTO pessoaDTO) {
				
		try {
		
			pessoaService.deletePessoa(pessoaDTO);
			
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
