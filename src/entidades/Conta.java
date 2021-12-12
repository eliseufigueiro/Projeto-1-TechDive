package entidades;

public class Conta {

    //atributos
    private String nome;
    private String cpf;
    private double rendaMensal;
    private static int conta;
    private int agencia;
    private double saldo;

    //construtor sem depósito ínicial

    public Conta(String nome, String cpf, double rendaMensal, int conta, int agencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        nConta(conta);
        this.agencia = agencia;
    }

    //construtor com depósito ínicial
    public Conta(String nome, String cpf, double rendaMensal, int conta, int agencia, double depositoInicial) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        nConta(conta);
        this.agencia = agencia;
        deposito(depositoInicial);
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

    public void deposito(double montante) {

        saldo += montante;
    }

    public void saque(double montante) {

        saldo -= montante;
    }

    public int nConta(int conta) {

        return Conta.conta++;
    }

    @Override
    public String toString() {
        return "Conta {" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", rendaMensal=" + rendaMensal +
                ", conta=" + conta +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                '}';
    }
}
