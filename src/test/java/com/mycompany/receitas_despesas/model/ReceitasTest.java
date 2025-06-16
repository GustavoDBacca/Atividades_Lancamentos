package com.mycompany.receitas_despesas.model;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReceitasTest {
    @Test
    void testGetTipoRetornaReceita() {
        Receitas receita = new Receitas("Salário", "Pagamento", 3000.0, LocalDate.now());
        assertEquals("receita", receita.getTipo());
    }

    @Test
    void testToStringIncluiTipoReceita() {
        Receitas receita = new Receitas("Bonus", "Performance", 500.0, 
            LocalDate.of(2023, 6, 15));
        
        assertTrue(receita.toString().contains("[receita]"));
    }
}