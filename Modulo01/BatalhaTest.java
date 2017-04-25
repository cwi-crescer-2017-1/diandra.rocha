import static org.junit.Assert.*;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void iniciarBatalhaRetiraVidaCorretamenteQuandoSaint1CategoriaMaiorDoQueOSaint2() throws Exception {
        GoldSaint mu = new GoldSaint("Mu", "Áries");
        SilverSaint dante = new SilverSaint ("Dante","Cérbero");
        Batalha battle = new Batalha(mu, dante);

        dante.aprenderGolpe(new Golpe("Teste", 10));
        mu.aprenderGolpe(new Golpe("Teste", 15));
        mu.golpear(dante);
        dante.golpear(mu);

        battle.iniciar();
        double vidaMu = mu.getVida();
        double vidaDante = dante.getVida();

        assertEquals(40, vidaMu, 0.1);
        assertEquals(0, vidaDante, 0.1);   
    }

    @Test
    public void iniciarBatalhaRetiraVidaDoSaintCorretoQuandoSaoDeMesmaCategoria() throws Exception {
        BronzeSaint shiryu = new BronzeSaint ("Shiryu", "Draco");
        BronzeSaint shun = new BronzeSaint ("Shun", "Andromêda");
        Batalha battle = new Batalha(shiryu, shun);

        shiryu.aprenderGolpe(new Golpe("Teste", 40));
        shun.aprenderGolpe(new Golpe("Teste", 100));
        shiryu.golpear(shun);
        shun.golpear(shiryu);

        battle.iniciar();
        double vidaShiryu = shiryu.getVida();
        double vidaShun = shun.getVida();

        assertEquals(0, vidaShiryu, 0.1);
        assertEquals (90, vidaShun, 0.1);     
    }   

    @Test
    public void iniciarRetiraVidaCorretamenteQuandoSaint2CategoriaMaiorDoQueOSaint1() throws Exception {

        BronzeSaint ikki = new BronzeSaint("Ikki","Fênix");
        GoldSaint mascaraMorte = new GoldSaint("Máscara da Morte","Câncer");
        Batalha batalha = new Batalha(ikki, mascaraMorte);

        mascaraMorte.aprenderGolpe(new Golpe("Teste", 30));
        ikki.aprenderGolpe(new Golpe("Teste", 10));
        mascaraMorte.golpear(ikki);
        ikki.golpear(mascaraMorte);

        batalha.iniciar();

        assertEquals(0, ikki.getVida(), 0.01);
        assertEquals(70, mascaraMorte.getVida(), 0.01);
    }
}