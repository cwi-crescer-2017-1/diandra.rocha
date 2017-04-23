import static org.junit.Assert.*;
import org.junit.Test;

public class GolpearTest {
    
    @Test
    public void executarRetornaCorretamenteOFatorDeDanoSemArmadura() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");

        Golpear test = new Golpear (algol, babel);
        algol.getConstelacao().adicionarGolpe(new Golpe("Teste", 10));
         
        test.executar();
        
        assertEquals(90, babel.getVida(), 0.1);
    }
    
     @Test
    public void executarRetornaCorretamenteOFatorDeDanoTotal100SemArmadura() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");

        Golpear test = new Golpear (algol, babel);
        algol.getConstelacao().adicionarGolpe(new Golpe("Teste", 100));
         
        test.executar();
        
        assertEquals(0, babel.getVida(), 0.1);
    }
    @Test
    public void executarRetornaCorretamenteOFatorDeDanoComArmadura() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");
        algol.vestirArmadura();

        Golpear test = new Golpear (algol, babel);
        algol.getConstelacao().adicionarGolpe(new Golpe("Teste", 10));
         
        test.executar();
        
        assertEquals(70, babel.getVida(), 0.1);
    }
    
    @Test
    public void executarRetornaCorretamenteOFatorDeDanoTotal100ComArmadura() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");
        Movimento armaduraVestida = new VestirArmadura(algol);
        armaduraVestida.executar();

        Golpear test = new Golpear (algol, babel);
        algol.getConstelacao().adicionarGolpe(new Golpe("Teste", 40));
         
        test.executar();
        
        assertEquals(0, babel.getVida(), 0.1);
    }
    
}
