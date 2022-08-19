package com.example.demo.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.ExameRealizadoEntity;
import com.example.demo.entity.FuncionarioEntity;
import com.example.demo.repository.ExameRealizadoRepository;
import com.example.demo.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private ExameRealizadoRepository exameRealizadoRepository;

	@RequestMapping(value = "/consultaFuncionarios", method = RequestMethod.GET)
	public ModelAndView listarFuncionarios() {
		ModelAndView mv = new ModelAndView("consultaFuncionarios");
		mv.addObject("consultaFuncionarios", funcionarioRepository.findAll());
		return mv;
	}

	@RequestMapping(value = "/novoFuncionario", method = RequestMethod.GET)
	public ModelAndView novoFuncionario() {
		ModelAndView mv = new ModelAndView("novoFuncionario");
		mv.addObject("novoFuncionario", null);
		return mv;
	}

	@RequestMapping(value = "/cadastrarFuncionario", method = RequestMethod.POST)
	public String salvarFuncionario(FuncionarioEntity Funcionario) {
		funcionarioRepository.save(Funcionario);
		return "redirect:/consultaFuncionarios";
	}

	@RequestMapping(value = "/atualizarFunc/{id}", method = RequestMethod.GET)
	public ModelAndView getFuncUp(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("atualizarFuncionario");
		FuncionarioEntity funcionario = funcionarioRepository.findById(id).get();
		mv.addObject("funcionario", funcionario);
		return mv;
	}

	@RequestMapping(value = "/upFunc/{id}", method = RequestMethod.POST)
	public String upFunc(FuncionarioEntity funcionario, @PathVariable("id") Integer id) {
		funcionario.setId(id);
		funcionarioRepository.save(funcionario);
		return "redirect:/consultaFuncionarios";
	}

	
	@RequestMapping(value = "/apagarFunc/{id}", method = RequestMethod.GET)
	public String deletar(@PathVariable("id") Integer id) {
		FuncionarioEntity funcionario = funcionarioRepository.findById(id).get();
		if (!exameRealizadoRepository.findByFuncionario(funcionario).isEmpty()) {
			for (ExameRealizadoEntity exameRealizado : exameRealizadoRepository.findByFuncionario(funcionario)) {
				exameRealizadoRepository.deleteById(exameRealizado.getId());
			}
		}
		funcionarioRepository.deleteById(id);
		return "redirect:/consultaFuncionarios";
	}

}
