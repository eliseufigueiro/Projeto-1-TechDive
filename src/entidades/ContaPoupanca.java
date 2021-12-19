package entidades;

import servicos.ValidaCPF;

import java.util.Scanner;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
    }

    public ContaPoupanca(String nome, String cpf, double rendaMensal, String tipoConta, String agencia) {
        super(nome, cpf, rendaMensal, tipoConta, agencia);
    }

    public ContaPoupanca(String nome, String cpf, double rendaMensal, String tipoConta, String agencia, double depositoInicial) {
        super(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
    }

    @Override
    public String toString() {
        return "======================================\n" +
                "         EXTRATO CONTA POUPANÇA        \n" +
                " ======================================\n" +
                "  *  NOME: " + getNome() + "\n" +
                "  *  CPF: " + getCpf() + "\n" +
                "  *  AGÊNCIA: " + getAgencia() + "\n" +
                "  *  CONTA: " + getConta() + "\n" +
                "  *  TIPO CONTA: " + getTipoConta() + "\n" +
                "  *  RENDA MENSAL: " + String.format("%.2f", getRendaMensal()) + "\n" +
                "  *  SALDO: " + getSaldo() + "\n" +
                "  *  DATA ABERTURA CONTA: " + getData() + "\n" +
                "======================================\n";
    }
}
