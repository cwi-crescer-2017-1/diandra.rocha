import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest {
    
    //buscarPorNome

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

    //buscarPorCategoria
    
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

    //saintMaiorVida
    
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

    //saintMenorVida
    
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

    //Ascendente

    @Test
    public void ordenarComListaTotalmenteDesordenadaAscendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);

        shun.perderVida(30);
        misty.perderVida(70);
        june.perderVida(45);

        listaSaints.ordenarLista();
        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();

        assertEquals(misty, resultado.get(0));
        assertEquals(june, resultado.get(1));
        assertEquals(shun, resultado.get(2));
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

        shun.perderVida(88);
        misty.perderVida(63);
        june.perderVida(15);

        listaSaints.ordenarLista(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();
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

        ArrayList<Saint> resultado = lista.getExercitoDeAthena();

        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarComListaApenasUmAscendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));

        listaSaints.adicionarSaint(shun);
        shun.perderVida(30);
        listaSaints.ordenarLista();

        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarComListaDeValoresIguaisAscendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new Saint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);
        listaSaints.ordenarLista();

        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();

        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    //Descendente

    @Test
    public void ordenarComListaTotalmenteDesordenadaDescendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);

        shun.perderVida(30);
        misty.perderVida(70);
        june.perderVida(45);

        listaSaints.ordenarLista(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();

        assertEquals(misty, resultado.get(2));
        assertEquals(june, resultado.get(1));
        assertEquals(shun, resultado.get(0));
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

        shun.perderVida(88);
        misty.perderVida(63);
        june.perderVida(15);

        listaSaints.ordenarLista(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();
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

        ArrayList<Saint> resultado = lista.getExercitoDeAthena();

        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarComListaApenasUmDescendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));

        listaSaints.adicionarSaint(shun);
        shun.perderVida(30);
        listaSaints.ordenarLista();

        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarComListaDeValoresIguaisDescendente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new Saint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));

        listaSaints.adicionarSaint(shun);
        listaSaints.adicionarSaint(misty);
        listaSaints.adicionarSaint(june);
        listaSaints.ordenarLista();

        ArrayList<Saint> resultado = listaSaints.getExercitoDeAthena();

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
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));

        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionarSaint(june);

        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false\n";
        assertEquals(esperado, lista.getCSV());
    }

    @Test
    public void getCSVComApenasDoisSaints() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);

        Saint dohko = new Saint("Dohko", new Armadura(new Constelacao(""), Categoria.OURO));
        dohko.perderVida(90);
        dohko.vestirArmadura();

        lista.adicionarSaint(june);
        lista.adicionarSaint(dohko);

        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false\nDohko,10.0,,OURO,VIVO,NAO_INFORMADO,true\n";
        assertEquals(esperado, lista.getCSV());
    }

}