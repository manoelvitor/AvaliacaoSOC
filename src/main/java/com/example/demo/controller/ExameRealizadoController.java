package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.ExameRealizadoEntity;
import com.example.demo.repository.ExameRealizadoRepository;
import com.example.demo.repository.ExameRepository;
import com.example.demo.repository.FuncionarioRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class ExameRealizadoController {

	@Autowired
	private ExameRealizadoRepository exameRealizadoRepository;

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@RequestMapping(value = "/consultaExameRealizados", method = RequestMethod.GET)
	public ModelAndView listarExameRealizados() {
		ModelAndView mv = new ModelAndView("consultaExameRealizados");
		mv.addObject("consultaExameRealizados", exameRealizadoRepository.findAll());
		return mv;
	}

	@RequestMapping(value = "/novoExameRealizado", method = RequestMethod.GET)
	public ModelAndView novoExameRealizado() {
		ModelAndView mv = new ModelAndView("novoExameRealizado");
		mv.addObject("exames", exameRepository.findAll());
		mv.addObject("funcionarios", funcionarioRepository.findAll());
		return mv;
	}

	@RequestMapping(value = "/cadastrarExameRealizado", method = RequestMethod.POST)
	public String salvarExameRealizado(ExameRealizadoEntity exameRealizado) {
		if (exameRealizadoRepository.verificaExameRealizado(exameRealizado.getDtExame(),
				exameRealizado.getExame().getId(), exameRealizado.getFuncionario().getId()) == null)
			exameRealizadoRepository.save(exameRealizado);
		return "redirect:/consultaExameRealizados";
	}

	@RequestMapping(value = "/atualizarExRealizado/{id}", method = RequestMethod.GET)
	public ModelAndView getFuncUp(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("atualizarExameRealizado");
		ExameRealizadoEntity exameRealizado = exameRealizadoRepository.findById(id).get();
		mv.addObject("exames", exameRepository.findAll());
		mv.addObject("funcionarios", funcionarioRepository.findAll());
		mv.addObject("exameRealizado", exameRealizado);
		return mv;
	}

	@RequestMapping(value = "/upExRealizado/{id}", method = RequestMethod.POST)
	public String upFunc(ExameRealizadoEntity exameRealizado, @PathVariable("id") Integer id) {
		exameRealizado.setId(id);
		exameRealizadoRepository.save(exameRealizado);
		return "redirect:/consultaExameRealizados";
	}

	@RequestMapping(value = "/apagarExRealizado/{id}", method = RequestMethod.GET)
	public String deletar(@PathVariable("id") Integer id) {
		exameRealizadoRepository.deleteById(id);
		return "redirect:/consultaExameRealizados";
	}
	
	@RequestMapping(value = "/gerarRelatorio", method = RequestMethod.GET)
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de contatos:"));
			documento.add(new Paragraph(" "));
			
			documento.close();
		} catch (Exception e) {
			documento.close();
		}
	
	}


	
}
