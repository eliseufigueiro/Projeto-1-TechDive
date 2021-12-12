package entidades;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
    }

    public ContaPoupanca(String nome, String cpf, double rendaMensal, int tipoConta, int agencia) {
        super(nome, cpf, rendaMensal, tipoConta, agencia);
    }

    public ContaPoupanca(String nome, String cpf, double rendaMensal, int tipoConta, int agencia, double depositoInicial) {
        super(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
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
                " }";
    }
}
