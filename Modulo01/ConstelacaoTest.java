import static org.junit.Assert.*;
import org.junit.Test;

public class ConstelacaoTest {
    
    @Test
    public void adicionarGolpeColocaCorretamenteOGolpeEmUltimaPosicao() {
        Golpe [] golpesTest = new Golpe[3];
        Golpe golpeTest = new Golpe("Test", 25);
        Constelacao constelacao = new Constelacao("Test", golpesTest);
        
        constelacao.adicionarGolpe(golpeTest);
        
        assertEquals(golpeTest, golpesTest[2]);
    }
    
    @Test
    public void getGolpesRetornaCorretamenteOArrayDeGolpes() {
        Golpe [] golpesTest = new Golpe[3];
        Constelacao constelacao = new Constelacao("Test", golpesTest);
        
        Golpe[] segundoArrayTest = constelacao.getGolpes();
        
        assertEquals(golpesTest, segundoArrayTest);
    }
  
}
