package br.com.crescer.aula01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diandra Rocha
 */
public class Lista01Parte03Test {
    
     @Test
     public void testCalcular() {
        
        BigDecimal valorParcelar = new BigDecimal(100.00);
        int numeroParcelas = 2;
        double taxaJuros = 10;
        GregorianCalendar c = new GregorianCalendar(2017, 04, 21);      
        Date dataPrimeiroVencimento = c.getTime();
        Lista01Parte03 instance = new Lista01Parte03();
        
        Map<String, BigDecimal> expResult = new TreeMap<String, BigDecimal>();
        expResult.put("21/05/2017", new BigDecimal(60.00).setScale(2, BigDecimal.ROUND_CEILING));
        expResult.put("21/06/2017", new BigDecimal(60.00).setScale(2, BigDecimal.ROUND_CEILING));
        Map<String, BigDecimal> result = instance.calcular(valorParcelar, numeroParcelas, taxaJuros, dataPrimeiroVencimento);
        
        assertEquals(expResult, result);
    }
    
        @Test
        public void testCalcular2() {
        
        BigDecimal valorParcelar = new BigDecimal(1300.00);
        int numeroParcelas = 4;
        double taxaJuros = 15;
        GregorianCalendar c = new GregorianCalendar(2017, 04, 23);      
        Date dataPrimeiroVencimento = c.getTime();
        Lista01Parte03 instance = new Lista01Parte03();
        
        Map<String, BigDecimal> expResult = new TreeMap<String, BigDecimal>();
        expResult.put("23/05/2017", new BigDecimal(520.00).setScale(2, BigDecimal.ROUND_HALF_UP));
        expResult.put("23/06/2017", new BigDecimal(520.00).setScale(2, BigDecimal.ROUND_HALF_UP));
        expResult.put("23/07/2017", new BigDecimal(520.00).setScale(2, BigDecimal.ROUND_HALF_UP));
        expResult.put("23/08/2017", new BigDecimal(520.00).setScale(2, BigDecimal.ROUND_HALF_UP));
        Map<String, BigDecimal> result = instance.calcular(valorParcelar, numeroParcelas, taxaJuros, dataPrimeiroVencimento);
        
        assertEquals(expResult, result);
    }

    
}
