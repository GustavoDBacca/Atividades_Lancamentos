package com.mycompany.receitas_despesas.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TipoReceitasTest {

    @Test
    public void testEnumValues() {
        assertNotNull(TipoReceitas.valueOf("SALARIO"));
        assertNotNull(TipoReceitas.valueOf("FERIAS"));
    }
}
