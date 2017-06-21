package br.com.crescer.aula01;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Diandra Rocha
 */
public class Lista01Parte03 implements Parcelator{
    
    @Override
    public Map<String, BigDecimal> calcular (BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento){
          
        Map<String, BigDecimal> mapa = new TreeMap<String, BigDecimal>();     
        BigDecimal valor = valorParcelar.divide(BigDecimal.valueOf(numeroParcelas)).setScale(2, BigDecimal.ROUND_HALF_UP);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        Calendar c = Calendar.getInstance();
        c.setTime(dataPrimeiroVencimento);
        
        BigDecimal taxa = BigDecimal.valueOf(taxaJuros).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal valorTaxa = valorParcelar.divide(BigDecimal.valueOf(100)).multiply(taxa).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal valorFinal = valor.add(valorTaxa).setScale(2, BigDecimal.ROUND_HALF_UP);
        valorFinal.setScale(2, BigDecimal.ROUND_HALF_UP);
        
         
        
        for(int i=0; i<numeroParcelas; i++){
            
            String data = formato.format(c.getTime());
            mapa.put(data, valorFinal);
            c.add(Calendar.MONTH, 1);
            
        }
        
        return mapa;
    }   
    
}
