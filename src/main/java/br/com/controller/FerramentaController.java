package br.com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enumUtil.StatusEnum;
import br.com.model.Ferramenta;
import br.com.service.FerramentaService;

/**
 * Classe responsável por ser o Controller
 * das requisições relacionadas ao menu Ferramentas 
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
@Controller
public class FerramentaController {

	/** Bean gerenciado do Spring
	 * é necessário injetar com a anotação
	 * @Autowired
	 *  **/
	@Autowired
	private FerramentaService ferramentaService;
	
	/**
	 * Método que retorna o index do administrador
	 * @author Carvalho
	 * @return
	 */
	@RequestMapping("/admin")
	public String index() {
		return "admin/index";
	}
	
	/**
	 * Método responsável por retornar a view com um novo objeto
	 * ferramenta
	 * @author Carvalho
	 * @return
	 */
	@RequestMapping("/admin/ferramenta/adicionar-ferramenta")
	public ModelAndView adicionar() {
		ModelAndView mv = new ModelAndView("admin/ferramenta/adicionar-ferramenta");
		mv.addObject(new Ferramenta());
		return mv;
	}
	
	/**
	 * Método responsável por retornar uma lista de ferramentas
	 * caso não seja passado nenhum valor pela requisição
	 * a variável nome recebe % por default
	 * @author Carvalho
	 * @param nome
	 * @return
	 */
	@RequestMapping("/admin/ferramenta/lista-ferramenta")
	public ModelAndView lista(@RequestParam(defaultValue = "%")String nome) {
		Iterable<Ferramenta> lista = ferramentaService.getListaPesquisa(nome);
		ModelAndView mv = new ModelAndView("admin/ferramenta/lista-ferramenta");
		mv.addObject("ferramentas", lista);
		return mv;
	}
	
	/**
	 * Método responsável por verificar a existência de erros 
	 * enviados via POST caso contrário executa a chamada 
	 * para adicionar a base de dados uma nova ferramenta
	 * @author Carvalho
	 * @param f
	 * @param erros
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/admin/ferramenta/salvar", method=RequestMethod.POST)
	public String salvar(@Validated Ferramenta f, Errors erros, RedirectAttributes redirectAttributes){
		if(erros.hasErrors()){
			return "admin/ferramenta/adicionar-ferramenta";
		}
		f.setDataCadastrada(new Date());
		f.setStatus(StatusEnum.DISPONIVEL);
		ferramentaService.salvar(f);
		redirectAttributes.addFlashAttribute("mensagem", "Ferramenta cadastrada com sucesso!");
		return "redirect:adicionar-ferramenta";
	}
	
	/**
	 * Método responsável por receber via get um id
	 * e redirecionar para view de edição de ferramenta
	 * @author Carvalho
	 * @param f
	 * @return
	 */
	@RequestMapping("/admin/ferramenta/editar/{id}")
    public ModelAndView edit(@PathVariable("id") Ferramenta f) {
		
		ModelAndView mv = new ModelAndView("/admin/ferramenta/adicionar-ferramenta");
         mv.addObject("ferramenta", f);
        return mv;
    }
	
	/**
	 * Método responsável por receber um id via get 
	 * e chamar o método responsável pela exclusão da ferramenta
	 * @author Carvalho
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value= "/admin/ferramenta/deletar/{id}",method=RequestMethod.DELETE)
	public String excluir(@PathVariable String id, RedirectAttributes redirectAttributes) {
		Long codigo = Long.parseLong(id);
		ferramentaService.excluir(codigo);
		redirectAttributes.addFlashAttribute("mensagem", "Ferramenta exlcuída com sucesso" );
		return"redirect:/admin/ferramenta/lista-ferramenta";
	}
	
}
