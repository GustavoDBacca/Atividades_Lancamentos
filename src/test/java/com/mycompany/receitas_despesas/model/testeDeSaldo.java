package com.mycompany.receitas_despesas.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.receitas_despesas.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author T-Gamer
 */
public class testeDeSaldo {
    
    
    @Test
    public void testCalculoSaldoComReceitasEDespesas() {
        // Criar lista de lançamentos
        ArrayList<Lancamentos> lancamentos = new ArrayList<>();
        
        Receitas r = new Receitas("Salário", "Salário", 3000.0, LocalDate.parse("2025-06-01"));
        Receitas s = new Receitas("Salário", "Décimo Terceiro", 1500.0, LocalDate.parse("2025-06-10"));
        Despesas d = new Despesas("Moradia", "Aluguel", 1200.0, LocalDate.parse("2025-06-02"));
        Despesas e = new Despesas("Alimentos", "Mercado", 450.0, LocalDate.parse("2025-06-03"));

        lancamentos.add(r);
        lancamentos.add(s);
        lancamentos.add(d);
        lancamentos.add(e);
        

        // Criar saldo e aplicar lançamentos
        Saldo saldo = new Saldo();

        for (Lancamentos l : lancamentos) {
            if (l instanceof Receitas) {
                saldo.adicionar(l.getValor());
            } else if (l instanceof Despesas) {
                saldo.subtrair(l.getValor());
            }
        }

        // Verificar se o saldo final é o esperado
        double esperado = 3000 + 1500 - 1200 - 450; // 2850.0
        assertEquals(esperado, saldo.getValor(), 0.0001); // tolerância de comparação
    }
    
}
