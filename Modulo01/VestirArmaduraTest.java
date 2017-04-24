import static org.junit.Assert.*;
import org.junit.Test;

public class VestirArmaduraTest {
    
    @Test
    public void vestirArmadura() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Movimento vestir = new VestirArmadura(june);

        vestir.executar();

        assertEquals(true, june.getArmaduraVestida());
    }
    
    @Test
    public void naoVestirArmadura() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Movimento vestir = new VestirArmadura(june);
        
        assertFalse(june.getArmaduraVestida());
    }
    
    @Test (expected=NullPointerException.class)
    public void vestirArmaduraComSaintNull() throws Exception {
        BronzeSaint june = null;
        Movimento vestir = new VestirArmadura(june);

        vestir.executar();
    }
}
