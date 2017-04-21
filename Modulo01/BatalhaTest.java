import static org.junit.Assert.*;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void iniciarRetiraVidaCorretamenteQuandoSaint1CategoriaMaiorDoQueOSaint2() throws Exception {
        Saint mu = new Saint("Mu", new Armadura (new Constelacao("Áries"), Categoria.OURO));
        Saint dante = new Saint ("Dante", new Armadura(new Constelacao("Cérbero"), Categoria.PRATA));
        Batalha battle = new Batalha(mu, dante);

        battle.iniciar();    
        double vidaMu = mu.getVida();
        double vidaDante = dante.getVida();

        assertEquals(100, vidaMu, 0.1);
        assertEquals(90, vidaDante, 0.1);             
    }

    @Test
    public void iniciarRetiraVidaDoSaintCorretoQuandoSaoDeMesmaCategoria() throws Exception {
        Saint shiryu = new Saint ("Shiryu", new Armadura(new Constelacao("Draco"), Categoria.BRONZE));
        Saint shun = new Saint ("Shun", new Armadura(new Constelacao("Andromêda"), Categoria.BRONZE));
        Batalha battle = new Batalha(shiryu, shun);

        battle.iniciar();
        double vidaShiryu = shiryu.getVida();
        double vidaShun = shun.getVida();

        assertEquals(100, vidaShiryu, 0.1);
        assertEquals (90, vidaShun, 0.1);     
    }   

    @Test
    public void  iniciarRetiraVidaCorretamenteQuandoSaint2CategoriaMaiorDoQueOSaint1() throws Exception {

        Saint ikki = new Saint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
        Saint mascaraMorte = new Saint("Máscara da Morte", new Armadura(new Constelacao("Câncer"), Categoria.OURO));
        Batalha batalha = new Batalha(ikki, mascaraMorte);

        batalha.iniciar();

        assertEquals(90, ikki.getVida(), 0.01);
        assertEquals(100, mascaraMorte.getVida(), 0.01);
    }

}
