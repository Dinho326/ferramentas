package br.com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Empresa;
import br.com.repository.EmpresaRepository;

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
}
