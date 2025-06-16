package com.mycompany.receitas_despesas.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SaldoTest {
    private Saldo saldo;

    @BeforeEach
    void setUp() {
        saldo = new Saldo();
    }

    @Test
    void testAdicionarAumentaValor() {
        saldo.adicionar(1000.0);
        assertEquals(1000.0, saldo.getValor(), 0.001);
        
        saldo.adicionar(500.0);
        assertEquals(1500.0, saldo.getValor(), 0.001);
    }

    @Test
    void testSubtrairDiminuiValor() {
        saldo.adicionar(2000.0);
        saldo.subtrair(800.0);
        assertEquals(1200.0, saldo.getValor(), 0.001);
        
        saldo.subtrair(200.0);
        assertEquals(1000.0, saldo.getValor(), 0.001);
    }

    @Test
    void testSaldoPodeFicarNegativo() {
        saldo.subtrair(500.0);
        assertEquals(-500.0, saldo.getValor(), 0.001);
    }
}