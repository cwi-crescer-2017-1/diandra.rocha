public class Saint {

    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;

    public Saint(String nome, Armadura armadura) throws Exception {
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

    public int getQtdSentidosDespertados() {
        return this.qtdSentidosDespertados;
    }

    public void perderVida(double perda) throws Exception {
        if(perda < 0) {
            throw new Exception("InvalidParameterException");
        }
        if(this.vida<1 || perda>=this.vida) {
            this.status = Status.MORTO;
            this.vida = 0;
        }else{
            this.vida-=perda;
        }
    }
    
    public void getGolpes() {
        Golpe [] golpesArmaduraSaint = this.getArmadura().getConstelacao().getGolpes();
        for(int i = 0; i<5; i++){
            System.out.println(golpesArmaduraSaint[i]);
        }
    }
    
    public void aprenderGolpe(Golpe golpe) {
        Constelacao constelacaoSaint = this.getArmadura().getConstelacao();
        constelacaoSaint.adicionarGolpe(golpe);
    }
    
    public void getProximoGolpe() {
        for(int i = 0; i<5; i++){
            Golpe [] golpesArmaduraSaint = this.getArmadura().getConstelacao().getGolpes();
            System.out.println(golpesArmaduraSaint[i]);
            if(i==4) {
                i = 0;
            }
        }
    }
}