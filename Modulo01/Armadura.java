public class Armadura {
	
    private String constelacao;
    private Categoria categoria;
    
    public Armadura(String constelacao, Categoria categoria) {
        this.constelacao = constelacao;
        this.categoria = categoria;
    }
	
	public String getConstelacao() {
		return this.constelacao;
	}
    
    public Categoria getCategoria() {
        return this.categoria;
    }
	
}