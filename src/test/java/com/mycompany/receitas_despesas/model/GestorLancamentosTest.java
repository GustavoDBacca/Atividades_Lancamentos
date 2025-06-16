package com.mycompany.receitas_despesas.model;

import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorLancamentosTest {

    @BeforeEach
    public void setup() {
        GestorLancamentos.getTodos().clear();
    }

    @Test
    public void testAdicionar() {
        Receitas r = new Receitas("SALARIO", "Salário", 2500, LocalDate.now());
        GestorLancamentos.adicionar(r);
        assertEquals(1, GestorLancamentos.getTodos().size());
    }

    @Test
    public void testFiltrarReceitas() {
        GestorLancamentos.adicionar(new Receitas("SALARIO", "Salário", 2500, LocalDate.now()));
        GestorLancamentos.adicionar(new Despesas("ALIMENTOS", "Mercado", 300, LocalDate.now()));
        List<Lancamentos> receitas = GestorLancamentos.filtrarReceitas();
        assertEquals(1, receitas.size());
        assertEquals("receita", receitas.get(0).getTipo());
    }

    @Test
    public void testFiltrarDespesas() {
        GestorLancamentos.adicionar(new Receitas("SALARIO", "Salário", 2500, LocalDate.now()));
        GestorLancamentos.adicionar(new Despesas("ALIMENTOS", "Mercado", 300, LocalDate.now()));
        List<Lancamentos> despesas = GestorLancamentos.filtrarDespesas();
        assertEquals(1, despesas.size());
        assertEquals("despesa", despesas.get(0).getTipo());
    }

    @Test
    public void testCalcularSaldo() {
        GestorLancamentos.adicionar(new Receitas("SALARIO", "Salário", 2500, LocalDate.now()));
        GestorLancamentos.adicionar(new Despesas("ALIMENTOS", "Mercado", 300, LocalDate.now()));
        assertEquals(2200.0, GestorLancamentos.calcularSaldo());
    }

    @Test
    public void testGetSaldo() {
        GestorLancamentos.adicionar(new Receitas("SALARIO", "Salário", 1000, LocalDate.now()));
        GestorLancamentos.adicionar(new Despesas("TRANSPORTE", "Uber", 200, LocalDate.now()));
        assertEquals(800.0, GestorLancamentos.getSaldo());
    }
}
