/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Diandra Rocha
 */
public class Main {
    
    public void TesteCliente(){
        Cliente cliente = new Cliente();
        cliente.setBairro("Jardim Planalto");
        cliente.setCPF("123456789");
        cliente.setCelular("123456");
        cliente.setCidade("Esteio");
        cliente.setEmail("teste@teste.com");
        cliente.setFuncao("Cliente");
        
        GregorianCalendar c = new GregorianCalendar(2000, 02, 19);

        Date date = c.getTime();

        cliente.setNascimento(date);
        cliente.setNome("Arianne");
        cliente.setNumero_casa("455");
        cliente.setRG("123456");
        cliente.setRua("Jardel Filho");
        cliente.setSalario(1090.90);
        cliente.setTelefone("40028922");
        
        ClienteDAO dao = new ClienteDAO();
        
        dao.save(cliente);
        Cliente encontrado = dao.loadById(1l);
        
        System.out.println(encontrado.getNome());
        
        List<Cliente> clientes = dao.findAll();
        
        for(Cliente cli: clientes ){
            System.out.println(cli.getNome());
        }
        
        dao.remove(cliente);
        }
    
    public void TesteFuncionario(){
        Funcionario funf = new Funcionario();
        funf.setBairro("Teste");
        funf.setCPF("123456789");
        funf.setCelular("123456");
        funf.setCidade("estante");
        funf.setEmail("teste@teste.com");
        funf.setFuncao("Funcionario");
        
        GregorianCalendar c = new GregorianCalendar(1998, 02, 12);

        Date date = c.getTime();

        funf.setNascimento(date);
        funf.setNome("Testando mesmo");
        funf.setNumero_casa("455");
        funf.setRG("123456");
        funf.setRua("Testante testados");
        funf.setSalario(1090.90);
        funf.setTelefone("40028922");
        
        FuncionarioDAO dao = new FuncionarioDAO();
        
        dao.save(funf);
        Funcionario encontrado = dao.loadById(1l);
        System.out.println(encontrado.getNome());
        
        List<Funcionario> funfs = dao.findAll();
        for(Funcionario funf2: funfs){
            System.out.println(funf2.getNome());
        }
        
        dao.remove(funf);
    }
    
    public void TesteGenero(){
        Genero genero = new Genero();
        genero.setDescricao("teste teste teste");
        
        GeneroDAO dao = new GeneroDAO();
        
        dao.save(genero);
        Genero encontrado = dao.loadById(1l);
        System.out.println(encontrado.getDescricao());
        
        List<Genero> generos = dao.findAll();
        for(Genero gen: generos){
            System.out.println(gen.getDescricao());
        }
        
        dao.remove(genero);
        
    }
    
    public void TesteLocacao(){
        Cliente cliente = new Cliente();
        Funcionario funf = new Funcionario();
        Video video = new Video();
        
        Locacao loca = new Locacao();
        loca.setValor_total(142.33);
        loca.setCliente(cliente);
        loca.setFuncionario(funf);
        loca.setVideo(video);
    }
    
    
    public static void Main(String [] args){
        
        
        
        
        
    }
}
