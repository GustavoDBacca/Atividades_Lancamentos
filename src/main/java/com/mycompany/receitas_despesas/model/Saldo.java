package com.mycompany.receitas_despesas.model;

/**
 * Classe responsável por representar e manipular o saldo financeiro.
 * <p>
 * Permite adicionar ou subtrair valores do saldo atual, bem como definir ou obter seu valor.
 * </p>
 * 
 * @author Miguel
 */
public class Saldo {
    
    /**
     * Valor atual do saldo.
     */
    protected double valor;

    /**
     * Adiciona um valor ao saldo atual.
     *
     * @param valor Valor a ser somado ao saldo.
     */
    public void adicionar(double valor) {
        this.valor += valor;
    }

    /**
     * Subtrai um valor do saldo atual.
     *
     * @param valor Valor a ser subtraído do saldo.
     */
    public void subtrair(double valor) {
        this.valor -= valor;
    }

    /**
     * Retorna o valor atual do saldo.
     *
     * @return Valor do saldo.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define um novo valor para o saldo.
     *
     * @param valor Novo valor do saldo.
     */
    public void setValor(double valor) {
        this.valor = valor;
    } 
}
