package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.model.Ferramenta;
import br.com.repository.FerramentaRepository;

@Controller
public class FerramentaController {

	/** Bean gerenciado do Spring
	 * é necessário injetar com a anotação
	 * @Autowired
	 *  **/
	@Autowired
	private FerramentaRepository ferramenta;
	
	@RequestMapping("/admin")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping("/admin/adicionar-ferramenta")
	public ModelAndView adicionar() {
		ModelAndView mv = new ModelAndView("admin/adicionar-ferramenta");
		mv.addObject(new Ferramenta());
		return mv;
	}
	
	@RequestMapping("/admin/lista-ferramenta")
	public String lista(Model model) {
		Iterable<Ferramenta> lista = ferramenta.findAll();
		model.addAttribute("ferramentas", lista);
		
		return "admin/lista-ferramenta";
	}
	
	@RequestMapping(value = "/admin/salvar", method=RequestMethod.POST)
	public String salvar(@Validated Ferramenta f, Errors erros, RedirectAttributes redirectAttributes){
		if(erros.hasErrors()){
			return "admin/adicionar-ferramenta";
		}
		ferramenta.save(f);
		redirectAttributes.addFlashAttribute("mensagem", "Título salvo com sucesso!");
		return "redirect:adicionar-ferramenta";
	}
	
	@RequestMapping("/admin/editar/{id}")
    public ModelAndView edit(@PathVariable("id") Ferramenta f) {
		
		ModelAndView mv = new ModelAndView("/admin/adicionar-ferramenta");
         mv.addObject("ferramenta", f);
        return mv;
    }
	
}
