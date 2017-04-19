import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest {

    @Test
    public void buscarPorNomeRetornaCorretamenteOSaintDesejado() throws Exception {
        Saint jamian = new Saint("Jamian", new Armadura(new Constelacao("Corvo"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(jamian);
        Saint jamianTest = lista.buscarPorNome("Jamian");

        assertEquals(jamian, jamianTest);
    }
    
    @Test
    public void buscarPorNomeComRepeticaoDeNomes() throws Exception {
        Saint jamian = new Saint("Jamian", new Armadura(new Constelacao("Corvo"), Categoria.PRATA));
        Saint outroJamian = new Saint("Jamian", new Armadura(new Constelacao("Corvo"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();
        
        lista.adicionarSaint(jamian);
        lista.adicionarSaint(outroJamian);
        
        assertEquals(jamian, lista.buscarPorNome("Jamian"));
    }
    
    @Test
    public void buscarPorNomeComSaintInexistente() throws Exception {
        Saint jamian = new Saint("Jamian", new Armadura(new Constelacao("Corvo"), Categoria.PRATA));
        Saint outroJamian = new Saint("Jamian", new Armadura(new Constelacao("Corvo"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();
        
        lista.adicionarSaint(jamian);
        lista.adicionarSaint(outroJamian);
        
        assertNull(lista.buscarPorNome("June"));
    }
    
    @Test
    public void buscarPorNomeComListaVazia()  {
        assertNull(new  ListaSaints().buscarPorNome("Marin"));
    }
    
     @Test
    public void buscarPorCategoriaComListaVazia()  {
        ListaSaints lista = new ListaSaints();
        ArrayList <Saint> busca = lista.buscarPorCategoria(Categoria.BRONZE);
        ArrayList <Saint> list = lista.getExercitoDeAthena();
       
        assertEquals(busca, list);
    }
    
    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }
    
    @Test
    public void buscarPorCategoriaRetornaSublistaComSaintsDeMesmaCategoriaQueAInformada() throws Exception {
        Saint aiolia = new Saint("Aiolia", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint kanon = new Saint("Kanon", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(aiolia);
        lista.adicionarSaint(kanon);

        ArrayList <Saint> sublistaGold = lista.buscarPorCategoria(Categoria.OURO);

        assertEquals(sublistaGold.get(0), aiolia);
        assertEquals(sublistaGold.get(1), kanon);
    }

    @Test
    public void buscarPorStatusRetornaSublistaComSaintsDeMesmoStatusQueOInformado() throws Exception {
        Saint aiolia = new Saint("Aiolia", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint kanon = new Saint("Kanon", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(aiolia);
        lista.adicionarSaint(kanon);

        ArrayList <Saint> sublistaGold = lista.buscarPorStatus(Status.VIVO);

        assertEquals(sublistaGold.get(0), aiolia);
        assertEquals(sublistaGold.get(1), kanon);
    }

    @Test
    public void buscarSaintComMaiorVidaComDoisSaintsDeMesmaVida() throws Exception {
        Saint algol = new Saint("Algol", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
        Saint babel = new Saint("Babel", new Armadura(new Constelacao("Centauro"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        Saint maiorVida = lista.getSaintMaiorVida();

        assertEquals(lista.getSaint(0), maiorVida);
    }
    
    @Test
    public void buscarSaintComMaiorVidaComTresSaintsDeVidasDiferentes() throws Exception {
        Saint algol = new Saint("Algol", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
        Saint kanon = new Saint("Kanon", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Saint babel = new Saint("Babel", new Armadura(new Constelacao("Centauro"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        lista.adicionarSaint(kanon);
        algol.perderVida(80);
        babel.perderVida(40);
        kanon.perderVida(20);
        
        Saint maiorVida = lista.getSaintMaiorVida();

        assertEquals(kanon, maiorVida);
    }

    @Test
    public void buscarSaintComMenorVida() throws Exception {
        Saint algol = new Saint("Algol", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
        Saint babel = new Saint("Babel", new Armadura(new Constelacao("Centauro"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();

        babel.perderVida(50);
        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        Saint menorVida = lista.getSaintMenorVida();

        assertEquals(lista.getSaint(1), menorVida);
    }
    
    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        
        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);
        
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        
        listaSaints.ordenarLista();
        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();
        
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

}
