package servicos;

import java.util.Scanner;

public class MenuRelatorios {

    public boolean menuRelatoriosEscolha(int menuRelatoriosEscolha) {
        switch (menuRelatoriosEscolha) {

            case 1:
                System.out.println("LISTAR TODAS AS CONTAS CADASTRADAS");
                return false;
            case 2:
                System.out.println("LISTAR TODAS AS CONTAS COM SALDO NEGATIVO");
                return false;
            case 3:
                System.out.println("LISTAR TODAS AS CONTAS COM INVESTIMENTOS");
                return false;
            case 4:
                System.out.println("LISTAR TODAS AS TRANSAÇÕES BANCÁRIAS POR CLIENTE");
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
                "           MENU DE RELATÓRIOS" + "\n" +
                "-----------------------------------------" + "\n" +
                "[1] LISTAR TODAS AS CONTAS CADASTRADAS" + "\n" +
                "[2] LISTAR TODAS AS CONTAS COM SALDO NEGATIVO" + "\n" +
                "[3] LISTAR TODAS AS CONTAS COM INVESTIMENTOS" + "\n" +
                "[4] LISTAR TODAS AS TRANSAÇÕES BANCÁRIAS POR CLIENTE" + "\n" +
                "[0] SAIR" + "\n" +
                "-----------------------------------------");
        System.out.print("Digite a opção desejada: ");
        int menuRelatoriosEscolha = sc.nextInt();

        return menuRelatoriosEscolha; // retorna o numero escolhido.
    }
}
