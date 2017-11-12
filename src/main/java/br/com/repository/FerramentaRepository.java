package br.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.model.Ferramenta;

public interface FerramentaRepository extends CrudRepository<Ferramenta, Long>{

	public List<Ferramenta> findByNomeContaining(String nome);
}
