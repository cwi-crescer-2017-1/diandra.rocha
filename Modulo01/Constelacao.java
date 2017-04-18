public class Constelacao {
    
    private String nome;
    private Golpe [] golpes = new Golpe[3];
    
    public Constelacao(String nome) {
        this.nome = nome;
    }
    
    public Constelacao (Golpe [] golpes) {
        this.golpes = golpes;
    }
    
     public Constelacao(String nome, Golpe [] golpes ) {
        this.nome = nome;
        this.golpes = golpes;
    }
    
    public String getNomeConstelacao(){
        return this.nome;
    }
    
    public void adicionarGolpe(Golpe golpe) {
        golpes[2] = golpe;
    }
    
    public Golpe [] getGolpes() {
        return this.golpes;
    }
    
}