class Contapoupanca extends Conta {

    private double taxa = 0.05;

    public Contapoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void calculo_rendimento() {
        double rendimento = saldo * taxa;
        saldo += rendimento;

        System.out.println("Rendimento aplicado: R$ " + rendimento);
    }
}