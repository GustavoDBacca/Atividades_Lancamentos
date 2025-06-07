/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.receitas_despesas.model.*;
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

        lancamentos.add(new Receitas("Salário", 3000.0, "2025-06-01"));
        lancamentos.add(new Receitas("Décimo Terceiro", 1500.0, "2025-06-10"));
        lancamentos.add(new Despesas("Aluguel", 1200.0, "2025-06-02"));
        lancamentos.add(new Despesas("Mercado", 450.0, "2025-06-03"));
        

        // Criar saldo e aplicar lançamentos
        Saldo saldo = new Saldo();

        for (Lancamentos l : lancamentos) {
            if (l instanceof Receitas) {
                saldo.Adicionar(l.getValor());
            } else if (l instanceof Despesas) {
                saldo.Subtrair(l.getValor());
            }
        }

        // Verificar se o saldo final é o esperado
        double esperado = 3000 + 1500 - 1200 - 450; // 2850.0
        assertEquals(esperado, saldo.getValor(), 0.0001); // tolerância de comparação
    }
    
}
