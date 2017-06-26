package br.com.crescer.aula04;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diandra Rocha
 */
public class Main {
    
    public static void TesteCliente(EntityManager entityManager){
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
        
        ClienteDAO dao = new ClienteDAO(entityManager);
        
        dao.save(cliente);
        Cliente encontrado = dao.loadById(1l);
        
        System.out.println(encontrado.getNome());
        
        List<Cliente> clientes = dao.findAll();
        
        for(Cliente cli: clientes ){
            System.out.println(cli.getNome());
        }
        
        dao.remove(cliente);
        }
    
    public static void TesteFuncionario(EntityManager entityManager){
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
        
        FuncionarioDAO dao = new FuncionarioDAO(entityManager);
        
        dao.save(funf);
        Funcionario encontrado = dao.loadById(1l);
        System.out.println(encontrado.getNome());
        
        List<Funcionario> funfs = dao.findAll();
        for(Funcionario funf2: funfs){
            System.out.println(funf2.getNome());
        }
        
        dao.remove(funf);
    }
    
    public static void TesteGenero(EntityManager entityManager){
        Genero genero = new Genero();
        genero.setDescricao("Me ferrei em matemática");
        
        GeneroDAO dao = new GeneroDAO(entityManager);
        
        dao.save(genero);
        Genero encontrado = dao.loadById(1l);
        System.out.println(encontrado.getDescricao());
        
        List<Genero> generos = dao.findAll();
        for(Genero gen: generos){
            System.out.println(gen.getDescricao());
        }
        
        dao.remove(genero);
        
    }
    
    public static void TesteLocacao(EntityManager entityManager){
        Cliente cliente = new Cliente();
        Funcionario funf = new Funcionario();
        Video video = new Video();
        GregorianCalendar c = new GregorianCalendar(2017, 06, 30);

        Date date = c.getTime();
        
        Locacao loca = new Locacao();
        loca.setValor_total(142.33);
        loca.setCliente(cliente);
        loca.setFuncionario(funf);
        loca.setVideo(video);
        loca.setData_devolucao(date);
        
        LocacaoDAO dao = new LocacaoDAO(entityManager);
        
        dao.save(loca);
        Locacao encontrado = dao.loadById(1l);
        
        System.out.println(encontrado.getValor_total() + " "
                + " " + encontrado.getCliente().getId() + " "
                + " " +encontrado.getFuncionario().getId() + " "
                + " " + encontrado.getVideo().getId());
        
        List<Locacao> locacoes = dao.findAll();
        for(Locacao lo: locacoes){
            System.out.println(lo.getValor_total());
        }
        
        dao.remove(loca);
    }
    
    public static void TesteVideo(EntityManager entityManager){
        Video video = new Video();
        video.setValor(19.30);
        video.setDuracao("143min");
        video.setNome("A noite dos mortos em matemática");
        video.setQuantidade_estoque(5);
        GregorianCalendar c = new GregorianCalendar(2017, 06, 26);

        Date date = c.getTime();
        video.setData_lancamento(date);
        Genero genero = new Genero();
        video.setGenero(genero);
        
        VideoDAO dao = new VideoDAO(entityManager);
        
        dao.save(video);
        Video encontrado = dao.loadById(1l);
        
        System.out.println(encontrado.getNome() + " " + encontrado.getGenero().getId());
        
        List<Video> videos = dao.findAll();
        for(Video vi: videos){
            System.out.println(vi.getNome());
        }
        
        dao.remove(video);
    }
    
    
    public static void Main(String [] args){
  
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CRESCER");
        EntityManager entityManager = factory.createEntityManager();
        
        TesteCliente(entityManager);
        TesteFuncionario(entityManager);
        TesteGenero(entityManager);
        TesteVideo(entityManager);
        TesteLocacao(entityManager);
        
        
        entityManager.close();
        factory.close();
        
    }
}
