class CalculadoradeImposto {
    private double total;
    public void registro(Tributavel t){
        total += t.calcularatributo();
    }
    public double gettotal(){
        return total;
    }
}
