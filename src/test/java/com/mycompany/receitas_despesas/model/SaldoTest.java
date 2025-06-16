package com.mycompany.receitas_despesas.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaldoTest {

    @Test
    public void testAdicionar() {
        Saldo s = new Saldo();
        s.adicionar(100);
        assertEquals(100, s.getValor());
    }

    @Test
    public void testSubtrair() {
        Saldo s = new Saldo();
        s.adicionar(200);
        s.subtrair(50);
        assertEquals(150, s.getValor());
    }
}
