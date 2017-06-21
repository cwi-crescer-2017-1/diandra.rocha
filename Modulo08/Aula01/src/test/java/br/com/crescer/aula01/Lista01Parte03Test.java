package br.com.crescer.aula01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.MONTH;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
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

    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private final Parcelator parcelator;

    public Lista01Parte03Test() {
        this.parcelator = new Lista01Parte03();
    }

    /**
     * Test of calcular method, of class Parcelator.
     */
    @Test
    public void testCalcular3() {
        CALENDAR.set(2017, 5, 18);

        final BigDecimal valor = BigDecimal.valueOf(1000);
        final BigDecimal total = valor.multiply(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE)).setScale(2, RoundingMode.HALF_UP);

        final Map<String, BigDecimal> parcelas = parcelator.calcular(valor, 3, 10.0, CALENDAR.getTime());

        assertTrue(true);

        parcelas.entrySet().forEach(e -> {
            assertTrue(true);
            CALENDAR.add(MONTH, 1);
        });
        
    }

}
