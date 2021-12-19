package servicos;

import java.util.Scanner;

public class Menus {

    Scanner sc = new Scanner(System.in);

    public void menuPrincipal() {

        System.out.println("");
        System.out.println("******************************************");
        System.out.println("*             BANCO TECHDIVE             *");
        System.out.println("******************************************");
        System.out.println("*                                        *");
        System.out.println("*     [1] CADASTRO CLIENTE               *");
        System.out.println("*     [2] TRANSAÇÕES BANCÁRIAS           *");
        System.out.println("*     [0] RELATÓRIOS                     *");
        System.out.println("*     [0] SAIR                           *");
        System.out.println("*                                        *");
        System.out.println("******************************************");
        System.out.println("");
    }

    public void menuCadastro() {

        System.out.println("");
        System.out.println("******************************************");
        System.out.println("*             BANCO TECHDIVE             *");
        System.out.println("******************************************");
        System.out.println("*                                        *");
        System.out.println("*     [1] CADASTRAR NOVO CLIENTE         *");
        System.out.println("*     [2] ATUALIZAR CADASTRO CLIENTE     *");
        System.out.println("*     [3] EXCLUIR CADASTRO CLIENTE       *");
        System.out.println("*     [0] SAIR                           *");
        System.out.println("*                                        *");
        System.out.println("******************************************");
        System.out.println("");
    }

    public void menuTransacoes() {

        System.out.println("");
        System.out.println("******************************************");
        System.out.println("*             BANCO TECHDIVE             *");
        System.out.println("******************************************");
        System.out.println("*                                        *");
    }
}
