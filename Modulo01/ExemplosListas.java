import java.util.ArrayList;

public class ExemplosListas {
    public void rodar() {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Bernardo");
        nomes.add("André Nunes");

        System.out.println("For");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println( nomes.get(i) );
        }

        System.out.println("While");
        int i = 0;
        while (i < nomes.size()) {
            System.out.println( nomes.get(i) );
            i++;
        }

        System.out.println("Do-While");
        // nomes.clear();
        int x = 0;
        do {
            System.out.println( nomes.get(x) );
            x++;
        } while (x < nomes.size());

        System.out.println("Iterator");
        for (String nome : nomes) {
            System.out.println(nome);            
        }
    }
}