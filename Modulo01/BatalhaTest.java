import static org.junit.Assert.*;
import org.junit.Test;

public class BatalhaTest {
    
    @Test
    public void iniciarRetiraVidaDoSaintCorreto() {
		Saint mu = new Saint("Mu", new Armadura ("Áries", Categoria.OURO));
		Saint dante = new Saint ("Dante", new Armadura("Cérbero", Categoria.PRATA));
		Batalha battle = new Batalha(mu, dante);
		
		battle.iniciar();    
		double vidaMu = mu.getVida();
		double vidaDante = dante.getVida();
           
		assertEquals(100, vidaMu, 0.5);
		assertEquals(90, vidaDante, 0.5);             
    }
	
    @Test
    public void iniciarRetiraVidaDoSaintCorretoQuandoSaoDeMesmaCategoria() {
        Saint shiryu = new Saint ("Shiryu", new Armadura("Draco", Categoria.BRONZE));
        Saint shun = new Saint ("Shun", new Armadura("Andromêda", Categoria.BRONZE));
        Batalha battle = new Batalha(shiryu, shun);
        
        battle.iniciar();
        double vidaShiryu = shiryu.getVida();
        double vidaShun = shun.getVida();
        
        assertEquals(100, vidaShiryu, 0.5);
        assertEquals (90, vidaShun, 0.5);     
    }   
    
}