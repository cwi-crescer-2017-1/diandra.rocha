import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import java.security.InvalidParameterException; 

public class SaintTest {

    //vestirArmadura

    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        GoldSaint milo = new GoldSaint ("Milo", "Escorpião");

        milo.vestirArmadura();

        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true,resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", "Cisne");

        assertEquals(false, hyoga.getArmaduraVestida());
    }

    //saintGenero
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        GoldSaint shaka = new GoldSaint("Shaka", "Virgem");

        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        BronzeSaint jabu = new BronzeSaint("Jabu", "Unicórnio");
        jabu.setGenero(Genero.MASCULINO);

        assertEquals(Genero.MASCULINO, jabu.getGenero());

        jabu.setGenero(Genero.FEMININO);

        assertEquals(Genero.FEMININO, jabu.getGenero());
    }

    //criarSaintStatus
    @Test
    public void aoCriarSaintStatusEVivo() throws Exception {
        GoldSaint camus = new GoldSaint ("Camus", "Aquário");

        assertEquals(Status.VIVO, camus.getStatus());
    }

    //Categoria
    @Test
    public void verificarCategoriaSaint() throws Exception {
        SilverSaint shaina = new SilverSaint("Shaina", "Serpentário");

        int nivelArmaduraSaint = shaina.getNivelArmadura();
        Categoria categoriaArmaduraSaint = shaina.getCategoriaArmadura();

        assertEquals(2, nivelArmaduraSaint);
        assertEquals(Categoria.PRATA, categoriaArmaduraSaint);
    } 

    //vidaInicial
    @Test
    public void vidaInicialDeveSer100() throws Exception {
        BronzeSaint shiryu = new BronzeSaint("Shiryu", "Dragão");
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    //perderVida

    @Test
    public void aoPerderVidaSubtraiDezDeVida() throws Exception {
        GoldSaint saintTest = new GoldSaint("Aphrodite", "Peixes");

        saintTest.perderVida(10);

        assertEquals(90 , saintTest.getVida(), 0.1);    
    }

    @Test
    public void aoPerderVidaComDano100VidaFica0EStatusMorto() throws Exception {
        BronzeSaint shiryu = new BronzeSaint("Shiryu", "Dragão");

        shiryu.perderVida(100);

        assertEquals(0, shiryu.getVida(), 0.01);
        assertEquals(Status.MORTO, shiryu.getStatus());
    }

    @Test
    public void aoPerderVidaComDano1000VidaFica0EStatusMorto() throws Exception {
        GoldSaint aphrodite = new GoldSaint("Aphrodite", "Peixes");

        aphrodite.perderVida(1000);

        assertEquals(0 , aphrodite.getVida(), 0.1);
        assertEquals(Status.MORTO, aphrodite.getStatus());
    }

    @Test (expected=InvalidParameterException.class)
    public void aoPerderVidaComDanoNegativoLancaErro() throws Exception {
        GoldSaint aphrodite = new GoldSaint("Aphrodite", "Peixes");

        aphrodite.perderVida(-1000);
    }

    //sentidosDespertados

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", "Pégasu");

        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintNasceCom6SentidosDespertados() throws Exception {
        SilverSaint marin = new SilverSaint("Marin", "Águia");

        assertEquals(6, marin.getQtdSentidosDespertados());

    }

    @Test
    public void criarSaintNasceCom7SentidosDespertados() throws Exception {
        GoldSaint aldebaran = new GoldSaint("Aldebaran", "Touro");

        assertEquals(7, aldebaran.getQtdSentidosDespertados());
    }

    //Constelacao
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", "Café");
    }

    //aprenderGolpe

    @Test
    public void aprenderUmGolpe() throws Exception {
        GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        ArrayList <Golpe> golpes = saga.getGolpes();

        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));

        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(1, golpes.size());
    }

    @Test
    public void aprenderDoisGolpes() throws Exception {
        GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        ArrayList <Golpe> golpes = saga.getGolpes();

        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);

        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(2, golpes.size());
    }

    //getProximoGolpe

    @Test
    public void getProximoGolpeComUm() throws Exception {
        GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);

        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));

        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComDois() throws Exception {
        GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);

        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);

        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComTresChamadas() throws Exception {
        GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);

        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);

        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }

    //getCSVSaint

    @Test
    public void retornaOCSVDeSaint() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");

        String CSVresultado = june.getCSV();

        String CSV = "June,100.0,Camaleão,BRONZE,VIVO,NAO_INFORMADO,false";

        assertEquals(CSV, CSVresultado);
    }

    @Test
    public void getCSVComNomeNulo() throws Exception {
        BronzeSaint june = new BronzeSaint(null, "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);

        String esperado = "null,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";

        assertEquals(esperado, june.getCSV());
    }

    @Test
    public void getCSVComVidaZeroEStatusMorto() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(100);

        String esperado = "June,0.0,Camaleão,BRONZE,MORTO,FEMININO,false";

        assertEquals(esperado, june.getCSV());
    }

    @Test
    public void getCSVComConstelacaoSemNomeENomeNull() throws Exception {
        BronzeSaint june = new BronzeSaint(null, "");
        june.setGenero(Genero.FEMININO);
        june.perderVida(100);

        String esperado = "null,0.0,,BRONZE,MORTO,FEMININO,false";

        assertEquals(esperado, june.getCSV());
    }

    @Test
    public void vestirArmaduraUtilizandoClasse() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Movimento vestir = new VestirArmadura(june);

        vestir.executar();

        assertEquals(true, june.getArmaduraVestida());
    }
}