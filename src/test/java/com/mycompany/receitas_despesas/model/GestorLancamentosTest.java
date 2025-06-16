package com.mycompany.receitas_despesas.model;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestorLancamentosTest {
    private GestorLancamentos gestor;
    private final LocalDate data = LocalDate.of(2023, 6, 1);

    @BeforeEach
    void setUp() {
        gestor = new GestorLancamentos();
    }

    @Test
    void testCalcularSaldoComReceitas() {
        gestor.adicionar(new Receitas("Salário", "Mensal", 3000.0, data));
        gestor.adicionar(new Receitas("Bônus", "Performance", 500.0, data));
        
        assertEquals(3500.0, gestor.calcularSaldo(), 0.001);
    }

    @Test
    void testCalcularSaldoComDespesas() {
        gestor.adicionar(new Despesas("Aluguel", "Apartamento", 1200.0, data));
        gestor.adicionar(new Despesas("Transporte", "Combustível", 200.0, data));
        
        assertEquals(-1400.0, gestor.calcularSaldo(), 0.001);
    }

    @Test
    void testCalcularSaldoMisto() {
        gestor.adicionar(new Receitas("Salário", "Mensal", 3000.0, data));
        gestor.adicionar(new Despesas("Aluguel", "Apartamento", 1200.0, data));
        gestor.adicionar(new Despesas("Alimentação", "Supermercado", 350.0, data));
        gestor.adicionar(new Receitas("Freelance", "Projeto", 800.0, data));
        
        assertEquals(2250.0, gestor.calcularSaldo(), 0.001);
    }

    @Test
    void testGetTodosRetornaListaCorreta() {
        Receitas r = new Receitas("Salário", "Mensal", 3000.0, data);
        Despesas d = new Despesas("Aluguel", "Apartamento", 1200.0, data);
        
        gestor.adicionar(r);
        gestor.adicionar(d);
        
        assertEquals(2, gestor.getTodos().size());
        assertTrue(gestor.getTodos().contains(r));
        assertTrue(gestor.getTodos().contains(d));
    }
}