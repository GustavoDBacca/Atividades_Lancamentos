package com.mycompany.receitas_despesas.model;

/**
 * Enumeração que representa os tipos possíveis de receitas no sistema.
 * 
 * <p>Usada para classificar lançamentos de receita com categorias padronizadas.</p>
 * 
 * <ul>
 *   <li>{@link #SALARIO} – Receita proveniente do salário mensal.</li>
 *   <li>{@link #DECIMO_TERCEIRO} – Receita extra correspondente ao 13º salário.</li>
 *   <li>{@link #FERIAS} – Receita proveniente do pagamento de férias.</li>
 *   <li>{@link #OUTRA_RECEITA} – Qualquer outra receita que não se encaixa nas categorias anteriores.</li>
 * </ul>
 * 
 * @author Miguel
 */
public enum TipoReceitas {
    SALARIO,
    DECIMO_TERCEIRO,
    FERIAS,
    OUTRA_RECEITA;
}
