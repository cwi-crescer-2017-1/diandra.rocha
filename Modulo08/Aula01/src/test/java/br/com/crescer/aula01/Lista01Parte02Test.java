package br.com.crescer.aula01;

import br.com.crescer.aula01.CalendarUtils.DiaSemana;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

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
        
        String expResult = "1 ano(s), 2 mês (s) e 1 dia(s)";
        String result = instance.tempoDecorrido(date);
        
        assertEquals(expResult, result);
    }
    
        @Test
    public void testTempoDecorrido2() {
        
        GregorianCalendar c = new GregorianCalendar(2014, 01, 01);
        
        Date date = c.getTime();
        Lista01Parte02 instance = new Lista01Parte02();
        
        String expResult = "3 ano(s), 5 mês (s) e 20 dia(s)";
        String result = instance.tempoDecorrido(date);
        
        assertEquals(expResult, result);
    }
    
}
