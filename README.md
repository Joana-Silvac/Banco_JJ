Nome: Joana da Silva Clemente
Matrícula: 2642043
Disciplina: Projeto de Programação
Professor: Amaury Nogueira

Como executar?
-É necessário dar um fork no repósitorio e possuir uma IDE, clonar esse repositorio na sua maquina com 'git clone' e depois rodar o arquivo main.java

Funcionalidades implementadas

1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
7-Calcular atributo de contas existentes
8-Autenticar gerente
9-sair

A classe Conta é abstrata pq existe 2 tipos de contas,então Conta precisa ser abstrata para ser usada como base para corrente e poupança( e a classe Conta é generico para poder ser extendida ).
Tributável é interface pq a conta corrente vai extender e implementar ela, ela é a base para especializações.
Aqui->'total += t.calcularatributo();' pq t pode ser conta corrente ou qualquer outra coisa que implemente Tributavel.