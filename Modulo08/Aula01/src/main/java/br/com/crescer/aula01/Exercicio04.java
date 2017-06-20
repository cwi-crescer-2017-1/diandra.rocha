package br.com.crescer.aula01;

import java.util.Scanner;

/**
 *
 * @author diandra.rocha
 */
public class Exercicio04 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        System.out.println("Digite uma frase:");
        String frase = in.next();
        
        int contador = 0;
        
        char [] arrayDeLetras = new char[frase.length()];
        
        arrayDeLetras = frase.toCharArray();
        
        for(char crc : arrayDeLetras){
            if(crc == 'a'|| crc == 'e' || crc == 'i'|| crc == 'o' || crc == 'u'){
                contador ++;
            }
        }
        
        System.out.println("Número de vogais:" + contador);
    }
    
}
