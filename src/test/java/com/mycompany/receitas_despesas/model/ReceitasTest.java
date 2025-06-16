package com.mycompany.receitas_despesas.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ReceitasTest {

    @Test
    public void testGetTipo() {
        Receitas r = new Receitas("SALARIO", "Salário", 2000, LocalDate.now());
        assertEquals("receita", r.getTipo());
    }
}
