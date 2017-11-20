package br.com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.model.Empresa;
import br.com.service.EmpresaService;

/**
 * Classe responsável por ser o Controller
 * das requisições relacionadas ao menu empresa 
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;

	private static final String PATH = "admin/empresa/";
	private static final String PATH_ADICIONAR = "admin/empresa/adicionar-empresa";
	private static final String PATH_LISTA = "admin/empresa/lista-empresa";
	
	
	/**
	 * Método que retorna um ModelAndView com um novo
	 * objeto empresa
	 * @author Carvalho
	 * @return 
	 */
	@RequestMapping(PATH_ADICIONAR)
	public ModelAndView adicionar() {
		 
		ModelAndView mv = new ModelAndView(PATH_ADICIONAR);
		mv.addObject(new Empresa());
		return mv;
	}
	
	/**
	 * Método responsável por verificar se os campos
	 * estão de acordo com as regras de preenchimento e por fazer
	 * chamada ao método que adiciona o objeto na base de dados
	 * @author Carvalho
	 * @param e
	 * @param erros
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = PATH+"salvar", method=RequestMethod.POST)
	public String salvar(@Validated Empresa e, Errors erros, RedirectAttributes redirectAttributes){
		if(erros.hasErrors()){
			return PATH_ADICIONAR;
		}
		e.setDataCadastrada(new Date());
		empresaService.salvar(e);
		redirectAttributes.addFlashAttribute("mensagem", "Empresa cadastrada com sucesso!");
		return "redirect:adicionar-empresa";
	}
	
	/**
	 * Método responsável por retornar a view uma
	 * lista de empresas 
	 * @author Carvalho
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH_LISTA)
	public String lista(Model model) {
		Iterable<Empresa> lista = empresaService.listaEmpresa();
		model.addAttribute("empresas", lista);
		return PATH_LISTA;
	}
	
	/**
	 * Método responável por retornar a view
	 * uma empresa específica, selecionada pelo usuário
	 * para edição
	 * @author Carvalho
	 * @param e
	 * @return
	 */
	@RequestMapping("/admin/empresa/editar/{id}")
    public ModelAndView edit(@PathVariable("id") Empresa e) {
		
		ModelAndView mv = new ModelAndView(PATH_ADICIONAR);
         mv.addObject("empresa", e);
        return mv;
    }
	
	/**
	 * Método responsável por fazer a chamada ao método excluir
	 * passando o id da empresa e retornar a view uma lista de empresas
	 * atualizada
	 * @author Carvalho
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value= "/admin/empresa/deletar/{id}",method=RequestMethod.DELETE)
	public ModelAndView excluir(@PathVariable Long id, Model model) {
		empresaService.excluir(id);
		model.addAttribute("mensagem", "Empresa exlcuída com sucesso");
		Iterable<Empresa> lista = empresaService.listaEmpresa();
		model.addAttribute("empresas", lista);
		ModelAndView mv = new ModelAndView(PATH_LISTA);
		return mv;
	}

}
