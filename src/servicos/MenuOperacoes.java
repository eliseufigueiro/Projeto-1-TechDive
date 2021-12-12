package servicos;

import java.util.Scanner;

public class MenuOperacoes {

    public boolean menuOperacoesEscolha(int menuOperacoesEscolha) {
        switch (menuOperacoesEscolha) {

            case 1:
                System.out.println("SAQUE");
                return false;
            case 2:
                System.out.println("DEPÓSITO");
                return false;
            case 3:
                System.out.println("SALDO");
                return false;
            case 4:
                System.out.println("EXTRATO");
                return false;
            case 5:
                System.out.println("TRANSFERÊNCIA");
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
                "BEM VINDO AO MENU DE OPERAÇÕES BANCÁRIAS" + "\n" +
                "-----------------------------------------" + "\n" +
                "[1] SAQUE" + "\n" +
                "[2] DEPÓSITO" + "\n" +
                "[3] SALDO" + "\n" +
                "[4] EXTRATO" + "\n" +
                "[5] TRANSFERÊNCIA" + "\n" +
                "[0] SAIR" + "\n" +
                "-----------------------------------------");
        System.out.print("DIGITE A OPÇÃO DESEJADA: ");
        int menuOperacoesEscolha = sc.nextInt();

        return menuOperacoesEscolha; // retorna o numero escolhido.
    }
}
