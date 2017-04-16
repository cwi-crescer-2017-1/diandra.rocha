public class Saint {

    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;

    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
    }

    public void vestirArmadura() {
        this.armaduraVestida = true;
    }

    public boolean getArmaduraVestida() {
        return this.armaduraVestida;
    }

    public Armadura getArmadura() {
        return this.armadura;
    }

    public Categoria getCategoriaArmadura() {
        return this.getArmadura().getCategoria();
    }

    public int getNivelArmadura() {
        return this.getArmadura().getCategoria().getValor();
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Status getStatus() {
        return this.status;
    }

    public double getVida() {
        return this.vida;
    }

    public void perderVida(double perda) {
        this.vida = this.vida - perda;
    }

}