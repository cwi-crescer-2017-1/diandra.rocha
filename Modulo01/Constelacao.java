import java.util.ArrayList;

public class Constelacao {

    private String nome;
    private ArrayList <Golpe> golpes= new ArrayList<>();

    public Constelacao(String nome) {
        this.nome = nome;
    }

    public Constelacao(String nome, ArrayList <Golpe> golpes) {
        this.nome = nome;
        this.golpes = golpes;
    }

    public String getNomeConstelacao(){
        return this.nome;
    }

    public ArrayList <Golpe> getGolpes() {
        return this.golpes;
    }

    public void adicionarGolpe(Golpe golpe) {
        this.golpes.add(golpe);
    }

}