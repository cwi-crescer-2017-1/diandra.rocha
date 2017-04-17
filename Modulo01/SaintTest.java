import static org.junit.Assert.*;
import org.junit.Test;

public class SaintTest{
	
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() {
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint ("Milo", escorpiao);
        
        milo.vestirArmadura();
        
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true,resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() {
        Saint hyoga = new Saint ("Hyoga", new Armadura("Cisne",  Categoria.BRONZE));
		
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() {
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test
    public void aoCriarSaintStatusEVivo() {
        Saint camus = new Saint ("Camus", new Armadura("Aquario", Categoria.OURO));
        
        assertEquals(Status.VIVO, camus.getStatus());
    }
	
    @Test
    public void verificarCategoriaSaint() {
        Saint saintTest = new Saint("Shaina", new Armadura ("Sepentário", Categoria.PRATA));
        
        int nivelArmaduraSaint = saintTest.getNivelArmadura();
        Categoria categoriaArmaduraSaint = saintTest.getCategoriaArmadura();
        
        assertEquals(2, nivelArmaduraSaint);
	assertEquals(Categoria.PRATA, categoriaArmaduraSaint);
    } 
    
    @Test
    public void vidaInicialDeveSer100() {
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.BRONZE));
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }
	
    @Test
    public void aoPerderVidaSubtraiDezDeVida() {
        Saint saintTest = new Saint("Aphrodite", new Armadura("Peixes", Categoria.OURO));
        
        saintTest.perderVida(10);
        
        assertEquals(90 , saintTest.getVida(), 0.1);    
    }
	
    @Test
    public void aoPerderVidaSubtraiVidaCorretamenteComPerdaDe1000() {
        Saint saintTest = new Saint("Aphrodite", new Armadura("Peixes", Categoria.OURO));
        
        saintTest.perderVida(1000);
        
        assertEquals(-900 , saintTest.getVida(), 0.1);
    }
	
    @Test
    public void aoPerderVidaSubtraiVidaCorretamenteComPerdaDeMenos1000() {
        Saint saintTest = new Saint("Aphrodite", new Armadura("Peixes", Categoria.OURO));
        
        saintTest.perderVida(-1000);
        
        assertEquals(1100 , saintTest.getVida(), 0.1);    
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero() {
        Saint jabu = new Saint("Jabu", new Armadura("Unicórnio", Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }
    
    @Test
    public void criarSaintNasceCom5SentidosDespertados() {
        Saint seiya = new Saint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
        
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }
	
}