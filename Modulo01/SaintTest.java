import static org.junit.Assert.*;
import org.junit.Test;

public class SaintTest{
	
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint ("Milo", escorpiao);
        
        milo.vestirArmadura();
        
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true,resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint hyoga = new Saint ("Hyoga", new Armadura("Cisne",  Categoria.BRONZE));
		
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusEVivo() throws Exception {
        Saint camus = new Saint ("Camus", new Armadura("Touro", Categoria.OURO));
        
        assertEquals(Status.VIVO, camus.getStatus());
    }
	
    @Test
    public void verificarCategoriaSaint() throws Exception {
        Saint saintTest = new Saint("Shaina", new Armadura ("Sepentário", Categoria.PRATA));
        
        int nivelArmaduraSaint = saintTest.getNivelArmadura();
        Categoria categoriaArmaduraSaint = saintTest.getCategoriaArmadura();
        
        assertEquals(2, nivelArmaduraSaint);
	assertEquals(Categoria.PRATA, categoriaArmaduraSaint);
    } 
    
    @Test
    public void vidaInicialDeveSer100() throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.BRONZE));
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }
	
    @Test
    public void aoPerderVidaSubtraiDezDeVida() throws Exception {
        Saint saintTest = new Saint("Aphrodite", new Armadura("Peixes", Categoria.OURO));
        
        saintTest.perderVida(10);
        
        assertEquals(90 , saintTest.getVida(), 0.1);    
    }
	
    @Test
    public void aoPerderVidaSubtraiVidaCorretamenteComPerdaDe1000() throws Exception {
        Saint saintTest = new Saint("Aphrodite", new Armadura("Peixes", Categoria.OURO));
        
        saintTest.perderVida(1000);
        
        assertEquals(-900 , saintTest.getVida(), 0.1);
    }
	
    @Test
    public void aoPerderVidaSubtraiVidaCorretamenteComPerdaDeMenos1000() throws Exception {
        Saint saintTest = new Saint("Aphrodite", new Armadura("Peixes", Categoria.OURO));
        
        saintTest.perderVida(-1000);
        
        assertEquals(1100 , saintTest.getVida(), 0.1);    
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new Saint("Jabu", new Armadura("Unicórnio", Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }
    
    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
        
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintNasceCom6SentidosDespertados() throws Exception {
        SilverSaint marin = new SilverSaint("Marin", new Armadura("Águia", Categoria.PRATA));
        
        assertEquals(6, marin.getQtdSentidosDespertados());
        
    }
    
    @Test
    public void criarSaintNasceCom7SentidosDespertados() throws Exception {
        GoldSaint aldebaran = new GoldSaint("Aldebaran", new Armadura("Touro", Categoria.OURO));
        
        assertEquals(7, aldebaran.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", new Armadura("Café", Categoria.OURO));
    }
    
}