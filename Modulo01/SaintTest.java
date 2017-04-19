import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import java.security.InvalidParameterException; 

public class SaintTest {
	
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        Armadura escorpiao = new Armadura(new Constelacao("Escorpião"), Categoria.OURO);
        Saint milo = new Saint ("Milo", escorpiao);
        
        milo.vestirArmadura();
        
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true,resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint hyoga = new Saint ("Hyoga", new Armadura(new Constelacao("Cisne"),  Categoria.BRONZE));
		
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Saint shaka = new Saint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
        
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusEVivo() throws Exception {
        Saint camus = new Saint ("Camus",new Armadura (new Constelacao("Aquário"), Categoria.OURO));
        
        assertEquals(Status.VIVO, camus.getStatus());
    }
	
    @Test
    public void verificarCategoriaSaint() throws Exception {
        Saint shaina = new Saint("Shaina", new Armadura (new Constelacao("Serpentário"), Categoria.PRATA));
        
        int nivelArmaduraSaint = shaina.getNivelArmadura();
        Categoria categoriaArmaduraSaint = shaina.getCategoriaArmadura();
        
        assertEquals(2, nivelArmaduraSaint);
	    assertEquals(Categoria.PRATA, categoriaArmaduraSaint);
    } 
    
    @Test
    public void vidaInicialDeveSer100() throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }
	
    @Test
    public void aoPerderVidaSubtraiDezDeVida() throws Exception {
        Saint saintTest = new Saint("Aphrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        
        saintTest.perderVida(10);
        
        assertEquals(90 , saintTest.getVida(), 0.1);    
    }
	
    @Test
    public void aoPerderVidaComDano100VidaFica0EStatusMorto() throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));

        shiryu.perderVida(100);
   
        assertEquals(0, shiryu.getVida(), 0.01);
        assertEquals(Status.MORTO, shiryu.getStatus());
    }
    
    @Test
    public void aoPerderVidaComDano1000VidaFica0EStatusMorto() throws Exception {
        Saint aphrodite = new Saint("Aphrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        
        aphrodite.perderVida(1000);
        
        assertEquals(0 , aphrodite.getVida(), 0.1);
        assertEquals(Status.MORTO, aphrodite.getStatus());
    }
	
    @Test (expected=InvalidParameterException.class)
    public void aoPerderVidaComDanoNegativoLancaErro() throws Exception {
        Saint aphrodite = new Saint("Aphrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        
        aphrodite.perderVida(-1000);
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new Saint("Jabu", new Armadura(new Constelacao("Unicórnio"), Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        
        jabu.setGenero(Genero.FEMININO);
        
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }
    
    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégasu"), Categoria.BRONZE));
        
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintNasceCom6SentidosDespertados() throws Exception {
        SilverSaint marin = new SilverSaint("Marin", new Armadura(new Constelacao("Águia"), Categoria.PRATA));
        
        assertEquals(6, marin.getQtdSentidosDespertados());
        
    }
    
    @Test
    public void criarSaintNasceCom7SentidosDespertados() throws Exception {
        GoldSaint aldebaran = new GoldSaint("Aldebaran", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        
        assertEquals(7, aldebaran.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", new Armadura(new Constelacao("Café"), Categoria.OURO));
    }
    
    @Test
    public void aprenderUmGolpe() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        ArrayList <Golpe> golpes = saga.getGolpes();
         
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
       
        assertEquals(outraDimensao, golpes.get(0));
    }

    @Test
    public void aprenderDoisGolpes() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        ArrayList <Golpe> golpes = saga.getGolpes();
        
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
    }

    @Test
    public void getProximoGolpeComUm() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComDois() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }
    
    @Test
    public void getProximoGolpeComTresChamadas() throws Exception {
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }

    
}