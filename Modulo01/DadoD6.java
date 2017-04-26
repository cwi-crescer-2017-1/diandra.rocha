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
        int resultado = this.sortear() % 3;
        return resultado == 33.3;
    }
}
