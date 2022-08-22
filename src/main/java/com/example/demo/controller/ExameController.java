package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.ExameEntity;
import com.example.demo.repository.ExameRealizadoRepository;
import com.example.demo.repository.ExameRepository;

@Controller
public class ExameController {
	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private ExameRealizadoRepository exameRealizadoRepository;
	String msg = "";

	


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/consultaExames", method = RequestMethod.GET)
	public ModelAndView listarExames() {
		ModelAndView mv = new ModelAndView("consultaExames");
		mv.addObject("consultaExames", exameRepository.findAll());
		return mv;
	}

	@RequestMapping(value = "/novoExame", method = RequestMethod.GET)
	public ModelAndView novoExame() {
		ModelAndView mv = new ModelAndView("novoExame");
		mv.addObject("novoExame", null);
		return mv;
	}

	@RequestMapping(value = "/cadastrarExame", method = RequestMethod.POST)
	public String salvarAgendamento(ExameEntity exame) {
		exameRepository.save(exame);
		return "redirect:/consultaExames";
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.GET)
	public ModelAndView getFuncUp(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("atualizarExame");
		ExameEntity exame = exameRepository.findById(id).get();
		mv.addObject("exame", exame);
		return mv;
	}

	@RequestMapping(value = "/up/{id}", method = RequestMethod.POST)
	public String upFunc(ExameEntity exame, @PathVariable("id") Integer id) {
		exame.setId(id);
		exameRepository.save(exame);
		return "redirect:/consultaExames";
	}

	@RequestMapping(value = "/apagar/{id}", method = RequestMethod.GET)
	public ModelAndView deletar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("redirect:/consultaExames");
		ExameEntity exame = exameRepository.findById(id).get();
		if (exameRealizadoRepository.findByExame(exame).isEmpty()) {
			exameRepository.deleteById(id);
		}
		mv.addObject("exames", exameRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/buscaPorNomeExame", method = RequestMethod.POST)
	public ModelAndView buscarPorNome(@RequestParam("nome") String nome) {
		ModelAndView mv = new ModelAndView("consultaExames");
		if(nome != "") {
			mv.addObject("consultaExames", exameRepository.consultaPorNome("%"+nome+"%"));
		}
		else {
			mv.addObject("consultaExames", exameRepository.findAll());
		}
		return mv;
		
	}


}
