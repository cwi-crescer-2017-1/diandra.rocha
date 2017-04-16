import static org.junit.Assert.*;
import org.junit.Test;

public class ArmaduraTest {
	
	@Test
	public void armaduraRecebeConstelacaoCorretamenteMesmoEmStringComMaisDeUmaPalavra() {
		Armadura armaduraTest = new Armadura("Nome De Teste", Categoria.BRONZE);
		
		String constelacaoArmadura= armaduraTest.getConstelacao();
		
		assertEquals("Nome De Teste", constelacaoArmadura);
	}
	
	@Test
	public void armaduraRecebeCategoriaCorretamente() {
		Armadura armaduraTest = new Armadura("NomeTeste", Categoria.BRONZE);
		
		Categoria categoriaArmaduraTest = armaduraTest.getCategoria();
		
		assertEquals(Categoria.BRONZE, categoriaArmaduraTest);
	}
	
}