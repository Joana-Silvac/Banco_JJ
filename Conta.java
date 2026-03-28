

public abstract class Conta {

    protected String titular;
    protected double saldo;
    public static int total_de_contas;


    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        total_de_contas +=1;
        System.out.println("Conta criada com sucesso");




    }

    @Override
    public String toString(){
        return "Titular: " + titular + "\nsaldo: " + saldo;
    }


public void setdepositar(double valor) {
        saldo += valor;
    }
    public void settransferencia(double valor) {
        if(valor>saldo){
            System.out.println("O valor digitado é maior que o saldo");

        }
        else{

            System.out.println("Tranferencia bem sucedida");
        }
    }

    public void setsacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void getsaldo() {
        System.out.println("Saldo: R$ " + saldo);

    }

    public abstract void calculo_rendimento();

    public void exibirDados() {
        System.out.println("Titular: " + titular);

    }
}