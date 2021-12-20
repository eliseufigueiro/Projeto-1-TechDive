package aplicacao;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaInvestimento;
import entidades.ContaPoupanca;
import servicos.Menus;
import servicos.Transacoes;
import servicos.ValidaCPF;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class BancoTechDive {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Conta> contas = new ArrayList<>();//Lista para guardar as contas
        List<Transacoes> transacoes = new ArrayList<>();//Lista para guardar as transações

        Scanner sc = new Scanner(System.in);
        Menus menu = new Menus();

        //Menu Principal
        int opcaoMenuPrincipal = 0;
        int opcaoMenuCadastro = 0;
        int opcapMenuTransacoes = 0;
        int opcaoMenuRelatorios = 0;

        do {
            menu.menuPrincipal();
            System.out.print("*  Digite a opção desejada: ");
            opcaoMenuPrincipal = sc.nextInt();
            switch (opcaoMenuPrincipal) {
                case 1:
                    do {
                        menu.menuCadastro();
                        System.out.print("*  Digite a opção desejada: ");
                        opcaoMenuCadastro = sc.nextInt();
                        switch (opcaoMenuCadastro) {
                            case 1:
                                //Variavéis passadas no construtor
                                String nome, cpf, tipoConta, agencia = "";
                                int tipoDeConta;
                                double rendaMensal;

                                System.out.print("\n*  Nome completo: ");
                                sc.nextLine();
                                nome = sc.nextLine();

                                boolean validaCPF;
                                do {
                                    System.out.print("*  CPF: ");
                                    cpf = sc.nextLine();
                                    cpf = ValidaCPF.removeCaracteresEspeciais(cpf);
                                    if (ValidaCPF.validaCPF(cpf)) {
                                        validaCPF = true;
                                    } else {
                                        System.out.println("CPF INVÁLIDO, DIGITE NOVAMENTE!");
                                        validaCPF = false;
                                    }
                                } while (validaCPF == false);

                                System.out.print("*  Renda mensal: ");
                                rendaMensal = sc.nextDouble();

                                boolean opcaoAgencia = false;
                                do {
                                    System.out.print("*  Escolha sua Agência: [1] - Florianópolis, [2] - São José: ");
                                    int agenciaOpt = sc.nextInt();
                                    if (agenciaOpt == 1) {
                                        agencia = "Florianópolis";
                                        opcaoAgencia = true;
                                    }
                                    if (agenciaOpt == 2) {
                                        agencia = "São José";
                                        opcaoAgencia = true;
                                    }
                                } while (opcaoAgencia != true);

                                System.out.print("*  Escolha o Tipo de Conta: [1]-Conta Corrente, [2]-Conta Investimento, [3]-Conta Poupança: ");
                                tipoDeConta = sc.nextInt();

                                if (tipoDeConta == 1) {
                                    ContaCorrente.numerocontas++;//Contador para toral de contas criadas
                                    ContaCorrente cc;// Instância a classe
                                    Transacoes.numeroTransações++;
                                    Transacoes tt = null;
                                    tipoConta = "Conta Corrente";

                                    System.out.print("*  Deseja fazer um depósito ínicial? (S/N): ");
                                    char resposta = sc.next().charAt(0);
                                    if (resposta == 'S' || resposta == 's') {
                                        System.out.print("*  Entre com o valor ínicial: ");
                                        double depositoInicial = sc.nextDouble();
                                        cc = new ContaCorrente(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
                                        tt = new Transacoes("DEPÓSITO", null, depositoInicial);
                                    } else {
                                        cc = new ContaCorrente(nome, cpf, rendaMensal, tipoConta, agencia);
                                    }
                                    contas.add(cc);
                                    transacoes.add(tt);
                                }
                                if (tipoDeConta == 2) {
                                    ContaInvestimento.numerocontas++;//Contador para toral de contas criadas
                                    ContaInvestimento ci;// Instância a classe
                                    Transacoes.numeroTransações++;
                                    Transacoes tt = null;
                                    tipoConta = "Conta Investimentos";

                                    System.out.print("*  Deseja fazer um depósito ínicial? (S/N): ");
                                    char resposta = sc.next().charAt(0);
                                    if (resposta == 'S' || resposta == 's') {
                                        System.out.print("*  Entre com o valor ínicial: ");
                                        double depositoInicial = sc.nextDouble();
                                        ci = new ContaInvestimento(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
                                        tt = new Transacoes("DEPÓSITO", null, depositoInicial);
                                    } else {
                                        ci = new ContaInvestimento(nome, cpf, rendaMensal, tipoConta, agencia);
                                    }
                                    contas.add(ci);
                                    transacoes.add(tt);
                                }
                                if (tipoDeConta == 3) {
                                    ContaPoupanca.numerocontas++;//Contador para toral de contas criadas
                                    ContaPoupanca cp;// Instância a classe
                                    Transacoes.numeroTransações++;
                                    Transacoes tt = null;
                                    tipoConta = "Conta Poupança";

                                    System.out.print("*  Deseja fazer um depósito ínicial? (s/n): ");
                                    char resposta = sc.next().charAt(0);
                                    if (resposta == 'S' || resposta == 's') {
                                        System.out.print("*  Entre com o valor ínicial: ");
                                        double depositoInicial = sc.nextDouble();
                                        cp = new ContaPoupanca(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
                                        tt = new Transacoes("DEPÓSITO", null, depositoInicial);
                                    } else {
                                        cp = new ContaPoupanca(nome, cpf, rendaMensal, tipoConta, agencia);
                                    }
                                    contas.add(cp);
                                    transacoes.add(tt);
                                }

                                System.out.println("*  Conta criada com sucesso!");
                                System.out.println("------------------------------------------");
                                System.out.println("");
                                System.out.println(contas);
                                break;
                            case 2:
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.print("\n*  Digite o número da conta: ");
                                    int nConta = sc.nextInt();
                                    nConta--;

                                    Conta aux = contas.get(nConta);
                                    System.out.println("");
                                    System.out.println("*  " + aux.getTipoConta());
                                    System.out.println("*  Nome: " + aux.getNome());
                                    System.out.println("*  CPF: " + aux.getCpf());
                                    System.out.println("*  Renda Mensal: " + String.format("%.2f", aux.getRendaMensal()));
                                    System.out.println("*  Agência: " + aux.getAgencia());
                                    System.out.println("*  Conta: " + aux.getConta());
                                    System.out.println("*  Saldo: " + aux.getSaldo());
                                    System.out.println("------------------------------------------");

                                    System.out.print("*  Deseja atualizar o Cadastro? (s/n): ");
                                    char respostaAtualizar = sc.next().charAt(0);
                                    System.out.println("");
                                    if (respostaAtualizar == 'S' || respostaAtualizar == 's') {
                                        System.out.print("*  Escolha o Tipo de Conta: ");
                                        System.out.println("\n[1]-Conta Corrente\n[2]-Conta Investimento\n[3]-Conta Poupança:");
                                        int tipoDeContaAtualizar = sc.nextInt();
                                        boolean opcaoConta;
                                        do {
                                            switch (tipoDeContaAtualizar) {
                                                case 1:
                                                    aux.setTipoConta("Conta Corrente");
                                                    opcaoConta = true;
                                                    break;
                                                case 2:
                                                    aux.setTipoConta("Conta Investimento");
                                                    opcaoConta = true;
                                                    break;
                                                case 3:
                                                    aux.setTipoConta("Conta Poupança");
                                                    opcaoConta = true;
                                                    break;
                                                default:
                                                    System.out.println("Tipo de Conta Inválida!");
                                                    opcaoConta = false;
                                            }
                                        } while (opcaoConta != true);

                                        System.out.print("*  Nome: ");
                                        sc.nextLine();
                                        aux.setNome(sc.nextLine());
                                        System.out.print("*  Renda Mensal: ");
                                        aux.setRendaMensal(sc.nextDouble());

                                        boolean opcaoAgenciaAtualizar = false;
                                        do {
                                            System.out.print("*  Escolha sua Agência: [1] - Florianópolis, [2] - São José: ");
                                            int agenciaOpt = sc.nextInt();
                                            if (agenciaOpt == 1) {
                                                aux.setAgencia("Florianópolis");
                                                opcaoAgenciaAtualizar = true;
                                            }
                                            if (agenciaOpt == 2) {
                                                aux.setAgencia("São José");
                                                opcaoAgenciaAtualizar = true;
                                            }
                                            System.out.println("------------------------------------------");
                                        } while (opcaoAgenciaAtualizar != true);
                                    }
                                }
                                break;
                            case 3:
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.print("\n*  Digite o número da conta a ser excluida: ");
                                    int nConta = sc.nextInt();
                                    nConta--;

                                    Conta aux = contas.get(nConta);
                                    ContaCorrente aux1 = null;
                                    System.out.println("");
                                    System.out.println("*  " + aux.getTipoConta());
                                    System.out.println("*  Nome: " + aux.getNome());
                                    System.out.println("*  CPF: " + aux.getCpf());
                                    System.out.println("*  Renda Mensal: " + String.format("%.2f", aux.getRendaMensal()));
                                    System.out.println("*  Agência: " + aux.getAgencia());
                                    System.out.println("*  Conta: " + aux.getConta());
                                    System.out.println("*  Cheque Especial: " + String.format("%.2f", aux1.getValorChequeEspecial()));
                                    System.out.println("*  Saldo: " + aux.getSaldo());
                                    System.out.println("------------------------------------------");

                                    System.out.print("*  Deseja realmente excluir o Cadastro? (s/n): ");
                                    char respostaAtualizar = sc.next().charAt(0);
                                    if (respostaAtualizar == 'S' || respostaAtualizar == 's') {
                                        contas.remove(nConta);
                                    }
                                    System.out.println("*  Conta Exluida com Sucesso!");
                                    System.out.println("------------------------------------------");
                                }
                                break;
                            case 0:
                                System.out.println("\nVOLTAR MENU PRINCIPAL");
                                break;
                            default:
                                System.out.println("\nOPÇÃO INVÁLIDA!");
                                break;
                        }
                    } while (opcaoMenuCadastro != 0);
                    break;
                case 2:
                    do {
                        menu.menuTransacoes();
                        System.out.print("\n*  Digite a opção desejada: ");
                        opcapMenuTransacoes = sc.nextInt();
                        switch (opcapMenuTransacoes) {
                            case 1://Saque
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.print("*  Digite o número da conta para Saque: ");
                                    int nConta = sc.nextInt();
                                    nConta--;
                                    int contasTotal = 0;
                                    for (int i = 0; i < contas.size(); i++) {
                                        contasTotal = i++;
                                    }
                                    if (nConta > contasTotal) {
                                        System.out.println("*  Conta inexistente Saque cancelado!");
                                        System.out.println("------------------------------------------");
                                    } else {
                                        System.out.print("*  Digite o valor para Saque: R$ ");
                                        double montante = sc.nextDouble();
                                        Conta aux = contas.get(nConta);
                                        if (montante > aux.getSaldo() + aux.getLimiteDeConta()) {
                                            System.out.println("*  Saldo insuficiente!");
                                            System.out.println("*  Saldo em Conta: " + String.format("%.2f", aux.getSaldo()));
                                            System.out.println("------------------------------------------");
                                        } else {
                                            Transacoes.numeroTransações++;
                                            Transacoes tt = null;
                                            aux.saque(montante);
                                            tt = new Transacoes("SAQUE", aux, null, montante);
                                            transacoes.add(tt);
                                            System.out.println("------------------------------------------");
                                            System.out.println("*  Saque efetuado com SUCESSO!");
                                            System.out.println("*  Saldo em Conta: " + String.format("%.2f", aux.getSaldo()));
                                            System.out.println("------------------------------------------");
                                        }
                                    }
                                }
                                break;
                            case 2://Depósito
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.print("*  Digite o número da conta para Depósito: ");
                                    int nConta = sc.nextInt();
                                    nConta--;
                                    int contasTotal = 0;
                                    for (int i = 0; i < contas.size(); i++) {
                                        contasTotal = i++;
                                    }
                                    if (nConta > contasTotal) {
                                        System.out.println("*  Conta inexistente Depósito cancelado!");
                                        System.out.println("------------------------------------------");
                                    } else {
                                        Conta aux = contas.get(nConta);
                                        System.out.println("------------------------------------------");
                                        System.out.println("*  Saldo em Conta: " + String.format("%.2f", aux.getSaldo()));
                                        System.out.print("*  Digite o valor para Depósito: R$ ");
                                        double montante = sc.nextDouble();
                                        aux.deposito(montante);
                                        Transacoes tt = new Transacoes("DEPÓSITO", aux, null, montante);
                                        transacoes.add(tt);
                                        System.out.println("------------------------------------------");
                                        System.out.println("*  Depósito efetuado com SUCESSO!");
                                        System.out.println("*  Saldo em Conta: " + String.format("%.2f", aux.getSaldo()));
                                        System.out.println("------------------------------------------");
                                    }
                                }
                                break;
                            case 3://Saldo
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.print("*  Digite o número da conta para visualizar o Saldo: ");
                                    int nConta = sc.nextInt();
                                    nConta--;
                                    Conta aux = contas.get(nConta);
                                    System.out.println("*  Saldo em Conta: " + aux.getSaldo());
                                    System.out.println("------------------------------------------");
                                }
                                break;
                            case 4://Extrato
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.print("*  Digite o número da conta para Extrato: ");
                                    int nConta = sc.nextInt();
                                    System.out.println("------------------------------------------");
                                    nConta--;
                                    Conta aux = contas.get(nConta);
                                    if (aux instanceof ContaCorrente) {
                                        System.out.println("\n" +
                                                "======================================\n" +
                                                "        EXTRATO CONTA CORRENTE        \n" +
                                                "======================================\n" +
                                                "  *  NOME: " + aux.getNome() + "\n" +
                                                "  *  CPF: " + aux.getCpf() + "\n" +
                                                "  *  AGÊNCIA: " + aux.getAgencia() + "\n" +
                                                "  *  CONTA: " + aux.getConta() + "\n" +
                                                "  *  TIPO CONTA: " + aux.getTipoConta() + "\n" +
                                                "  *  RENDA MENSAL: " + String.format("%.2f", aux.getRendaMensal()) + "\n" +
                                                "  *  CHEQUE ESPECIAL: " + String.format("%.2f", ((ContaCorrente) aux).saldoChequeEspecial()) + "\n" +
                                                "  *  SALDO: " + aux.getSaldo() + "\n" +
                                                "  *  DATA ABERTURA: " + aux.getData() + "\n" +
                                                "======================================\n"
                                        );
                                    } else if (aux instanceof ContaInvestimento) {
                                        System.out.println("\n" +
                                                "======================================\n" +
                                                "      EXTRATO CONTA INVESTIMENTO      \n" +
                                                "======================================\n" +
                                                "  *  NOME: " + aux.getNome() + "\n" +
                                                "  *  CPF: " + aux.getCpf() + "\n" +
                                                "  *  AGÊNCIA: " + aux.getAgencia() + "\n" +
                                                "  *  CONTA: " + aux.getConta() + "\n" +
                                                "  *  TIPO CONTA: " + aux.getTipoConta() + "\n" +
                                                "  *  RENDA MENSAL: " + String.format("%.2f", aux.getRendaMensal()) + "\n" +
                                                "  *  INVESTIMENTOS: " + String.format("%.2f", ((ContaCorrente) aux).saldoChequeEspecial()) + "\n" +
                                                "  *  SALDO: " + aux.getSaldo() + "\n" +
                                                "  *  DATA ABERTURA: " + aux.getData() + "\n" +
                                                "======================================\n"
                                        );
                                    } else {
                                        System.out.println("\n" +
                                                "======================================\n" +
                                                "        EXTRATO CONTA POUPANÇA        \n" +
                                                "======================================\n" +
                                                "  *  NOME: " + aux.getNome() + "\n" +
                                                "  *  CPF: " + aux.getCpf() + "\n" +
                                                "  *  AGÊNCIA: " + aux.getAgencia() + "\n" +
                                                "  *  CONTA: " + aux.getConta() + "\n" +
                                                "  *  TIPO CONTA: " + aux.getTipoConta() + "\n" +
                                                "  *  RENDA MENSAL: " + String.format("%.2f", aux.getRendaMensal()) + "\n" +
                                                "  *  RENDIMENTO: " + String.format("%.2f", ((ContaCorrente) aux).saldoChequeEspecial()) + "\n" +
                                                "  *  SALDO: " + aux.getSaldo() + "\n" +
                                                "  *  DATA ABERTURA: " + aux.getData() + "\n" +
                                                "======================================\n"
                                        );
                                    }
                                }
                                break;
                            case 5:
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.print("*  Digite o número da Conta Origem: ");
                                    int nContaOrigem = sc.nextInt();
                                    nContaOrigem--;
                                    System.out.print("*  Digite o número da Conta Destino: ");
                                    int nContaDestino = sc.nextInt();
                                    nContaDestino--;

                                    Conta auxContaOrigem = contas.get(nContaOrigem);
                                    Conta auxContaDestino = contas.get(nContaDestino);

                                    System.out.print("*  Digite o valor do PIX: ");
                                    double valorPix = sc.nextDouble();

                                    auxContaOrigem.saque(valorPix);
                                    auxContaDestino.deposito(valorPix);

                                    Transacoes.numeroTransações++;
                                    Transacoes tt = new Transacoes("TRANSFERÊNCIA", auxContaOrigem, auxContaDestino, valorPix);
                                    transacoes.add(tt);
                                }
                                break;
                            case 0:
                                System.out.println("\nVOLTAR MENU PRINCIPAL");
                                break;
                            default:
                                System.out.println("\nOPÇÃO INVÁLIDA!");
                                break;
                        }
                    }
                    while (opcapMenuTransacoes != 0);
                    break;
                case 3:
                    do {
                        menu.menuRelatorios();
                        System.out.print("*  Digite a opção desejada: ");
                        opcaoMenuRelatorios = sc.nextInt();
                        switch (opcaoMenuRelatorios) {
                            case 1:
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    for (int i = 0; i < contas.size(); i++) {
                                        System.out.println(contas);
                                    }
                                }
                                break;
                            case 2:
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    for (int i = 0; i < contas.size(); i++) {
                                        if (contas.get(i).getSaldo() < 0) {
                                            System.out.println(contas);
                                        }
                                    }
                                }
                                break;
                            case 3:

                                break;
                            case 4:
                                if (contas.isEmpty() == true) {
                                    System.out.println("\n*  Não há contas cadastradas!");
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.print("*  Digite o número da conta: ");
                                    int nConta = sc.nextInt();
                                    nConta--;
                                    Transacoes trans = transacoes.get(nConta);
                                    System.out.println(trans);
                                }
                                break;
                            case 0:
                                System.out.println("\nVOLTAR MENU PRINCIPAL");
                                break;
                            default:
                                System.out.println("\nOPÇÃO INVÁLIDA!");
                                break;
                        }
                    } while (opcaoMenuRelatorios != 0);
                    break;
                case 0:
                    System.out.println("\nFINALIZANDO SISTEMA");
                    break;
                default:
                    System.out.println("\nOPÇÃO INVÁLIDA!");
            }
        } while (opcaoMenuPrincipal != 0);
    }

//Metodos de ajuda


}//FIM
