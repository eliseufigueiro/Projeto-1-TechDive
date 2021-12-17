package entidades;

import servicos.ValidaCPF;

import java.util.ArrayList;
import java.util.Scanner;

public class ContaCorrente extends Conta {

    public ContaCorrente() {
    }

    public ContaCorrente(String nome, String cpf, double rendaMensal, int tipoConta, int agencia) {
        super(nome, cpf, rendaMensal, tipoConta, agencia);
    }

    public ContaCorrente(String nome, String cpf, double rendaMensal, int tipoConta, int agencia, double depositoInicial) {
        super(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
    }

    @Override
    public String toString() {
        return "Conta Corrente {" +
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
