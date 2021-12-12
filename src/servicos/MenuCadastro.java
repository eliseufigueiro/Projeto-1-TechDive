package servicos;

import entidades.Conta;
import entidades.ContaCorrente;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCadastro {

    public boolean menuCadastroEscolha(int menuCadastroEscolha) {
        switch (menuCadastroEscolha) {

            case 1:
                /*Scanner sc = new Scanner(System.in);
                ContaCorrente novaConta = null;
                String nome, cpf;
                int agencia = 0, conta = 0, tipoConta = 1;

                System.out.println("-----------------------------------------");
                System.out.println("CADASTRAR NOVO CLIENTE");
                System.out.println("-----------------------------------------");
                System.out.print("NOME COMPLETO: ");
                nome = sc.nextLine();

                boolean validaCPF;
                do {
                    System.out.println("-----------------------------------------");
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

                System.out.println("-----------------------------------------");
                System.out.print("RENDA MENSAL: ");
                double rendaMensal = sc.nextDouble();

                System.out.println("-----------------------------------------");
                System.out.println(
                        "AGENCIAS:" + "\n" +
                                "[1] 001 - Florianópolis" + "\n" +
                                "[2] 002 - São José" + "\n"
                );
                System.out.print("Escolha um agência: ");
                int escolhaAgencia = sc.nextInt();
                if (escolhaAgencia == 1) {
                    agencia = 1;
                }
                if (escolhaAgencia == 2) {
                    agencia = 2;
                }

                System.out.println("-----------------------------------------");
                System.out.print("DESEJA FAZER UM DEPÓSITO INICIAL? (S/N): ");
                char resposta = sc.next().charAt(0);
                if (resposta == 'S' || resposta == 's') {
                    System.out.print("ENTRE COM O VALOR INICIAL: ");
                    double depositoInicial = sc.nextDouble();
                    novaConta = new ContaCorrente(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);

                } else {
                    novaConta = new ContaCorrente(nome, cpf, rendaMensal, tipoConta, agencia);
                }
                System.out.println("-----------------------------------------");
                System.out.println("Conta criada com sucesso!");
                System.out.println(novaConta.toString());*/
                ContaCorrente contaCorrente = new ContaCorrente();
                contaCorrente.cadastroContaCorrent();

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
                "        MENU DE CADASTRO CLIENTE" + "\n" +
                "-----------------------------------------" + "\n" +
                "[1] CADASTRAR NOVO CLIENTE" + "\n" +
                "[2] ATUALIZAR CADASTRO CLIENTE" + "\n" +
                "[0] SAIR" + "\n");
        System.out.print("Digite a opção desejada: ");
        int menuCadastroEscolha = sc.nextInt();
        System.out.println("");

        return menuCadastroEscolha; // retorna o numero escolhido.
    }
}
