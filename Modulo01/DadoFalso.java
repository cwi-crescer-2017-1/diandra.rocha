import java.util.Random;

public class DadoFalso  implements Sorteador {
    double numeroResultado;
    
    public DadoFalso(double numeroResultado) {
        this.numeroResultado = numeroResultado;
    }
    
    public int sortear() {
        return (int) this.numeroResultado;
    }
    
    public boolean chances30PorCento() {
        double resultado = (this.numeroResultado/6) * 100;
        return resultado <= 34;
    }

}