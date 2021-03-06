package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

public class EmprestimoService {

	public static EmprestimoConcedido processar(
			DadosEmprestimo emprestimo,
			Set<EmprestimoConcedido> emprestimosConcedidos, 
			DadosUsuario usuario, 
			DadosExemplar exemplar,
			Map<Integer, Integer> countEmprestimosPadrao, 
			LocalDate dataExpiracao) {
		
		LocalDate dataDevolucaoEstimada = LocalDate.now().plusDays(emprestimo.tempo);
		
		/*
		 * Na forma convencional sem precisar rescrever o enum fica dessa forma o if e não iria contar mais 1
		 * 
		 * if (usuario.padrao.isDevolvidoAntesPrazo(dataExpiracao, usuario, exemplar, dataDevolucaoEstimada, countEmprestimosPadrao))
		 * 
		 */
		//1
		if (usuario.padrao == TipoUsuario.PADRAO &&
				TipoUsuarioStrategy.valueOf(usuario.padrao.name())
				.isDevolvidoAntesPrazo(
						dataExpiracao, usuario, exemplar, 
						dataDevolucaoEstimada, countEmprestimosPadrao)) {
			emprestimosConcedidos.add(new EmprestimoConcedido(usuario.idUsuario, exemplar.idExemplar, dataDevolucaoEstimada));
			countEmprestimosPadrao.putIfAbsent(usuario.idUsuario, 0);
			countEmprestimosPadrao.put(usuario.idUsuario, countEmprestimosPadrao.get(usuario.idUsuario) + 1);
		}
		
		return null;
	}
	
	

}
