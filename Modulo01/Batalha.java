public class Batalha {

    private Saint saint1;
    private Saint saint2;
    private double dano = 10;

    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar() throws Exception{
        Golpear batalha;
        do{
            if (saint1.getNivelArmadura() >= saint2.getNivelArmadura()) {
                batalha = new Golpear(this.saint1, this.saint2);
                batalha.executar();
            } else {
                batalha = new Golpear(this.saint2, this.saint1);
                batalha.executar();
            }
        }while(this.saint1.getVida()<0 && this.saint1.getStatus()!= Status.MORTO
        ||this.saint2.getVida()<0 && this.saint2.getStatus()!= Status.MORTO);
    }
}