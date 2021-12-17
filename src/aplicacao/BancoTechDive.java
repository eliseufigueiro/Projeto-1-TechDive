package aplicacao;

import entidades.Conta;
import entidades.ContaCorrente;
import servicos.Menus;
import servicos.ValidaCPF;

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
                                ContaCorrente cc = new ContaCorrente();

                                //Variavéis passadas no construtor
                                String nome, cpf;
                                int agencia = 0, tipoConta = 0;
                                double rendaMensal;

                                System.out.println("");
                                System.out.println("******************************************");
                                System.out.println("*         CADASTRAR NOVO CLIENTE         *");
                                System.out.println("******************************************");
                                System.out.println("");
                                System.out.print("Nome completo: ");
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
                                    agencia = sc.nextInt();
                                    if (agencia == 1) {
                                        opcaoAgencia = true;
                                    }
                                    if (agencia == 2) {
                                        opcaoAgencia = true;
                                    }
                                } while (opcaoAgencia != true);

                                System.out.print("Deseja fazer um depósito ínicial? (S/N): ");
                                char resposta = sc.next().charAt(0);
                                if (resposta == 'S' || resposta == 's') {
                                    System.out.print("ENTRE COM O VALOR INICIAL: ");
                                    double depositoInicial = sc.nextDouble();
                                    cc = new ContaCorrente(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
                                } else {
                                    cc = new ContaCorrente(nome, cpf, rendaMensal, tipoConta, agencia);
                                }

                                contas.add(cc);

                                System.out.println("Conta criada com sucesso!");
                                System.out.println(contas);
                                break;
                            case 2:
                                System.out.println("ATUALIZAR CADASTRO CLIENTE");
                                break;
                            case 3:
                                System.out.println("EXCLUIR CADASTRO CLIENTE");
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
}//FIM
