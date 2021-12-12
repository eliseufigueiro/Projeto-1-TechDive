package servicos;

import java.util.Scanner;

public class MenuPrincipal {
    public boolean menuPrincipalEscolha(int menuPrincipalEscolha) {
        switch (menuPrincipalEscolha) {

            case 1:
                MenuCadastro menuCadastro = new MenuCadastro();

                boolean menu = false;

                while (menu == false) {
                    int menuOpc = menuCadastro.menu();
                    menu = menuCadastro.menuCadastroEscolha(menuOpc);
                }
                return false;
            case 2:
                MenuOperacoes menuOperacoes = new MenuOperacoes();

                menu = false;

                while (menu == false) {
                    int menuOpc = menuOperacoes.menu();
                    menu = menuOperacoes.menuOperacoesEscolha(menuOpc);
                }
                return false;

            case 3:
                MenuRelatorios menuRelatorios = new MenuRelatorios();

                menu = false;

                while (menu == false) {
                    int menuOpc = menuRelatorios.menu();
                    menu = menuRelatorios.menuRelatoriosEscolha(menuOpc);
                }
                return false;
            case 0:
                System.out.println("SISTEMA FINALIZADO");
                return true;
            default:
                System.out.println("Opção inválida! Por favor, escolha novamente!");
        }
        return false; // Opção para rodar o while novamente, caso as opções acima não sejam atendidas.

    }

    public int menu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------------------------" + "\n" +
                "BEM VINDO AO MENU DO BANCO TECHDIVE" + "\n" +
                "-----------------------------------------" + "\n" +
                "[1] CADASTRO CLIENTE" + "\n" +
                "[2] OPERAÇÕES BANCÁRIAS" + "\n" +
                "[3] RELATÓRIOS" + "\n" +
                "[0] SAIR" + "\n" +
                "-----------------------------------------");
        System.out.print("DIGITE A OPÇÃO DESEJADA: ");
        int menuPrincipalEscolha = sc.nextInt();

        return menuPrincipalEscolha; // retorna o numero escolhido.
    }
}
