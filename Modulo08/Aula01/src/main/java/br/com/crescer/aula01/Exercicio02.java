package br.com.crescer.aula01;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author diandra.rocha
 */
public class Exercicio02 {
    
    enum Estados {
    AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
    BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
    MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
    MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
    RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
    AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
    RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
    RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

    private String nome;

    private Estados(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    }
    
    
     public static void main(String[] args) {
         
         ArrayList<String> estados = new ArrayList<String>();
         
         for(Estados estado : Estados.values()){
             estados.add(estado.getNome());
         }
         
         Collections.sort(estados);
         
         StringBuffer strings = new StringBuffer();
         for(String estado : estados){             
             
             strings.append(estado);
             strings.append(" , ");
                         
         }
         
         System.out.println(strings.toString());
    }
}