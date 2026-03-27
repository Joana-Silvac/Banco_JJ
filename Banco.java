import java.util.ArrayList;

public class Banco {
    public ArrayList<Conta> contas = new ArrayList<>();

    public void adicionar_contas(Conta conta_nova){
        contas.add(conta_nova);

    }

    public Conta Procurar_conta(String nome){

        for(Conta n:contas) {
            if (n.titular.equals(nome)) {
                return n;

            }
        }
            return null;

    }

    public String exibir_lista() {
        StringBuilder lista = new StringBuilder();

        for(Conta c:contas){
            lista.append(c.toString()).append("\n\n");
        }

        return lista.toString();
    }
}
