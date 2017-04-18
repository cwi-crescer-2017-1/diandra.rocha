import static org.junit.Assert.*;
import org.junit.Test;

public class ArmaduraTest {
    
    @Test
    public void armaduraRecebeCategoriaCorretamente() {
        Armadura armaduraTest = new Armadura(new Constelacao("Nome de Teste"),Categoria.BRONZE);
        
        Categoria categoriaArmaduraTest = armaduraTest.getCategoria();
        
        assertEquals(Categoria.BRONZE, categoriaArmaduraTest);
    }
    
}