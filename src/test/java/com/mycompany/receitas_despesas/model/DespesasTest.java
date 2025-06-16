package com.mycompany.receitas_despesas.model;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DespesasTest {
    @Test
    void testGetTipoRetornaDespesa() {
        Despesas despesa = new Despesas("Transporte", "Combustível", 200.0, LocalDate.now());
        assertEquals("despesa", despesa.getTipo());
    }

    @Test
    void testToStringIncluiTipoDespesa() {
        Despesas despesa = new Despesas("Alimentação", "Supermercado", 350.0, 
            LocalDate.of(2023, 6, 5));
        
        assertTrue(despesa.toString().contains("[despesa]"));
    }
}