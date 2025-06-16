package com.mycompany.receitas_despesas.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class DespesasTest {

    @Test
    public void testGetTipo() {
        Despesas d = new Despesas("ALIMENTOS", "Comida", 500, LocalDate.now());
        assertEquals("despesa", d.getTipo());
    }
}
