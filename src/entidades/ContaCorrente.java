package entidades;

public class ContaCorrente extends Conta {

    private double valorChequeEspecial = 20 * getRendaMensal() / 100;

    public ContaCorrente() {
    }

    public ContaCorrente(double valorChequeEspecial) {

        this.valorChequeEspecial = valorChequeEspecial;
    }

    public ContaCorrente(String nome, String cpf, double rendaMensal, String tipoConta, String agencia) {
        super(nome, cpf, rendaMensal, tipoConta, agencia);
    }

    public ContaCorrente(String nome, String cpf, double rendaMensal, String tipoConta, String agencia, double depositoInicial) {
        super(nome, cpf, rendaMensal, tipoConta, agencia, depositoInicial);
    }

    public double getValorChequeEspecial() {
        return valorChequeEspecial;
    }

    public double somaChequeEspecial() {
        return getSaldo() + getValorChequeEspecial();
    }

    public double saldoChequeEspecial() {
        return valorChequeEspecial;
    }

    @Override
    public String toString() {
        return "======================================\n" +
                "         EXTRATO CONTA CORRENTE        \n" +
                " ======================================\n" +
                "  *  NOME: " + getNome() + "\n" +
                "  *  CPF: " + getCpf() + "\n" +
                "  *  AGÊNCIA: " + getAgencia() + "\n" +
                "  *  CONTA: " + getConta() + "\n" +
                "  *  TIPO CONTA: " + getTipoConta() + "\n" +
                "  *  RENDA MENSAL: " + String.format("%.2f", getRendaMensal()) + "\n" +
                "  *  CHEQUE ESPECIAL: " + String.format("%.2f", getValorChequeEspecial()) + "\n" +
                "  *  SALDO: " + getSaldo() + "\n" +
                "  *  DATA ABERTURA CONTA: " + getData() + "\n" +
                "======================================\n";
    }
}
