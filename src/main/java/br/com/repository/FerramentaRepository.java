package br.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.model.Ferramenta;

/**
* Interface FerramentaRepository, extends CrudRepository
* responsável por facilitar o acesso ao banco de dados
* @author Carvalho
* @since  20/11/2017
* @version 1.0
*/
public interface FerramentaRepository extends CrudRepository<Ferramenta, Long>{

	public List<Ferramenta> findByNomeContaining(String nome);
}
