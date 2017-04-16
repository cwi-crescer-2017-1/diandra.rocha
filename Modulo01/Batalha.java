public class Batalha {
	
    private Saint saint1;
    private Saint saint2;
    
    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
	
    public void iniciar() {
        if (saint1.getNivelArmadura() == saint2.getNivelArmadura() || 
	    saint1.getNivelArmadura() > saint2.getNivelArmadura()) {
            saint2.perderVida(10);
        } else {
            saint1.perderVida(10);	
        }
    }
	
}
