import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest {

    //buscarPorNome

    @Test
    public void buscarPorNomeRetornaCorretamenteOSaintDesejado() throws Exception {
        SilverSaint jamian = new SilverSaint("Jamian", "Corvo");
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(jamian);
        Saint jamianTest = lista.buscarPorNome("Jamian");

        assertEquals(jamian, jamianTest);
    }

    @Test
    public void buscarPorNomeComRepeticaoDeNomes() throws Exception {
        SilverSaint jamian = new SilverSaint("Jamian", "Corvo");
        SilverSaint outroJamian = new SilverSaint("Jamian", "Corvo");
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(jamian);
        lista.adicionarSaint(outroJamian);

        assertEquals(jamian, lista.buscarPorNome("Jamian"));
    }

    @Test
    public void buscarPorNomeComSaintInexistente() throws Exception {
        SilverSaint jamian = new SilverSaint("Jamian", "Corvo");
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(jamian);

        assertNull(lista.buscarPorNome("June"));
    }

    @Test
    public void buscarPorNomeComListaVazia()  {
        assertNull(new ListaSaints().buscarPorNome("Marin"));
    }

    //buscarPorCategoria

    @Test
    public void buscarPorCategoriaComListaVazia()  {
        ListaSaints lista = new ListaSaints();

        ArrayList <Saint> busca = lista.buscarPorCategoria(Categoria.BRONZE);
        ArrayList <Saint> list = lista.getTodos();

        assertEquals(busca, list);
    }

    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");

        lista.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = lista.buscarPorCategoria(Categoria.PRATA);

        assertEquals(new ArrayList<Saint>(), resultadoBusca);
        assertEquals(0, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaRetornaSublistaComSaintsDeMesmaCategoriaQueAInformada() throws Exception {
        GoldSaint aiolia = new GoldSaint("Aiolia", "Leão");
        GoldSaint kanon = new GoldSaint("Kanon", "Gêmeos");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");

        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(aiolia);
        lista.adicionarSaint(kanon);
        lista.adicionarSaint(misty);

        ArrayList <Saint> sublistaGold = lista.buscarPorCategoria(Categoria.OURO);

        assertEquals(sublistaGold.get(0), aiolia);
        assertEquals(sublistaGold.get(1), kanon);
        assertEquals(2, sublistaGold.size());
    }

    //buscarPorStatus

    @Test
    public void buscarPorStatusComListaVazia()  {
        ListaSaints lista = new ListaSaints();

        ArrayList <Saint> busca = lista.buscarPorStatus(Status.VIVO);

        assertEquals(new ArrayList<Saint>(), busca);
    }

    @Test
    public void buscarPorStatusInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");

        listaSaints.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.DESACORDADO);

        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("June", "Andrômeda");

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

    //saintMaiorVida

    @Test
    public void buscarSaintComMaiorVidaComDoisSaintsDeMesmaVida() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        Saint maiorVida = lista.getSaintMaiorVida();

        assertEquals(algol, maiorVida);
    }

    @Test
    public void buscarSaintComMaiorVidaComTresSaintsDeVidasDiferentes() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        GoldSaint kanon = new GoldSaint("Kanon", "Gêmeos");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");
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

    //saintMenorVida

    @Test
    public void buscarSaintComMenorVidaComDoisSaintsDeMesmaVida() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");
        ListaSaints lista = new ListaSaints();

        lista.adicionarSaint(algol);
        lista.adicionarSaint(babel);
        Saint menorVida = lista.getSaintMenorVida();

        assertEquals(algol, menorVida);
    }

    @Test
    public void buscarSaintComMenorVidaComMaisDeUmSaintDeVidasDiferentes() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
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

    //Ascendente

    @Test
    public void ordenarComListaTotalmenteDesordenadaAscendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);

        shun.perderVida(30);
        misty.perderVida(70);
        june.perderVida(45);

        listaSaints.ordenarLista();
        ArrayList<Saint> resultado = listaSaints.getTodos();

        assertEquals(misty, resultado.get(0));
        assertEquals(june, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarComListaTotalmenteOrdenadaAscendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);

        shun.perderVida(88);
        misty.perderVida(63);
        june.perderVida(15);

        listaSaints.ordenarLista(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        ArrayList<Saint> ordenado = new ArrayList<>();
        ordenado.add(shun);
        ordenado.add(misty);
        ordenado.add(june);

        assertEquals(ordenado, resultado);
    }

    @Test
    public void ordenarComListaVaziaAscendente() throws Exception {
        ListaSaints lista = new ListaSaints();
        lista.ordenarLista();

        ArrayList<Saint> resultado = lista.getTodos();

        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarComListaApenasUmAscendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        listaSaints.adicionarSaint(shun);
        shun.perderVida(30);
        listaSaints.ordenarLista();

        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarComListaDeValoresIguaisAscendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);
        listaSaints.ordenarLista();

        ArrayList<Saint> resultado = listaSaints.getTodos();

        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    //Descendente

    @Test
    public void ordenarComListaTotalmenteDesordenadaDescendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);

        shun.perderVida(30);
        misty.perderVida(70);
        june.perderVida(45);

        listaSaints.ordenarLista(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();

        assertEquals(misty, resultado.get(2));
        assertEquals(june, resultado.get(1));
        assertEquals(shun, resultado.get(0));
    }

    @Test
    public void ordenarComListaTotalmenteOrdenadaDescendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);

        shun.perderVida(88);
        misty.perderVida(63);
        june.perderVida(15);

        listaSaints.ordenarLista(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getTodos();
        ArrayList<Saint> ordenado = new ArrayList<>();
        ordenado.add(june);
        ordenado.add(misty);
        ordenado.add(shun);

        assertEquals(ordenado, resultado);
    }

    @Test
    public void ordenarComListaVaziaDescendente() throws Exception {
        ListaSaints lista = new ListaSaints();
        lista.ordenarLista();

        ArrayList<Saint> resultado = lista.getTodos();

        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarComListaApenasUmDescendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        listaSaints.adicionarSaint(shun);
        shun.perderVida(30);
        listaSaints.ordenarLista();

        ArrayList<Saint> resultado = listaSaints.getTodos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarComListaDeValoresIguaisDescendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);
        listaSaints.ordenarLista();

        ArrayList<Saint> resultado = listaSaints.getTodos();

        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    //getCSV

    @Test
    public void retornoDaStringDeSaintsComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();

        String CSVresultado = listaSaints.getCSV();
        String CSV = "";

        assertEquals(CSV, CSVresultado);
    }

    @Test
    public void getCSVComApenasUmSaint() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");

        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionarSaint(june);

        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false\n";
        assertEquals(esperado, lista.getCSV());
    }

    @Test
    public void getCSVComApenasDoisSaints() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);

        GoldSaint dohko = new GoldSaint("", "Áries");
        dohko.perderVida(90);
        dohko.vestirArmadura();

        lista.adicionarSaint(june);
        lista.adicionarSaint(dohko);

        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false\n,10.0,Áries,OURO,VIVO,NAO_INFORMADO,true\n";
        assertEquals(esperado, lista.getCSV());
    }

    //unir

    @Test
    public void unirListasComAprimeiraMaiorDoQueASegunda() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(june);
        lista.adicionarSaint(misty);

        ListaSaints listaUnir = new ListaSaints();
        listaUnir.adicionarSaint(shun);

        ListaSaints resultado = lista.unir(listaUnir);

        assertEquals(june, resultado.getSaint(0));
        assertEquals(misty, resultado.getSaint(1));
        assertEquals(shun, resultado.getSaint(2));
        assertEquals(3, resultado.getTodos().size());
    }

    @Test
    public void unirListasComAprimeiraMenorDoQueASegunda() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(june);

        ListaSaints listaUnir = new ListaSaints();
        listaUnir.adicionarSaint(shun);
        listaUnir.adicionarSaint(misty);

        ListaSaints resultado = lista.unir(listaUnir);

        assertEquals(june, resultado.getSaint(0));
        assertEquals(shun, resultado.getSaint(1));
        assertEquals(misty, resultado.getSaint(2));
        assertEquals(3, resultado.getTodos().size());
    }

    @Test
    public void unirListasComListaInicialVazia() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        ListaSaints lista = new ListaSaints();

        ListaSaints listaUnir = new ListaSaints();
        listaUnir.adicionarSaint(shun);
        listaUnir.adicionarSaint(misty);

        ListaSaints resultado = lista.unir(listaUnir);

        assertEquals(shun, resultado.getSaint(0));
        assertEquals(misty, resultado.getSaint(1));
        assertEquals(2, resultado.getTodos().size());
    }

    //Diff
    @Test
    public void diffListasComAprimeiraListaMaiorDoQueASegunda() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(misty);
        lista.adicionarSaint(shun);
        lista.adicionarSaint(june);

        ListaSaints listaDiff = new ListaSaints();
        listaDiff.adicionarSaint(misty);
        listaDiff.adicionarSaint(shun);

        ListaSaints resultado = lista.diff(listaDiff);

        assertEquals(june, resultado.getSaint(0));
        assertEquals(1, resultado.getTodos().size());
    }

    @Test
    public void diffListasComAprimeiraListaMenorDoQueASegunda() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        SilverSaint jamian = new SilverSaint("Jamian","Corvo");

        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(jamian);
        lista.adicionarSaint(june);

        ListaSaints listaDiff = new ListaSaints();
        listaDiff.adicionarSaint(june);
        listaDiff.adicionarSaint(misty);
        listaDiff.adicionarSaint(shun);

        ListaSaints resultado = lista.diff(listaDiff);

        assertEquals(jamian, resultado.getSaint(0));
        assertEquals(1, resultado.getTodos().size());
    }

    @Test
    public void diffListasComListaInicialVazia() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        ListaSaints lista = new ListaSaints();

        ListaSaints listaDiff = new ListaSaints();
        listaDiff.adicionarSaint(shun);
        listaDiff.adicionarSaint(misty);

        ListaSaints listaFinal = lista.diff(listaDiff);

        assertEquals(0, listaFinal.getTodos().size());
    }

    //Intersec

    @Test
    public void interecListasComAprimeiraListaMaiorDoQueASegunda() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(misty);
        lista.adicionarSaint(shun);
        lista.adicionarSaint(june);

        ListaSaints listaIntersec = new ListaSaints();
        listaIntersec.adicionarSaint(misty);
        listaIntersec.adicionarSaint(shun);

        ListaSaints resultado = lista.intersec(listaIntersec);

        assertEquals(misty, resultado.getSaint(0));
        assertEquals(shun, resultado.getSaint(1));
        assertEquals(2, resultado.getTodos().size());
    }

    @Test
    public void intersecListasComAprimeiraListaMenorDoQueASegunda() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        SilverSaint jamian = new SilverSaint("Jamian","Corvo");

        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(jamian);
        lista.adicionarSaint(june);

        ListaSaints listaIntersec = new ListaSaints();
        listaIntersec.adicionarSaint(june);
        listaIntersec.adicionarSaint(misty);
        listaIntersec.adicionarSaint(shun);

        ListaSaints resultado = lista.intersec(listaIntersec);

        assertEquals(june, resultado.getSaint(0));
        assertEquals(1, resultado.getTodos().size());
    }

    @Test
    public void intersecListasComListaInicialVazia() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        SilverSaint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        ListaSaints lista = new ListaSaints();

        ListaSaints listaIntersec = new ListaSaints();
        listaIntersec.adicionarSaint(shun);
        listaIntersec.adicionarSaint(misty);

        ListaSaints listaFinal = lista.intersec(listaIntersec);

        assertEquals(0, listaFinal.getTodos().size());
    }

}