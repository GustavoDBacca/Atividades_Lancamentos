package com.mycompany.receitas_despesas.model;

/**
 * Enumeração que representa os tipos possíveis de despesas no sistema.
 * 
 * <p>Utilizada para categorizar os lançamentos de despesa de forma padronizada.</p>
 * 
 * <ul>
 *   <li>{@link #ALIMENTOS} – Gastos com alimentação.</li>
 *   <li>{@link #EDUCACAO} – Gastos com escola, cursos, materiais didáticos.</li>
 *   <li>{@link #ENTRETERIMENTO} – Gastos com lazer, cinema, jogos, passeios.</li>
 *   <li>{@link #RESIDENCIA} – Gastos com aluguel, água, luz, gás, etc.</li>
 *   <li>{@link #SAUDE} – Gastos com remédios, consultas, planos de saúde.</li>
 *   <li>{@link #TRANSPORTE} – Gastos com ônibus, gasolina, transporte por app.</li>
 *   <li>{@link #OUTRA_DESPESA} – Qualquer outro tipo de despesa não especificada acima.</li>
 * </ul>
 * 
 * @author Miguel
 */
public enum TipoDespesas {
    ALIMENTOS,
    EDUCACAO,
    ENTRETERIMENTO,
    RESIDENCIA,
    SAUDE,
    TRANSPORTE,
    OUTRA_DESPESA;
}
