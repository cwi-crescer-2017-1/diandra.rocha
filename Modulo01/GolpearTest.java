import static org.junit.Assert.*;
import org.junit.Test;

public class GolpearTest {

    @Test
    public void executarRetornaCorretamenteOFatorDeDanoTotal100ComArmadura() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");
        Movimento armaduraVestida = new VestirArmadura(algol);
        armaduraVestida.executar();

        Golpear golpe = new Golpear (algol, babel);
        algol.aprenderGolpe(new Golpe("Teste", 1100));

        golpe.executar();

        assertEquals(0, babel.getVida(), 0.1);
    }

    @Test
    public void executarRetornaCorretamenteOFatorDeDanoTotal100SemArmadura() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");

        Golpear golpe = new Golpear (algol, babel);
        algol.aprenderGolpe(new Golpe("Teste", 1100));

        golpe.executar();

        assertEquals(0, babel.getVida(), 0.1);
    }

    @Test
    public void golpearSilverComArmaduraVestida() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");
        Movimento armaduraVestida = new VestirArmadura(algol);
        armaduraVestida.executar();

        Golpear golpe = new Golpear (algol, babel);
        algol.aprenderGolpe(new Golpe("Teste", 10));

        golpe.executar();

        assertEquals(70, babel.getVida(), 0.1);
    }

    @Test
    public void golpearSilverSemArmaduraVestida() throws Exception {
        SilverSaint algol = new SilverSaint("Algol", "Perseu");
        SilverSaint babel = new SilverSaint("Babel", "Centauro");

        Golpear golpe = new Golpear (algol, babel);
        algol.aprenderGolpe(new Golpe("Teste", 10));

        golpe.executar();

        assertEquals(90, babel.getVida(), 0.1);
    }

    @Test
    public void golpearBronzeComArmadura() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        Movimento armaduraVestida = new VestirArmadura(june);
        armaduraVestida.executar();

        Golpear golpe = new Golpear (june, shun);
        june.aprenderGolpe(new Golpe("Teste", 40));

        golpe.executar();

        assertEquals(20, shun.getVida(), 0.1);

    }

    @Test
    public void golpearBronzeSemArmadura() throws Exception {
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");

        Golpear golpe = new Golpear (june, shun);
        june.aprenderGolpe(new Golpe("Teste", 40));

        golpe.executar();

        assertEquals(60, shun.getVida(), 0.1);
    }

    @Test
    public void golpearOuroComArmadura() throws Exception {
        GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
        GoldSaint aphrodite = new GoldSaint("Aphrodite", "Peixes");
        Movimento armaduraVestida = new VestirArmadura(saga);
        armaduraVestida.executar();

        Golpear golpe = new Golpear (saga, aphrodite);
        saga.aprenderGolpe(new Golpe("Teste", 10));

        golpe.executar();

        assertEquals(60, aphrodite.getVida(), 0.1);

    }

    @Test
    public void golpearOuroSemArmadura() throws Exception {
        GoldSaint saga = new GoldSaint("Saga", "Gêmeos");
        GoldSaint aphrodite = new GoldSaint("Aphrodite", "Peixes");

        Golpear golpe = new Golpear (saga, aphrodite);
        saga.aprenderGolpe(new Golpe("Teste", 80));

        golpe.executar();

        assertEquals(20, aphrodite.getVida(), 0.1);
    }

    @Test(expected=ArithmeticException.class)
    public void naoGolpear() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");

        Movimento golpear = new Golpear(aldebaran, seiya);

        golpear.executar();
    }
}