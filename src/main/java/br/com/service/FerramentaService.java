package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Ferramenta;
import br.com.repository.FerramentaRepository;

@Service
public class FerramentaService {

	@Autowired
	private FerramentaRepository ferramentaRepository;

	
	public void salvar(Ferramenta f) {
		ferramentaRepository.save(f);
	}


	public void excluir(Long codigo) {
		ferramentaRepository.delete(codigo);
		
	}

	
	
}
