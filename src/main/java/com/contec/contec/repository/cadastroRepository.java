package com.contec.contec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contec.contec.models.Cadastro;

@Repository
public interface cadastroRepository extends CrudRepository<Cadastro, String> {
	
	@Query("select campo from Cadastro campo where campo.os = ?1 order by id desc")
	Iterable<Cadastro> findByOS(String os);
	
	

}
