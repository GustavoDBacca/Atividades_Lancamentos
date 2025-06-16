package com.mycompany.receitas_despesas.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EnumsTest {
    @Test
    void testTipoReceitasContemValoresEsperados() {
        assertEquals(4, TipoReceitas.values().length);
        assertEquals("SALARIO", TipoReceitas.SALARIO.name());
        assertEquals("DECIMO_TERCEIRO", TipoReceitas.DECIMO_TERCEIRO.name());
        assertEquals("FERIAS", TipoReceitas.FERIAS.name());
        assertEquals("OUTRA_RECEITA", TipoReceitas.OUTRA_RECEITA.name());
    }

    @Test
    void testTipoDespesasContemValoresEsperados() {
        assertEquals(7, TipoDespesas.values().length);
        assertEquals("ALIMENTOS", TipoDespesas.ALIMENTOS.name());
        assertEquals("EDUCACAO", TipoDespesas.EDUCACAO.name());
        assertEquals("ENTRETERIMENTO", TipoDespesas.ENTRETERIMENTO.name());
        assertEquals("RESIDENCIA", TipoDespesas.RESIDENCIA.name());
        assertEquals("SAUDE", TipoDespesas.SAUDE.name());
        assertEquals("TRANSPORTE", TipoDespesas.TRANSPORTE.name());
        assertEquals("OUTRA_DESPESA", TipoDespesas.OUTRA_DESPESA.name());
    }
}