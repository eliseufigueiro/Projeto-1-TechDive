package aplicacao;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaInvestimento;
import entidades.ContaPoupanca;
import servicos.Menus;
import servicos.ValidaCPF;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class BancoTechDive {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Conta> contas = new ArrayList<>();//Lista para guardar as contas

        Scanner sc = new Scanner(System.in);
        Menus menu = new Menus();

        //Base para testes
        ContaCorrente c1 = new ContaCorrente("Eliseu Figueiro", "78945612312", 5100, "Conta Corrente", "Florianópolis", 320);
        ContaPoupanca c2 = new ContaPoupanca("Eliseu Selbach", "78945678978", 3000, "Conta Popança", "Florianópolis", 320);
        ContaPoupanca c3 = new ContaPoupanca("João da Silva", "14785236987", 2500, "Conta Popança", "Florianópolis", 320);
        ContaInvestimento c4 = new ContaInvestimento("Jairo Mattos", "11111122233", 15000, "Conta Investimento", "Florianópolis", 320);
        ContaInvestimento c5 = new ContaInvestimento("Renata Figueiro", "25896314789", 3200, "Conta Investimento", "Florianópolis", 320);
        contas.add(c1);
        contas.add(c2);
        contas.add(c3);
        contas.add(c4);
        contas.add(c5);

        //System.out.println("Olá, Mundo");

        //Menu Principal
        int opcaoMenuPrincipal = 0;
        int opcaoMenuCadastro = 0;
        int opcapMenuTransacoes = 0;
        int opcaoMenuRelatorios = 0;

        do {
            menu.menuPrincipal();
            System.out.print("Digite a opção desejada: ");
            opcaoMenuPrincipal = sc.nextInt();
            switch (opcaoMenuPrincipal) {
                case 1:
                    do {
                        menu.menuCadastro();
                        System.out.print("Digite a opção desejada: ");
                        opcaoMenuCadastro = sc.nextInt();
                        switch (opcaoMenuCadastro) {
                            case 1:
                                //Variavéis passadas no construtor
                                String nome, cpf, tipoConta, agencia = "";
                                int tipoDeConta;
                                double rendaMensal;

                                System.out.print("Nome completo: ");
                                sc.nextLine();
                                nome = sc.nextLine();

                                boolean validaCPF;
                                do {
                                    System.out.print("CPF: ");
                                    cpf = sc.nextLine();
                                    cpf = ValidaCPF.removeCaracteresEspeciais(cpf);
                                    if (ValidaCPF.validaCPF(cpf)) {
                                        validaCPF = true;
                                    } else {
                                        System.out.println("CPF INVÁLIDO, DIGITE NOVAMENTE!");
                                        validaCPF = false;
                                    }
                                } while (validaCPF == false);

                                System.out.print("Renda mensal: ");
                                rendaMensal = sc.nextDouble();

                                boolean opcaoAgencia = false;
                                do {
                                    System.out.print("Escolha sua Agência: [1] - Florianópolis, [2] - São José: ");
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

                                System.out.print("Escolha o Tipo de Conta: [1]-Conta Corrente, [2]-Conta Investimento, [3]-Conta Poupança: ");
                                tipoDeConta = sc.nextInt();

                                if (tipoDeConta == 1) {
                                    ContaCorrente.numerocontas++;//Contador para toral de contas criadas
                                    ContaCorrente cc;// Instância a classe
                                    tipoConta = "Conta Corrente";

                                    System.out.print("Deseja fazer um depósito ínicial? (S/N): ");
                                    char resposta = sc.next().charAt(0);
                                    if (resposta == 'S' || resposta == 's') {
                                        System.out.print("Entre com o valor ínicial: ");
                                        double depositoInicial = sc.nextDouble();
                                        cc = new ContaCorrente(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
                                    } else {
                                        cc = new ContaCorrente(nome, cpf, rendaMensal, tipoConta, agencia);
                                    }
                                    contas.add(cc);
                                }
                                if (tipoDeConta == 2) {
                                    ContaInvestimento.numerocontas++;//Contador para toral de contas criadas
                                    ContaInvestimento ci;// Instância a classe
                                    tipoConta = "Conta Investimentos";

                                    System.out.print("Deseja fazer um depósito ínicial? (S/N): ");
                                    char resposta = sc.next().charAt(0);
                                    if (resposta == 'S' || resposta == 's') {
                                        System.out.print("Entre com o valor ínicial: ");
                                        double depositoInicial = sc.nextDouble();
                                        ci = new ContaInvestimento(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
                                    } else {
                                        ci = new ContaInvestimento(nome, cpf, rendaMensal, tipoConta, agencia);
                                    }
                                    contas.add(ci);
                                }
                                if (tipoDeConta == 3) {
                                    ContaPoupanca.numerocontas++;//Contador para toral de contas criadas
                                    ContaPoupanca cp;// Instância a classe
                                    tipoConta = "Conta Poupança";

                                    System.out.print("Deseja fazer um depósito ínicial? (s/n): ");
                                    char resposta = sc.next().charAt(0);
                                    if (resposta == 'S' || resposta == 's') {
                                        System.out.print("Entre com o valor ínicial: ");
                                        double depositoInicial = sc.nextDouble();
                                        cp = new ContaPoupanca(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
                                    } else {
                                        cp = new ContaPoupanca(nome, cpf, rendaMensal, tipoConta, agencia);
                                    }
                                    contas.add(cp);
                                }

                                System.out.println("Conta criada com sucesso!");
                                System.out.println(contas);
                                break;
                            case 2:
                                if (contas.isEmpty() == true) {
                                    System.out.println("\nNão há contas cadastradas!");
                                } else {
                                    System.out.print("\nDigite o número da conta: ");
                                    int nConta = sc.nextInt();
                                    nConta--;

                                    Conta aux = contas.get(nConta);
                                    System.out.println("");
                                    System.out.println("*  " + aux.getTipoConta());
                                    System.out.println("*  Nome: " + aux.getNome());
                                    System.out.println("*  CPF: " + aux.getCpf());
                                    System.out.println("*  Renda Mensal: " + aux.getRendaMensal());
                                    System.out.println("*  Agência: " + aux.getAgencia());
                                    System.out.println("*  Conta: " + aux.getConta());
                                    System.out.println("*  Saldo: " + aux.getSaldo());
                                    System.out.println("------------------------------------------");

                                    System.out.print("Deseja atualizar o Cadastro? (s/n): ");
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
                                                    System.out.println("Agência Inválida!");
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
                                    System.out.println("");
                                    System.out.println("*  " + aux.getTipoConta());
                                    System.out.println("*  Nome: " + aux.getNome());
                                    System.out.println("*  CPF: " + aux.getCpf());
                                    System.out.println("*  Renda Mensal: " + aux.getRendaMensal());
                                    System.out.println("*  Agência: " + aux.getAgencia());
                                    System.out.println("*  Conta: " + aux.getConta());
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
                                System.out.println("\nFINALIZANDO SISTEMA");
                                break;
                            default:
                                System.out.println("\nOPÇÃO INVÁLIDA!");
                        }
                    } while (opcaoMenuCadastro != 0);
                    break;
                case 2:
                    System.out.println("TRANSAÇÕES");
                    break;
                case 3:
                    System.out.println("RELATÓRIOS");
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
