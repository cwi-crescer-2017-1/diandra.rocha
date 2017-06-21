package br.com.crescer.aula01;

import java.text.Normalizer;

/**
 *
 * @author Diandra Rocha
 */

public class Lista01Parte01 implements StringUtils {
    
    @Override
    public boolean isEmpty(String string){
        return string.isEmpty();
    }
    
    @Override
    public String inverter (String string){
        StringBuilder entrada = new StringBuilder();
        entrada.append(string);
        return entrada.reverse().toString();
    }
    
    @Override
    public int contaVogais(String string){
        normalize(string);
        int contador = 0;
        char [] arrayDeLetras;
        
        arrayDeLetras = string.toCharArray();
        
        for(char crc : arrayDeLetras){
            if(crc == 'a'|| crc == 'e' || crc == 'i'|| crc == 'o' || crc == 'u'){
                contador ++;
            }
        }
        return contador;
    }
    
    @Override
    public boolean isPalindromo(String string){
        normalize(string);
        
        String invertida = inverter(string);
        
        return invertida.equals(string);
        
    }
    
    private static String normalize(String nome) {
        return Normalizer.normalize(nome, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
