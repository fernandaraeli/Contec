package com.contec.contec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.contec.contec.models.Cadastro;
import com.contec.contec.repository.cadastroRepository;

@Controller
public class CadastroController {
	
	@Autowired
	private cadastroRepository cr;
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.GET)
	public String form() {
		return "cadastro/cadastrarOS";
	}
	
	@RequestMapping(value="/cadastrar", method = RequestMethod.POST)
	public String form(Cadastro cadastro) {
		cr.save(cadastro);
		return "redirect:/cadastrar";
	}
	
	@RequestMapping("/listar")
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("cadastro/pesquisarOS");
		Iterable<Cadastro> cadastros = cr.findAll();
		mv.addObject("cadastros", cadastros);
		return mv;
	}
	
	@RequestMapping(value="/pesquisar", method = RequestMethod.GET)
	public String busca() {
		return "cadastro/pesquisarOS";
	}
	
	@RequestMapping(value="/pesquisar", method = RequestMethod.POST)
	public ModelAndView pesquisar(@RequestParam (value="pesquisaordem") String pesquisaordem) {
		ModelAndView mv = new ModelAndView("cadastro/pesquisarOS");
		Iterable<Cadastro> cadastros = cr.findByOS(pesquisaordem);
		mv.addObject("cadastros", cadastros);
		return mv;		
	}
	

}
