package com.example.demo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.ExameEntity;
import com.example.demo.entity.ExameRealizadoEntity;
import com.example.demo.entity.FuncionarioEntity;
import com.example.demo.repository.ExameRealizadoRepository;
import com.example.demo.repository.ExameRepository;
import com.example.demo.repository.FuncionarioRepository;

@SpringBootApplication
public class AvaliacaoDevSpringApplication implements CommandLineRunner {

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ExameRealizadoRepository exameRealizadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoDevSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ExameEntity exame1 = new ExameEntity("HEMOGRAMA");
		ExameEntity exame2 = new ExameEntity("URINA");
		ExameEntity exame3 = new ExameEntity("HCG");
		ExameEntity exame4 = new ExameEntity("ESCARRO");
		ExameEntity exame5 = new ExameEntity("PARASITOLÓGICO ");
		ExameEntity exame6 = new ExameEntity("GLICEMIA EM JEJUM");
		ExameEntity exame7 = new ExameEntity("COLESTEROL E TRIGLICERÍDEOS");
		ExameEntity exame8 = new ExameEntity("UREIA E CREATINA");
		ExameEntity exame9 = new ExameEntity("TGO (AST) E TGP (ALT)");
		ExameEntity exame10 = new ExameEntity("ÁCIDO ÚRICO");
		ExameEntity exame11 = new ExameEntity("ELETROCARDIOGRAMA");
		ExameEntity exame12 = new ExameEntity("TESTE ERGOMÉTRICO");
		ExameEntity exame13 = new ExameEntity("ECOCARDIOGRAMA");
		ExameEntity exame14 = new ExameEntity("PAPANICOLAU");
		ExameEntity exame15 = new ExameEntity("MAMOGRAFIA");
		ExameEntity exame16 = new ExameEntity("ULTRASSONOGRAFIA TRANSVAGINAL");
		ExameEntity exame17 = new ExameEntity("TOQUE RETAL");
		ExameEntity exame18 = new ExameEntity("TESTE ERGOMÉTRICO");
		ExameEntity exame19 = new ExameEntity("DOSAGEM DE PSA");
		ExameEntity exame20 = new ExameEntity("ANAMNESE CLÍNICA E ESPORTIVA");
		ExameEntity exame21 = new ExameEntity("AVALIAÇÃO FÍSICA COMPLETA");
		ExameEntity exame22 = new ExameEntity("CONSULTA NUTRICIONAL");
		ExameEntity exame23 = new ExameEntity("TESTE CARDIOPULMONAR");

		exameRepository.saveAll(Arrays.asList(exame1, exame2, exame3, exame4, exame5, exame6, exame7, exame8, exame9,
				exame10, exame11, exame12, exame13, exame14, exame15, exame16, exame17, exame18, exame19, exame20,
				exame21, exame22, exame23

		));

		FuncionarioEntity func1 = new FuncionarioEntity("MARIA DA SILVA");
		FuncionarioEntity func2 = new FuncionarioEntity("JOSÉ DE SOUZA");
		FuncionarioEntity func3 = new FuncionarioEntity("CARLOS DOS SANTOS");
		FuncionarioEntity func4 = new FuncionarioEntity("BEATRIZ DE OLIVEIRA");
		FuncionarioEntity func5 = new FuncionarioEntity("ANA LUIZA DE BARROS");
		FuncionarioEntity func6 = new FuncionarioEntity("CLAUDIA CRISTINA TEXEIRA");
		FuncionarioEntity func7 = new FuncionarioEntity("ELEONOR FARIAS");
		FuncionarioEntity func8 = new FuncionarioEntity("LUIZ JOSE DA SILVA");
		FuncionarioEntity func9 = new FuncionarioEntity("JOSE ALENCAR");
		FuncionarioEntity func10 = new FuncionarioEntity("CARLOS EDUARDO DA SILVA");
		FuncionarioEntity func11 = new FuncionarioEntity("RYOKU TSUBAKA");
		FuncionarioEntity func12 = new FuncionarioEntity("YURI KROSVITCH");
		FuncionarioEntity func13 = new FuncionarioEntity("RENATA ALENCAR");
		FuncionarioEntity func14 = new FuncionarioEntity("DEBORA AURORA DE SOUSA");
		FuncionarioEntity func15 = new FuncionarioEntity("LEONARDO TELES");
		FuncionarioEntity func16 = new FuncionarioEntity("BRUNA PEIXOTO DE OLIVEIRA");
		FuncionarioEntity func17 = new FuncionarioEntity("KAMILA ALVES DA SILVA");
		FuncionarioEntity func18 = new FuncionarioEntity("REINALDO DE LIMA");
		FuncionarioEntity func19 = new FuncionarioEntity("HOMERIO SANTIAGO");
		FuncionarioEntity func20 = new FuncionarioEntity("VICTORIA LEAL");
		FuncionarioEntity func21 = new FuncionarioEntity("DANIEL CHAGAS DA SILVA");
		FuncionarioEntity func22 = new FuncionarioEntity("SELENA GOMES DA SILVA");
		FuncionarioEntity func23 = new FuncionarioEntity("UBIRAJARA GONZAGA");

		funcionarioRepository
				.saveAll(Arrays.asList(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11,
						func12, func13, func14, func15, func16, func17, func18, func19, func20, func21, func22, func23

				));

		ExameRealizadoEntity ex1 = new ExameRealizadoEntity(func1, exame1, "2022-10-10");
		ExameRealizadoEntity ex2 = new ExameRealizadoEntity(func2, exame2, "2022-11-25");
		ExameRealizadoEntity ex3 = new ExameRealizadoEntity(func3, exame3, "2022-12-08");
		ExameRealizadoEntity ex4 = new ExameRealizadoEntity(func4, exame4, "2022-10-09");
		ExameRealizadoEntity ex5 = new ExameRealizadoEntity(func5, exame5, "2022-01-10");
		ExameRealizadoEntity ex6 = new ExameRealizadoEntity(func6, exame6, "2022-12-10");
		ExameRealizadoEntity ex7 = new ExameRealizadoEntity(func7, exame7, "2022-11-10");
		ExameRealizadoEntity ex8 = new ExameRealizadoEntity(func8, exame8, "2022-10-10");
		ExameRealizadoEntity ex9 = new ExameRealizadoEntity(func9, exame9, "2022-09-10");
		ExameRealizadoEntity ex10 = new ExameRealizadoEntity(func10, exame10, "2022-08-10");
		ExameRealizadoEntity ex11 = new ExameRealizadoEntity(func11, exame11, "2022-07-10");
		ExameRealizadoEntity ex12 = new ExameRealizadoEntity(func12, exame12, "2022-06-10");
		ExameRealizadoEntity ex13 = new ExameRealizadoEntity(func13, exame13, "2022-05-10");
		ExameRealizadoEntity ex14 = new ExameRealizadoEntity(func14, exame14, "2022-04-10");
		ExameRealizadoEntity ex15 = new ExameRealizadoEntity(func15, exame15, "2022-03-10");
		ExameRealizadoEntity ex16 = new ExameRealizadoEntity(func16, exame16, "2022-02-10");
		ExameRealizadoEntity ex17 = new ExameRealizadoEntity(func17, exame17, "2022-01-10");
		ExameRealizadoEntity ex18 = new ExameRealizadoEntity(func18, exame18, "2021-01-10");
		ExameRealizadoEntity ex19 = new ExameRealizadoEntity(func19, exame19, "2022-02-10");
		ExameRealizadoEntity ex20 = new ExameRealizadoEntity(func20, exame20, "2022-03-10");
		ExameRealizadoEntity ex21 = new ExameRealizadoEntity(func21, exame21, "2022-04-10");
		ExameRealizadoEntity ex22 = new ExameRealizadoEntity(func22, exame22, "2022-05-10");
		ExameRealizadoEntity ex23 = new ExameRealizadoEntity(func23, exame23, "2022-06-10");
		ExameRealizadoEntity ex24 = new ExameRealizadoEntity(func1, exame11, "2022-07-10");
		ExameRealizadoEntity ex25 = new ExameRealizadoEntity(func2, exame12, "2022-08-10");
		ExameRealizadoEntity ex26 = new ExameRealizadoEntity(func3, exame13, "2022-09-10");
		ExameRealizadoEntity ex27 = new ExameRealizadoEntity(func4, exame14, "2022-10-10");
		ExameRealizadoEntity ex28 = new ExameRealizadoEntity(func5, exame15, "2022-11-10");
		ExameRealizadoEntity ex29 = new ExameRealizadoEntity(func6, exame16, "2022-12-10");
		ExameRealizadoEntity ex30 = new ExameRealizadoEntity(func7, exame17, "2022-12-28");
		ExameRealizadoEntity ex31 = new ExameRealizadoEntity(func8, exame18, "2020-01-27");
		ExameRealizadoEntity ex32 = new ExameRealizadoEntity(func9, exame19, "2022-02-26");
		ExameRealizadoEntity ex33 = new ExameRealizadoEntity(func10, exame1, "2022-03-25");
		ExameRealizadoEntity ex34 = new ExameRealizadoEntity(func11, exame1, "2022-04-24");
		ExameRealizadoEntity ex35 = new ExameRealizadoEntity(func12, exame1, "2022-05-23");
		ExameRealizadoEntity ex36 = new ExameRealizadoEntity(func13, exame1, "2022-06-22");
		ExameRealizadoEntity ex37 = new ExameRealizadoEntity(func14, exame1, "2022-01-10");
		ExameRealizadoEntity ex38 = new ExameRealizadoEntity(func15, exame1, "2015-02-29");
		ExameRealizadoEntity ex39 = new ExameRealizadoEntity(func16, exame1, "2016-03-28");
		ExameRealizadoEntity ex40 = new ExameRealizadoEntity(func17, exame2, "2017-04-27");
		ExameRealizadoEntity ex41 = new ExameRealizadoEntity(func18, exame2, "2018-05-26");
		ExameRealizadoEntity ex42 = new ExameRealizadoEntity(func19, exame2, "2019-06-25");
		ExameRealizadoEntity ex43 = new ExameRealizadoEntity(func20, exame2, "2020-07-24");
		ExameRealizadoEntity ex44 = new ExameRealizadoEntity(func21, exame2, "2022-08-23");
		ExameRealizadoEntity ex45 = new ExameRealizadoEntity(func22, exame3, "2022-09-02");
		ExameRealizadoEntity ex46 = new ExameRealizadoEntity(func23, exame3, "2010-01-01");
		ExameRealizadoEntity ex47 = new ExameRealizadoEntity(func1, exame3, "2011-01-11");
		ExameRealizadoEntity ex48 = new ExameRealizadoEntity(func2, exame3, "2012-10-28");
		ExameRealizadoEntity ex49 = new ExameRealizadoEntity(func3, exame4, "2013-09-28");
		ExameRealizadoEntity ex50 = new ExameRealizadoEntity(func4, exame4, "2014-08-29");
		ExameRealizadoEntity ex51 = new ExameRealizadoEntity(func5, exame4, "2015-07-28");
		ExameRealizadoEntity ex52 = new ExameRealizadoEntity(func6, exame4, "2016-06-27");
		ExameRealizadoEntity ex53 = new ExameRealizadoEntity(func7, exame6, "2017-05-26");
		ExameRealizadoEntity ex54 = new ExameRealizadoEntity(func8, exame6, "2018-04-25");
		ExameRealizadoEntity ex55 = new ExameRealizadoEntity(func9, exame6, "2019-03-24");
		ExameRealizadoEntity ex56 = new ExameRealizadoEntity(func10, exame5, "2020-02-23");
		ExameRealizadoEntity ex57 = new ExameRealizadoEntity(func11, exame5, "2021-01-22");


		exameRealizadoRepository.saveAll(Arrays.asList(ex1, ex2, ex3, ex4, ex5, ex6, ex7, ex8, ex9, ex10, ex11, ex12,
				ex13, ex14, ex15, ex16, ex17, ex18, ex19, ex20, ex21, ex22, ex23, ex24, ex25, ex26, ex27, ex28, ex29,
				ex30, ex31, ex32, ex33, ex34, ex35, ex36, 
				ex37,
				ex38,
				ex39,
				ex40,
				ex41,
				ex42,
				ex43,
				ex44,
				ex45,
				ex46,
				ex47,
				ex48,
				ex49,
				ex50,
				ex51,
				ex52,
				ex53,
				ex54,
				ex55,
				ex56,
				ex57

				
		));

	}

}
