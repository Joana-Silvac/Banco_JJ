class Contacorrente extends Conta implements Tributavel{

    private double taxa = 20.0;

    public Contacorrente(String titular, double saldoInicial) {

        super(titular, saldoInicial);
    }

    @Override
    public void calculo_rendimento() {
        saldo -= taxa;
        System.out.println("Taxa que foi descontada: R$ " + taxa);
        System.out.println("Você possui um saldo de R$"+saldo+ "reais");
    }

    @Override
    public double calcularatributo() {
        return 0;
    }
}

