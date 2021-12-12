package servicos;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaInvestimento;
import entidades.ContaPoupanca;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCadastro {

    public boolean menuCadastroEscolha(int menuCadastroEscolha) {
        Scanner sc = new Scanner(System.in);

        switch (menuCadastroEscolha) {
            case 1:
                System.out.println("-----------------------------------------");
                System.out.println(
                        "TIPO DE CONTA:" + "\n" +
                                "[1] 001 - Conta Corrente" + "\n" +
                                "[2] 002 - Conta Investimentos" + "\n" +
                                "[3] 003 - Conta Poupança" + "\n"
                );
                System.out.print("Escolha o Tipo de Conta: ");
                int tipoConta = sc.nextInt();

                do {
                    switch (tipoConta) {
                        case 1:
                            ContaCorrente contaCorrente = new ContaCorrente();
                            contaCorrente.cadastroContaCorrente();
                            return false;
                        case 2:
                            ContaInvestimento contaInvestimento = new ContaInvestimento();
                            contaInvestimento.cadastroContaInvestimentos();
                            return false;
                        case 3:
                            ContaPoupanca contaPoupanca = new ContaPoupanca();
                            contaPoupanca.cadastroContaPoupanca();
                            return false;
                        default:
                            System.out.print("Tipo de conta inválido, Digite novamente: ");
                            tipoConta = sc.nextInt();
                    }
                } while (tipoConta != 1 || tipoConta != 2 || tipoConta != 3);

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
