package br.com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Empresa;
import br.com.repository.EmpresaRepository;

/**
 * Classe EmpresaService, responsável por
 * ser o intermédiario entre o EmpresaController e EmpresaRepository
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public void salvar(Empresa e) {
		empresaRepository.save(e);
	}
	
	public void excluir(Long codigo) {
		empresaRepository.delete(codigo);
	}
	
	public Iterable<Empresa> listaEmpresa(){
		
		return empresaRepository.findAll();
	}
	
	public Empresa getEmpresa(Long id) {
		
		return empresaRepository.findOne(id);
	}
	
	public Empresa getByNome(String nome) {
		return empresaRepository.findByNome(nome);
	}
	
	public Empresa getByCnpj(String cnpj) {
		return empresaRepository.findByCnpj(cnpj);
	}
}
