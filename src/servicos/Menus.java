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
        System.out.println("*     [3] RELATÓRIOS                     *");
        System.out.println("*     [0] FINALIZAR SISTEMA              *");
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
        System.out.println("*     [0] VOLTAR                         *");
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
        System.out.println("*     [1] REALIZAR SAQUE                 *");
        System.out.println("*     [2] REALIZAR DEPÓSITO              *");
        System.out.println("*     [3] VISUALIZAR SALDO               *");
        System.out.println("*     [4] EXTRATO POR CONTA              *");
        System.out.println("*     [5] TRANSFERÊNCIA                  *");
        System.out.println("*     [0] VOLTAR                         *");
        System.out.println("*                                        *");
        System.out.println("******************************************");
        System.out.println("");
    }

    public void menuRelatorios() {
        System.out.println("");
        System.out.println("******************************************");
        System.out.println("*             BANCO TECHDIVE             *");
        System.out.println("******************************************");
        System.out.println("*                                        *");
        System.out.println("*     [1] LISTAR TODAS AS CONTAS         *");
        System.out.println("*     [2] CONTAS SALDO NEGTAIVO          *");
        System.out.println("*     [3] TOTAL DE INVESTIMENTOS         *");
        System.out.println("*     [4] TRANSAÇÕES POR CLIENTE         *");
        System.out.println("*     [0] VOLTAR                         *");
        System.out.println("*                                        *");
        System.out.println("******************************************");
        System.out.println("");
    }
}
