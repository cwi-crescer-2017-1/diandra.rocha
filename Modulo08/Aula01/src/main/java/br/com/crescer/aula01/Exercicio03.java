package br.com.crescer.aula01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author diandra.rocha
 */
public class Exercicio03 {
    
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
         
         Date data = new Date();
         
         SimpleDateFormat dataformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
             
         System.out.println("Data Atual:");
         System.out.println(dataformat.format(data));
         
         
         String dataEntrada = "";
         System.out.println("Informe a data de nascimento");
         dataEntrada = in.next();
         System.out.println("Informe dias a adicionar:");
         int adicionar = in.nextInt();
         
         SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy"); 
         Date dataFormatada = dataFormat.parse(dataEntrada); 
         
         Calendar c = Calendar.getInstance();
         c.setTime(dataFormatada);
         
         c.add(Calendar.DAY_OF_MONTH, adicionar);
         
         
         Date formatada = c.getTime();
         
         int dia = c.DAY_OF_WEEK;
         
         System.out.println("Data: " + dataFormat.format(formatada));
         
         switch(dia){
             case 1:
                 System.out.println("Dia da Semana: Domingo");
             break;
             case 2:
                 System.out.println("Dia da Semana: Segunda");
             break;
             case 3:
                 System.out.println("Dia da Semana: Terça");
             break;
             case 4:
                 System.out.println("Dia da Semana: Quarta");
             break;
             case 5:
                 System.out.println("Dia da Semana: Quinta");
             break;
             case 6:
                 System.out.println("Dia da Semana: Sexta");
             break;
             case 7:
                 System.out.println("Dia da Semana: Sábado");
             break;
         }
         System.out.println("Dia da Semana: " + dia);
    }   
}