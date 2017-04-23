public class Golpear implements Movimento{

    private Saint golpeador;
    private Saint golpeado;

    public Golpear (Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar() throws Exception {

        if(golpeador.getArmaduraVestida() == true){
            int nivelGolpeador = this.golpeador.getNivelArmadura() +1;
            double dano = this.golpeador.getProximoGolpe().getFatorDano() * nivelGolpeador;
            this.golpeado.perderVida(dano);
        }else{
            double dano = this.golpeador.getProximoGolpe().getFatorDano();
            this.golpeado.perderVida(dano);
        }
    }
}