package entidades;

import servicos.ValidaCPF;

import java.util.Scanner;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
    }

    public ContaPoupanca(String nome, String cpf, double rendaMensal, int tipoConta, int agencia) {
        super(nome, cpf, rendaMensal, tipoConta, agencia);
    }

    public ContaPoupanca(String nome, String cpf, double rendaMensal, int tipoConta, int agencia, double depositoInicial) {
        super(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
    }

    public void cadastroContaPoupanca() {
        Scanner sc = new Scanner(System.in);
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

        String escolhaAgencia = "False";
        do {
            System.out.print("Escolha um agência: ");
            agencia = sc.nextInt();
            if (agencia == 1) {
                escolhaAgencia = "true";
            }
            if (agencia == 2) {
                escolhaAgencia = "true";
            }

        } while (escolhaAgencia == "False");

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
        System.out.println(novaConta.toString());
    }

    @Override
    public String toString() {
        return "Conta Poupança {" +
                "Nome=" + getNome() + '\'' +
                ", CPF=" + getCpf() +
                ", Renda Mensal=" + String.format("%.2f", getRendaMensal()) +
                ", Conta=" + getConta() +
                ", Agência=" + getAgencia() +
                ", Saldo=" + String.format("%.2f", getSaldo()) +
                ", Data=" + getData() +
                "}" + "\n";
    }
}
