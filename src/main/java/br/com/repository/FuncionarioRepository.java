package br.com.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

}
