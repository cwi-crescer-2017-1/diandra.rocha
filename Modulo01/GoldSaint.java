public class GoldSaint extends Saint {

    public GoldSaint(String nome, String constelacao) throws Exception {
        this(nome, new Armadura(new Constelacao(constelacao), Categoria.OURO));
    }

    public GoldSaint(String nome, Armadura armadura) throws Exception {
        super(nome, armadura);
        this.qtdSentidosDespertados = 7;

        String constelacao = armadura.getConstelacao().getNomeConstelacao();
        if (!constelacao.equals("Áries") 
        && !constelacao.equals("Touro")
        && !constelacao.equals("Gêmeos")
        && !constelacao.equals("Câncer")
        && !constelacao.equals("Virgem")
        && !constelacao.equals("Leão")
        && !constelacao.equals("Libra")
        && !constelacao.equals("Escorpião")
        && !constelacao.equals("Sagitário")
        && !constelacao.equals("Capricórnio")
        && !constelacao.equals("Aquário")
        && !constelacao.equals("Peixes") ) {

            throw new Exception("Constelação inválida");
        }
    }
}