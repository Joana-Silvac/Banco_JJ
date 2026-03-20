 class Funcionario implements Autenticavel {
    private String senhafuncionario;
    private String nome;


    public Funcionario(String senhafuncionario, String nome){
        this.nome=nome;
        this.senhafuncionario=senhafuncionario;

    }


     @Override
     public boolean autenticar(String senha) {
         return this.senhafuncionario.equals(senha);


     }


 }
