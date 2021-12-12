package servicos;

import entidades.Conta;

import java.util.Scanner;

public class MenuCadastro {

    public boolean menuCadastroEscolha(int menuCadastroEscolha) {
        switch (menuCadastroEscolha) {

            case 1:
                Scanner sc = new Scanner(System.in);
                Conta novaConta = null;
                String nome, cpf;
                int agencia = 0, conta = 0;

                System.out.println("CADASTRAR NOVO CLIENTE");
                System.out.print("NOME COMPLETO: ");
                nome = sc.nextLine();

                boolean validaCPF;
                do {
                    System.out.print("CPF: ");
                    cpf = sc.next();
                    cpf = ValidaCPF.removeCaracteresEspeciais(cpf);
                    if (ValidaCPF.validaCPF(cpf)) {
                        validaCPF = true;
                    } else {
                        System.out.println("ERRO, CPF INVÁLIDO, DIGITE NOVAMENTE!");
                        validaCPF = false;
                    }
                } while (validaCPF == false);

                System.out.print("RENDA MENSAL: ");
                double rendaMensal = sc.nextDouble();
                System.out.println(
                        "AGENCIAS:" + "\n" +
                                "[1] 001 - Florianópolis" + "\n" +
                                "[2] 002 - São José" + "\n"
                );
                System.out.print("ESCOLHA UMA AGENCIA: ");
                int escolhaAgencia = sc.nextInt();
                if (escolhaAgencia == 1) {
                    agencia = 001;
                    conta = 100000;
                }
                if (escolhaAgencia == 2) {
                    agencia = 002;
                    conta = 200000;
                }

                System.out.print("DESEJA FAZER UM DEPÓSITO INICIAL? (S/N): ");
                char resposta = sc.next().charAt(0);
                if (resposta == 'S' || resposta == 's') {
                    System.out.print("ENTRE COM O VALOR INICIAL: ");
                    double depositoInicial = sc.nextDouble();
                    novaConta = new Conta(nome, cpf, rendaMensal, conta, agencia, depositoInicial);
                } else {
                    novaConta = new Conta(nome, cpf, rendaMensal, conta, agencia);
                }
                System.out.println(novaConta.toString());

                return false;
            case 2:
                System.out.println("ATUALIZAR CADASTRO CLIENTE");
                return false;
            case 0:
                System.out.println("SAIR");
                return true;
            default:
                System.out.println("Opção inválida! Por favor, escolha novamente!");
        }
        return false; // Opção para rodar o while novamente, caso as opções acima não sejam atendidas.

    }

    public int menu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------------------------" + "\n" +
                "BEM VINDO AO MENU DE CADASTRO CLIENTE" + "\n" +
                "-----------------------------------------" + "\n" +
                "[1] CADASTRAR NOVO CLIENTE" + "\n" +
                "[2] ATUALIZAR CADASTRO CLIENTE" + "\n" +
                "[0] SAIR" + "\n" +
                "-----------------------------------------");
        System.out.print("DIGITE A OPÇÃO DESEJADA: ");
        int menuCadastroEscolha = sc.nextInt();

        return menuCadastroEscolha; // retorna o numero escolhido.
    }
}
