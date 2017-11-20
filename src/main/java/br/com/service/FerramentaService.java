package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Ferramenta;
import br.com.repository.FerramentaRepository;

/**
 * Classe FerramentaService, responsável por
 * ser o intermédiario entre o FerramentaController e FerramentaRepository
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
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
	
	public List<Ferramenta> getListaPesquisa(String nome){
		
		return ferramentaRepository.findByNomeContaining(nome);
	}

	
	
}
