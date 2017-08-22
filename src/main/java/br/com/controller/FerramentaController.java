package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/")
	public String indexView() {
		return "index";
	}
	
	@RequestMapping("/admin")
	public String index() {
		return "redirect:admin/index";
	}
	
	@RequestMapping("/admin/adicionar-ferramenta")
	public String adicionar() {
		return "admin/adicionar-ferramenta";
	}
	
	@RequestMapping("/admin/lista-ferramenta")
	public String lista(Model model) {
		Iterable<Ferramenta> lista = ferramenta.findAll();
		model.addAttribute("ferramentas", lista);
		
		return "admin/lista-ferramenta";
	}
	
	@RequestMapping(value = "/admin/salvar", method=RequestMethod.POST)
	public ModelAndView salvar( Ferremanta f) {
		//Ferramenta f = new Ferramenta(patrimonio, nome);
		ferramenta.save(f);
		 ModelAndView mv = new ModelAndView("redirect:/admin/lista-ferramenta");
		 mv.addObject("ferramenta", f);
		//Iterable<Ferramenta> lista = ferramenta.findAll();
		//model.addAttribute("ferramentas", lista);
		return mv;
	}
	
	 @RequestMapping("/admin/edit/{id}")
    	public ModelAndView edit(@PathVariable("id") Long id) {
         
        return salvar(ferramenta.findOne(id));
    }
}
