package com.mycompany.receitas_despesas.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TipoDespesasTest {

    @Test
    public void testEnumValues() {
        assertNotNull(TipoDespesas.valueOf("ALIMENTOS"));
        assertNotNull(TipoDespesas.valueOf("SAUDE"));
    }
}
