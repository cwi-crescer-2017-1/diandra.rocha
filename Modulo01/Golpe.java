public class Golpe{

    private String nome;
    private double fatorDano;

    public Golpe(String nome, double fatorDano) {
        this.nome = nome;
        this.fatorDano = fatorDano;
    }

    public String getNome() {
        return this.nome;
    }

    public double getFatorDano() {
        return this.fatorDano;
    }

    public boolean equals(Object object) {
        Golpe outroGolpe = (Golpe)object;        

        return 
        this.nome.equals(outroGolpe.nome)
        && this.fatorDano == outroGolpe.fatorDano;
    }
}