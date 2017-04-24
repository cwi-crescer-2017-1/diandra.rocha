public class Golpear implements Movimento{

    private Saint golpeador;
    private Saint golpeado;

    public Golpear (Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar() throws Exception {
        double dano = this.golpeador.getProximoGolpe().getFatorDano();

        if(golpeador.getArmaduraVestida()){
            dano *= this.golpeador.getNivelArmadura() +1;
            this.golpeado.perderVida(dano);
        }else{
            this.golpeado.perderVida(dano);
        }
    }
    
    public boolean equals(Object object) {
        Golpear outroGolpear = (Golpear)object;        

        return 
        this.golpeador.equals(outroGolpear.golpeador) && this.golpeado.equals(outroGolpear.golpeado);
    }
}