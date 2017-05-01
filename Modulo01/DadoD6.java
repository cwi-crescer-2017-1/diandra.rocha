import java.util.Random;

public class DadoD6 implements Sorteador {
    
    public DadoD6() {
    }

    public int sortear() {
        final Random random = new Random();
        final int min = 1, max = 6;
        return random.nextInt(max - min + 1) + min;
    }
    
    public boolean chances30PorCento() {
        double resultado = (this.sortear()/6) * 100;
        return resultado <= 33.3;
    }
}
