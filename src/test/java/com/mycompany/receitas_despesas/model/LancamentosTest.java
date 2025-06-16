package com.mycompany.receitas_despesas.model;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LancamentoConcreto extends Lancamentos {
    public LancamentoConcreto(String categoria, double valor, LocalDate data, String descricao) {
        super(categoria, valor, data, descricao);
    }

    @Override
    public String getTipo() {
        return "concreto";
    }
}

public class LancamentosTest {
    @Test
    void testToStringFormatacaoCorreta() {
        Lancamentos lancamento = new LancamentoConcreto("Aluguel", 1500.0, 
            LocalDate.of(2023, 6, 10), "Pagamento mensal");
        
        String expected = "Lançamento [concreto] - Aluguel | 1500.00 | 2023-06-10 | Pagamento mensal";
        assertEquals(expected, lancamento.toString());
    }

    @Test
    void testMetodoAbstratoGetTipo() {
        Lancamentos lancamento = new LancamentoConcreto("Teste", 100.0, 
            LocalDate.now(), "Teste");
        
        assertEquals("concreto", lancamento.getTipo());
    }
}