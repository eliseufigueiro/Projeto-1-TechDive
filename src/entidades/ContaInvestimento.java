package entidades;

import servicos.ValidaCPF;

import java.util.Scanner;

public class ContaInvestimento extends Conta {

    public ContaInvestimento() {
    }

    public ContaInvestimento(String nome, String cpf, double rendaMensal, String tipoConta, String agencia) {
        super(nome, cpf, rendaMensal, tipoConta, agencia);
    }

    public ContaInvestimento(String nome, String cpf, double rendaMensal, String tipoConta, String agencia, double depositoInicial) {
        super(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
    }

    @Override
    public String toString() {
        return "Conta Investimentos {" +
                "Nome=" + getNome() + '\'' +
                ", CPF=" + getCpf() +
                ", Renda Mensal=" + String.format("%.2f", getRendaMensal()) +
                ", Conta=" + numerocontas +
                ", Agência=" + getAgencia() +
                ", Número da Conta=" + getConta() +
                ", Saldo=" + String.format("%.2f", getSaldo()) +
                ", Data=" + getData() +
                "}" + "\n";
    }
}
