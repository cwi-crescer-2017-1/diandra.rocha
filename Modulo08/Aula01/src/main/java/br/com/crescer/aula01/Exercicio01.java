package br.com.crescer.aula01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author diandra.rocha
 */
public class Exercicio01 {


    public static void main(String[] args) {

        try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
            try (final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                 int numero = Integer.parseInt(bufferedReader.readLine());
                 if(numero%2==0){
                     System.out.println("É par.");
                 }else{
                     System.out.println("É ímpar.");
                 }
            } catch (Exception e) {
                //...
            }
        } catch (Exception e) {
            //...
        }
    }
} 