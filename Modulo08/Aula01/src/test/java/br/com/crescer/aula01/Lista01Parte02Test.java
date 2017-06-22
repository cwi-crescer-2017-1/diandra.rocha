package br.com.crescer.aula01;

import br.com.crescer.aula01.CalendarUtils.DiaSemana;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

import static br.com.crescer.aula01.CalendarUtils.DiaSemana.DOMINGO;
import static br.com.crescer.aula01.CalendarUtils.DiaSemana.QUARTA_FEIRA;
import static br.com.crescer.aula01.CalendarUtils.DiaSemana.QUINTA_FEIRA;
import static br.com.crescer.aula01.CalendarUtils.DiaSemana.SABADO;
import static br.com.crescer.aula01.CalendarUtils.DiaSemana.SEGUNDA_FEIRA;
import static br.com.crescer.aula01.CalendarUtils.DiaSemana.SEXTA_FEIRA;
import static br.com.crescer.aula01.CalendarUtils.DiaSemana.TERCA_FEIRA;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;

/**
 *
 * @author Diandra Rocha
 */
public class Lista01Parte02Test {

    @Test
    public void testDiaSemana() {

        GregorianCalendar c = new GregorianCalendar(2017, 05, 20);

        Date date = c.getTime();

        Lista01Parte02 instance = new Lista01Parte02();

        DiaSemana expResult = DiaSemana.TERCA_FEIRA;
        DiaSemana result = instance.diaSemana(date);

        assertEquals(expResult, result);

    }

    @Test
    public void testTempoDecorrido() {

        GregorianCalendar c = new GregorianCalendar(2016, 04, 20);

        Date date = c.getTime();
        Lista01Parte02 instance = new Lista01Parte02();

        String expResult = "1 ano(s), 1 mês (s) e 2 dia(s)";
        String result = instance.tempoDecorrido(date);

        assertEquals(expResult, result);
    }

    @Test
    public void testTempoDecorrido2() {

        GregorianCalendar c = new GregorianCalendar(2014, 01, 01);

        Date date = c.getTime();
        Lista01Parte02 instance = new Lista01Parte02();

        String expResult = "3 ano(s), 4 mês (s) e 21 dia(s)";
        String result = instance.tempoDecorrido(date);

        assertEquals(expResult, result);
    }

    private final CalendarUtils calendarUtils = new Lista01Parte02();
    private static final Calendar CALENDAR = Calendar.getInstance();

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_Domingo() {
        CALENDAR.set(2017, 5, 18, 0, 0, 0); // 2017-06-18 00:00:00

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(DOMINGO, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_SegundaFeira() {
        CALENDAR.set(2017, 5, 19, 0, 0, 0); // 2017-06-19 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(SEGUNDA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_TercaFeira() {
        CALENDAR.set(2017, 5, 20, 0, 0, 0); // 2017-06-20 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(TERCA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_QuartaFeira() {
        CALENDAR.set(2017, 5, 21, 0, 0, 0); // 2017-06-21 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(QUARTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_QuintaFeira() {
        CALENDAR.set(2017, 5, 22, 0, 0, 0); // 2017-06-22 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(QUINTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_SextaFeira() {
        CALENDAR.set(2017, 5, 23, 0, 0, 0); // 2017-06-23 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(SEXTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_Sabado() {
        CALENDAR.set(2017, 5, 24, 0, 0, 0); // 2017-06-24 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(SABADO, diaSemana);
    }

    /**
     * Test of tempoDecorrido method, of class CalendarUtils.
     */
    @Test
    public void testTempoDecorrido3() {
        final Period between = Period.between(LocalDate.of(1985, Month.JANUARY, 29), LocalDate.now());

        CALENDAR.set(1985, 0, 29, 0, 0, 0); // 1985-01-29 00:00:00    

        final String tempo = calendarUtils.tempoDecorrido(CALENDAR.getTime());
        final String format = String.format("%s ano(s), %s mês (s) e %s dia(s)",
                between.getYears(),
                between.getMonths(),
                between.getDays());

        assertEquals(format, tempo);
    }

}
