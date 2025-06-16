package com.mycompany.receitas_despesas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe abstrata que representa um lançamento genérico (receita ou despesa).
 * 
 * <p>Contém os atributos e métodos comuns às subclasses {@link Receitas} e {@link Despesas},
 * incluindo descrição, valor, data e categoria.</p>
 * 
 * <p>Obrigatoriamente, subclasses devem implementar o método {@code getTipo()}.</p>
 * 
 * @author Miguel
 */
public abstract class Lancamentos {
    
    /**
     * Descrição do lançamento.
     */
    protected String descricao;
    
    /**
     * Valor monetário do lançamento.
     */
    protected double valor;
    
    /**
     * Data do lançamento.
     */
    protected LocalDate data;
    
    /**
     * Categoria do lançamento (ex: "Alimentação", "Salário").
     */
    protected String categoria;

    /**
     * Construtor da classe base Lancamentos.
     *
     * @param categoria Categoria do lançamento.
     * @param valor Valor monetário do lançamento.
     * @param data Data do lançamento.
     * @param descricao Descrição detalhada do lançamento.
     */
    public Lancamentos(String categoria, double valor, LocalDate data, String descricao) {
        setCategoria(categoria);
        setDescricao(descricao);
        setValor(valor);
        setData(data);
    }

    /**
     * Método abstrato que retorna o tipo do lançamento.
     * Subclasses devem retornar "receita" ou "despesa".
     *
     * @return Tipo do lançamento.
     */
    public abstract String getTipo();

    /**
     * Retorna uma representação formatada do lançamento como string.
     *
     * @return String com dados do lançamento.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[Lançamento [%s] - %s | %.2f | %s | %s]",
                getTipo(), categoria, valor, data.format(formatter), descricao);
    }

    /**
     * Retorna a descrição do lançamento.
     *
     * @return Descrição.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do lançamento.
     *
     * @param descricao Nova descrição.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o valor do lançamento.
     *
     * @return Valor.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor do lançamento.
     *
     * @param valor Novo valor.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Retorna a data do lançamento.
     *
     * @return Data.
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Define a data do lançamento.
     *
     * @param data Nova data.
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Retorna a categoria do lançamento.
     *
     * @return Categoria.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do lançamento.
     *
     * @param categoria Nova categoria.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
