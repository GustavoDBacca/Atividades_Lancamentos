package com.mycompany.receitas_despesas.model;

import java.time.LocalDate;

/**
 * Representa uma despesa financeira no sistema.
 * <p>
 * Esta classe estende a classe {@link Lancamentos} e implementa o método {@code getTipo()}
 * para identificar o lançamento como uma "despesa".
 * </p>
 * 
 * @author Miguel
 */
public class Despesas extends Lancamentos {

    /**
     * Cria uma nova instância de {@code Despesas}.
     *
     * @param categoria Categoria da despesa (ex: Alimentação, Transporte).
     * @param descricao Descrição detalhada da despesa.
     * @param valor Valor monetário da despesa.
     * @param data Data em que a despesa ocorreu.
     */
    public Despesas(String categoria, String descricao, double valor, LocalDate data) {
        super(categoria, valor, data, descricao);
    }

    /**
     * Retorna o tipo do lançamento.
     *
     * @return Uma string "despesa".
     */
    @Override
    public String getTipo() {
        return "despesa";
    }
}
