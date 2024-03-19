package com.service.mongodb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.service.mongodb.entity.Pessoa;
import com.service.mongodb.util.PessoaConverter;

@Repository
public class PessoaDAO extends EntityDao<Pessoa>{

	public PessoaDAO() {
		super(Pessoa.class);
	}

	public void savePessoa(Map<String, Object> mapPessoa) {
		save(mapPessoa);
    }
	
	
	public void update(Pessoa oldPessoa, Pessoa novaPessoa) {
		
        Map<String, Object> query = PessoaConverter.converterToMap(oldPessoa);

        Map<String, Object> map = PessoaConverter.converterToMap(novaPessoa);

        update(query, map);
    }
	
	public void delete(Pessoa pessoa) {
        Map<String, Object> map = PessoaConverter.converterToMap(pessoa);

        delete(map);
    }
	
	public Pessoa findPessoa(Map<String, Object> mapKeyValue) {
		
        DBObject dbObject = findOne(mapKeyValue);

        Pessoa pessoa = PessoaConverter.converterToPerson(dbObject);

        return pessoa;
    }
	
	public List<Pessoa> findPessoas() {
		
        List<DBObject> dbObject = findAll();

        List<Pessoa> persons = new ArrayList<Pessoa>();

        for (DBObject dbo : dbObject) {
        	Pessoa person = PessoaConverter.converterToPerson(dbo);

            persons.add(person);
        }

        return persons;
    }
	
}
