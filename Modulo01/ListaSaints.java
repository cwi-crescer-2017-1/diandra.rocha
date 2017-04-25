import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaints {

    private ArrayList <Saint> exercitoDeAthena = new ArrayList<>();
    private double maior = 0;
    private double menor = 999;

    public ListaSaints() {
    }

    public ArrayList<Saint> getTodos() {
        return this.exercitoDeAthena;
    }

    public void adicionarSaint(Saint saint) {
        this.exercitoDeAthena.add(saint);
    }

    public Saint getSaint(int indice) {
        return this.exercitoDeAthena.get(indice);
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
        return (ArrayList<Saint>) this.exercitoDeAthena.stream()
        .filter (s -> s.getCategoriaArmadura().equals(categoria))
        .collect(Collectors.toList());
    }

    public ArrayList<Saint> buscarPorStatus(Status status) {
        return (ArrayList<Saint>) this.exercitoDeAthena.stream()
        .filter (s ->  s.getStatus().equals(status))
        .collect(Collectors.toList());
    }

    public Saint getSaintMaiorVida() {
        if(this.exercitoDeAthena.isEmpty()) {
            return null;
        }
        Saint saintMaiorVida = null;
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
        Saint saintMenorVida = null;
        for(Saint s : this.exercitoDeAthena) {
            if(s.getVida() < menor){
                menor = s.getVida();
                saintMenorVida = s;
            }
        }
        return saintMenorVida;
    }

    public void ordenarLista(TipoOrdenacao tipo) {
        boolean ascendente = TipoOrdenacao.ASCENDENTE == tipo;
        boolean posicoesSendoTrocadas;
        
        do{
            posicoesSendoTrocadas = false;
            Saint auxiliar = null;
            for(int p = 0; p < this.exercitoDeAthena.size() -1 ; p ++){
                Saint posicaoA = this.exercitoDeAthena.get(p);
                Saint posicaoP = this.exercitoDeAthena.get(p+1);
                boolean tipoTroca = ascendente ? posicaoA.getVida() > posicaoP.getVida(): posicaoA.getVida() < posicaoP.getVida();

                if(tipoTroca){
                    auxiliar = this.exercitoDeAthena.get(p);
                    this.exercitoDeAthena.set(p, this.exercitoDeAthena.get(p+1));
                    this.exercitoDeAthena.set(p+1, auxiliar);
                    posicoesSendoTrocadas = true;
                }          
            }
        }while(posicoesSendoTrocadas);
    }

    public void ordenarLista() {
        this.ordenarLista(TipoOrdenacao.ASCENDENTE);
    }

    public String getCSV() {
        if(this.exercitoDeAthena.isEmpty()) {
            return "";
        }
        StringBuilder CSV = new StringBuilder(512);

        for(Saint s: this.exercitoDeAthena) {
            CSV.append(s.getCSV());
            CSV.append("\n");
        }
        return CSV.toString();
    }

    public ListaSaints unir(ListaSaints paraUnir) {
        ListaSaints listaFinal = new ListaSaints();
        ArrayList <Saint> arrayParaUnir = paraUnir.getTodos();

        for(Saint s: this.exercitoDeAthena) {
            listaFinal.adicionarSaint(s);
        }
        int index = this.exercitoDeAthena.size();
        int ii = 0;
        for(int i = index; i < index + arrayParaUnir.size(); i++) {
            listaFinal.adicionarSaint(arrayParaUnir.get(ii));
            ii++;
        }
        return listaFinal;
    }

    public ListaSaints diff (ListaSaints paraDiff) {
        ListaSaints listaFinal = new ListaSaints(); 
        ArrayList<Saint> arrayParaDiff = paraDiff.getTodos();
        boolean possuiNaLista = false;

        for(Saint saint1 : this.exercitoDeAthena) {
            for(Saint saint2 : arrayParaDiff) {
                if(saint1.equals(saint2)) {
                    possuiNaLista = true;
                    break;
                }
            }
            if(!possuiNaLista) { 
                listaFinal.adicionarSaint(saint1);
            }
            possuiNaLista = false;
        }
        return listaFinal;
    }

    public ListaSaints intersec (ListaSaints paraIntersec) {
        ListaSaints listaFinal = new ListaSaints(); 
        ArrayList<Saint> arrayParaIntersec = paraIntersec.getTodos();
        boolean possuiNaLista = false;

        for(Saint saint1 : this.exercitoDeAthena) { 
            for(Saint saint2 : arrayParaIntersec) { 
                if(saint1.equals(saint2)) {
                    possuiNaLista = true;
                    break;
                }
            }
            if(possuiNaLista) { 
                listaFinal.adicionarSaint(saint1);
            }
            possuiNaLista = false;
        }
        return listaFinal;
    }
}