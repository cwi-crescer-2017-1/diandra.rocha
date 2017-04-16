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
    public void aoPerderVidaSubtraiDezDeVida() {
        Saint saintTest = new Saint("Aphrodite", new Armadura("Peixes", Categoria.OURO));
        
        saintTest.perderVida(10);
        
        assertEquals(90 , saintTest.getVida(), 0.5);    
    }
	
    @Test
    public void aoPerderVidaSubtraiVidaCorretamenteMesmoAPerdaSendoComVirgula() {
        Saint saintTest = new Saint("Aphrodite", new Armadura("Peixes", Categoria.OURO));
        
        saintTest.perderVida(15.5);
        
        assertEquals(84.5 , saintTest.getVida(), 0.5);
    }
	
    @Test
    public void aoPerderVidaSubtraiVidaCorretamenteMesmoAPerdaSendoComVirgulaEMargemDeArredondamentoMenor() {
        Saint saintTest = new Saint("Aphrodite", new Armadura("Peixes", Categoria.OURO));
        
        saintTest.perderVida(23.7);
        
        assertEquals(76.3 , saintTest.getVida(), 0.2);    
    }
	
}
