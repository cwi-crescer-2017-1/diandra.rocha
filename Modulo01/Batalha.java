public class Batalha {

    private Saint saint1;
    private Saint saint2;
    private double dano = 10;

    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar() throws Exception {

        int valor1 = this.saint1.getNivelArmadura();
        int valor2 = this.saint2.getNivelArmadura();
        final double dano = 10;
        Saint saintEmAcao = null;

        if (valor1 >= valor2) {
            saintEmAcao = this.saint1;
            this.saint2.perderVida(dano);
        } else {
            saintEmAcao = this.saint2;
            this.saint1.perderVida(dano);
        }

        boolean nenhumMorto = true;
        while (nenhumMorto) {

            saintEmAcao = saintEmAcao == this.saint1 ? this.saint2 : this.saint1;

            Movimento proximoMovimento = saintEmAcao.getProximoMovimento();
            proximoMovimento.executar();

            nenhumMorto = this.saint1.getStatus() != Status.MORTO && this.saint1.getVida() >0 &&
            this.saint2.getStatus() != Status.MORTO && this.saint2.getVida()>0;
        }
    }
}