import static org.junit.Assert.*;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void iniciarRetiraVidaCorretamenteQuandoSaint1CategoriaMaiorDoQueOSaint2() throws Exception {
        GoldSaint mu = new GoldSaint("Mu", "Áries");
        SilverSaint dante = new SilverSaint ("Dante","Cérbero");
        Batalha battle = new Batalha(mu, dante);

        battle.iniciar();    
        double vidaMu = mu.getVida();
        double vidaDante = dante.getVida();

        assertEquals(100, vidaMu, 0.1);
        assertEquals(90, vidaDante, 0.1);             
    }

    @Test
    public void iniciarRetiraVidaDoSaintCorretoQuandoSaoDeMesmaCategoria() throws Exception {
        BronzeSaint shiryu = new BronzeSaint ("Shiryu", "Draco");
        BronzeSaint shun = new BronzeSaint ("Shun", "Andromêda");
        Batalha battle = new Batalha(shiryu, shun);

        battle.iniciar();
        double vidaShiryu = shiryu.getVida();
        double vidaShun = shun.getVida();

        assertEquals(100, vidaShiryu, 0.1);
        assertEquals (90, vidaShun, 0.1);     
    }   

    @Test
    public void  iniciarRetiraVidaCorretamenteQuandoSaint2CategoriaMaiorDoQueOSaint1() throws Exception {

        BronzeSaint ikki = new BronzeSaint("Ikki","Fênix");
        GoldSaint mascaraMorte = new GoldSaint("Máscara da Morte","Câncer");
        Batalha batalha = new Batalha(ikki, mascaraMorte);

        batalha.iniciar();

        assertEquals(90, ikki.getVida(), 0.01);
        assertEquals(100, mascaraMorte.getVida(), 0.01);
    }

}
