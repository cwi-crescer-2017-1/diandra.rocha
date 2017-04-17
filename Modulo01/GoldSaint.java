public class GoldSaint extends Saint {
    
     public GoldSaint (String nome, Armadura armadura) throws Exception {
        super(nome, armadura);
        
         
            this.qtdSentidosDespertados = 7;
            String constelacao = armadura.getConstelacao();
            if ( !constelacao.equals("Áries") && !constelacao.equals("Touro") && !constelacao.equals("Escorpião") 
            && !constelacao.equals("Virgem")
            && !constelacao.equals("Peixes")
            && !constelacao.equals("Câncer")
            ) {
                // dar erro
                throw new Exception("Constelação inválida");
            
        } 
    }
}