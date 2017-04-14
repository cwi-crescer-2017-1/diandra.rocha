public class Batalha{
    private Saint number1;
    private Saint number2;
    
    public Batalha(Saint number1, Saint number2){
        this.number1 = number1;
        this.number2 = number2;
    }
    
    public void iniciar(){
        int nivelArmaduraN1 = number1.getArmadura().getCategoria().getValor();
        int nivelArmaduraN2 =  number2.getArmadura().getCategoria().getValor();
        
        if(nivelArmaduraN1 == nivelArmaduraN2){
            number1.perderVida(10);
            }
        if(nivelArmaduraN1 > nivelArmaduraN2){
            number2.perderVida(10);
        }
        if(nivelArmaduraN1 < nivelArmaduraN2){
                number1.perderVida(10);
        }
        }
    }
