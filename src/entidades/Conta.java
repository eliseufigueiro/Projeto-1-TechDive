package entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Conta {

    //atributos
    private String nome;
    private String cpf;
    private double rendaMensal;
    private String tipoConta;
    public static int numerocontas = 0;//Total de contas instanciadas
    private int conta;
    private String agencia;
    private double saldo;
    private String data;
    private double limiteDeConta = 0;

    //construtor sem depósito ínicial
    public Conta() {
    }

    public Conta(String nome, String cpf, double rendaMensal, String tipoConta, String agencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        dataAtual();
        AddNumeroConta();
    }

    //construtor com depósito ínicial
    public Conta(String nome, String cpf, double rendaMensal, String tipoConta, String agencia, double depositoInicial) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        deposito(depositoInicial);
        dataAtual();
        AddNumeroConta();
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

    public String getTipoConta() {

        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {

        this.tipoConta = tipoConta;
    }

    public int getConta() {

        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getAgencia() {

        return agencia;
    }

    public void setAgencia(String agencia) {

        this.agencia = agencia;
    }

    public double getSaldo() {

        return saldo;
    }

    public String getData() {

        return data;
    }

    public double getLimiteDeConta() {
        return limiteDeConta;
    }

    public void setLimiteDeConta(double limiteDeConta) {
        this.limiteDeConta = limiteDeConta;
    }

    //Metodos auxiliares
    public void AddNumeroConta() {

        setConta(numerocontas);//Passa o total de conta como número da conta... esse deu trabalho kkkkk
    }

    public void saque(double montante) {

        this.saldo -= montante;
    }

    public void deposito(double montante) {

        this.saldo += montante;
    }

    public void extrato() {

    }

    public void transferir() {

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
                ", Total de Contas=" + numerocontas +
                ", Número da Conta=" + conta +
                ", Agência=" + agencia +
                ", Saldo=" + String.format("%.2f", saldo) +
                ", Data=" + data +
                "}" + "\n";
    }
}
