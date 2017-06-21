package br.com.crescer.aula01;

import java.util.Date;

/**
 * @author carloshenrique
 */
public interface CalendarUtils {

    public enum DiaSemana {
        DOMINGO,
        SEGUNDA_FEIRA,
        TERCA_FEIRA,
        QUARTA_FEIRA,
        QUINTA_FEIRA,
        SEXTA_FEIRA,
        SABADO;
    }

    DiaSemana diaSemana(Date date);

    String tempoDecorrido(Date date);

}