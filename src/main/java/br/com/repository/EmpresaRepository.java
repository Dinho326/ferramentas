package br.com.repository;


import org.springframework.data.repository.CrudRepository;
import br.com.model.Empresa;

/**
 * Interface EmpresaRepository, extends CrudRepository
 * responsável por facilitar o acesso ao banco de dados
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
public interface EmpresaRepository extends CrudRepository<Empresa, Long>{
	
	public Empresa findByNome(String nome);
	public Empresa findByCnpj(String cnpj);

}		
