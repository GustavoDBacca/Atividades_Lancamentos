package com.mycompany.receitas_despesas.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LancamentosTest {

    @Test
    public void testToString() {
        Receitas r = new Receitas("SALARIO", "Salário", 1200, LocalDate.of(2024, 5, 10));
        String str = r.toString();
        assertTrue(str.contains("receita"));
        assertTrue(str.contains("SALARIO"));
        assertTrue(str.contains("1200.00"));
        assertTrue(str.contains("10/05/2024"));
        assertTrue(str.contains("Salário"));
    }
}
