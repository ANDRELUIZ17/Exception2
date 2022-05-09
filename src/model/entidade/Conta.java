package model.entidade;

import exceptions.BusinessExceptions;

public class Conta {
    private Integer numero;
    private String titular;
    private Double saldo;
    private Double saqueLimite;

    public Conta () {
    }


    public Conta(Integer numero, String suporte, Double saldo, Double saqueLimite) {
        this.numero = numero;
        this.titular = suporte;
        this.saldo = saldo;
        this.saqueLimite = saqueLimite;
    }

    public Integer getNumero() {
        return numero;
    }

    public Conta setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public String getSuporte() {
        return titular;
    }

    public Conta setSuporte(String suporte) {
        this.titular = suporte;
        return this;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Conta setSaldo(Double saldo) {
        this.saldo = saldo;
        return this;
    }

    public Double getSaqueLimite() {
        return saqueLimite;
    }

    public Conta setSaqueLimite(Double saqueLimite) {
        this.saqueLimite = saqueLimite;
        return this;
    }
    public void depositar (double montante) {
        saldo += montante;
    }
    public void saque (double montante) {
        validarSaque(montante);
        saldo -= montante;
    }
    private void validarSaque (double montante) {
        if (montante > getSaqueLimite()) {
            throw new BusinessExceptions("Erro de Saque: A quantia excede o limite de saque");
        }
        if (montante > getSaldo()) {
            throw new BusinessExceptions("Erro de saque: Saldo insuficiente");
        }
    }
}
