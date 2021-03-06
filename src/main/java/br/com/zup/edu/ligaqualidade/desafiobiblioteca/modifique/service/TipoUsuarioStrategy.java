package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.service;

import java.time.LocalDate;
import java.util.Map;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.util.ValidadorUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;

/*
 * 3
 */
public enum TipoUsuarioStrategy {
	
	PADRAO {
		@Override
		public boolean isDevolvidoAntesPrazo(
				LocalDate dataExpiracao, 
				//1
				DadosUsuario usuario,
				//1
				DadosExemplar exemplar,
				LocalDate dataDevolucao, 
				Map<Integer, Integer> countEmprestimosPadrao) {
			//1
			return ValidadorUsuario.isEmprestimoUsuarioPadrao(dataExpiracao, usuario, exemplar, dataDevolucao, countEmprestimosPadrao);
		}
	},
	PESQUISADOR {
		@Override
		public boolean isDevolvidoAntesPrazo(
				LocalDate dataExpiracao, 
				DadosUsuario usuario, 
				DadosExemplar exemplar,
				LocalDate dataDevolucao, 
				Map<Integer, Integer> countEmprestimosPadrao) {
			return ValidadorUsuario.isEmprestimoPesquisador(dataExpiracao, dataDevolucao);
		}
	};
	
	
	public abstract boolean isDevolvidoAntesPrazo(LocalDate dataExpiracao, DadosUsuario usuario, DadosExemplar exemplar, LocalDate dataDevolucao, Map<Integer, Integer> countEmprestimosPadrao);

}
