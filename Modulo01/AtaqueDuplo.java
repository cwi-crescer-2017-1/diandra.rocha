public class AtaqueDuplo implements Movimento{
    Saint golpeador;
    Saint golpeado;
    
    public void preGolpe() throws Exception{
        
        int dano = this.golpeador.getProximoGolpe().getFatorDano();
        
        if(golpeador.getArmaduraVestida()) {
            dano *= this.golpeador.getNivelArmadura() +1;
        }
             this.golpeado.perderVida(dano);
        
    }

    public void executar() throws Exception {

        DadoD6 random = new DadoD6();
        
        if(random.chances30PorCento()){
           /*preGolpe*/
        }
    }
}
