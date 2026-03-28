import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Front {
    public Front(Banco banco){
        JFrame janela_principal = new JFrame();
        JFrame janela_criar = new JFrame();
        JFrame janela_deposito = new JFrame();
        JFrame janela_saque= new JFrame();
        JFrame janela_tranferencia= new JFrame();
        JFrame janela_saldo= new JFrame();
        JFrame janela_autenticar=new JFrame();



        Gerente gerente= new Gerente("Eduardo Silva","senha_245");



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
        criar.setBounds(70, 110, 250, 45);
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
        Listar.setBounds(70, 160, 250, 45);
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
        deposito.setBounds(70, 212, 250, 45);
        janela_principal.add(deposito);


        deposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela_principal.setVisible(false);

                janela_deposito.setBounds(400, 100, 730, 460);
                janela_deposito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela_deposito.setLayout(null);
                janela_deposito.setVisible(true);

                if(banco.contas.isEmpty()){

                    JOptionPane.showMessageDialog(null, "Nenhuma conta existente");
                    janela_deposito.setVisible(false);
                    janela_principal.setVisible(true);


                }

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

                                    if (valorreal<0){
                                        JOptionPane.showMessageDialog(null, "Não pode depositar valores menores que zero");
                                        janela_deposito.setVisible(false);
                                        janela_principal.setVisible(true);

                                    }
                                    else{
                                        c.setdepositar(valorreal);

                                        JOptionPane.showMessageDialog(null, "Deposito realizado!");
                                        janela_deposito.setVisible(false);
                                        janela_principal.setVisible(true);


                                    }


                                }
                            });


                        }
                    });

                }



            }
        });
        JButton Saque = new JButton("4- Sacar");
        Saque.setFocusPainted(false);
        Saque.setBounds(70, 262, 250, 45);
        janela_principal.add(Saque);

        Saque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela_principal.setVisible(false);

                janela_saque.setBounds(400, 100, 730, 460);
                janela_saque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela_saque.setLayout(null);
                janela_saque.setVisible(true);

                if(banco.contas.isEmpty()){

                    JOptionPane.showMessageDialog(null, "Nenhuma conta existente");
                    janela_saque.setVisible(false);
                    janela_principal.setVisible(true);


                }

                int y=30;

                for (Conta c: banco.contas) {
                    JButton botao = new JButton(c.titular + " saldo: " + c.saldo);
                    botao.setBounds(50, y, 250, 45);
                    janela_saque.add(botao);
                    y = y + 50;

                    botao.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            janela_saque.getContentPane().removeAll();
                            JLabel valor_nome = new JLabel("Quanto deseja sacar");
                            valor_nome.setBounds(50,110,350,70);
                            valor_nome.setForeground(Color.black);
                            valor_nome.setFont(new Font("Arial",Font.BOLD,25));
                            janela_saque.add(valor_nome);

                            JTextField valor = new JTextField();
                            valor.setBounds(50,200,400,35);
                            janela_saque.add(valor);

                            JButton sacar = new JButton("Sacar");
                            sacar.setFocusPainted(false);
                            sacar.setBounds(50, 255, 200, 40);
                            janela_saque.add(sacar);

                            sacar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    double valorreal = Double.parseDouble(valor.getText());

                                    if (valorreal>c.saldo){
                                        JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                                        janela_saque.setVisible(false);
                                        janela_principal.setVisible(true);

                                    }
                                    else{
                                        c.setsacar(valorreal);

                                        JOptionPane.showMessageDialog(null, "Saque realizado!");
                                        janela_saque.setVisible(false);
                                        janela_principal.setVisible(true);


                                    }

                                }
                            });






                        }
                    });




                }



            }
        });


        JButton Tranferir = new JButton("5- Tranferência");
        Tranferir.setFocusPainted(false);
        Tranferir.setBounds(70, 310, 250, 45);
        janela_principal.add(Tranferir);

        Tranferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela_principal.setVisible(false);

                janela_tranferencia.setBounds(400, 100, 730, 460);
                janela_tranferencia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela_tranferencia.setLayout(null);
                janela_tranferencia.setVisible(true);

                if(banco.contas.isEmpty()){

                    JOptionPane.showMessageDialog(null, "Nenhuma conta existente");
                    janela_tranferencia.setVisible(false);
                    janela_principal.setVisible(true);


                }

                int y=30;

                for (Conta c: banco.contas) {
                    JButton botao = new JButton(c.titular + " saldo: " + c.saldo);
                    botao.setBounds(50, y, 250, 45);
                    janela_tranferencia.add(botao);
                    y = y + 50;

                    botao.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            janela_tranferencia.getContentPane().removeAll();

                            JLabel valor_nome = new JLabel("Quanto deseja tranferir");
                            valor_nome.setBounds(50,110,350,70);
                            valor_nome.setForeground(Color.black);
                            valor_nome.setFont(new Font("Arial",Font.BOLD,25));
                            janela_tranferencia.add(valor_nome);

                            JTextField valor = new JTextField();
                            valor.setBounds(50,200,400,35);
                            janela_tranferencia.add(valor);

                            JButton botao_t = new JButton("Transferir");
                            botao_t.setFocusPainted(false);
                            botao_t.setBounds(50, 255, 200, 40);
                            janela_tranferencia.add(botao_t);

                            botao_t.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    double valorreal = Double.parseDouble(valor.getText());

                                    if (valorreal>c.saldo){
                                        JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                                        janela_tranferencia.setVisible(false);
                                        janela_principal.setVisible(true);

                                    }
                                    else{
                                        c.settransferencia(valorreal);

                                        JOptionPane.showMessageDialog(null, "tranferência realizada");
                                        janela_tranferencia.setVisible(false);
                                        janela_principal.setVisible(true);


                                    }

                                }
                            });






                        }
                    });




                }



            }
        });

        JButton saldo = new JButton("6- Saldo");
        saldo.setFocusPainted(false);
        saldo.setBounds(370, 110, 265, 45);
        janela_principal.add(saldo);

        saldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela_principal.setVisible(false);

                janela_saldo.setBounds(400, 100, 730, 460);
                janela_saldo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela_saldo.setLayout(null);
                janela_saldo.setVisible(true);

                if(banco.contas.isEmpty()){

                    JOptionPane.showMessageDialog(null, "Nenhuma conta existente");
                    janela_saldo.setVisible(false);
                    janela_principal.setVisible(true);


                }

                int y=30;

                for (Conta c: banco.contas) {
                    JButton botao = new JButton(c.titular );
                    botao.setBounds(50, y, 250, 45);
                    janela_saldo.add(botao);
                    y = y + 50;

                    botao.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            janela_saldo.getContentPane().removeAll();
                            JOptionPane.showMessageDialog(null,"você tem R$" + c.saldo);


                        }
                    });




                }



            }
        });

        JButton corrente = new JButton("7- Calcular atributos de contas correntes");
        corrente.setFocusPainted(false);
        corrente.setBounds(370, 160, 265, 45);
        janela_principal.add(corrente);

        corrente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculadoradeImposto calc = new CalculadoradeImposto();

                for (Conta continha : banco.contas) {
                    if (continha instanceof Tributavel) {
                        calc.registro((Tributavel) continha);}
                }
                JOptionPane.showMessageDialog(null,"Total de atributos:"+ calc.gettotal());



            }
        });

        JButton autenticarg = new JButton("8- Autenticar gerente");
        autenticarg.setFocusPainted(false);
        autenticarg.setBounds(370, 212, 265, 45);
        janela_principal.add(autenticarg);

        autenticarg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                janela_principal.setVisible(false);

                janela_autenticar.setBounds(400, 100, 730, 460);
                janela_autenticar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela_autenticar.setLayout(null);
                janela_autenticar.setVisible(true);

                JLabel g_nome = new JLabel("Nome?");
                g_nome.setBounds(50,60,350,70);
                g_nome.setForeground(Color.black);
                g_nome.setFont(new Font("Arial",Font.BOLD,25));
                janela_autenticar.add(g_nome);

                JTextField nome_usuario = new JTextField();
                nome_usuario.setBounds(50,115,400,35);
                janela_autenticar.add(nome_usuario);

                JLabel senha_nome = new JLabel("Senha:");
                senha_nome.setBounds(50,155,350,70);
                senha_nome.setForeground(Color.black);
                senha_nome.setFont(new Font("Arial",Font.BOLD,25));
                janela_autenticar.add(senha_nome);

                JTextField senha_usurio = new JTextField();
                senha_usurio.setBounds(50,205,400,35);
                janela_autenticar.add(senha_usurio);

                JButton autenticado = new JButton("Autenticar");
                autenticado.setFocusPainted(false);
                autenticado.setBounds(50, 255, 200, 40);
                janela_autenticar.add(autenticado);

                autenticado.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nomefuncionario = nome_usuario.getText();

                        String senhafuncionario = senha_usurio.getText();



                        if (gerente.autenticar(senhafuncionario) ) {
                            JOptionPane.showMessageDialog(null,"Bem vindo senhor Eduardo.");
                            janela_autenticar.setVisible(false);
                            janela_principal.setVisible(true);


                        } else {
                            JOptionPane.showMessageDialog(null,"acesso negado");
                            janela_autenticar.setVisible(false);
                            janela_principal.setVisible(true);
                        }
                    }
                });




            }
        });

        JButton sair = new JButton("9- Sair");
        sair.setFocusPainted(false);
        sair.setBounds(370, 262, 265, 45);
        janela_principal.add(sair);

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);            }
        });


    }
}
