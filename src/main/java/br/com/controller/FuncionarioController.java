package br.com.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
import br.com.enumUtil.FuncionarioEnum;
import br.com.model.Empresa;
import br.com.model.Funcionario;
import br.com.service.EmpresaService;
import br.com.service.FuncionarioService;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private EmpresaService empresaService;
	
	private static final String PATH = "admin/funcionario/";
	private static final String PATH_ADICIONAR = "admin/funcionario/adicionar-funcionario";
	private static final String PATH_LISTA = "admin/funcionario/lista-funcionario";
	private static final String PATH_CARREGAR = "admin/funcionario/carregar";
	
	
	
	@RequestMapping(PATH_ADICIONAR)
	public ModelAndView adicionar() {
		ModelAndView mv = new ModelAndView(PATH_ADICIONAR);
		mv.addObject(new Funcionario());
		Iterable<Empresa> lista = empresaService.listaEmpresa();
		mv.addObject(lista);
		return mv;
	}
	
	@RequestMapping(value = PATH+"salvar", method=RequestMethod.POST)
	public String salvar(@Validated Funcionario f, Empresa e, Errors erros, RedirectAttributes redirectAttributes){
		if(erros.hasErrors()){
			return PATH_ADICIONAR;
		}
		f.setDataCadastrada(new Date());
		funcionarioService.salvar(f);
		redirectAttributes.addFlashAttribute("mensagem", "Funcionário cadastrado com sucesso!");
		return "redirect:adicionar-funcionario";
	}
	
	@RequestMapping(PATH_LISTA)
	public String lista(Model model) {
		Iterable<Funcionario> lista = funcionarioService.listaFuncionario();
		model.addAttribute("funcionarios", lista);
		return PATH_LISTA;
	}
	
	@RequestMapping("/admin/funcionario/editar/{id}")
    public ModelAndView edit(@PathVariable("id") Funcionario f) {
		
		ModelAndView mv = new ModelAndView(PATH_ADICIONAR);
         mv.addObject("funcionario", f);
        return mv;
    }
	
	@RequestMapping(value= "/admin/funcionario/deletar/{id}",method=RequestMethod.DELETE)
	public ModelAndView excluir(@PathVariable Long id, Model model) {
		funcionarioService.excluir(id);
		model.addAttribute("mensagem", "Funcionário exlcuído com sucesso");
		Iterable<Funcionario> lista = funcionarioService.listaFuncionario();
		model.addAttribute("funcionarios", lista);
		ModelAndView mv = new ModelAndView(PATH_LISTA);
		return mv;
	}
	
	@RequestMapping(PATH_CARREGAR)
	public String carregarListaEnum(RedirectAttributes redirectAttributes) {
		List<FuncionarioEnum> lista = Arrays.asList(FuncionarioEnum.values());
		
		for (int i = 0; i < lista.size(); i++) {
	        	Funcionario f = new Funcionario();
	        	f.setNome(lista.get(i).getNome());
	        	f.setMatricula(lista.get(i).getMatricula());
	        	f.setEmpresa(getEmpresaRandom());
	        	f.setDataCadastrada(new Date());
	        	funcionarioService.salvar(f);
	        }
	        redirectAttributes.addFlashAttribute("mensagem", "Lista de funcionários criada com sucesso !");
	        return "redirect:lista-funcionario";
	}
	
	
	public Empresa getEmpresaRandom() {
		List<Empresa> empresas = (List<Empresa>) empresaService.listaEmpresa();
        Empresa e = new Empresa();
      	Random gerador = new Random();
      	e = empresas.get(gerador.nextInt(empresas.size()));
		return e;
	}

}
