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
    public void buscarSaintComMaiorVida() throws Exception {
        Saint algol = new Saint("Algol", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
        Saint babel = new Saint("Babel", new Armadura(new Constelacao("Centauro"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        Saint maiorVida = lista.getSaintMaiorVida();

        assertEquals(lista.getSaint(0), maiorVida);
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
    public void ordenarListaRetornaListaEmOrdemCorretaDeVida() throws Exception {
        Saint algol = new Saint("Algol", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
        Saint babel = new Saint("Babel", new Armadura(new Constelacao("Centauro"), Categoria.PRATA));
        Saint aiolia = new Saint("Aiolia", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint kanon = new Saint("Kanon", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));

        ListaSaints lista = new ListaSaints();
        
        algol.perderVida(20);
        babel.perderVida(40);
        aiolia.perderVida(60);
        kanon.perderVida(80);

        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        lista.adicionarSaint(aiolia);
        lista.adicionarSaint(kanon);
        
        ArrayList <Saint> ordenado = new ArrayList<>();
        ordenado.add(algol);
        ordenado.add(babel);
        ordenado.add(aiolia);
        ordenado.add(kanon);
        
        lista.ordenarLista();

        assertEquals(ordenado, lista.getExercitoDeAthena());
    }

}
