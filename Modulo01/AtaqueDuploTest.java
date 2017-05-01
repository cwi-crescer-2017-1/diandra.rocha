import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest {

    //Dentro dos 30%
    @Test
    public void perderVidaComGolpeDuploDentroDosTrintaPorCentoSemArmadura() throws Exception{
        SilverSaint moses = new SilverSaint("Moses", "Baleia");
        SilverSaint asterion = new SilverSaint("Asterion", "Cães de Caça");
        DadoFalso oFalso = new DadoFalso(2);

        moses.aprenderGolpe(new Golpe("1 Milhão de Fantasmas", 10));
        Movimento ataque = new AtaqueDuploFalso(moses, asterion, oFalso);

        ataque.executar();

        assertEquals(80, asterion.getVida(), 0.1);
        assertEquals(100, moses.getVida(), 0.1);
    }

    @Test
    public void perderVidaComGolpeDuploDentroDosTrintaPorCentoComArmadura() throws Exception{
        SilverSaint moses = new SilverSaint("Moses", "Baleia");
        SilverSaint asterion = new SilverSaint("Asterion", "Cães de Caça");
        moses.vestirArmadura();

        DadoFalso oFalso = new DadoFalso(2);

        moses.aprenderGolpe(new Golpe("1 Milhão de Fantasmas", 10));
        Movimento ataque = new AtaqueDuploFalso(moses, asterion, oFalso);

        ataque.executar();

        assertEquals(40, asterion.getVida(), 0.1);
        assertEquals(100, moses.getVida(), 0.1);
    }

    //Fora dos 30%
    @Test
    public void perderVidaComGolpeDuploForaDosTrintaPorCentoComArmadura() throws Exception{
        SilverSaint moses = new SilverSaint("Moses", "Baleia");
        SilverSaint asterion = new SilverSaint("Asterion", "Cães de Caça");
        moses.vestirArmadura();

        DadoFalso oFalso = new DadoFalso(5);

        moses.aprenderGolpe(new Golpe("1 Milhão de Fantasmas", 10));
        Movimento ataque = new AtaqueDuploFalso(moses, asterion, oFalso);

        ataque.executar();

        assertEquals(70, asterion.getVida(), 0.1);
        assertEquals(95, moses.getVida(), 0.1);
    }

    @Test
    public void perderVidaComGolpeDuploForaDosTrintaPorCentoSemArmadura() throws Exception{
        SilverSaint moses = new SilverSaint("Moses", "Baleia");
        SilverSaint asterion = new SilverSaint("Asterion", "Cães de Caça");

        DadoFalso oFalso = new DadoFalso(5);

        moses.aprenderGolpe(new Golpe("1 Milhão de Fantasmas", 10));
        Movimento ataque = new AtaqueDuploFalso(moses, asterion, oFalso);

        ataque.executar();

        assertEquals(90, asterion.getVida(), 0.1);
        assertEquals(95, moses.getVida(), 0.1);
    }

}
