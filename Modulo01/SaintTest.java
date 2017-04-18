import static org.junit.Assert.*;
import org.junit.Test;

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
        Saint saintTest = new Saint("Shaina", new Armadura (new Constelacao("Serpentário"), Categoria.PRATA));
        
        int nivelArmaduraSaint = saintTest.getNivelArmadura();
        Categoria categoriaArmaduraSaint = saintTest.getCategoriaArmadura();
        
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
        Saint saintTest = new Saint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));

        saintTest.perderVida(100);
   
        assertEquals(0, saintTest.getVida(), 0.01);
        assertEquals(Status.MORTO, saintTest.getStatus());
    }
    
    @Test
    public void aoPerderVidaComDano1000VidaFica0EStatusMorto() throws Exception {
        Saint saintTest = new Saint("Aphrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        
        saintTest.perderVida(1000);
        
        assertEquals(0 , saintTest.getVida(), 0.1);
        assertEquals(Status.MORTO, saintTest.getStatus());
    }
	
    @Test (expected=Exception.class)
    public void aoPerderVidaComDanoNegativoLancaErro() throws Exception {
        Saint saintTest = new Saint("Aphrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        
        saintTest.perderVida(-1000);
        
        assertEquals(0 , saintTest.getVida(), 0.1); 
        assertEquals(Status.MORTO, saintTest.getStatus());
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
    public void getGolpesRetornaCorretamenteOArrayDeGolpesDaConstelacao() throws Exception {
        Saint saintTest = new Saint("Aldebaran", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Golpe [] golpesArmaduraSaint = saintTest.getArmadura().getConstelacao().getGolpes();
        Golpe [] golpeTest = new Golpe[3];
        Constelacao constelacaoTest = new Constelacao("Teste", golpeTest);
        
        assertEquals(golpeTest, golpesArmaduraSaint);
    }
    
    @Test
    public void aprenderGolpeAdicionaGolpeAoArrayDEGolpesDaConstelacao() throws Exception {
        Saint saintTest = new Saint("Aldebaran", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        Constelacao constelacaoSaint = saintTest.getArmadura().getConstelacao();
        Golpe [] arrayGolpeTest = saintTest.getArmadura().getConstelacao().getGolpes();
        Golpe golpeTest = new Golpe("Test" , 24);
        
        constelacaoSaint.adicionarGolpe(golpeTest);
        
        assertEquals(golpeTest,arrayGolpeTest[2]); 
    } 
    
}