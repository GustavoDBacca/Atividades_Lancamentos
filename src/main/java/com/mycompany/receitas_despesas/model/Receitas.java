package com.mycompany.receitas_despesas.model;

import java.time.LocalDate;

/**
 * Representa uma receita financeira no sistema.
 * <p>
 * Esta classe estende {@link Lancamentos} e representa entradas de dinheiro, como salário,
 * bônus, prêmios etc.
 * </p>
 * 
 * @author Miguel
 */
public class Receitas extends Lancamentos {

    /**
     * Construtor que cria uma nova instância de {@code Receitas}.
     *
     * @param categoria Categoria da receita (ex: Salário, Investimento).
     * @param descricao Descrição detalhada da receita.
     * @param valor Valor monetário da receita.
     * @param data Data em que a receita foi recebida.
     */
    public Receitas(String categoria, String descricao, double valor, LocalDate data) {
        super(categoria, valor, data, descricao);
    }

    /**
     * Retorna o tipo do lançamento.
     *
     * @return Uma string "receita".
     */
    @Override
    public String getTipo() {
        return "receita";
    }
}
