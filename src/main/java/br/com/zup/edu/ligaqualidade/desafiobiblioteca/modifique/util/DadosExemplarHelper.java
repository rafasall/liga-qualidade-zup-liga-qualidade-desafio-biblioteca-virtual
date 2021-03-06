package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.util;

import java.util.Set;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;

public class DadosExemplarHelper {


    public static DadosExemplar find(int id, Set<DadosExemplar> exemplares) {
        return exemplares.stream()
        		.filter(exemplar -> exemplar.idLivro == id).findFirst()
                .orElseThrow(() -> new RuntimeException(Constants.ERROR_MESSAGE));
    }
    
}
