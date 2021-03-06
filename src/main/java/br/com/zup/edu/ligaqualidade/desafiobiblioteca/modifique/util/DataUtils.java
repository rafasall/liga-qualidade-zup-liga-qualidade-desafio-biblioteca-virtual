package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.util;

import java.time.LocalDate;
import java.time.Period;
/*
 * 
 */
public class DataUtils {

    private static final int LIMITE_DIAS = 60;
    
    //1
    public static boolean isLimiteDiasEmprestimo(LocalDate dataDevolucao) {
        return Period.between(LocalDate.now(), dataDevolucao).getDays() < LIMITE_DIAS;
    }
}
