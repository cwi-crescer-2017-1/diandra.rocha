package br.com.crescer.aula01;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author Diandra Rocha
 */
public class Lista01Parte02 implements CalendarUtils{
    
    @Override
    public DiaSemana diaSemana(Date date){
        
        GregorianCalendar c = new GregorianCalendar();
         c.setTime(date);
         
         int dia = c.get(Calendar.DAY_OF_WEEK);
         
         switch(dia){
             case 1:
                 return DiaSemana.DOMINGO;
             case 2:
                 return DiaSemana.SEGUNDA_FEIRA;
             case 3:
                 return DiaSemana.TERCA_FEIRA;
             case 4:
                 return DiaSemana.QUARTA_FEIRA;
             case 5:
                 return DiaSemana.QUINTA_FEIRA;
             case 6:
                 return DiaSemana.SEXTA_FEIRA;
             case 7:
                 return DiaSemana.SABADO;
         }
         return null;
    }
    
    @Override
    public String tempoDecorrido(Date date){
        
        LocalDate hoje = LocalDate.now();
        
        LocalDate outraData = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        Period periodo = Period.between(hoje, outraData);
        
        int diferencaEmDias = periodo.getDays();
        String diferencaDias = " e " + Math.abs(diferencaEmDias) + " dia(s)";

        int diferencaEmMes = periodo.getMonths();
        String diferencaMeses = ", " + Math.abs(diferencaEmMes) + " mês (s)";

        int diferencaEmAnos = periodo.getYears();
        String diferencaAnos = Math.abs(diferencaEmAnos) + " ano(s)";
        
        StringBuilder saida = new StringBuilder();
        saida.append(diferencaAnos).append(diferencaMeses).append(diferencaDias);
        
        return saida.toString();

    }
}
