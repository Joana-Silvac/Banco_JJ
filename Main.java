import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        new Front(banco);


        Gerente gerente= new Gerente("Eduardo Silva","senha_245");

        Scanner entrada= new Scanner(System.in);
        while(true){
            System.out.println("- BANCO JAVA -\n" +
                    "\n" +
                    "1 - Criar conta\n" +
                    "2 - Listar contas\n" +
                    "3 - Depositar\n" +
                    "4 - Sacar\n" +
                    "5 - Transferir\n" +
                    "6 - Consultar saldo\n" +
                    "7 - Calcular atributo de contas correntes\n"+
                    "8 - Autenticar gerente"+"\n"+
                    "9 - sair"+"\n"+
                    "Escolha uma opção:");

            int n= entrada.nextInt();

            if (n==1){
                System.out.println("Nome do Titular: ");
                entrada.nextLine();

                String nome= entrada.nextLine();

                System.out.println("Saldo inicial? ");

                double saldo_de_inicio= entrada.nextDouble();

                System.out.println("Conta corrente(1) ou Conta de poupança?(2) ");

                int opcao= entrada.nextInt();

                Conta resposta= (opcao==1)? new Contacorrente(nome,saldo_de_inicio):new Contapoupanca(nome,saldo_de_inicio);
                banco.adicionar_contas(resposta);
            }


            else if (n==2){
                banco.exibir_lista();
            }

            else if(n==3) {
                System.out.println("Em qual das contas abaixo o senhor/a deseja depositar?(Digite o nome do titular)");
                banco.exibir_lista();
                entrada.nextLine();
                String nome_titular = entrada.nextLine();
                Conta conta = banco.Procurar_conta(nome_titular);
                if (conta != null) {
                    System.out.println("Digite o vaor que deseja depositar: ");
                    entrada.nextLine();
                    double valor = entrada.nextDouble();
                    conta.setdepositar(valor);
                }
                else {
                    System.out.println("Conta não encontrada");
                }
            }
                else if(n==4){
                    System.out.println("Em qual das contas abaixo o senhor/a deseja sacar?(Digite o nome do titular)");
                    banco.exibir_lista();
                    entrada.nextLine();
                    String nome_titular = entrada.nextLine();
                    Conta conta=banco.Procurar_conta(nome_titular);
                    if(conta!=null){
                        System.out.println("Digite o valor que deseja sacar: ");
                        entrada.nextLine();
                        double valor= entrada.nextDouble();
                        conta.setsacar(valor);
                    }
                    else {
                        System.out.println("Conta não encontrada");
                    }
                }
            else if(n==5){
                System.out.println("Em qual das contas abaixo o senhor/a deseja fazer a transferência?(Digite o nome do titular)");
                banco.exibir_lista();
                entrada.nextLine();
                String nome_titular = entrada.nextLine();
                Conta conta=banco.Procurar_conta(nome_titular);
                if(conta!=null){
                    System.out.println("Para quem o senhor/a deseja tranferir o dinheiro?");
                    entrada.nextLine();
                    String pessoa_que_vai_receber= entrada.nextLine();
                    System.out.println("Digite o valor que deseja tranferir: ");
                    entrada.nextLine();
                    double valor= entrada.nextDouble();
                    conta.settransferencia(valor);
                }
                else {
                    System.out.println("Conta não encontrada");
                }
            }
            else if(n==6){
                System.out.println("Em qual das contas abaixo o senhor/a deseja fazer a transferência?(Digite o nome do titular)");
                banco.exibir_lista();
                entrada.nextLine();
                String nome_titular = entrada.nextLine();
                Conta conta=banco.Procurar_conta(nome_titular);
                if(conta!=null){

                    conta.getsaldo();


                }
                else {
                    System.out.println("Conta não encontrada");
                }

            }

            else if(n==7){
                CalculadoradeImposto calc = new CalculadoradeImposto();

                for (Conta continha : banco.contas) {
                    if (continha instanceof Tributavel) {
                        calc.registro((Tributavel) continha);}
                }

                System.out.println("Total de tributos: " + calc.gettotal());
            }

            else if(n==8){
                System.out.print("Digite a senha do gerente: ");
                entrada.nextLine();
                String senhafuncionario = entrada.nextLine();

                if (gerente.autenticar(senhafuncionario)) {
                    System.out.println("acesso liberado");
                } else {
                    System.out.println("acesso negado");
                }
            }

            else if(n==9){
                System.out.println("Até a próxima!");
                break;
            }
            else {
                System.out.println("Opção não encontrada,pfvr digite um número dentre as opções.");
            }




        }


    }
}
