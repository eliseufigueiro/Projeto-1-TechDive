package entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Conta {

    //atributos
    private String nome;
    private String cpf;
    private double rendaMensal;
    private int tipoConta;
    private static int conta;
    private int agencia;
    private double saldo;
    private String data;

    //construtor sem depósito ínicial
    public Conta() {
    }

    public Conta(String nome, String cpf, double rendaMensal, int tipoConta, int agencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.tipoConta = tipoConta;
        nConta();
        this.agencia = agencia;
        dataAtual();
    }

    //construtor com depósito ínicial
    public Conta(String nome, String cpf, double rendaMensal, int tipoConta, int agencia, double depositoInicial) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.tipoConta = tipoConta;
        nConta();
        this.agencia = agencia;
        deposito(depositoInicial);
        dataAtual();
    }

    //Metodos
    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getCpf() {

        return cpf;
    }

    public double getRendaMensal() {

        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {

        this.rendaMensal = rendaMensal;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getConta() {

        return conta;
    }

    public int getAgencia() {

        return agencia;
    }

    public void setAgencia(int agencia) {

        this.agencia = agencia;
    }

    public double getSaldo() {

        return saldo;
    }

    public String getData() {
        return data;
    }

    //Metodos auxiliares
    public void deposito(double montante) {

        saldo += montante;
    }

    public void saque(double montante) {

        saldo -= montante;
    }

    public int nConta() {

        return Conta.conta++;
    }

    public String dataAtual() {
        String dataAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int time = cal.get(Calendar.HOUR_OF_DAY);
        return data = dataAtual;
    }

    public String toString() {
        return "Conta {" +
                "Nome=" + nome + '\'' +
                ", CPF=" + cpf +
                ", Renda Mensal=" + String.format("%.2f", rendaMensal) +
                ", Tipo Conta=" + tipoConta +
                ", Conta=" + conta +
                ", Agência=" + agencia +
                ", Saldo=" + String.format("%.2f", saldo) +
                ", Data=" + data +
                "}" + "\n";
    }
}
