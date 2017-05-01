public class AtaqueDuploFalso implements Movimento{ 
    Saint golpeador;
    Saint golpeado;
    DadoFalso dadoFalso;
    
    public AtaqueDuploFalso (Saint golpeador, Saint golpeado, DadoFalso dadoFalso) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.dadoFalso = dadoFalso;
    }

    private double preGolpe() throws Exception {

        int dano = this.golpeador.getProximoGolpe().getFatorDano();

        if(golpeador.getArmaduraVestida()) {
            return dano *= this.golpeador.getNivelArmadura() +1;
        }else{
            return dano;
        }
    }

    public void executar() throws Exception {
        
        double dano = this.preGolpe();

        if(this.dadoFalso.chances30PorCento()){
            dano *= 2;
            this.golpeado.perderVida(dano);
         }else{
            this.golpeado.perderVida(dano);
			double perdaGolpeador = (this.golpeador.getVida() * 0.05);
			this.golpeador.perderVida(perdaGolpeador);
        }
    }
}
