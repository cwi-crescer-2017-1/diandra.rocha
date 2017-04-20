import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaints {

    private ArrayList <Saint> exercitoDeAthena = new ArrayList<>();
    private double maior = 0;
    private double menor = 999;

    public ListaSaints() {
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
        /* return this.saints.stream ()
        .filter(s -> s.getNome().equals(nome))
        .findFirst()
        .orElse(null); */
    }

    public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
        /* ArrayList <Saint> sublistaCategoria = new ArrayList<>();
        for(Saint s : this.exercitoDeAthena) {
        if(s.getCategoriaArmadura() == categoria) {
        sublistaCategoria.add(s);
        }
        }
        return sublistaCategoria;*/

        return (ArrayList<Saint>) this.exercitoDeAthena.stream()
        .filter (s -> s.getCategoriaArmadura().equals(categoria))
        .collect(Collectors.toList());
    }

    public ArrayList<Saint> buscarPorStatus(Status status) {
        /* ArrayList <Saint> sublistaStatus = new ArrayList<>();
        for(Saint s : this.exercitoDeAthena) {
        if(s.getStatus() == status) {
        sublistaStatus.add(s);
        }
        }
        return sublistaStatus;*/
        return (ArrayList<Saint>) this.exercitoDeAthena.stream()
        .filter (s ->  s.getStatus().equals(status))
        .collect(Collectors.toList());
    }

    public Saint getSaintMaiorVida() {
        if(this.exercitoDeAthena.isEmpty()) {
            return null;
        }
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
        if(this.exercitoDeAthena.isEmpty()) {
            return null;
        }
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
        boolean posicoesSendoTrocadas;

        do{
            posicoesSendoTrocadas = false;
            for(int p = 0; p < this.exercitoDeAthena.size() -1 ; p ++){
                Saint posicaoA = this.exercitoDeAthena.get(p);
                Saint posicaoP = this.exercitoDeAthena.get(p+1);

                if(posicaoA.getVida() > posicaoP.getVida()){
                    this.exercitoDeAthena.set(p, this.exercitoDeAthena.get(p+1));
                    this.exercitoDeAthena.set(p+1, this.exercitoDeAthena.get(p));
                    posicoesSendoTrocadas = true;
                }          

            }
        }while(posicoesSendoTrocadas);
    }

    public void ordenarLista(TipoOrdenacao tipo) {
        
        if(tipo == TipoOrdenacao.ASCENDENTE) {
            this.ordenarLista();
        } else {
            boolean posicoesSendoTrocadas;
            do{
                posicoesSendoTrocadas = false;
                Saint auxiliar = new Saint();
                for(int p = 0; p < this.exercitoDeAthena.size() -1 ; p ++){
                    Saint posicaoA = this.exercitoDeAthena.get(p);
                    Saint posicaoP = this.exercitoDeAthena.get(p+1);

                    if(posicaoA.getVida() < posicaoP.getVida()){
                        auxiliar = this.exercitoDeAthena.get(p);
                        this.exercitoDeAthena.set(p, this.exercitoDeAthena.get(p+1));
                        this.exercitoDeAthena.set(p+1, auxiliar);
                        posicoesSendoTrocadas = true;
                    }          

                }
            }while(posicoesSendoTrocadas);

        }
    }
    
    public String getCSV() {
        String CSV = new String();
        for(Saint s : this.exercitoDeAthena) {
            CSV += s.getCSV() + "\n";
        }
        return CSV;
    }
}