package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosDevolucao;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.util.DadosExemplarHelper;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.util.DadosUsuarioHelper;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosLivro;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

public class BibliotecaService {
	
	
	
	public static Set<EmprestimoConcedido> processar(
			Set<DadosLivro> livros,
			Set<DadosExemplar> exemplares,
			Set<DadosUsuario> usuarios, 
			Set<DadosEmprestimo> emprestimos,
			Set<DadosDevolucao> devolucoes, 
			LocalDate dataExpiracao) {
		
		Map<Integer, Integer> countEmprestimosPadrao = new HashMap<>();
		
		//1
		return emprestimos.stream().map(emprestimo ->
			
			EmprestimoService.processar(
					emprestimo,
					//1
					DadosUsuarioHelper.find(emprestimo.idUsuario, usuarios),
					//1
					DadosExemplarHelper.find(emprestimo.idLivro, exemplares),
					dataExpiracao,
					countEmprestimosPadrao)		
			
		).collect(Collectors.toSet());
		
	}
	
	



}
