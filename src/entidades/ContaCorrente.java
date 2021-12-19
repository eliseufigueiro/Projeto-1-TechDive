package entidades;

import servicos.ValidaCPF;

import java.util.ArrayList;
import java.util.Scanner;

public class ContaCorrente extends Conta {

    public ContaCorrente() {
    }

    public ContaCorrente(String nome, String cpf, double rendaMensal, String tipoConta, String agencia) {
        super(nome, cpf, rendaMensal, tipoConta, agencia);
    }

    public ContaCorrente(String nome, String cpf, double rendaMensal, String tipoConta, String agencia, double depositoInicial) {
        super(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
    }

    @Override
    public String toString() {
        return "Conta Corrente {" +
                "Nome=" + getNome() + '\'' +
                ", CPF=" + getCpf() +
                ", Renda Mensal=" + String.format("%.2f", getRendaMensal()) +
                ", Total de Contas=" + numerocontas +
                ", Agência=" + getAgencia() +
                ", Número da Conta=" + getConta() +
                ", Saldo=" + String.format("%.2f", getSaldo()) +
                ", Data=" + getData() +
                "}" + "\n";
    }

}
