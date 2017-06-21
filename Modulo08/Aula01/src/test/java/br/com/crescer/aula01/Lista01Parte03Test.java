package br.com.crescer.aula01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
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
        
        Map<String, BigDecimal> expResult = new HashMap<String, BigDecimal>();
        expResult.put("21/05/2017", new BigDecimal(60.00).setScale(1, BigDecimal.ROUND_CEILING));
        expResult.put("21/06/2017", new BigDecimal(60.00).setScale(1, BigDecimal.ROUND_CEILING));
        Map<String, BigDecimal> result = instance.calcular(valorParcelar, numeroParcelas, taxaJuros, dataPrimeiroVencimento);
        
        assertEquals(expResult, result);
    }
    

    
}
