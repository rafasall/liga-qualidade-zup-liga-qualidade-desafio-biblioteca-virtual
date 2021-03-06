package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.util;

import java.time.LocalDate;
import java.util.Map;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoExemplar;

public class ValidadorUsuario {

    public static boolean isEmprestimoUsuarioPadrao(LocalDate dataExpiracao, DadosUsuario usuario, DadosExemplar exemplar, LocalDate dataDevolucao, Map<Integer, Integer> countEmprestimosPadrao) {
        Integer countEmprestimosFeito = countEmprestimosPadrao.get(usuario.idUsuario);
        boolean estourouMaximoDeLivros = countEmprestimosFeito != null && countEmprestimosFeito >= 5;
        return dataDevolucao.isBefore(dataExpiracao)
                && DataUtils.isLimiteDiasEmprestimo(dataDevolucao)
                && exemplar.tipo == TipoExemplar.LIVRE
                && !estourouMaximoDeLivros;
    }

    public static boolean isEmprestimoPesquisador(LocalDate dataExpiracao, LocalDate dataDevolucao) {
        return dataDevolucao == null
                || dataDevolucao.isBefore(dataExpiracao)
                && DataUtils.isLimiteDiasEmprestimo(dataDevolucao);
    }
}
