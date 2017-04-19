import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class GolpeTest {
    
    @Test
    public void comparandoDoisObjetosGolpeComMetodoEquals() {
        Golpe golpe = new Golpe ("Pó de Diamante", 33);
        Object object = new Golpe("Pó de Diamante", 33);
        
        boolean resultado = golpe.equals(object);
        
        assertEquals(true, resultado);
    }
}
