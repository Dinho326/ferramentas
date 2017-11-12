package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Funcionario;
import br.com.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public void salvar(Funcionario e) {
		funcionarioRepository.save(e);
	}
	
	public void excluir(Long codigo) {
		funcionarioRepository.delete(codigo);
	}
	
	public Iterable<Funcionario> listaFuncionario(){	
		
		return funcionarioRepository.findAll();
	}
}
