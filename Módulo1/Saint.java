public class Saint{
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    
    public Saint(String nome, Armadura armadura){
        this.nome = nome;
        this.armadura = armadura; 
    }
    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
    
    //camelCase aAA
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }
    public Armadura getArmadura(){
        return this.armadura;
    }
    
    public Genero getGenero(){
        return this.genero;
    }
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    
    public Status getStatus(){
        return this.status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public double getVida(){
        return this.vida;
    }
    public void perderVida(double perda){
        this.vida = this.vida - perda;
    }
    
    
}
