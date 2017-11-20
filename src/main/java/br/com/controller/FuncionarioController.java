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
import br.com.model.Funcionario;
import br.com.service.EmpresaService;
import br.com.service.FuncionarioService;

/**
 * Classe responsável por ser o Controller
 * das requisições relacionadas ao menu Funcionário 
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private EmpresaService empresaService;
	
	private static final String PATH = "admin/funcionario/";
	private static final String PATH_ADICIONAR = "admin/funcionario/adicionar-funcionario";
	private static final String PATH_LISTA = "admin/funcionario/lista-funcionario";
	
	
	/**
	 * Método responsável por retornar a 
	 * view um novo objeto de funcionário e 
	 * uma lista de empresas
	 * @author Carvalho
	 * @return
	 */
	@RequestMapping(PATH_ADICIONAR)
	public ModelAndView adicionar() {
		ModelAndView mv = new ModelAndView(PATH_ADICIONAR);
		mv.addObject(new Funcionario());
		Iterable<Empresa> lista = empresaService.listaEmpresa();
		mv.addObject(lista);
		return mv;
	}
	
	/**
	 * Método responsável por verificar a existência de erros 
	 * enviado no post, caso contrário chama o método responsável 
	 * pela adição a base de dados de um novo funcionário e sua respectiva 
	 * empresa
	 * @author Carvalho
	 * @param f
	 * @param erros
	 * @param redirectAttributes
	 * @param model
	 * @return
	 */
	@RequestMapping(value = PATH+"salvar", method=RequestMethod.POST)
	public String salvar(@Validated Funcionario f, Errors erros, RedirectAttributes redirectAttributes,Model model){
		if(erros.hasErrors()){
			model.addAttribute("empresaList", empresaService.listaEmpresa());
			return PATH_ADICIONAR;
		}
		f.setDataCadastrada(new Date());
		funcionarioService.salvar(f);
		redirectAttributes.addFlashAttribute("mensagem", "Funcionário cadastrado com sucesso!");
		return "redirect:adicionar-funcionario";
	}
	
	/**
	 * Método responsável por retornar uma lista de 
	 * funcionários
	 * @author Carvalho
	 * @param model
	 * @return
	 */
	@RequestMapping(PATH_LISTA)
	public String lista(Model model) {
		Iterable<Funcionario> lista = funcionarioService.listaFuncionario();
		model.addAttribute("funcionarios", lista);
		return PATH_LISTA;
	}
	
	/**
	 * Método responsável por receber via get 
	 * um id e enviar para view um objeto para edição
	 * @author Carvalho
	 * @param f
	 * @return
	 */
	@RequestMapping("/admin/funcionario/editar/{id}")
    public ModelAndView edit(@PathVariable("id") Funcionario f) {
		
		ModelAndView mv = new ModelAndView(PATH_ADICIONAR);
		mv.addObject("empresa", empresaService.getEmpresa(f.getEmpresa().getId()));
        mv.addObject("funcionario", f);
        return mv;
    }
	
	/**
	 * Método responsável por receber via DELETE
	 * um id e fazer a chamada ao método responsável por tratar a exclusão
	 * da base de dados
	 * @author Carvalho
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value= "/admin/funcionario/deletar/{id}",method=RequestMethod.DELETE)
	public ModelAndView excluir(@PathVariable Long id, Model model) {
		funcionarioService.excluir(id);
		model.addAttribute("mensagem", "Funcionário exlcuído com sucesso");
		Iterable<Funcionario> lista = funcionarioService.listaFuncionario();
		model.addAttribute("funcionarios", lista);
		ModelAndView mv = new ModelAndView(PATH_LISTA);
		return mv;
	}
	

}
