package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.util;

import java.util.Set;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;

public class DadosUsuarioHelper {

    public static DadosUsuario find(int id, Set<DadosUsuario> usuarios) {
        return usuarios.stream()
        		.filter(usuario -> usuario.idUsuario == id).findFirst()
                .orElseThrow(() -> new RuntimeException(Constants.ERROR_MESSAGE));
    }

}
