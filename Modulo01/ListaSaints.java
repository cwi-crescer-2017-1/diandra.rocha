import java.util.ArrayList;

public class ListaSaints {

    private ArrayList <Saint> exercitoDeAthena = new ArrayList<>();
    private double maior = 0;
    private double menor = 999;

    public ListaSaints () {
    }

    public ListaSaints (ArrayList<Saint> exercitoDeAthena){
        this.exercitoDeAthena = exercitoDeAthena;
    }

    public ArrayList<Saint> getExercitoDeAthena() {
        return this.exercitoDeAthena;
    }

    public void adicionarSaint(Saint saint) {
        this.exercitoDeAthena.add(saint);
    }

    public Saint getSaint(int indice) {
        return this.exercitoDeAthena.get(indice);
    }

    public void todos() {
        for(Saint s : this.exercitoDeAthena) {
            System.out.println(s.getNome());
        }
    }

    public void remover(Saint saint) {
        this.exercitoDeAthena.remove(saint);
    }

    public Saint buscarPorNome(String nome) {
        for(Saint s : this.exercitoDeAthena) {
            if(s.getNome().equalsIgnoreCase(nome)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
        ArrayList <Saint> sublistaCategoria = new ArrayList<>();
        for(Saint s : this.exercitoDeAthena) {
            if(s.getCategoriaArmadura() == categoria) {
                sublistaCategoria.add(s);
            }
        }
        return sublistaCategoria;
    }

    public ArrayList<Saint> buscarPorStatus(Status status) {
        ArrayList <Saint> sublistaStatus = new ArrayList<>();
        for(Saint s : this.exercitoDeAthena) {
            if(s.getStatus() == status) {
                sublistaStatus.add(s);
            }
        }
        return sublistaStatus;
    }

    public Saint getSaintMaiorVida() {
        Saint saintMaiorVida = new Saint();
        for(Saint s : this.exercitoDeAthena) {
            if(s.getVida() > maior){
                maior = s.getVida();
                saintMaiorVida = s;
            }
        }
        return saintMaiorVida;
    }

    public Saint getSaintMenorVida() {
        Saint saintMenorVida = new Saint();
        for(Saint s : this.exercitoDeAthena) {
            if(s.getVida() < menor){
                menor = s.getVida();
                saintMenorVida = s;
            }
        }
        return saintMenorVida;
    }

    public void ordenarLista(){
        Saint aux = new Saint();

        for(int i = 0; i < this.exercitoDeAthena.size(); i++){
            for(int p = 0; p < this.exercitoDeAthena.size() -1 ; p ++){

                Saint posicaoA = this.exercitoDeAthena.get(p);
                Saint posicaoP = this.exercitoDeAthena.get(p++);
                
                if(posicaoA.getVida() > posicaoP.getVida()){
                    aux = this.exercitoDeAthena.get(p++);
                    this.exercitoDeAthena.set(p++, this.exercitoDeAthena.get(p));
                    this.exercitoDeAthena.set(p, aux);
                }          
            }
        }
    }

}