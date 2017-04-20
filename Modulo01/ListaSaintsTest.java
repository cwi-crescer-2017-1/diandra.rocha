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
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(jamian);

        assertNull(lista.buscarPorNome("June"));
    }

    @Test
    public void buscarPorNomeComListaVazia()  {
        assertNull(new ListaSaints().buscarPorNome("Marin"));
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
        ListaSaints lista = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));

        lista.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = lista.buscarPorCategoria(Categoria.PRATA);

        assertEquals(new ArrayList<Saint>(), resultadoBusca);
        assertEquals(0, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaRetornaSublistaComSaintsDeMesmaCategoriaQueAInformada() throws Exception {
        Saint aiolia = new Saint("Aiolia", new Armadura(new Constelacao("Leão"), Categoria.OURO));
        Saint kanon = new Saint("Kanon", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));

        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(aiolia);
        lista.adicionarSaint(kanon);
        lista.adicionarSaint(misty);

        ArrayList <Saint> sublistaGold = lista.buscarPorCategoria(Categoria.OURO);

        assertEquals(sublistaGold.get(0), aiolia);
        assertEquals(sublistaGold.get(1), kanon);
        assertEquals(2, sublistaGold.size());
    }

    @Test
    public void buscarPorStatusComListaVazia()  {
        ListaSaints lista = new ListaSaints();

        ArrayList <Saint> busca = lista.buscarPorStatus(Status.VIVO);

        assertEquals(new ArrayList<Saint>(), busca);
    }

    @Test
    public void buscarPorStatusInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));

        listaSaints.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.DESACORDADO);

        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);
        june.perderVida(100);
        misty.perderVida(100);

        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);

        assertEquals(june, resultadoBusca.get(1));
        assertEquals(misty, resultadoBusca.get(0));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void buscarSaintComMaiorVidaComDoisSaintsDeMesmaVida() throws Exception {
        Saint algol = new Saint("Algol", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
        Saint babel = new Saint("Babel", new Armadura(new Constelacao("Centauro"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        Saint maiorVida = lista.getSaintMaiorVida();

        assertEquals(algol, maiorVida);
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
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaints lista = new ListaSaints();

        Saint maiorVida = lista.getSaintMaiorVida();

        assertNull(maiorVida);
    }

    @Test
    public void buscarSaintComMenorVidaComDoisSaintsDeMesmaVida() throws Exception {
        Saint algol = new Saint("Algol", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
        Saint babel = new Saint("Babel", new Armadura(new Constelacao("Centauro"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        Saint menorVida = lista.getSaintMenorVida();

        assertEquals(algol, menorVida);
    }

    @Test
    public void buscarSaintComMenorVidaComMaisDeUmSaintDeVidasDiferentes() throws Exception {
        Saint algol = new Saint("Algol", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
        Saint babel = new Saint("Babel", new Armadura(new Constelacao("Centauro"), Categoria.PRATA));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        ListaSaints lista = new ListaSaints();

        babel.perderVida(50);
        misty.perderVida(82);
        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        lista.adicionarSaint(misty);

        Saint menorVida = lista.getSaintMenorVida();

        assertEquals(misty, menorVida);
    }

    @Test
    public void getSaintMenorVidaComListaVazia() {
        ListaSaints lista = new ListaSaints();

        Saint menorVida = lista.getSaintMenorVida();

        assertNull(menorVida);
    }

    @Test
    public void ordenarComListaTotalmenteOrdenadaAscendente() throws Exception {
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

    @Test
    public void ordenarComListaTotalmenteOrdenadaDescendente() throws Exception {
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

        listaSaints.ordenarLista(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();
        ArrayList<Saint> ordenado = new ArrayList<>();
        ordenado.add(june);
        ordenado.add(misty);
        ordenado.add(shun);

        assertEquals(ordenado, resultado);
    }

    @Test
    public void retornoDaStringDeSaints() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));

        listaSaints.adicionarSaint(shun);

        String CSVresultado = listaSaints.getCSV();

        String CSV = "";
        CSV += shun.getNome() + "," + shun.getVida() + "," + shun.getNomeConstelacaoArmadura() + "," + shun.getCategoriaArmadura()
        + "," + shun.getStatus() + "," + shun.getGenero() + "," + shun.getArmaduraVestida() + "\n";

        assertEquals(CSV, CSVresultado);
    }

    @Test
    public void retornoDaStringDeSaintsComMaisDeUmSaint() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);

        String CSVresultado = listaSaints.getCSV();

        String CSV = "";
        CSV += shun.getNome() + "," + shun.getVida() + "," + shun.getNomeConstelacaoArmadura() + "," + shun.getCategoriaArmadura()
        + "," + shun.getStatus() + "," + shun.getGenero() + "," + shun.getArmaduraVestida() + "\n"
        +  misty.getNome() + "," + misty.getVida() + "," + misty.getNomeConstelacaoArmadura() + "," + misty.getCategoriaArmadura()
        + "," + misty.getStatus() + "," + misty.getGenero() + "," + misty.getArmaduraVestida() + "\n";

        assertEquals(CSV, CSVresultado);
    }
    
    @Test
    public void retornoDaStringDeSaintsComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        
        String CSVresultado = listaSaints.getCSV();
        String CSV = "";
        
        assertEquals(CSV, CSVresultado);
    }

}