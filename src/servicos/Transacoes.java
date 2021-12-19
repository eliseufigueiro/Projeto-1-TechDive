package servicos;

import entidades.Conta;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Transacoes {

    public static int numeroTransações = 0;//Total de transações
    private Conta contaOrigem;
    private Conta contaDestino;
    private double valorTransacao;
    private String dataTransacao;
    private int idTransacao;
    private String tipoDeTransacao;

    public Transacoes() {
    }

    public Transacoes(String tipoDeTransacao, Conta contaOrigem, double valorTransacao) {
        addIdTransacao();
        this.tipoDeTransacao = tipoDeTransacao;
        this.contaOrigem = contaOrigem;
        this.valorTransacao = valorTransacao;
        dataAtualTransacoes();
    }

    public Transacoes(String tipoDeTransacao, Conta contaOrigem, Conta contaDestino, double valorTransacao) {
        addIdTransacao();
        this.tipoDeTransacao = tipoDeTransacao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valorTransacao = valorTransacao;
        dataAtualTransacoes();
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public void addIdTransacao() {
        setIdTransacao(numeroTransações);//Passa o total de transações
    }

    public String dataAtualTransacoes() {
        String dataAtualTransacoes = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int time = cal.get(Calendar.HOUR_OF_DAY);
        return dataTransacao = dataAtualTransacoes;
    }

    @Override
    public String toString() {
        return "Transações {" +
                "contaOrigem=" + contaOrigem +
                ", contaDestino=" + contaDestino +
                ", valorTransacao=" + valorTransacao +
                ", dataTransacao='" + dataTransacao + '\'' +
                ", idTransacao=" + idTransacao +
                ", tipoDeTransacao='" + tipoDeTransacao + '\'' +
                '}' + "\n";
    }
}
