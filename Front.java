import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Front {
    public Front(Banco banco){
        JFrame janela_principal = new JFrame();
        JFrame janela_criar = new JFrame();
        JFrame janela_deposito = new JFrame();


        Gerente gerente= new Gerente("Eduardo Silva","senha_245");


        Scanner entrada= new Scanner(System.in);

        janela_principal.setBounds(400, 100, 730, 460);
        janela_principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela_principal.setLayout(null);
        janela_principal.setVisible(true);

        JLabel nome_principal = new JLabel("Banco_JJ");
        nome_principal.setBounds(215,30,600,70);
        nome_principal.setForeground(Color.black);
        nome_principal.setFont(new Font("Arial",Font.BOLD,56));
        janela_principal.add(nome_principal);

        JButton criar = new JButton("1 - Criar conta");
        criar.setFocusPainted(false);
        criar.setBounds(50, 110, 250, 45);
        janela_principal.add(criar);

        criar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela_principal.setVisible(false);

                janela_criar.setBounds(400, 100, 730, 460);
                janela_criar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela_criar.setLayout(null);
                janela_criar.setVisible(true);

                JLabel Titular = new JLabel("Nome do Titular:");
                Titular.setBounds(50,30,300,70);
                Titular.setForeground(Color.black);
                Titular.setFont(new Font("Arial",Font.BOLD,30));
                janela_criar.add(Titular);

                JTextField titular_usuario = new JTextField();
                titular_usuario.setBounds(50,100,400,35);
                janela_criar.add(titular_usuario);

                JLabel saldo_nome = new JLabel("Saldo inicial:");
                saldo_nome.setBounds(50,140,200,70);
                saldo_nome.setForeground(Color.black);
                saldo_nome.setFont(new Font("Arial",Font.BOLD,30));
                janela_criar.add(saldo_nome);

                JTextField saldo_inicial = new JTextField();
                saldo_inicial.setBounds(50,210,400,35);
                janela_criar.add(saldo_inicial);

                JButton botao_corrente =new JButton("Conta corrente");
                botao_corrente.setFocusPainted(false);
                botao_corrente.setBounds(50,340,130,25);
                janela_criar.add(botao_corrente);

                JButton botao_poupanca =new JButton("Conta poupança");
                botao_poupanca.setFocusPainted(false);
                botao_poupanca.setBounds(200,340,130,25);
                janela_criar.add(botao_poupanca);

                botao_poupanca.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nome = titular_usuario.getText();
                        double saldo = Double.parseDouble(saldo_inicial.getText());


                        Conta resposta= new Contapoupanca(nome,saldo);
                        banco.adicionar_contas(resposta);

                        JOptionPane.showMessageDialog(janela_criar,
                                "Conta poupança criada");

                        janela_criar.setVisible(false);
                        janela_principal.setVisible(true);

                        titular_usuario.setText("");
                        saldo_inicial.setText("");
                    }
                });

                botao_corrente.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nome = titular_usuario.getText();
                        double saldo = Double.parseDouble(saldo_inicial.getText());


                        Conta resposta= new Contacorrente(nome,saldo);
                        banco.adicionar_contas(resposta);

                        JOptionPane.showMessageDialog(janela_criar,
                                "Conta corrente criada");

                        janela_criar.setVisible(false);
                        janela_principal.setVisible(true);

                        titular_usuario.setText("");
                        saldo_inicial.setText("");




                    }
                });


            }
        });

        JButton Listar = new JButton("2- Listar contas");
        Listar.setFocusPainted(false);
        Listar.setBounds(50, 160, 250, 45);
        janela_principal.add(Listar);

        Listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String lista = banco.exibir_lista();

                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhuma conta cadastrada.");
                } else {
                    JOptionPane.showMessageDialog(null, lista);
                }

            }
        });

        JButton deposito = new JButton("3- Depositar");
        deposito.setFocusPainted(false);
        deposito.setBounds(50, 212, 250, 45);
        janela_principal.add(deposito);


        deposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela_principal.setVisible(false);

                janela_deposito.setBounds(400, 100, 730, 460);
                janela_deposito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela_deposito.setLayout(null);
                janela_deposito.setVisible(true);

                int y=30;

                for (Conta c: banco.contas){
                    JButton botao= new JButton(c.titular+" saldo: "+ c.saldo);
                    botao.setBounds(50, y, 250, 45);
                    janela_deposito.add(botao);
                    y=y+50;

                    botao.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            janela_deposito.getContentPane().removeAll();

                            JLabel valor_nome = new JLabel("Quanto deseja depositar?");
                            valor_nome.setBounds(50,110,350,70);
                            valor_nome.setForeground(Color.black);
                            valor_nome.setFont(new Font("Arial",Font.BOLD,25));
                            janela_deposito.add(valor_nome);

                            JTextField valor = new JTextField();
                            valor.setBounds(50,200,400,35);
                            janela_deposito.add(valor);

                            JButton depositar = new JButton("Depositar");
                            depositar.setFocusPainted(false);
                            depositar.setBounds(50, 255, 200, 40);
                            janela_deposito.add(depositar);

                            depositar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    double valorreal = Double.parseDouble(valor.getText());
                                    try {
                                        c.setdepositar(valorreal);
                                        janela_deposito.getContentPane().removeAll();
                                        JOptionPane.showMessageDialog(null, "Depósito realizado!");
                                        janela_deposito.setVisible(false);
                                        janela_principal.setVisible(true);
                                    }
                                    catch (Exception ex){
                                        JOptionPane.showMessageDialog(null, "Valor invalido");

                                    }


                                }
                            });


                        }
                    });

                }



            }
        });

    }
}
