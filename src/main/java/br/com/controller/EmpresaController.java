package br.com.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

import br.com.enumUtil.EmpresaEnum;
import br.com.model.Empresa;
import br.com.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;

	private static final String PATH = "admin/empresa/";
	private static final String PATH_ADICIONAR = "admin/empresa/adicionar-empresa";
	private static final String PATH_LISTA = "admin/empresa/lista-empresa";
	private static final String PATH_CARREGAR = "admin/empresa/carregar";
	
	
	@RequestMapping(PATH_ADICIONAR)
	public ModelAndView adicionar() {
		 
		ModelAndView mv = new ModelAndView(PATH_ADICIONAR);
		mv.addObject(new Empresa());
		return mv;
	}
	
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
	
	@RequestMapping(PATH_LISTA)
	public String lista(Model model) {
		Iterable<Empresa> lista = empresaService.listaEmpresa();
		model.addAttribute("empresas", lista);
		return PATH_LISTA;
	}
	
	@RequestMapping("/admin/empresa/editar/{id}")
    public ModelAndView edit(@PathVariable("id") Empresa e) {
		
		ModelAndView mv = new ModelAndView(PATH_ADICIONAR);
         mv.addObject("empresa", e);
        return mv;
    }
	
	@RequestMapping(value= "/admin/empresa/deletar/{id}",method=RequestMethod.DELETE)
	public ModelAndView excluir(@PathVariable Long id, Model model) {
		empresaService.excluir(id);
		model.addAttribute("mensagem", "Empresa exlcuída com sucesso");
		Iterable<Empresa> lista = empresaService.listaEmpresa();
		model.addAttribute("empresas", lista);
		ModelAndView mv = new ModelAndView(PATH_LISTA);
		return mv;
	}
	
	@RequestMapping(PATH_CARREGAR)
	public String carregarListaEnum(RedirectAttributes redirectAttributes) {
		List<EmpresaEnum> lista = Arrays.asList(EmpresaEnum.values());
	        for (int i = 0; i < lista.size(); i++) {
	        	Empresa e = new Empresa();
	        	e.setNome(lista.get(i).getNome());
	        	e.setCnpj(lista.get(i).getCnpj());
	        	e.setDataCadastrada(new Date());
	        	empresaService.salvar(e);
	        }
	        redirectAttributes.addFlashAttribute("mensagem", "Lista de empresa criada com sucesso !");
	        return "redirect:lista-empresa";
	}

}
