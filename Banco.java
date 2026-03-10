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
    public void exibir_lista(){
        for(Conta c:contas){
           c.exibirDados();
        }
    }
}
